package io.github.ccincharge.newsapi.endpoints;

import com.google.gson.Gson;
import io.github.ccincharge.newsapi.NewsApiRequestBuilder;
import io.github.ccincharge.newsapi.NewsApiSourcesResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class SourcesEndpoint extends Endpoint {
    public SourcesEndpoint() {
        super();
        this.setRootURL("https://newsapi.org/v2/sources?");
    }

    NewsApiSourcesResponse getDataFromResponseBody(String responseBody) {
        NewsApiSourcesResponse responseObj = (new Gson()).fromJson(responseBody,
                NewsApiSourcesResponse.class);
        responseObj.setRawJSON(responseBody);
        return responseObj;
    }

    public NewsApiSourcesResponse sendRequest(NewsApiRequestBuilder apiRequest,
                                                Client restClient) {
        WebTarget target = buildTarget(apiRequest, restClient);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);

        Response response = builder.header("X-Api-Key", apiRequest.getApiKey()).get();
        String responseBody = response.readEntity(String.class);

        NewsApiSourcesResponse responseObj = getDataFromResponseBody(responseBody);
        this.checkExceptions(response, responseObj);
        return responseObj;
    }

    WebTarget buildTarget(NewsApiRequestBuilder apiRequest, Client restClient) {
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
