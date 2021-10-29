package requestresponse;

public class LoginRequest {
    public String username;
    public String password;

    public void setDataFromRegister(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
}
