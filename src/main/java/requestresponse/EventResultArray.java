package requestresponse;

import model.Event;

public class EventResultArray {
    Event[] data;
    String message;
    public boolean success;

    public EventResultArray (Event[] data, String message, boolean success)
    {
        this.data = data;
        this.message = message;
        this.success = success;
    }
}
