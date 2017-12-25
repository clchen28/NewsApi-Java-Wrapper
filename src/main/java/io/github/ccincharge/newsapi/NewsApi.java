package io.github.ccincharge.newsapi;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

class NewsApi {
    private String apiKey;
    private NewsApiTopEndpoint TopEndpoint;
    private NewsApiEverythingEndpoint EverythingEndpoint;
    private NewsApiSourcesEndpoint SourcesEndpoint;
    private Client restClient;

    public NewsApi(String apiKey) {
        this.setApiKey(apiKey);
        initializeEndpoints();
    }

    private void initializeEndpoints() {
        this.TopEndpoint = new NewsApiTopEndpoint();
        this.EverythingEndpoint = new NewsApiEverythingEndpoint();
        this.SourcesEndpoint = new NewsApiSourcesEndpoint();
    }

    private void initializeRequestAndClient(NewsApiRequestBuilder apiRequest) {
        apiRequest.setApiKey(this.apiKey);
        if (this.restClient == null) {
            this.restClient = ClientBuilder.newClient();
        }
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public NewsApiArticlesResponse sendTopRequest(NewsApiRequestBuilder apiRequest) {
        initializeRequestAndClient(apiRequest);
        return this.TopEndpoint.sendRequest(apiRequest, this.restClient);
    }


    public NewsApiArticlesResponse sendEverythingRequest(NewsApiRequestBuilder apiRequest) {
        initializeRequestAndClient(apiRequest);
        return this.EverythingEndpoint.sendRequest(apiRequest, this.restClient);
    }

    public NewsApiSourcesResponse sendSourcesRequest(NewsApiRequestBuilder apiRequest) {
        initializeRequestAndClient(apiRequest);
        return this.SourcesEndpoint.sendRequest(apiRequest, this.restClient);
    }

}
