package io.github.ccincharge.newsapi;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import io.github.ccincharge.newsapi.requests.RequestBuilder;
import io.github.ccincharge.newsapi.endpoints.EverythingEndpoint;
import io.github.ccincharge.newsapi.endpoints.SourcesEndpoint;
import io.github.ccincharge.newsapi.endpoints.TopEndpoint;
import io.github.ccincharge.newsapi.responses.ApiArticlesResponse;
import io.github.ccincharge.newsapi.responses.ApiSourcesResponse;

class NewsApi {
    private String apiKey;
    private io.github.ccincharge.newsapi.endpoints.TopEndpoint TopEndpoint;
    private io.github.ccincharge.newsapi.endpoints.EverythingEndpoint EverythingEndpoint;
    private io.github.ccincharge.newsapi.endpoints.SourcesEndpoint SourcesEndpoint;
    private Client restClient;

    public NewsApi(String apiKey) {
        this.setApiKey(apiKey);
        initializeEndpoints();
    }

    private void initializeEndpoints() {
        this.TopEndpoint = new TopEndpoint();
        this.EverythingEndpoint = new EverythingEndpoint();
        this.SourcesEndpoint = new SourcesEndpoint();
    }

    private void initializeRequestAndClient(RequestBuilder apiRequest) {
        apiRequest.setApiKey(this.apiKey);
        if (this.restClient == null) {
            this.restClient = ClientBuilder.newClient();
        }
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public ApiArticlesResponse sendTopRequest(RequestBuilder apiRequest) {
        initializeRequestAndClient(apiRequest);
        return this.TopEndpoint.sendRequest(apiRequest, this.restClient);
    }


    public ApiArticlesResponse sendEverythingRequest(RequestBuilder apiRequest) {
        initializeRequestAndClient(apiRequest);
        return this.EverythingEndpoint.sendRequest(apiRequest, this.restClient);
    }

    public ApiSourcesResponse sendSourcesRequest(RequestBuilder apiRequest) {
        initializeRequestAndClient(apiRequest);
        return this.SourcesEndpoint.sendRequest(apiRequest, this.restClient);
    }

}
