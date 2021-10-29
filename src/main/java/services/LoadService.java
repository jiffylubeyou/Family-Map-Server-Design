package services;

import dao.*;
import model.Event;
import requestresponse.LoadRequest;
import requestresponse.LoadResult;

import java.sql.Connection;

public class LoadService {
    private LoadRequest loadRequest;

    /**
     * from this LoadRequest object will the results be generated from
     * @param loadRequest LoadRequest object
     */
    public LoadService (LoadRequest loadRequest){
        this.loadRequest = loadRequest;
    }

    /**
     * returns the result generated from the given request
     * @return LoadResult object
     */
    public LoadResult processLoad()
    {
        Database database = new Database();
        try {
            Connection conn = database.getConnection();
            UserDao userDao = new UserDao(conn);
            for (int i = 0; i < loadRequest.users.length; i++)
            {
                userDao.insert(loadRequest.users[i]);
            }
            PersonDao personDao = new PersonDao(conn);
            for (int i = 0; i < loadRequest.persons.length; i++)
            {
                personDao.insert(loadRequest.persons[i]);
            }
            EventDao eventDao = new EventDao(conn);
            for (int i = 0; i < loadRequest.events.length; ++i)
            {
                eventDao.insert(loadRequest.events[i]);
            }
            database.closeConnection(true);

        }
        catch (DataAccessException e)
        {
            try {
                database.closeConnection(false);
            }
            catch (DataAccessException ex)
            {
                return new LoadResult("Error: " + e.getMessage(), false);
            }
            return new LoadResult("Error: " + e.getMessage(), false);
        }
        return new LoadResult("asdf", true);
    }
}
