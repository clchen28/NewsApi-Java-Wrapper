package io.github.ccincharge.newsapi;

import io.github.ccincharge.newsapi.datamodels.Source;

import java.util.ArrayList;

public class NewsApiSourcesResponse extends NewsApiResponse {
    private ArrayList<Source> sources;

    public NewsApiSourcesResponse() {
        super();
    }

    void setSources(ArrayList<Source> sources) {
        this.sources = sources;
    }

    public ArrayList<Source> sources() {
        return this.sources;
    }
}
