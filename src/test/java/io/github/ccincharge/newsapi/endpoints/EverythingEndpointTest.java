package io.github.ccincharge.newsapi.endpoints;

import io.github.ccincharge.newsapi.datamodels.Article;
import io.github.ccincharge.newsapi.responses.ApiArticlesResponse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EverythingEndpointTest extends EndpointTest {
    @Test
    void getDataFromResponseBody() throws Exception {
        EverythingEndpoint everythingEndpoint = new EverythingEndpoint();
        String filename = "EverythingEndpointExampleResponse.txt";

        String responseBody = getBodyFromFile(filename);

        ApiArticlesResponse apiArticlesResponse = everythingEndpoint.getDataFromResponseBody(responseBody);
        assertEquals("ok", apiArticlesResponse.status());
        assertEquals(new Integer(36072), apiArticlesResponse.totalResults());
        assertEquals(responseBody, apiArticlesResponse.rawJSON());
        assertNull(apiArticlesResponse.code());
        assertNull(apiArticlesResponse.message());

        ArrayList<Article> articles = apiArticlesResponse.articles();
        assertNull(articles.get(0).author());
        assertEquals("Bitcoin", articles.get(0).title());
        assertEquals("Cryptocurrencies are gaining more and more popularity and on the background "
                + "of this interest in them by the ordinary web users is justified. Is it really "
                + "worth to get there if you do not understand anything? The answer is very "
                + "simple - only the latest news in…", articles.get(0).description());
        assertEquals("http://www.sostav.ru/blogs/132684/23861/", articles.get(0).url());
        assertNull(articles.get(0).urlToImage());
        assertEquals("2017-10-28T06:34:12Z", articles.get(0).publishedAt());
        assertNull(articles.get(0).source().id());
        assertEquals("Sostav.ru", articles.get(0).source().name());
    }

}