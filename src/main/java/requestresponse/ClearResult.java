package requestresponse;

public class ClearResult {
    String message;
    public boolean success;

    public ClearResult(String message, boolean success)
    {
        this.message = message;
        this.success = success;
    };
}
