package io.github.ccincharge.newsapiwrapper;

// TODO: Should publishedAt be a date object?

class NewsApiResponse {
    private String status;
    private String code;
    private String message;
    private String rawJSON;

    void setStatus(String status) {
        this.status = status;
    }

    void setCode(String code) {
        this.code = code;
    }

    void setMessage(String message) {
        this.message = message;
    }

    void setRawJSON(String rawJSON) {
        this.rawJSON = rawJSON;
    }

    public String status() {
        return this.status;
    }

    public String code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public String rawJSON() {
        return this.rawJSON;
    }

    public NewsApiResponse() {
        this.setStatus("unsent");
    }
}
