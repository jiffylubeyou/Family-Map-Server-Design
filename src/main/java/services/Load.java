package services;

import requestresponse.LoadRequest;
import requestresponse.LoadResult;

public class Load {
    private LoadRequest loadRequest;

    /**
     * from this LoadRequest object will the results be generated from
     * @param loadRequest LoadRequest object
     */
    public Load (LoadRequest loadRequest){
        this.loadRequest = loadRequest;
    }

    /**
     * returns the result generated from the given request
     * @return LoadResult object
     */
    LoadResult processLoad() {
        return new LoadResult();
    }
}
