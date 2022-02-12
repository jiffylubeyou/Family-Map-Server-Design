package requestresponse;

public class LoginResult {
    String authtoken;
    String username;
    String personID;
    String message;
    public boolean success;

    /**
     * Builds the object taking in the necessary information
     * @param authtoken
     * @param username
     * @param personID
     * @param message
     * @param success
     */
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

    /**
     * @return String object username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return String object personID
     */
    public String getPersonID() {
        return personID;
    }

    /**
     * @return String object message
     */
    public String getMessage() {
        return message;
    }
}
