package requestresponse;

public class RegisterResult {
    public String username;
    String personID;
    public String password;
    String message;
    public boolean success;

    /**
     * Constructor that builds the object with the correct information
     * @param username
     * @param personID
     * @param password
     * @param message
     * @param success
     */
    public RegisterResult(String username, String personID, String password, String message, boolean success)
    {
        this.username = username;
        this.personID = personID;
        this.password = password;
        this.message = message;
        this.success = success;
    }

    /**
     * @return username String object
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return personID String object
     */
    public String getPersonID() {
        return personID;
    }

    /**
     * @return password String object
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return message String object
     */
    public String getMessage() {
        return message;
    }
}
