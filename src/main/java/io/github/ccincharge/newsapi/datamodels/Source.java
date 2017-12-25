package io.github.ccincharge.newsapi.datamodels;

public class Source {
    private String id;
    private String name;
    private String description;
    private String url;
    private String category;
    private String language;
    private String country;

    void setId(String id) {
        this.id = id;
    }

    void setName(String name) {
        this.name = name;
    }

    void setDescription(String description) {
        this.description = description;
    }

    void setUrl(String url) {
        this.url = url;
    }

    void setCategory(String category) {
        this.category = category;
    }

    void setLanguage(String language) {
        this.language = language;
    }

    void setCountry(String country) {
        this.country = country;
    }

    public String id() {
        return this.id;
    }

    public String name() {
        return this.name;
    }

    public String description() {
        return this.description;
    }

    public String url() {
        return this.url;
    }

    public String category() {
        return this.category;
    }

    public String language() {
        return this.language;
    }

    public String country() {
        return this.country;
    }
}
