package io.github.ccincharge.newsapi.endpoints;

import com.google.gson.Gson;
import io.github.ccincharge.newsapi.requests.RequestBuilder;
import io.github.ccincharge.newsapi.responses.ApiSourcesResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Represents the NewsAPI REST endpoint that returns every news source that matches a given query.
 * For more information, refer to the REST API docs:
 * https://newsapi.org/docs/endpoints/sources
 */
public class SourcesEndpoint extends Endpoint {
    /**
     * Instantiates a new SourcesEndpoint object. Sets the rootURL for the corresponding
     * REST endpoint.
     */
    public SourcesEndpoint() {
        super();
        this.setRootURL("https://newsapi.org/v2/sources?");
    }

    /**
     * Takes a raw JSON response string and produces an ApiSourcesResponse object from this data.
     * @param responseBody Raw JSON response from the NewsAPI REST endpoint
     * @return Representation of the data in the raw JSON response
     */
    ApiSourcesResponse getDataFromResponseBody(String responseBody) {
        ApiSourcesResponse responseObj = (new Gson()).fromJson(responseBody,
                ApiSourcesResponse.class);
        responseObj.setRawJSON(responseBody);
        return responseObj;
    }

    /**
     * @param apiRequest Request to send to this Endpoint
     * @param restClient Existing JAX-RS Client used to execute HTTP request. Takes this as a
     *                   parameter as opposed to creating a new Client object because Clients
     *                   are expensive to instantiate.
     * @return ApiSourcesResponse object that encapsulates the response from the sources REST
     * endpoint.
     */
    public ApiSourcesResponse sendRequest(RequestBuilder apiRequest,
                                          Client restClient) {
        WebTarget target = buildTarget(apiRequest, restClient);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);

        Response response = builder.header("X-Api-Key", apiRequest.getApiKey()).get();
        String responseBody = response.readEntity(String.class);

        ApiSourcesResponse responseObj = getDataFromResponseBody(responseBody);
        this.checkExceptions(response, responseObj);
        return responseObj;
    }

    /**
     * Constructs a WebTarget that encapsulates the specified queries and REST endpoint. Checks
     * for the presence of attributes in the apiRequest object that the sources REST endpoint
     * accepts, and constructs a WebTarget with these attributes attached as query-string params.
     * @param apiRequest Request to construct query parameters out of.
     * @param restClient Existing JAX-RS Client used to execute HTTP request. Takes this as a
     *                   parameter as opposed to creating a new Client object because Clients
     *                   are expensive to instantiate.
     * @return WebTarget that contains the parameters from the apiRequest object encoded as a query
     * string for issuing as the actual GET request to the sources REST endpoint.
     */
    WebTarget buildTarget(RequestBuilder apiRequest, Client restClient) {
        WebTarget target = restClient.target(this.getRootURL());
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
