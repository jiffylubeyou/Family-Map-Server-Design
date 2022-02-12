package requestresponse;

public class PersonRequest {
    public String personID = null;
    public String username;

    /**
     * @param username String object
     */
    public PersonRequest(String username)
    {
        this.username = username;
    }

    /**
     * Sets the person ID of this object
     * @param personID
     */
    public void setPersonID(String personID)
    {
        this.personID = personID;
    }
}
