package io.github.ccincharge.newsapiwrapper;

import java.util.ArrayList;

class NewsApiArticlesResponse extends NewsApiResponse {
    private Integer totalResults;
    private ArrayList<NewsApiArticle> articles;

    public NewsApiArticlesResponse() {
        super();
        this.setTotalResults(0);
    }

    void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    void setArticles(ArrayList<NewsApiArticle> articles) {
        this.articles = articles;
    }

    public Integer totalResults() {
        return this.totalResults;
    }

    public ArrayList<NewsApiArticle> articles() {
        return this.articles;
    }
}
