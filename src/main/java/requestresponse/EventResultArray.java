package requestresponse;

import model.Event;

public class EventResultArray {
    Event[] data;
    String message;
    public boolean success;

    /**
     * takes in information necessary to build the object
     * @param data
     * @param message
     * @param success
     */
    public EventResultArray (Event[] data, String message, boolean success)
    {
        this.data = data;
        this.message = message;
        this.success = success;
    }

    /**
     * @return Event[] object
     */
    public Event[] getEvents() {
        return data;
    }

    /**
     * returns the message
     * @return String object
     */
    public String getMessage() {
        return message;
    }
}
