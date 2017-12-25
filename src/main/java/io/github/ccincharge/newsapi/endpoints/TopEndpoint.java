package io.github.ccincharge.newsapi.endpoints;

import io.github.ccincharge.newsapi.requests.RequestBuilder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

public class TopEndpoint extends ArticlesEndpoint {
    public TopEndpoint() {
        super();
        this.setRootURL("https://newsapi.org/v2/top-headlines?");
    }

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
