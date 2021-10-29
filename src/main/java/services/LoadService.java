package services;

import requestresponse.LoadRequest;
import requestresponse.LoadResult;

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
    public LoadResult processLoad() {
        return new LoadResult("asdf", true);
    }
}
