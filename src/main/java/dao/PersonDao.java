package dao;

import model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.TreeSet;

public class PersonDao {
    /**
     * How we connect to our database
     */
    private final Connection conn;

    /**
     * Connecting to our database upon instantiating the object
     * @param conn Connection
     */
    public PersonDao(Connection conn)
    {
        this.conn = conn;
    }

    /**
     * will insert a new person object into the database
     * @param person Person Object
     * @throws DataAccessException
     */
    public void insert(Person person) throws DataAccessException {
    }

    /**
     * Will return a person object that corresponds to the person in the database that has this person ID
     * @param personID String
     * @return Person object
     * @throws DataAccessException
     */
    public Person find(String personID) throws DataAccessException {
        return null; //this is temporary
    }
}
