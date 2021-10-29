package services;

import dao.DataAccessException;
import dao.Database;
import dao.PersonDao;
import model.Person;
import requestresponse.PersonRequest;
import requestresponse.PersonResult;

import javax.xml.crypto.Data;
import java.sql.Connection;

public class PersonService {
    private PersonRequest personRequest;

    /**
     * takes int person ID
     * @param personRequest PersonRequest object
     */
    public PersonService (PersonRequest personRequest)
    {
        this.personRequest = personRequest;
    }

    /**
     * gives back the person info from the ID given
     * @return PersonResult object
     */
    public PersonResult processPerson () {

        Database database = new Database();
        try
        {
            Connection conn = database.getConnection();
            PersonDao dao = new PersonDao(conn);
            Person person = dao.find(personRequest.personID);
            if (person != null) {
                if (person.getAssociatedUsername().equals(personRequest.username)) {
                    return new PersonResult(person.getAssociatedUsername(), person.getPersonID(), person.getFirstName(),
                            person.getLastName(), person.getGender(), person.getFatherID(), person.getMotherID(),
                            person.getSpouseID(), null, true);
                }
                else
                {
                    return new PersonResult(null, null, null, null,
                            null, null, null, null, "Error : Not In your family tree", false);
                }
            } else {
                return new PersonResult(null, null, null, null,
                        null, null, null, null, "Error : That person can't be found", false);
            }
        }
        catch (DataAccessException e)
        {
            try {
                database.closeConnection(false);
            } catch (DataAccessException ex)
            {
                return new PersonResult(null,null,null,null,
                        null,null,null,null,"Error :" + ex.getMessage(),false);
            }
            return new PersonResult(null,null,null,null,
                    null,null,null,null,"Error :" + e.getMessage(),false);

        }
    }
}
