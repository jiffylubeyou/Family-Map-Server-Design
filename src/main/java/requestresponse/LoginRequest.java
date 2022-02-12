package requestresponse;

public class LoginRequest {
    public String username;
    public String password;

    /**
     * acts as sort of a Constructor for the LoginRequest, although it is technically not a constructor
     * @param username
     * @param password
     */
    public void setDataFromRegister(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
}
