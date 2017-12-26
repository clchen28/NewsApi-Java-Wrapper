package io.github.ccincharge.newsapi.endpoints;

import io.github.ccincharge.newsapi.requests.RequestBuilder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Represents the NewsAPI REST endpoint that returns the top headlines that match a given query.
 * For more information, refer to the REST API docs:
 * https://newsapi.org/docs/endpoints/top-headlines
 */
public class TopEndpoint extends ArticlesEndpoint {
    /**
     * Instantiates a new TopEndpoint object. Sets the rootURL for the corresponding
     * REST endpoint.
     */
    public TopEndpoint() {
        super();
        this.setRootURL("https://newsapi.org/v2/top-headlines?");
    }

    /**
     * Constructs a WebTarget that encapsulates the specified queries and REST endpoint. Checks
     * for the presence of attributes in the apiRequest object that the top-headlines REST endpoint
     * accepts, and constructs a WebTarget with these attributes attached as query-string params.
     * @param apiRequest Request to construct query parameters out of.
     * @param restClient Existing JAX-RS Client used to execute HTTP request. Takes this as a
     *                   parameter as opposed to creating a new Client object because Clients
     *                   are expensive to instantiate.
     * @return WebTarget that contains the parameters from the apiRequest object encoded as a query
     * string for issuing as the actual GET request to the top-headlines REST endpoint.
     */
    WebTarget buildTarget(RequestBuilder apiRequest, Client restClient) {
        WebTarget target = restClient.target(this.getRootURL());
        if (apiRequest.getSources() != null) {
            target = target.queryParam("sources", apiRequest.getSources());
        }
        if (apiRequest.getQ() != null) {
            target = target.queryParam("q", apiRequest.getQ());
        }
        if (apiRequest.getCategory() != null) {
            target = target.queryParam("category", apiRequest.getCategory());
        }
        if (apiRequest.getLanguage() != null) {
            target = target.queryParam("language", apiRequest.getLanguage());
        }
        if (apiRequest.getCountry() != null) {
            target = target.queryParam("country", apiRequest.getCountry());
        }
        return target;
    }
}
