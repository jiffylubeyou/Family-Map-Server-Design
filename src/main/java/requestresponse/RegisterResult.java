package requestresponse;

public class RegisterResult {
    String username;
    String personID;
    String message;
    public boolean success;

    public RegisterResult(String username, String personID, String message, boolean success)
    {
        this.username = username;
        this.personID = personID;
        this.message = message;
        this.success = success;
    }
}
