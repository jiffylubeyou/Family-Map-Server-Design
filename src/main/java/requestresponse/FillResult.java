package requestresponse;

public class FillResult {
    String message;
    public boolean success;

    /**
     * constructor that builds the object with correct information
     * @param message
     * @param success
     */
    public FillResult(String message, boolean success)
    {
        this.message = message;
        this.success = success;
    }
}
