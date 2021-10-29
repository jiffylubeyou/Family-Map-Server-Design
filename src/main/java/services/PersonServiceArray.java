package services;

import dao.DataAccessException;
import dao.Database;
import dao.PersonDao;
import model.Event;
import model.Person;
import requestresponse.PersonRequest;
import requestresponse.PersonResult;
import requestresponse.PersonResultArray;

import java.sql.Connection;

public class PersonServiceArray {
    private PersonRequest personRequestArray;

    /**
     * takes int person ID
     * @param personRequest PersonRequest object
     */
    public PersonServiceArray (PersonRequest personRequest)
    {
        this.personRequestArray = personRequest;
    }

    /**
     * gives back the person info from the ID given
     * @return PersonResult object
     */
    public PersonResultArray processPersonArray () {
        Database database = new Database();
        try
        {
            Connection conn = database.getConnection();
            PersonDao dao = new PersonDao(conn);
            Person[] people = dao.getPeopleByUsername(personRequestArray.username);
            database.closeConnection(true);
            return new PersonResultArray(people, null, true);
        }
        catch (DataAccessException e)
        {
            try {
                database.closeConnection(false);
            } catch (DataAccessException ex)
            {
                return new PersonResultArray(null,"Error :" + ex.getMessage(),false);
            }
            return new PersonResultArray(null,"Error :" + e.getMessage(),false);

        }
    }
}
