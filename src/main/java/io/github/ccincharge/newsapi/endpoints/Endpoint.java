package io.github.ccincharge.newsapi.endpoints;

import io.github.ccincharge.newsapi.requests.RequestBuilder;
import io.github.ccincharge.newsapi.responses.ApiResponse;
import io.github.ccincharge.newsapi.exceptions.AuthFailureException;
import io.github.ccincharge.newsapi.exceptions.BadQueryException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Generic Endpoint class that encapsulates common functionality and features that are provided
 * by all of NewsAPI's REST endpoints. Each REST endpoint has its own URL for that resource. This
 * class also exposes a sendRequest method for the end user to use to issue a request to a given
 * REST endpoint.
 */
public abstract class Endpoint {
    /**
     * URL of the REST API endpoint
     */
    private String rootURL;

    void setRootURL(String rootURL) {
        this.rootURL = rootURL;
    }

    String getRootURL() {
        return this.rootURL;
    }

    /**
     * Sends an API request to the NewsAPI to this Endpoint, given a request with optional and
     * required request parameters.
     * @param apiRequest Request to send to this Endpoint
     * @param restClient Existing JAX-RS Client used to execute HTTP request. Takes this as a
     *                   parameter as opposed to creating a new Client object because Clients
     *                   are expensive to instantiate.
     * @return ApiResponse object with attributes filled from the response of NewsAPI REST
     * endpoint.
     */
    public abstract ApiResponse sendRequest(RequestBuilder apiRequest,
                                            Client restClient);

    /**
     * Constructs a WebTarget that encapsulates the specified queries and REST endpoint. Different
     * endpoints take in different query parameters, so each class that derives from Endpoint has
     * a specific set of queries that are checked for and built upon this WebTarget.
     * @param apiRequest Request to construct query parameters out of.
     * @param restClient Existing JAX-RS Client used to execute HTTP request. Takes this as a
     *                   parameter as opposed to creating a new Client object because Clients
     *                   are expensive to instantiate.
     * @return WebTarget that contains the parameters from the apiRequest object encoded as a query
     * string for issuing as the actual GET request to this REST endpoint.
     */
    abstract WebTarget buildTarget(RequestBuilder apiRequest, Client restClient);

    void checkExceptions(Response response, ApiResponse responseObj) {
        if (response.getStatus() == 401) {
            throw new AuthFailureException(responseObj.message());
        }
        else if (response.getStatus() == 400) {
            throw new BadQueryException(responseObj.message());
        }
    }


}
