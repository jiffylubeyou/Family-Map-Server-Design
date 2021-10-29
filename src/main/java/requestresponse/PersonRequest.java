package requestresponse;

public class PersonRequest {
    public String personID = null;
    public String username;

    public PersonRequest(String username)
    {
        this.username = username;
    }

    public void setPersonID(String personID)
    {
        this.personID = personID;
    }
}
