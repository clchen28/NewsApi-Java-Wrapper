package io.github.ccincharge.newsapi.requests;

import io.github.ccincharge.newsapi.requests.RequestBuilder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for RequestBuilder class. Checks for correct getting and setting of various
 * attributes.
 */
class RequestBuilderTest {
    @Test
    void setSourcesString1() {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.setSources("abc-news");
        assertEquals("abc-news", requestBuilder.getSources());
    }

    @Test
    void setSourcesString0() {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.setSources("");
        assertEquals("", requestBuilder.getSources());
    }

    @Test
    void setSourcesString2() {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.setSources("abc-news,abc-news-au");
        assertEquals("abc-news,abc-news-au", requestBuilder.getSources());
    }

    @Test
    void setSourcesCollection1() {
        RequestBuilder requestBuilder = new RequestBuilder();
        Collection<String> sources = new ArrayList<String>();
        sources.add("abc-news");
        requestBuilder.setSources(sources);
        assertEquals("abc-news", requestBuilder.getSources());
    }

    @Test
    void setSourcesCollection2() {
        RequestBuilder requestBuilder = new RequestBuilder();
        Collection<String> sources = new ArrayList<String>();
        sources.add("abc-news");
        sources.add("abc-news-au");
        requestBuilder.setSources(sources);
        assertEquals("abc-news,abc-news-au", requestBuilder.getSources());
    }

    @Test
    void setQ() {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.setQ("my query");
        assertEquals("my+query", requestBuilder.getQ());
    }

    @Test
    void setQSingle() {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.setQ("query");
        assertEquals("query", requestBuilder.getQ());
    }

    @Test
    void setCategory() {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.setCategory("business");
        assertEquals("business", requestBuilder.getCategory());
    }

    @Test
    void setCategoryBad() {
        RequestBuilder requestBuilder = new RequestBuilder();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                ()-> requestBuilder.setCategory("abcde"));
        assertTrue(e.getMessage().contains("Invalid category"));
    }

    @Test
    void setLanguage() {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.setLanguage("en");
        assertEquals("en", requestBuilder.getLanguage());
    }

    @Test
    void setLanguageBad() {
        RequestBuilder requestBuilder = new RequestBuilder();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                ()-> requestBuilder.setLanguage("abcde"));
        assertTrue(e.getMessage().contains("Invalid language"));
    }

    @Test
    void setCountry() {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.setCountry("us");
        assertEquals("us", requestBuilder.getCountry());
    }

    @Test
    void setCountryBad() {
        RequestBuilder requestBuilder = new RequestBuilder();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                ()-> requestBuilder.setCountry("abcde"));
        assertTrue(e.getMessage().contains("Invalid country"));
    }


    @Test
    void setDomains() {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.setDomains("bbc.co.uk");
        assertEquals("bbc.co.uk", requestBuilder.getDomains());
    }

    @Test
    void setDomainsSeveralString() {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.setDomains("bbc.co.uk, techcrunch.com");
        assertEquals("bbc.co.uk,techcrunch.com", requestBuilder.getDomains());
    }

    @Test
    void setDomainsCollection() {
        RequestBuilder requestBuilder = new RequestBuilder();
        Collection<String> domains = new ArrayList<String>();
        domains.add("bbc.co.uk");
        requestBuilder.setDomains(domains);
        assertEquals("bbc.co.uk", requestBuilder.getDomains());
    }

    @Test
    void setDomainsSeveralCollection() {
        RequestBuilder requestBuilder = new RequestBuilder();
        Collection<String> domains = new ArrayList<String>();
        domains.add("bbc.co.uk");
        domains.add("techcrunch.com");
        requestBuilder.setDomains(domains);
        assertEquals("bbc.co.uk,techcrunch.com", requestBuilder.getDomains());
    }

    @Test
    void setFromDate() {
        RequestBuilder requestBuilder = new RequestBuilder();
        long epoch = 0;
        Date testDate = new Date(epoch);
        requestBuilder.setFrom(testDate);
        assertEquals("1970-01-01T00:00:00Z", requestBuilder.getFrom());
    }

    @Test
    void setFromString() {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.setFrom("1970-01-01T00:00:00Z");
        assertEquals("1970-01-01T00:00:00Z", requestBuilder.getFrom());
    }

    @Test
    void setFromStringDayOnly() {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.setFrom("1970-01-01");
        assertEquals("1970-01-01", requestBuilder.getFrom());
    }

    @Test
    void setFromStringBadDay() {
        RequestBuilder requestBuilder = new RequestBuilder();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                ()-> requestBuilder.setFrom("1970-02-30"));
        assertTrue(e.getMessage().contains("Invalid from date"));
    }

    @Test
    void setFromStringInvalid() {
        RequestBuilder requestBuilder = new RequestBuilder();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                ()-> requestBuilder.setFrom("1970-01-01T00:00:61Z"));
        assertTrue(e.getMessage().contains("Invalid from date"));
    }

    @Test
    void setToDate() {
        RequestBuilder requestBuilder = new RequestBuilder();
        long epoch = 0;
        Date testDate = new Date(epoch);
        requestBuilder.setTo(testDate);
        assertEquals("1970-01-01T00:00:00Z", requestBuilder.getTo());
    }

    @Test
    void setToString() {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.setTo("1970-01-01T00:00:00Z");
        assertEquals("1970-01-01T00:00:00Z", requestBuilder.getTo());
    }

    @Test
    void setToStringInvalid() {
        RequestBuilder requestBuilder = new RequestBuilder();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                ()-> requestBuilder.setTo("1970-01-01T00:00:61Z"));
        assertTrue(e.getMessage().contains("Invalid to date"));
    }

    @Test
    void setSortBy() {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.setSortBy("relevancy");
        assertEquals("relevancy", requestBuilder.getSortBy());
    }

    @Test
    void setSortByInvalid() {
        RequestBuilder requestBuilder = new RequestBuilder();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                ()-> requestBuilder.setSortBy("test"));
        assertTrue(e.getMessage().contains("Invalid sortBy"));
    }

    @Test
    void setPage() {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.setPage(2);
        assertEquals(new Integer(2), requestBuilder.getPage());
    }

    @Test
    void setMultiple() {
        RequestBuilder requestBuilder = new RequestBuilder()
                .setPage(2)
                .setSources("abc-news,abc-news-au")
                .setLanguage("en");
        assertEquals(new Integer(2), requestBuilder.getPage());
        assertEquals("abc-news,abc-news-au", requestBuilder.getSources());
        assertEquals("en", requestBuilder.getLanguage());
    }

}