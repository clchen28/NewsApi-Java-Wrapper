package io.github.ccincharge.newsapiwrapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

class NewsApiEverythingEndpoint extends NewsApiArticlesEndpoint {
    NewsApiEverythingEndpoint() {
        super();
        this.setRootURL("https://newsapi.org/v2/everything?");
    }

    WebTarget buildTarget(NewsApiRequestBuilder apiRequest, Client restClient) {
        WebTarget target = restClient.target(this.getRootURL());
        if (apiRequest.getQ() != null) {
            target = target.queryParam("q", apiRequest.getQ());
        }
        if (apiRequest.getSources() != null) {
            target = target.queryParam("sources", apiRequest.getSources());
        }
        if (apiRequest.getDomains() != null) {
            target = target.queryParam("domains", apiRequest.getDomains());
        }
        if (apiRequest.getFrom() != null) {
            target = target.queryParam("from", apiRequest.getFrom());
        }
        if (apiRequest.getTo() != null) {
            target = target.queryParam("to", apiRequest.getTo());
        }
        if (apiRequest.getLanguage() != null) {
            target = target.queryParam("language", apiRequest.getLanguage());
        }
        if (apiRequest.getSortBy() != null) {
            target = target.queryParam("sortBy", apiRequest.getSortBy());
        }
        if (apiRequest.getPage() != null) {
            target = target.queryParam("page", apiRequest.getPage().toString());
        }
        return target;
    }
}
