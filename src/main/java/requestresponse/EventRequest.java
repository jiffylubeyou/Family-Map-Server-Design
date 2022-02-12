package requestresponse;

public class EventRequest {
    public String eventID = null;
    public String username;

    /**
     * The constructor takes in the variables necessary to build the object
     * @param username
     */
    public EventRequest(String username)
    {
        this.username = username;
    }

    public void setEventID(String eventID)
    {
        this.eventID = eventID;
    }
}
