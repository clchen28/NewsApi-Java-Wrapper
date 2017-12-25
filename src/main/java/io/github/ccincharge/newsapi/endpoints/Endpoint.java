package io.github.ccincharge.newsapi.endpoints;

import io.github.ccincharge.newsapi.NewsApiRequestBuilder;
import io.github.ccincharge.newsapi.NewsApiResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

public abstract class Endpoint {
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
