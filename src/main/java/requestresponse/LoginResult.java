package requestresponse;

public class LoginResult {
    String authtoken;
    String username;
    String personID;
    String message;
    public boolean success;

    public LoginResult(String authtoken, String username, String personID, String message, boolean success)
    {
        this.authtoken = authtoken;
        this.username = username;
        this.personID = personID;
        this.message = message;
        this.success = success;
    }
}
