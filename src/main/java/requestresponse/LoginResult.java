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

    public String getAuthtoken() {
        return authtoken;
    }

    public String getUsername() {
        return username;
    }

    public String getPersonID() {
        return personID;
    }

    public String getMessage() {
        return message;
    }
}
