package io.github.ccincharge.newsapi;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import io.github.ccincharge.newsapi.requests.RequestBuilder;
import io.github.ccincharge.newsapi.endpoints.EverythingEndpoint;
import io.github.ccincharge.newsapi.endpoints.SourcesEndpoint;
import io.github.ccincharge.newsapi.endpoints.TopEndpoint;
import io.github.ccincharge.newsapi.responses.ApiArticlesResponse;
import io.github.ccincharge.newsapi.responses.ApiSourcesResponse;

/**
 * Java wrapper for the NewsAPI, encapsulating all API endpoints and possible queries. This class
 * exposes an interface to construct requests and to issue requests to the different REST
 * endpoints, as well as classes that map to the JSON responses of each endpoint.
 */
public class NewsApi {
    private String apiKey;
    private io.github.ccincharge.newsapi.endpoints.TopEndpoint TopEndpoint;
    private io.github.ccincharge.newsapi.endpoints.EverythingEndpoint EverythingEndpoint;
    private io.github.ccincharge.newsapi.endpoints.SourcesEndpoint SourcesEndpoint;
    private Client restClient;

    /**
     * Instantiate a new NewsApi object. Requires an API key.
     * @param apiKey Your NewsAPI API key. To get one, visit https://newsapi.org/
     */
    public NewsApi(String apiKey) {
        this.setApiKey(apiKey);
        initializeEndpoints();
    }

    private void initializeEndpoints() {
        this.TopEndpoint = new TopEndpoint();
        this.EverythingEndpoint = new EverythingEndpoint();
        this.SourcesEndpoint = new SourcesEndpoint();
    }

    /**
     * Sets the API key in the given RequestBuilder object, and also instantiates a new JAX-RS
     * client with which to issue HTTP requests, if one does not already exist. The JAX-RS client
     * is initialized here, and reused for all REST interactions, because instantiating a new
     * JAX-RS client is costly.
     * @param apiRequest Request to send to this Endpoint
     */
    private void initializeRequestAndClient(RequestBuilder apiRequest) {
        apiRequest.setApiKey(this.apiKey);
        if (this.restClient == null) {
            this.restClient = ClientBuilder.newClient();
        }
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Consumes the top-headlines endpoint. To view documentation on the actual REST endpoint,
     * visit https://newsapi.org/docs/endpoints/top-headlines
     * @param apiRequest Request to send to this Endpoint
     * @return ApiArticlesResponse object that is mapped from the response of this call to the
     * top-headlines REST endpoint.
     */
    public ApiArticlesResponse sendTopRequest(RequestBuilder apiRequest) {
        initializeRequestAndClient(apiRequest);
        return this.TopEndpoint.sendRequest(apiRequest, this.restClient);
    }

    /**
     * Consumes the everything endpoint. To view documentation on the actual REST endpoint, visit
     * https://newsapi.org/docs/endpoints/everything
     * @param apiRequest Request to send to this Endpoint
     * @return ApiArticlesResponse object that is mapped from the response of this call to the
     * everything REST endpoint.
     */
    public ApiArticlesResponse sendEverythingRequest(RequestBuilder apiRequest) {
        initializeRequestAndClient(apiRequest);
        return this.EverythingEndpoint.sendRequest(apiRequest, this.restClient);
    }

    /**
     * Consumes the sources endpoint. To view documentation on the actual REST endpoint, visit
     * https://newsapi.org/docs/endpoints/sources
     * @param apiRequest Request to send to this Endpoint
     * @return ApiSourcesResponse object that is mapped from the response of this call to the
     * everything REST endpoint.
     */
    public ApiSourcesResponse sendSourcesRequest(RequestBuilder apiRequest) {
        initializeRequestAndClient(apiRequest);
        return this.SourcesEndpoint.sendRequest(apiRequest, this.restClient);
    }

}
