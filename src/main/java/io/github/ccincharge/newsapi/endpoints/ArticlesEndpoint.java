package io.github.ccincharge.newsapi.endpoints;

import com.google.gson.Gson;
import io.github.ccincharge.newsapi.NewsApiArticlesResponse;
import io.github.ccincharge.newsapi.NewsApiRequestBuilder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public abstract class ArticlesEndpoint extends Endpoint {
    ArticlesEndpoint() {
        super();
    }

    NewsApiArticlesResponse getDataFromResponseBody(String responseBody) {
        NewsApiArticlesResponse responseObj = (new Gson()).fromJson(responseBody,
                NewsApiArticlesResponse.class);
        responseObj.setRawJSON(responseBody);
        return responseObj;
    }

    public NewsApiArticlesResponse sendRequest(NewsApiRequestBuilder apiRequest,
                                               Client restClient) {
        WebTarget target = buildTarget(apiRequest, restClient);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);

        Response response = builder.header("X-Api-Key", apiRequest.getApiKey()).get();
        String responseBody = response.readEntity(String.class);

        NewsApiArticlesResponse responseObj = getDataFromResponseBody(responseBody);
        this.checkExceptions(response, responseObj);
        return responseObj;
    }

}
