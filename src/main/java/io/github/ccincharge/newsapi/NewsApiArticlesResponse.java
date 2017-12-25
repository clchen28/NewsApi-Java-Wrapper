package io.github.ccincharge.newsapi;

import io.github.ccincharge.newsapi.datamodels.Article;

import java.util.ArrayList;

public class NewsApiArticlesResponse extends NewsApiResponse {
    private Integer totalResults;
    private ArrayList<Article> articles;

    public NewsApiArticlesResponse() {
        super();
        this.setTotalResults(0);
    }

    void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public Integer totalResults() {
        return this.totalResults;
    }

    public ArrayList<Article> articles() {
        return this.articles;
    }
}
