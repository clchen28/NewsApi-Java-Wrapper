package io.github.ccincharge.newsapiwrapper;

import java.io.UnsupportedEncodingException;

class NewsApi {
    private String apiKey;
    private NewsApiTopEndpoint TopEndpoint;

    public NewsApi(String apiKey) {
        this.setApiKey(apiKey);
    }

    private void initializeEndpoints() {
        this.TopEndpoint = new NewsApiTopEndpoint();
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public NewsApiArticlesResponse sendTopRequest(NewsApiRequestBuilder apiRequest)
            throws UnsupportedEncodingException {
        apiRequest.setApiKey(this.apiKey);
        return this.TopEndpoint.sendRequest(apiRequest);
    }

    /*
    public NewsApiArticlesResponse sendEverythingRequest(NewsApiRequestBuilder apiRequest);

    public NewsApiSourcesResponse sendSourcesRequest(NewsApiRequestBuilder apiRequest);
    */
}
