package io.github.ccincharge.newsapi;

import com.github.shyiko.dotenv.DotEnv;
import io.github.ccincharge.newsapi.exceptions.*;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class NewsApiTest {

    private Map<String, String> dotEnv = DotEnv.load();

    @Test
    void sendTopRequestBadAuth() {
        NewsApi newsApi = new NewsApi("badKey");
        NewsApiRequestBuilder request = new NewsApiRequestBuilder().setQ("bitcoin");
        NewsApiAuthFailureException e = assertThrows(NewsApiAuthFailureException.class,
                ()->newsApi.sendTopRequest(request));
        assertTrue(e.getMessage().contains("Your API key is invalid or incorrect"));
    }

    @Test
    void sendTopRequest() {
        NewsApi newsApi = new NewsApi(dotEnv.get("API_KEY"));
        NewsApiRequestBuilder request = new NewsApiRequestBuilder().setQ("bitcoin");
        NewsApiArticlesResponse response = newsApi.sendTopRequest(request);
        assertEquals("ok", response.status());
        assertNotNull(response.totalResults());
        assertNotNull(response.articles());
    }

    @Test
    void sendTopRequestNoQuery() {
        NewsApi newsApi = new NewsApi(dotEnv.get("API_KEY"));
        NewsApiRequestBuilder request = new NewsApiRequestBuilder();
        NewsApiBadQueryException e = assertThrows(NewsApiBadQueryException.class,
                ()->newsApi.sendTopRequest(request));
        assertTrue(e.getMessage().contains("Required parameters are missing"));
    }

    @Test
    void sendEverythingRequestBadAuth() {
        NewsApi newsApi = new NewsApi("badKey");
        NewsApiRequestBuilder request = new NewsApiRequestBuilder().setQ("bitcoin");
        NewsApiAuthFailureException e = assertThrows(NewsApiAuthFailureException.class,
                ()->newsApi.sendEverythingRequest(request));
        assertTrue(e.getMessage().contains("Your API key is invalid or incorrect"));
    }

    @Test
    void sendEverythingRequest() {
        NewsApi newsApi = new NewsApi(dotEnv.get("API_KEY"));
        NewsApiRequestBuilder request = new NewsApiRequestBuilder().setQ("bitcoin");
        NewsApiArticlesResponse response = newsApi.sendEverythingRequest(request);
        assertEquals("ok", response.status());
        assertNotNull(response.totalResults());
        assertNotNull(response.articles());
    }

    @Test
    void sendEverythingRequestNoQuery() {
        NewsApi newsApi = new NewsApi(dotEnv.get("API_KEY"));
        NewsApiRequestBuilder request = new NewsApiRequestBuilder();
        NewsApiBadQueryException e = assertThrows(NewsApiBadQueryException.class,
                ()->newsApi.sendEverythingRequest(request));
        assertTrue(e.getMessage().contains("Required parameters are missing"));
    }

    @Test
    void sendSourcesRequestBadAuth() {
        NewsApi newsApi = new NewsApi("badKey");
        NewsApiRequestBuilder request = new NewsApiRequestBuilder();
        NewsApiAuthFailureException e = assertThrows(NewsApiAuthFailureException.class,
                ()->newsApi.sendSourcesRequest(request));
        assertTrue(e.getMessage().contains("Your API key is invalid or incorrect"));
    }

    @Test
    void sendSourcesRequest() {
        NewsApi newsApi = new NewsApi(dotEnv.get("API_KEY"));
        NewsApiRequestBuilder request = new NewsApiRequestBuilder();
        NewsApiSourcesResponse response = newsApi.sendSourcesRequest(request);
        assertEquals("ok", response.status());
        assertNotNull(response.sources());
    }

}