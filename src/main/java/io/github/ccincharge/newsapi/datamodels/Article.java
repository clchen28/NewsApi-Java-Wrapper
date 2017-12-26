package io.github.ccincharge.newsapi.datamodels;

import java.util.Objects;

/**
 * Maps to an Article object from the NewsAPI. Each Article object represents one news article, and
 * consists of a Source object that describes the news source that this article is from, as well as
 * attributes that correspond to data within the actual article.
 */
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

    /**
     * @return Source that this article is from.
     */
    public Source source() {
        return this.source;
    }

    /**
     * @return Author of this article
     */
    public String author() {
        this.setAuthor(this.author);
        return this.author;
    }

    /**
     * @return Title of this article
     */
    public String title() {
        this.setTitle(this.title);
        return this.title;
    }

    /**
     * @return Description of the current article
     */
    public String description() {
        this.setDescription(this.description);
        return this.description;
    }

    /**
     * @return String URL at which this article can be found
     */
    public String url() {
        this.setUrl(this.url);
        return this.url;
    }

    /**
     * @return String URL to main image of this article
     */
    public String urlToImage() {
        this.setUrlToImage(this.urlToImage);
        return this.urlToImage;
    }

    /**
     * @return String date during which this article was published, in ISO 8601 format:
     * yyyy-MM-ddTHH:mm:ssZ
     * e.g., 2017-12-25T18:32:56Z for December 25, 2017 at 06:32:56 PM UTC
     */
    public String publishedAt() {
        this.setPublishedAt(this.publishedAt);
        return this.publishedAt;
    }
}
