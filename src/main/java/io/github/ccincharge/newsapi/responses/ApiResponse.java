package io.github.ccincharge.newsapi.responses;

/**
 * Represents attributes that are common to all responses from the NewsAPI REST endpoints.
 */
public class ApiResponse {
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

    public void setRawJSON(String rawJSON) {
        this.rawJSON = rawJSON;
    }

    /**
     * @return Status message from NewsAPI's REST endpoints. Possible values are ok and error.
     * In the case of error, code and message will be populated. Can also be "unsent", indicating
     * that no HTTP request has been issued to the REST endpoints yet.
     */
    public String status() {
        return this.status;
    }

    /**
     * @return Error code message from NewsAPI's REST endpoints.
     */
    public String code() {
        return this.code;
    }

    /**
     * @return Error message from NewsAPI's REST endpoints.
     */
    public String message() {
        return this.message;
    }

    /**
     * @return String of the raw JSON object that is returned by the REST endpoint.
     */
    public String rawJSON() {
        return this.rawJSON;
    }

    ApiResponse() {
        this.setStatus("unsent");
    }
}
