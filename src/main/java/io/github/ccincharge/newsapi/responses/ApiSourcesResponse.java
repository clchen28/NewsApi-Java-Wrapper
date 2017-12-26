package io.github.ccincharge.newsapi.responses;

import io.github.ccincharge.newsapi.datamodels.Source;

import java.util.ArrayList;

/**
 * Represents attributes that are common to the NewsAPI REST endpoints that respond with news
 * sources.
 */
public class ApiSourcesResponse extends ApiResponse {
    private ArrayList<Source> sources;

    public ApiSourcesResponse() {
        super();
    }

    void setSources(ArrayList<Source> sources) {
        this.sources = sources;
    }

    /**
     * @return ArrayList of news sources that NewsAPI allows, with each element of the ArrayList
     * representing a different news source.
     */
    public ArrayList<Source> sources() {
        return this.sources;
    }
}
