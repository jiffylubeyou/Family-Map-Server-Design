package services;

import requestresponse.LoginRequest;
import requestresponse.LoginResult;

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
    LoginResult processLogin () {
        return new LoginResult();
    }
}
