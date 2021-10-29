package requestresponse;

public class LoadResult {
    String message;
    public boolean success;

    public LoadResult(String message, boolean success)
    {
        this.message = message;
        this.success = success;
    }
}
