package dao;

import model.Event;

import java.sql.*;
import java.util.List;
import java.util.TreeSet;

public class AuthTokenDao {
    /**
     * How we connect to our database
     */
    private final Connection conn;

    /**
     * Connecting to our database upon instantiating the object
     * @param conn Connection
     */
    public AuthTokenDao(Connection conn)
    {
        this.conn = conn;
    }

    /**
     * will insert a new event object into the database
     * @param authtoken String
     * @param associatedUsername String
     * @throws DataAccessException
     */
    public void insert(String authtoken, String associatedUsername) throws DataAccessException {
        //We can structure our string to be similar to a sql command, but if we insert question
        //marks we can change them later with help from the statement
        String sql = "INSERT INTO AuthTokens (TokenID, AssociatedUsername) VALUES(?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            //Using the statements built-in set(type) functions we can pick the question mark we want
            //to fill in and give it a proper value. The first argument corresponds to the first
            //question mark found in our sql String
            stmt.setString(1, authtoken);
            stmt.setString(2, associatedUsername);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("Error encountered while inserting into the database");
        }
    }

    /**
     * Will return an event object that corresponds to the event in the database that has this event ID
     * @param authtoken String
     * @return String AssociatedUsername
     * @throws DataAccessException
     */
    public String find(String authtoken) throws DataAccessException {
        String associatedUsername;
        ResultSet rs = null;
        String sql = "SELECT * FROM Events WHERE EventID = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, authtoken);
            rs = stmt.executeQuery();
            if (rs.next()) {
                associatedUsername = rs.getString("AssociatedUsername");
                return associatedUsername;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Error encountered while finding event");
        } finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * Takes in an authtoken and removes that event from the Events table
     * @param authtoken String
     * @throws DataAccessException
     */
    public void Delete(String authtoken) throws DataAccessException
    {
        try (Statement stmt = conn.createStatement()){
            String sql = "DELETE FROM AuthTokens WHERE TokenID = '" + authtoken + "';";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new DataAccessException("SQL Error encountered while deleting authtoken");
        }
    }

    public void clearTable() throws DataAccessException
    {
        try (Statement stmt = conn.createStatement()){
            String sql = "DELETE FROM AuthTokens;";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new DataAccessException("SQL Error encountered while clearing AuthTokens table");
        }
    }

//    public List<Event> findForUser (String username) {return new List<Event>()}
}
