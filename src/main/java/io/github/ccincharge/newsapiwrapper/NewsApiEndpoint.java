package io.github.ccincharge.newsapiwrapper;

import java.io.UnsupportedEncodingException;

abstract class NewsApiEndpoint {
    private String rootURL;
    private NewsApiResponse response;

    void setRootURL(String rootURL) {
        this.rootURL = rootURL;
    }

    String getRootURL() {
        return this.rootURL;
    }

    public abstract NewsApiResponse sendRequest(NewsApiRequestBuilder apiRequest)
            throws UnsupportedEncodingException;
    abstract String buildURL(NewsApiRequestBuilder apiRequest) throws UnsupportedEncodingException;
}
