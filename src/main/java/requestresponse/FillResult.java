package requestresponse;

public class FillResult {
    String message;
    public boolean success;

    public FillResult(String message, boolean success)
    {
        this.message = message;
        this.success = success;
    }
}
