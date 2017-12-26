package io.github.ccincharge.newsapi.datamodels;

import java.util.Objects;

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
        if (Objects.equals(author, "")) {
            this.author = null;
        }
        else {
            this.author = author;
        }
    }

    void setTitle(String title) {
        if (Objects.equals(title, "")) {
            this.title = null;
        }
        else {
            this.title = title;
        }
    }

    void setDescription(String description) {
        if (Objects.equals(description, "")) {
            this.description = null;
        }
        else {
            this.description = description;
        }
    }

    void setUrl(String url) {
        if (Objects.equals(url, "")) {
            this.url = null;
        }
        else {
            this.url = url;
        }
    }

    void setUrlToImage(String urlToImage) {
        if (Objects.equals(urlToImage, "")) {
            this.urlToImage = null;
        }
        else {
            this.urlToImage = urlToImage;
        }
    }

    void setPublishedAt(String publishedAt) {
        if (Objects.equals(publishedAt, "")) {
            this.publishedAt = null;
        }
        else {
            this.publishedAt = publishedAt;
        }
    }

    public Source source() {
        return this.source;
    }

    public String author() {
        this.setAuthor(this.author);
        return this.author;
    }

    public String title() {
        this.setTitle(this.title);
        return this.title;
    }

    public String description() {
        this.setDescription(this.description);
        return this.description;
    }

    public String url() {
        this.setUrl(this.url);
        return this.url;
    }

    public String urlToImage() {
        this.setUrlToImage(this.urlToImage);
        return this.urlToImage;
    }

    public String publishedAt() {
        this.setPublishedAt(this.publishedAt);
        return this.publishedAt;
    }
}
