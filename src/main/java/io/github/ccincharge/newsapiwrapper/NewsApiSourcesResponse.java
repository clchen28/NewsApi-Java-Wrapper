package io.github.ccincharge.newsapiwrapper;

import java.util.ArrayList;

class NewsApiSourcesResponse extends NewsApiResponse {
    private ArrayList<NewsApiSource> sources;

    public NewsApiSourcesResponse() {
        super();
    }

    void setSources(ArrayList<NewsApiSource> sources) {
        this.sources = sources;
    }

    public ArrayList<NewsApiSource> sources() {
        return this.sources;
    }
}
