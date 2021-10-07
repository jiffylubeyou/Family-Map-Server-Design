package services;

import requestresponse.EventRequest;
import requestresponse.EventResult;

public class Event {
    private EventRequest eventRequest;

    /**
     * Takes in the eventrequest object to process it later
     * @param eventRequest EventRequest Object
     */
    public Event (EventRequest eventRequest)
    {
        this.eventRequest = eventRequest;
    }

    /**
     * Generate and return the result object
     * @return EventResult object
     */
    EventResult processEvent() {
        return new EventResult();
    }
}
