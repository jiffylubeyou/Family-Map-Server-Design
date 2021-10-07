package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.TreeSet;

public class UserDao {
    /**
     * How we connect to our database
     */
    private final Connection conn;

    /**
     * Connecting to our database upon instantiating the object
     * @param conn Connection
     */
    public UserDao(Connection conn)
    {
        this.conn = conn;
    }

    /**
     * will insert a new user object into the database
     * @param user User Object
     * @throws DataAccessException
     */
    public void insert(User user) throws DataAccessException {

    }

    /**
     * Will return a user object that corresponds to the user in the database that has this user ID
     * @param userID String
     * @return User object
     * @throws DataAccessException
     */
    public User find(String userID) throws DataAccessException {
        return null; //this is temporary
    }

//    boolean Validate (String username, String password) {}

//    User getUserById (String userID) {}
}
