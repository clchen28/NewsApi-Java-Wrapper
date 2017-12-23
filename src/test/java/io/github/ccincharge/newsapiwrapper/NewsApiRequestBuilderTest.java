package io.github.ccincharge.newsapiwrapper;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class NewsApiRequestBuilderTest {
    @Test
    void setSourcesString1() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        newsApiRequestBuilder.setSources("abc-news");
        assertEquals("abc-news", newsApiRequestBuilder.getSources());
    }

    @Test
    void setSourcesString0() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        newsApiRequestBuilder.setSources("");
        assertEquals("", newsApiRequestBuilder.getSources());
    }

    @Test
    void setSourcesString2() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        newsApiRequestBuilder.setSources("abc-news,abc-news-au");
        assertEquals("abc-news,abc-news-au", newsApiRequestBuilder.getSources());
    }

    @Test
    void setSourcesCollection1() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        Collection<String> sources = new ArrayList<String>();
        sources.add("abc-news");
        newsApiRequestBuilder.setSources(sources);
        assertEquals("abc-news", newsApiRequestBuilder.getSources());
    }

    @Test
    void setSourcesCollection2() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        Collection<String> sources = new ArrayList<String>();
        sources.add("abc-news");
        sources.add("abc-news-au");
        newsApiRequestBuilder.setSources(sources);
        assertEquals("abc-news,abc-news-au", newsApiRequestBuilder.getSources());
    }

    @Test
    void setQ() {
    }

    @Test
    void setCategory() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        newsApiRequestBuilder.setCategory("business");
        assertEquals("business", newsApiRequestBuilder.getCategory());
    }

    @Test
    void setCategoryBad() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                ()->newsApiRequestBuilder.setCategory("abcde"));
        assertTrue(e.getMessage().contains("Invalid category"));
    }

    @Test
    void setLanguage() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        newsApiRequestBuilder.setLanguage("en");
        assertEquals("en", newsApiRequestBuilder.getLanguage());
    }

    @Test
    void setCountry() {
    }

    @Test
    void setDomains() {
    }

    @Test
    void setFrom() {
    }

    @Test
    void setTo() {
    }

    @Test
    void setTo1() {
    }

    @Test
    void getTo() {
    }

    @Test
    void setSortBy() {
    }

    @Test
    void getSortBy() {
    }

    @Test
    void setPage() {
    }

    @Test
    void getPage() {
    }
}