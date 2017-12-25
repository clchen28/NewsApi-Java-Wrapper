package io.github.ccincharge.newsapi.endpoints;

import io.github.ccincharge.newsapi.NewsApiRequestBuilder;
import io.github.ccincharge.newsapi.NewsApiResponse;
import io.github.ccincharge.newsapi.exceptions.AuthFailureException;
import io.github.ccincharge.newsapi.exceptions.BadQueryException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

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

    void checkExceptions(Response response, NewsApiResponse responseObj) {
        if (response.getStatus() == 401) {
            throw new AuthFailureException(responseObj.message());
        }
        else if (response.getStatus() == 400) {
            throw new BadQueryException(responseObj.message());
        }
    }


}
