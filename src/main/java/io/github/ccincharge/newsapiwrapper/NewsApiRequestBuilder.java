package io.github.ccincharge.newsapiwrapper;

import com.google.common.collect.Sets;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

// TODO: Move all exception handling further down the line

class NewsApiRequestBuilder {
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

    public NewsApiRequestBuilder setSources(String sources) {
        // FIXME: Make this remove spaces
        this.sources = sources;
        return this;
    }

    public NewsApiRequestBuilder setSources(Collection<String> sources) {
        this.sources = Arrays.toString(sources.toArray());
        return this;
    }

    public String getSources() {
        return this.sources;
    }

    // TODO: Must be URL-encoded
    public NewsApiRequestBuilder setQ(String q) {
        this.q = q;
        return this;
    }

    public String getQ() {
        return this.q;
    }

    public NewsApiRequestBuilder setCategory(String category) {
        if (!validCategories.contains(category)) {
            throw new IllegalArgumentException("Invalid category - must be one of the following: "
                    + validCategories.toString());
        }
        this.category = category;
        return this;
    }

    public String getCategory() {
        return this.category;
    }

    public NewsApiRequestBuilder setLanguage(String language) {
        if (!validLanguages.contains(language)) {
            throw new IllegalArgumentException("Invalid language - must be one of the following: "
                    + validLanguages.toString());
        }
        this.language = language;
        return this;
    }

    public String getLanguage() {
        return this.language;
    }

    public NewsApiRequestBuilder setCountry(String country) {
        if (!validCountries.contains(country)) {
            throw new IllegalArgumentException("Invalid country - must be one of the following: "
                    + validCountries.toString());
        }
        this.country = country;
        return this;
    }

    public String getCountry() {
        return this.country;
    }

    public NewsApiRequestBuilder setDomains(String domains) {
        this.domains = domains;
        return this;
    }

    public String getDomains() {
        return this.domains;
    }

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
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
                formatter.setLenient(false);
                formatter.parse(date);
            } catch (ParseException e) {
                return false;
            }
        }
        return true;
    }

    public NewsApiRequestBuilder setFrom(Date from) {
        this.from = from.toString();
        return this;
    }

    public NewsApiRequestBuilder setFrom(String from) {
        if (!validateDate(from)) {
            throw new IllegalArgumentException("Invalid from date, must have \"yyyy-MM-dd\" or "
                    + " \"yyyy-MM-dd'T'HH:mm'Z'\" pattern");
        }
        this.from = from;
        return this;
    }

    // TODO: Add a getFrom that returns a Date object
    public String getFrom() {
        return this.from;
    }

    public NewsApiRequestBuilder setTo(Date to) {
        this.to = to.toString();
        return this;
    }

    public NewsApiRequestBuilder setTo(String to) {
        if (!validateDate(to)) {
            throw new IllegalArgumentException("Invalid to date, must have \"yyyy-MM-dd\" or "
                    + " \"yyyy-MM-dd'T'HH:mm'Z'\" pattern");
        }
        this.to = to;
        return this;
    }

    public String getTo() {
        return this.to;
    }

    public NewsApiRequestBuilder setSortBy(String sortBy) {
        if (!validSortBy.contains(sortBy)) {
            throw new IllegalArgumentException("Invalid sortBy - must be one of the following: "
                    + validSortBy.toString());
        }
        this.sortBy = sortBy;
        return this;
    }

    public String getSortBy() {
        return this.sortBy;
    }

    public NewsApiRequestBuilder setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getPage() {
        return this.page;
    }

    void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}