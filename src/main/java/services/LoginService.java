package services;

import dao.AuthTokenDao;
import dao.DataAccessException;
import dao.Database;
import dao.UserDao;
import model.User;
import requestresponse.LoginRequest;
import requestresponse.LoginResult;

import java.sql.Connection;

public class LoginService {
    private LoginRequest loginRequest;

    /**
     * Takes in the request object
     * @param loginRequest LoginRequest object
     */
    public LoginService (LoginRequest loginRequest)
    {
        this.loginRequest = loginRequest;
    }


    /**
     * will tell us whether the login was successful or not and give us the authtoken, username, and personID
     * @return LoginResult object
     */
    public LoginResult processLogin () {
        Database database = new Database();
        try {
            Connection conn = database.getConnection();
            UserDao dao = new UserDao(conn);
            User user = dao.find(loginRequest.username);
            database.closeConnection(true);
            if (user == null)
            {
                return new LoginResult(null, null, null, "Error: No such username was found", false);
            }
            if (! user.getPassword().equals(loginRequest.password))
            {
                return new LoginResult(null, null, null, "Error: Password was incorrect", false);
            }

            String authToken = RandomUUID.generateRandom();
            Connection conn2 = database.getConnection();
            AuthTokenDao authDao = new AuthTokenDao(conn2);
            authDao.insert(authToken, loginRequest.username);
            database.closeConnection(true);
            return new LoginResult(authToken, loginRequest.username, user.getPersonID(), null, true);
        }
        catch (DataAccessException e)
        {
            try {
                database.closeConnection(false);
            }
            catch (DataAccessException ex)
            {
                return new LoginResult(null, null, null, ex.getMessage(), false);
            }
            return new LoginResult(null, null, null, e.getMessage(), false);
        }
    }
}
