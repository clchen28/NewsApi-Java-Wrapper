package io.github.ccincharge.newsapiwrapper;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        newsApiRequestBuilder.setQ("my query");
        assertEquals("my+query", newsApiRequestBuilder.getQ());
    }

    @Test
    void setQSingle() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        newsApiRequestBuilder.setQ("query");
        assertEquals("query", newsApiRequestBuilder.getQ());
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
    void setLanguageBad() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                ()->newsApiRequestBuilder.setLanguage("abcde"));
        assertTrue(e.getMessage().contains("Invalid language"));
    }

    @Test
    void setCountry() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        newsApiRequestBuilder.setCountry("us");
        assertEquals("us", newsApiRequestBuilder.getCountry());
    }

    @Test
    void setCountryBad() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                ()->newsApiRequestBuilder.setCountry("abcde"));
        assertTrue(e.getMessage().contains("Invalid country"));
    }


    @Test
    void setDomains() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        newsApiRequestBuilder.setDomains("bbc.co.uk");
        assertEquals("bbc.co.uk", newsApiRequestBuilder.getDomains());
    }

    @Test
    void setDomainsSeveralString() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        newsApiRequestBuilder.setDomains("bbc.co.uk, techcrunch.com");
        assertEquals("bbc.co.uk,techcrunch.com", newsApiRequestBuilder.getDomains());
    }

    @Test
    void setDomainsCollection() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        Collection<String> domains = new ArrayList<String>();
        domains.add("bbc.co.uk");
        newsApiRequestBuilder.setDomains(domains);
        assertEquals("bbc.co.uk", newsApiRequestBuilder.getDomains());
    }

    @Test
    void setDomainsSeveralCollection() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        Collection<String> domains = new ArrayList<String>();
        domains.add("bbc.co.uk");
        domains.add("techcrunch.com");
        newsApiRequestBuilder.setDomains(domains);
        assertEquals("bbc.co.uk,techcrunch.com", newsApiRequestBuilder.getDomains());
    }

    @Test
    void setFromDate() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        long epoch = 0;
        Date testDate = new Date(epoch);
        newsApiRequestBuilder.setFrom(testDate);
        assertEquals("1970-01-01T00:00:00Z", newsApiRequestBuilder.getFrom());
    }

    @Test
    void setFromString() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        newsApiRequestBuilder.setFrom("1970-01-01T00:00:00Z");
        assertEquals("1970-01-01T00:00:00Z", newsApiRequestBuilder.getFrom());
    }

    @Test
    void setFromStringDayOnly() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        newsApiRequestBuilder.setFrom("1970-01-01");
        assertEquals("1970-01-01", newsApiRequestBuilder.getFrom());
    }

    @Test
    void setFromStringBadDay() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                ()->newsApiRequestBuilder.setFrom("1970-02-30"));
        assertTrue(e.getMessage().contains("Invalid from date"));
    }

    @Test
    void setFromStringInvalid() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                ()->newsApiRequestBuilder.setFrom("1970-01-01T00:00:61Z"));
        assertTrue(e.getMessage().contains("Invalid from date"));
    }

    @Test
    void setToDate() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        long epoch = 0;
        Date testDate = new Date(epoch);
        newsApiRequestBuilder.setTo(testDate);
        assertEquals("1970-01-01T00:00:00Z", newsApiRequestBuilder.getTo());
    }

    @Test
    void setToString() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        newsApiRequestBuilder.setTo("1970-01-01T00:00:00Z");
        assertEquals("1970-01-01T00:00:00Z", newsApiRequestBuilder.getTo());
    }

    @Test
    void setToStringInvalid() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                ()->newsApiRequestBuilder.setTo("1970-01-01T00:00:61Z"));
        assertTrue(e.getMessage().contains("Invalid to date"));
    }

    @Test
    void setSortBy() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        newsApiRequestBuilder.setSortBy("relevancy");
        assertEquals("relevancy", newsApiRequestBuilder.getSortBy());
    }

    @Test
    void setSortByInvalid() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                ()->newsApiRequestBuilder.setSortBy("test"));
        assertTrue(e.getMessage().contains("Invalid sortBy"));
    }

    @Test
    void setPage() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder();
        newsApiRequestBuilder.setPage(2);
        assertEquals(new Integer(2), newsApiRequestBuilder.getPage());
    }

    @Test
    void setMultiple() {
        NewsApiRequestBuilder newsApiRequestBuilder = new NewsApiRequestBuilder()
                .setPage(2)
                .setSources("abc-news,abc-news-au")
                .setLanguage("en");
        assertEquals(new Integer(2), newsApiRequestBuilder.getPage());
        assertEquals("abc-news,abc-news-au", newsApiRequestBuilder.getSources());
        assertEquals("en", newsApiRequestBuilder.getLanguage());
    }

}