package services;

import dao.DataAccessException;
import dao.Database;
import dao.EventDao;
import model.Event;
import requestresponse.EventRequest;
import requestresponse.EventResult;

import java.sql.Connection;

public class EventService {
    private EventRequest eventRequest;

    /**
     * takes int event ID
     * @param eventRequest EventRequest object
     */
    public EventService (EventRequest eventRequest)
    {
        this.eventRequest = eventRequest;
    }

    /**
     * gives back the event info from the ID given
     * @return EventResult object
     */
    public EventResult processEvent () {

        Database database = new Database();
        try
        {
            Connection conn = database.getConnection();
            EventDao dao = new EventDao(conn);
            Event event = dao.find(eventRequest.eventID);
            database.closeConnection(true);
            if (event != null) {
                if (event.getUsername().equals(eventRequest.username)) {
                    return new EventResult(event.getEventID(), event.getUsername(), event.getPersonID(),
                            Float.toString(event.getLatitude()), Float.toString(event.getLongitude()), event.getCountry(), event.getCity(),
                            event.getEventType(), Integer.toString(event.getYear()), null, true);
                }
                else
                {
                    return new EventResult(null, null, null, null,
                            null, null, null, null, null,
                            "Error : Not In your family tree", false);
                }
            } else {
                return new EventResult(null, null, null, null,
                        null, null, null, null,null,
                        "Error : That event can't be found", false);
            }
        }
        catch (DataAccessException e)
        {
            try {
                database.closeConnection(false);
            } catch (DataAccessException ex)
            {
                return new EventResult(null,null,null,null,
                        null,null,null,null, null,
                        "Error :" + ex.getMessage(),false);
            }
            return new EventResult(null,null,null,null,
                    null,null,null,null, null,
                    "Error :" + e.getMessage(),false);

        }
    }
}
