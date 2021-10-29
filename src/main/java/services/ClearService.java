package services;

import dao.DataAccessException;
import dao.Database;
import requestresponse.ClearResult;

public class ClearService {

    /**
     * @return ClearResult Object
     */
    public ClearResult processClear()
    {
        try
        {
            Database database = new Database();
            database.getConnection();
            database.clearTables();
            database.closeConnection(true);
            return new ClearResult("Clear succeeded", true);
        }
        catch (DataAccessException e)
        {
            return new ClearResult(("Error: " + e.getMessage()), false);
        }
    }
}
