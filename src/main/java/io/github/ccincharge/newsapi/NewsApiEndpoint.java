package io.github.ccincharge.newsapi;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

abstract class NewsApiEndpoint {
    private String rootURL;

    void setRootURL(String rootURL) {
        this.rootURL = rootURL;
    }

    String getRootURL() {
        return this.rootURL;
    }

    public abstract NewsApiResponse sendRequest(NewsApiRequestBuilder apiRequest,
                                                Client restClient);

    abstract WebTarget buildTarget(NewsApiRequestBuilder apiRequest, Client restClient);
}
