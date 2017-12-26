package io.github.ccincharge.newsapi.exceptions;

/**
 * Exception thrown upon a 400 Bad Request error from the NewsAPI. Typically due to missing
 * parameters that are required for an API endpoint.
 */
public class BadQueryException extends RuntimeException {
    /**
     * @param message The message to attach to this Exception upon throwing.
     */
    public BadQueryException(String message) {
        super(message);
    }
}
