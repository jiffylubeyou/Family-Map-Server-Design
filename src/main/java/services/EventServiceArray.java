package services;

import dao.DataAccessException;
import dao.Database;
import dao.EventDao;
import model.Event;
import requestresponse.EventRequest;
import requestresponse.EventResult;
import requestresponse.EventResultArray;

import java.sql.Connection;

public class EventServiceArray {
    private EventRequest eventRequestArray;

    /**
     * takes int event ID
     * @param  eventRequest object
     */
    public EventServiceArray (EventRequest eventRequest)
    {
        this.eventRequestArray = eventRequest;
    }

    /**
     * gives back the Event info from the ID given
     * @return EventResult object
     */
    public EventResultArray processEventArray () {
        Database database = new Database();
        try
        {
            Connection conn = database.getConnection();
            EventDao dao = new EventDao(conn);
            Event[] events = dao.getEventsByUsername(eventRequestArray.username);
            database.closeConnection(true);
            return new EventResultArray(events, null, true);
        }
        catch (DataAccessException e)
        {
            try {
                database.closeConnection(false);
            } catch (DataAccessException ex)
            {
                return new EventResultArray(null,"Error :" + ex.getMessage(),false);
            }
            return new EventResultArray(null,"Error :" + e.getMessage(),false);

        }
    }
}
