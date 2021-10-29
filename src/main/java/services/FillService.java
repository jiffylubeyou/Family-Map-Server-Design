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

        try {
            Database database = new Database();
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

                int people = 2^(generations - 1);
                GenerateGenerations.generatePeople(person, person.getLastName(),
                        person.getAssociatedUsername(),2021 , generations);
                return new FillResult("Successfully added " + people + " persons and " + "Y" +
                        " events to the database.", true);
            }
            else
            {
                return new FillResult("No such user exists", false);
            }
        }
        catch (Exception e)
        {
            return new FillResult(e.getMessage(), false);
        }
    }
}
