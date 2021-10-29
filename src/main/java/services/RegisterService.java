package services;

import dao.DataAccessException;
import model.Person;
import requestresponse.RegisterRequest;
import requestresponse.RegisterResult;

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

        Person person = new Person(RandomUUID.generateRandom(), registerRequest.username, registerRequest.firstName,
                registerRequest.lastName, registerRequest.gender, null, null, null);
        try {
            GenerateGenerations.generatePeople(person, registerRequest.lastName, registerRequest.username, 4);
        }
        catch (DataAccessException e)
        {
            return new RegisterResult( null, null, e.getMessage(), false);
        }

        //login
        String authToken = RandomUUID.generateRandom();


        return new RegisterResult(person.getAssociatedUsername(), person.getPersonID(), null,true);
    }
}
