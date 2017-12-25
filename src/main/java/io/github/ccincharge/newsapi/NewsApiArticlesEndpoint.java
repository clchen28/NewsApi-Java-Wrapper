package io.github.ccincharge.newsapi;

import com.google.gson.Gson;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

abstract class NewsApiArticlesEndpoint extends NewsApiEndpoint {
    NewsApiArticlesEndpoint() {
        super();
    }

    public NewsApiArticlesResponse sendRequest(NewsApiRequestBuilder apiRequest,
                                               Client restClient) {
        WebTarget target = buildTarget(apiRequest, restClient);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);

        Response response = builder.header("X-Api-Key", apiRequest.getApiKey()).get();
        String responseBody = response.readEntity(String.class);
        NewsApiArticlesResponse responseObj = (new Gson()).fromJson(responseBody,
                NewsApiArticlesResponse.class);

        if (response.getStatus() == 401) {
            throw new NewsApiAuthFailureException(responseObj.message());
        }
        else if (response.getStatus() == 400) {
            throw new NewsApiBadQueryException(responseObj.message());
        }

        responseObj.setRawJSON(responseBody);
        return responseObj;
    }

}
