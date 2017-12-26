package io.github.ccincharge.newsapi.requests;

import com.google.common.collect.Sets;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

/**
 * RequestBuilder is a Builder class that constructs a request based on given request parameters.
 * This class is sent to Endpoint objects, which take the RequestBuilder and construct a
 * query-string out of the given RequestBuilder in order to issue the appropriate GET request to
 * NewsAPI's REST endpoints.
 */
public class RequestBuilder {
    private String sources;
    private String q;
    private String category;
    private String language;
    private String country;
    private String domains;
    private String from;
    private String to;
    private String sortBy;
    private Integer page;
    private String apiKey;

    static private final Set<String> validCategories = Sets.newHashSet("business", "entertainment",
            "gaming", "general", "health-and-medical", "music", "politics", "science-and-nature",
            "sport", "technology");
    static private final Set<String> validLanguages = Sets.newHashSet("ar", "en", "cn", "de", "es",
            "fr", "he", "it", "nl", "no", "pt", "ru", "sv", "ud");
    static private final Set<String> validCountries = Sets.newHashSet("ar", "au", "br", "ca", "cn",
            "de", "es", "fr", "gb", "hk", "ie", "in", "is", "it", "nl", "no", "pk", "ru", "sa",
            "sv", "us", "za");
    static private final Set<String> validSortBy = Sets.newHashSet("relevancy", "popularity",
            "publishedAt");

    /**
     * Set the desired news sources for this request.
     * @param sources Comma-delimited string of source id's that NewsAPI recognizes. To get the
     *                full list of possible source id's, use the SourceEndpoint or refer to the
     *                NewsAPI REST documentation here: https://newsapi.org/docs/endpoints/sources
     * @return This RequestBuilder object with sources attribute set to the given input
     */
    public RequestBuilder setSources(String sources) {
        this.sources = sources.replaceAll("\\s","");
        return this;
    }

    /**
     * Set the desired news sources for this request.
     * @param sources Collection of source id's, where each element in the collection is a source
     *                id that NewsAPI recognizes. To get the full list of possible source id's,
     *                use the SourceEndpoint or refer to the NewsAPI REST documentation here:
     *                https://newsapi.org/docs/endpoints/sources
     * @return This RequestBuilder object with sources attribute set to the given input
     */
    public RequestBuilder setSources(Collection<String> sources) {
        this.sources = String.join(",", sources);
        return this;
    }

    /**
     * Get the desired news sources for this request.
     * @return Comma-delimited string of source id's
     */
    public String getSources() {
        return this.sources;
    }

    /**
     * Sets the query for the desired news articles for this request. Provide the query in plain
     * text, as this method will automatically apply URL encoding to the given input.
     * @param q String to query for, in plain text
     * @return This RequestBuilder object with query attribute set to the given input
     */
    public RequestBuilder setQ(String q) {
        try {
            q = URLEncoder.encode(q, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            throw new AssertionError("UTF-8 not supported");
        }
        this.q = q;
        return this;
    }

    /**
     * Gets the query for this request.
     * @return String representing the query from this request.
     */
    public String getQ() {
        return this.q;
    }

    /**
     * Sets the category of news articles or news sources.
     * @param category String representing category of news articles or news sources to obtain with
     *                 this query. The possible values for this are business, entertainment,
     *                 gaming, general, health-and-medical, music, politics, science-and-nature,
     *                 sport, and technology.
     * @return This RequestBuilder object with category attribute set to the given input
     */
    public RequestBuilder setCategory(String category) {
        if (!validCategories.contains(category)) {
            throw new IllegalArgumentException("Invalid category - must be one of the following: "
                    + String.join(", ", validCategories));
        }
        this.category = category;
        return this;
    }

    /**
     * Gets the category associated with this request.
     * @return String representing the category from this request.
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * Sets the language for news articles and sources obtained from this request.
     * @param language String representing the ISO 3166-1 language code that this request should
     *                 return. Possible values are ar, en, cn, de, es, fr, he, it, nl, no, pt, ru,
     *                 sv, and ud.
     * @return This RequestBuilder object with category attribute set to the given input
     */
    public RequestBuilder setLanguage(String language) {
        if (!validLanguages.contains(language)) {
            throw new IllegalArgumentException("Invalid language - must be one of the following: "
                    + String.join(", ", validLanguages));
        }
        this.language = language;
        return this;
    }

    /**
     * Gets the language associated with this request.
     * @return String representing the language from this request.
     */
    public String getLanguage() {
        return this.language;
    }

    /**
     * Sets the country for news articles and sources obtained from this request.
     * @param country String representing the ISO 3166-1 country code of the news sources that
     *                this request should return. Possible values are ar, au, br, ca, cn, de, es,
     *                fr, gb, hk, ie, in, is, it, nl, no, pk, ru, sa, sv, us, and za.
     * @return This RequestBuilder object with category attribute set to the given input
     */
    public RequestBuilder setCountry(String country) {
        if (!validCountries.contains(country)) {
            throw new IllegalArgumentException("Invalid country - must be one of the following: "
                    + String.join(", ", validCountries));
        }
        this.country = country;
        return this;
    }

    /**
     * Gets the country associated with this request.
     * @return String representing the country from this request.
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Sets the allowable domain names associated with this request.
     * @param domains Comma-delimited string of domains that the endpoint should return results for.
     * @return This RequestBuilder object with category attribute set to the given input
     */
    public RequestBuilder setDomains(String domains) {
        this.domains = domains.replaceAll("\\s","");
        return this;
    }

    /**
     * Sets the allowable domain names associated with this request.
     * @param domains Collection of domains that the endpoint should return results for, with every
     *                element of the collection be a domain.
     * @return This RequestBuilder object with category attribute set to the given input
     */
    public RequestBuilder setDomains(Collection<String> domains) {
        this.domains = String.join(",", domains);
        return this;
    }

    /**
     * Gets the domains associated with this request.
     * @return String representing the domains from this request.
     */
    public String getDomains() {
        return this.domains;
    }

    /**
     * Checks to see if the input string is a valid date in a format that is accepted by the
     * NewsAPI endpoints.
     * @param date String representing a date that is to be checked for validity.
     * @return True if the input is a String representation of a valid date, and False otherwise.
     */
    private Boolean validateDate(String date) {
        if (date.length() == 10) {
            try {
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                formatter.setLenient(false);
                formatter.parse(date);
            } catch (ParseException e) {
                return false;
            }
        }
        else {
            try {
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                formatter.setLenient(false);
                formatter.parse(date);
            } catch (ParseException e) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sets the from date associated with this request. ArticlesEndpoint will then only return news
     * Articles that are published no earlier than this date.
     * @param from Earliest publication date of desired articles
     * @return This RequestBuilder object with category attribute set to the given input
     */
    public RequestBuilder setFrom(Date from) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(tz);
        this.from = df.format(from);
        return this;
    }

    /**
     * Sets the from date associated with this request. ArticlesEndpoint will then only return news
     * Articles that are published no earlier than this date.
     * @param from String of date (and possibly also time), in UTC, of the earliest publication
     *             date of desired articles. Must be in either yyyy-MM-dd format, or in
     *             yyyy-MM-ddTHH:mm:ssZ format.
     *             e.g., 2017-12-25T18:32:56Z for December 25, 2017 at 06:32:56 PM UTC, or
     *             2017-12-25 for December 25, 2017.
     * @return This RequestBuilder object with category attribute set to the given input
     */
    public RequestBuilder setFrom(String from) {
        if (!validateDate(from)) {
            throw new IllegalArgumentException("Invalid from date, must have \"yyyy-MM-dd\" or "
                    + " \"yyyy-MM-dd'T'HH:mm:ss'Z'\" pattern");
        }
        this.from = from;
        return this;
    }

    /**
     * Gets the from date associated with this request.
     * @return String representing the from date for this request.
     */
    public String getFrom() {
        return this.from;
    }

    /**
     * Sets the to date associated with this request. ArticlesEndpoint will then only return news
     * Articles that are published no later than this date.
     * @param to Latest publication date of desired articles
     * @return This RequestBuilder object with category attribute set to the given input
     */
    public RequestBuilder setTo(Date to) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(tz);
        this.to = df.format(to);
        return this;
    }

    /**
     * Sets the to date associated with this request. ArticlesEndpoint will then only return news
     * Articles that are published no later than this date.
     * @param to String of date (and possibly also time), in UTC, of the latest publication
     *           date of desired articles. Must be in either yyyy-MM-dd format, or in
     *           yyyy-MM-ddTHH:mm:ssZ format.
     *           e.g., 2017-12-25T18:32:56Z for December 25, 2017 at 06:32:56 PM UTC, or
     *           2017-12-25 for December 25, 2017.
     * @return This RequestBuilder object with category attribute set to the given input
     */
    public RequestBuilder setTo(String to) {
        if (!validateDate(to)) {
            throw new IllegalArgumentException("Invalid to date, must have \"yyyy-MM-dd\" or "
                    + " \"yyyy-MM-dd'T'HH:mm:ss'Z'\" pattern");
        }
        this.to = to;
        return this;
    }

    /**
     * Gets the to date associated with this request.
     * @return String representing the to date for this request.
     */
    public String getTo() {
        return this.to;
    }

    /**
     * Sets the sortBy associated with this request. The EverythingEndpoint can return Articles
     * that are sorted by various options.
     * @param sortBy String that represents the order in which Articles should be sorted in, upon
     *               return. Possible values are relevancy, popularity, and publishedAt. Defaults
     *               to publishedAt.
     * @return This RequestBuilder object with category attribute set to the given input
     */
    public RequestBuilder setSortBy(String sortBy) {
        if (!validSortBy.contains(sortBy)) {
            throw new IllegalArgumentException("Invalid sortBy - must be one of the following: "
                    + validSortBy.toString());
        }
        this.sortBy = sortBy;
        return this;
    }

    /**
     * Gets the sortBy associated with this request.
     * @return String representing the sortBy for this request.
     */
    public String getSortBy() {
        return this.sortBy;
    }

    /**
     * Sets the page associated with this request. The EverythingEndpoint only returns a limited
     * number of Articles per request, so this can be used to page through the different Articles.
     * @param page Page number that is desired for this request
     * @return This RequestBuilder object with category attribute set to the given input
     */
    public RequestBuilder setPage(Integer page) {
        this.page = page;
        return this;
    }

    /**
     * Gets the page associated with this request.
     * @return String representing the page for this request.
     */
    public Integer getPage() {
        return this.page;
    }

    /**
     * Sets the API key associated with this request.
     * @param apiKey Your NewsAPI API key. To get one, visit https://newsapi.org/
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Returns your API key.
     * @return Your NewsAPI API key.
     */
    public String getApiKey() {
        return this.apiKey;
    }
}