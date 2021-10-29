package requestresponse;

public class EventRequest {
    public String eventID = null;
    public String username;

    public EventRequest(String username)
    {
        this.username = username;
    }

    public void setEventID(String eventID)
    {
        this.eventID = eventID;
    }
}
