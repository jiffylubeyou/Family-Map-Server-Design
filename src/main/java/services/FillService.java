package services;

import dao.*;
import model.Event;
import model.Person;
import model.User;
import requestresponse.FillResult;

import java.sql.Connection;

public class FillService {
    String username;
    int generations;

    /**
     * hands the request info to the fill service
     * @param username String
     * @param generations int
     */
    public FillService (String username, int generations)
    {
        this.username = username;
        this.generations = generations;
    }

    /**
     * Generates the fill Result
     * @return FillResult object
     */
    public FillResult processFill () {

        Database database = new Database();
        try {
            Connection conn = database.getConnection();
            UserDao dao = new UserDao(conn);
            User user = dao.find(username);
            database.closeConnection(true);

            if (user != null)
            {
                Connection conn2 = database.getConnection();
                PersonDao personDao = new PersonDao(conn2);
                Person person = personDao.find(user.getPersonID());
                database.closeConnection(true);

                //delete old people
                Connection conn3 = database.getConnection();
                PersonDao personDao2 = new PersonDao(conn3);
                personDao2.Delete(person);
                database.closeConnection(true);

                //delete old events
                Connection conn4 = database.getConnection();
                EventDao eventDao3 = new EventDao(conn4);
                eventDao3.Delete(person);
                database.closeConnection(true);

                int people = (int)(Math.pow(2, (generations + 1)) - 1);
                int events = (int)((Math.pow(2, (generations + 1)) * 3) - 2);
                GenerateGenerations.generatePeople(person, person.getLastName(),
                        person.getAssociatedUsername(),2021 , generations);
                return new FillResult("Successfully added " + people + " persons and " + events +
                        " events to the database.", true);
            }
            else
            {
                return new FillResult("Error: Invalid username or generations parameter", false);
            }
        }
        catch (Exception e)
        {
            try {
                database.closeConnection(false);
            }
            catch (DataAccessException ex)
            {
                return new FillResult(ex.getMessage(), false);
            }
            return new FillResult(e.getMessage(), false);
        }
    }
}
