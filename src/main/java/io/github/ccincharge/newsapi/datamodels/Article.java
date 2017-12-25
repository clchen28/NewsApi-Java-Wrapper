package io.github.ccincharge.newsapi.datamodels;

public class Article {
    private Source source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;

    void setSource(Source source) {
        this.source = source;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    void setTitle(String title) {
        this.title = title;
    }

    void setDescription(String description) {
        this.description = description;
    }

    void setUrl(String url) {
        this.url = url;
    }

    void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    void publishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Source source() {
        return this.source;
    }

    public String author() {
        return this.author;
    }

    public String title() {
        return this.title;
    }

    public String descrption() {
        return this.description;
    }

    public String url() {
        return this.url;
    }

    public String urlToImage() {
        return this.urlToImage;
    }

    public String publishedAt() {
        return this.publishedAt;
    }
}
