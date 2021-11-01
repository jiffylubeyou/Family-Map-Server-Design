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
        Database database = new Database();
        try
        {
            database.getConnection();
            database.clearTables();
            database.closeConnection(true);
            return new ClearResult("Clear succeeded", true);
        }
        catch (DataAccessException e)
        {
            try {
                database.closeConnection(false);
                return new ClearResult(("Error: " + e.getMessage()), false);
            }
            catch (DataAccessException ex)
            {
                return new ClearResult(("Error: " + ex.getMessage()), false);
            }
        }
    }
}
