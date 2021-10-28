package services;

import requestresponse.EventRequest;
import requestresponse.EventResult;

public class EventService {
    private EventRequest eventRequest;

    /**
     * Takes in the eventrequest object to process it later
     * @param eventRequest EventRequest Object
     */
    public EventService (EventRequest eventRequest)
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
