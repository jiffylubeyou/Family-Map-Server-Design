package services;

import requestresponse.FillRequest;
import requestresponse.FillResult;

public class Fill {
    private FillRequest fillRequest;

    /**
     * hands the request info to the fill service
     * @param fillRequest FillRequest object
     */
    public Fill (FillRequest fillRequest)
    {
        this.fillRequest = fillRequest;
    }

    /**
     * Generates the fill Result
     * @return FillResult object
     */
    FillResult processFill () {
        return new FillResult();
    }
}
