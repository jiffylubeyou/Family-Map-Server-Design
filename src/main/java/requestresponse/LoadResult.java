package requestresponse;

public class LoadResult {
    String message;
    public boolean success;

    /**
     * Constructor that builds object with correct information
     * @param message
     * @param success
     */
    public LoadResult(String message, boolean success)
    {
        this.message = message;
        this.success = success;
    }
}
