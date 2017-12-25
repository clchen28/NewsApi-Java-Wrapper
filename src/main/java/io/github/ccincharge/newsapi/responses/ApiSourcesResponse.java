package io.github.ccincharge.newsapi.responses;

import io.github.ccincharge.newsapi.datamodels.Source;

import java.util.ArrayList;

public class ApiSourcesResponse extends ApiResponse {
    private ArrayList<Source> sources;

    public ApiSourcesResponse() {
        super();
    }

    void setSources(ArrayList<Source> sources) {
        this.sources = sources;
    }

    public ArrayList<Source> sources() {
        return this.sources;
    }
}
