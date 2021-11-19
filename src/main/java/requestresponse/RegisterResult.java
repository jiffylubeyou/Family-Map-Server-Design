package requestresponse;

public class RegisterResult {
    public String username;
    String personID;
    public String password;
    String message;
    public boolean success;

    public RegisterResult(String username, String personID, String password, String message, boolean success)
    {
        this.username = username;
        this.personID = personID;
        this.password = password;
        this.message = message;
        this.success = success;
    }

    public String getUsername() {
        return username;
    }

    public String getPersonID() {
        return personID;
    }

    public String getPassword() {
        return password;
    }

    public String getMessage() {
        return message;
    }
}
