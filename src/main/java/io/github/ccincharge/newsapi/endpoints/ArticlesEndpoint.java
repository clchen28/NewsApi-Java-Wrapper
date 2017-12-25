package io.github.ccincharge.newsapi.endpoints;

import com.google.gson.Gson;
import io.github.ccincharge.newsapi.responses.ApiArticlesResponse;
import io.github.ccincharge.newsapi.requests.RequestBuilder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public abstract class ArticlesEndpoint extends Endpoint {
    ArticlesEndpoint() {
        super();
    }

    ApiArticlesResponse getDataFromResponseBody(String responseBody) {
        ApiArticlesResponse responseObj = (new Gson()).fromJson(responseBody,
                ApiArticlesResponse.class);
        responseObj.setRawJSON(responseBody);
        return responseObj;
    }

    public ApiArticlesResponse sendRequest(RequestBuilder apiRequest,
                                           Client restClient) {
        WebTarget target = buildTarget(apiRequest, restClient);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);

        Response response = builder.header("X-Api-Key", apiRequest.getApiKey()).get();
        String responseBody = response.readEntity(String.class);

        ApiArticlesResponse responseObj = getDataFromResponseBody(responseBody);
        this.checkExceptions(response, responseObj);
        return responseObj;
    }

}
