package io.github.ccincharge.newsapi.datamodels;

/**
 * Maps to a Source object from the NewsAPI. Each Source object represents a news source from which
 * Articles can be sourced from, e.g. The New York Times. Refer to https://newsapi.org/docs/endpoints/sources
 * for more information.
 */
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

    /**
     * @return id to use when designating this news sources in NewsAPI calls, e.g. abc-news
     */
    public String id() {
        return this.id;
    }

    /**
     * @return Name of this news source, e.g. ABC News
     */
    public String name() {
        return this.name;
    }

    /**
     * @return Description of this news source
     */
    public String description() {
        return this.description;
    }

    /**
     * @return URL to homepage of this news source
     */
    public String url() {
        return this.url;
    }

    /**
     * @return Category of news that this news source provides. Possibilities are business,
     * entertainment, gaming, general, health-and-medical, music, politics, science-and-nature,
     * sport, and technology.
     */
    public String category() {
        return this.category;
    }

    /**
     * @return Language that this news source provides articles in. Possibilities are ar, en, cn,
     * de, es, fr, he, it, nl, no, pt, ru, sv, and ud.
     */
    public String language() {
        return this.language;
    }

    /**
     * @return Country that this news source is located in. Possibilities are ar, au, br, ca, cn,
     * de, es, fr, gb, hk, ie, in, is, it, nl, no, pk, ru, sa, sv, us, za
     */
    public String country() {
        return this.country;
    }
}
