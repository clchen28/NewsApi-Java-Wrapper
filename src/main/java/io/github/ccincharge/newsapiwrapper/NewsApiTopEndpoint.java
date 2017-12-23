package io.github.ccincharge.newsapiwrapper;

import java.io.UnsupportedEncodingException;
import java.util.StringJoiner;
import java.net.URLEncoder;

class NewsApiTopEndpoint extends NewsApiEndpoint {
    NewsApiTopEndpoint() {
        super();
        this.setRootURL("https://newsapi.org/v2/top-headlines?");
    }

    // FIXME: Actually implement this
    public NewsApiArticlesResponse sendRequest(NewsApiRequestBuilder apiRequest)
            throws UnsupportedEncodingException {
        String queryUrl = buildURL(apiRequest);
        return new NewsApiArticlesResponse();
    }

    String buildURL(NewsApiRequestBuilder apiRequest) throws UnsupportedEncodingException {
        StringJoiner paramJoiner = new StringJoiner(",");
        if (apiRequest.getSources() != null) {
            paramJoiner.add("sources=" + apiRequest.getSources());
        }
        if (apiRequest.getQ() != null) {
            paramJoiner.add("q=" + apiRequest.getQ());
        }
        if (apiRequest.getCategory() != null) {
            paramJoiner.add("category=" + apiRequest.getCategory());
        }
        if (apiRequest.getLanguage() != null) {
            paramJoiner.add("language=" + apiRequest.getLanguage());
        }
        if (apiRequest.getCountry() != null) {
            paramJoiner.add("country=" + apiRequest.getCountry());
        }
        String url = this.getRootURL() + paramJoiner.toString();
        String finalUrl;
        try {
            finalUrl = URLEncoder.encode(url, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            throw new UnsupportedEncodingException("All parameters in NewsApiRequestBuilder must "
                + "be URL encode-able.");
        }
        return finalUrl;
    }
}
