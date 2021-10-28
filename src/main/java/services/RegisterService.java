package services;

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
     * Will give us the authtoken and personID of the new user
     * @return RegisterResult
     */
    RegisterResult processRegister ()
    {
        return new RegisterResult();
    }
}
