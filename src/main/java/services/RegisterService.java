package services;

import dao.DataAccessException;
import dao.Database;
import dao.UserDao;
import model.Person;
import model.User;
import requestresponse.RegisterRequest;
import requestresponse.RegisterResult;

import java.sql.Connection;

public class RegisterService {
    private RegisterRequest registerRequest;

    /**
     * Taking in the register information
     * @param registerRequest RegisterRequest object
     */
    public RegisterService (RegisterRequest registerRequest)
    {
        this.registerRequest = registerRequest;
    }

    /**
     * Will give us the auThtoken and personID of the new user
     * @return RegisterResult
     */
    public RegisterResult processRegister ()
    {
        Database database = new Database();
        try {
            Connection conn = database.getConnection();
            UserDao dao = new UserDao(conn);
            User user = dao.find(registerRequest.username);
            database.closeConnection(true);
            if (user != null)
            {
                return new RegisterResult( null, null, null,
                        "Error: Username already taken by another user", false);
            }

        }
        catch (DataAccessException e)
        {
            return new RegisterResult( null, null, null, e.getMessage(), false);
        }

        //create the Person first
        Person person = new Person(RandomUUID.generateRandom(), registerRequest.username, registerRequest.firstName,
                registerRequest.lastName, registerRequest.gender, null, null, null);
        try {
            GenerateGenerations.generatePeople(person, registerRequest.lastName, registerRequest.username, 2021, 4);
        }
        catch (Exception e)
        {
            return new RegisterResult( null, null, null, e.getMessage(), false);
        }

        //You have and the person and populated the data, now create the User
        User user = new User(registerRequest.username, registerRequest.password, registerRequest.email,
                registerRequest.firstName, registerRequest.lastName, registerRequest.gender, person.getPersonID());

        try {
            Connection conn2 = database.getConnection();
            UserDao dao = new UserDao(conn2);
            dao.insert(user);
            database.closeConnection(true);
        }
        catch (Exception e)
        {
            return new RegisterResult( null, null, null, e.getMessage(), false);
        }

        return new RegisterResult(person.getAssociatedUsername(), person.getPersonID(), registerRequest.password,null,true);
    }
}
