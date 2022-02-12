package requestresponse;



public class ClearResult {
    String message;
    public boolean success;


    /**
     * this returns the message and success objects inside of the ClearResult object
     * @param message
     * @param success
     */
    public ClearResult(String message, boolean success)
    {
        this.message = message;
        this.success = success;
    };
}
