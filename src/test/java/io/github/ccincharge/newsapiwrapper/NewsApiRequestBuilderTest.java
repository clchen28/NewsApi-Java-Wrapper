package io.github.ccincharge.newsapiwrapper;

import org.junit.Test;

import static org.junit.Assert.*;

public class NewsApiRequestBuilderTest {
    @Test
    public void setSourcesString() throws Exception {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        newsApiRequestBuilder.setSources("abc-news");
        assertEquals("abc-news", newsApiRequestBuilder.getSources());
    }

    @Test
    public void setSources1() throws Exception {
    }

    @Test
    public void getSources() throws Exception {
    }

    @Test
    public void setQ() throws Exception {
    }

    @Test
    public void getQ() throws Exception {
    }

    @Test
    public void setCategory() throws Exception {
    }

    @Test
    public void getCategory() throws Exception {
    }

    @Test
    public void setLanguage() throws Exception {
    }

    @Test
    public void getLanguage() throws Exception {
    }

    @Test
    public void setCountry() throws Exception {
    }

    @Test
    public void getCountry() throws Exception {
    }

    @Test
    public void setDomains() throws Exception {
    }

    @Test
    public void getDomains() throws Exception {
    }

    @Test
    public void setFrom() throws Exception {
    }

    @Test
    public void setFrom1() throws Exception {
    }

    @Test
    public void getFrom() throws Exception {
    }

    @Test
    public void setTo() throws Exception {
    }

    @Test
    public void setTo1() throws Exception {
    }

    @Test
    public void getTo() throws Exception {
    }

    @Test
    public void setSortBy() throws Exception {
    }

    @Test
    public void getSortBy() throws Exception {
    }

    @Test
    public void setPage() throws Exception {
    }

    @Test
    public void getPage() throws Exception {
    }

    @Test
    public void setApiKey() throws Exception {
    }

}