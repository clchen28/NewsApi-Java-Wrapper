package io.github.ccincharge.newsapi.exceptions;

/**
 * Exception thrown upon failure to authenticate to the NewsAPI. Due to incorrect API Key.
 */
public class AuthFailureException extends RuntimeException {
    /**
     * @param message The message to attach to this Exception upon throwing.
     */
    public AuthFailureException(String message) {
        super(message);
    }
}
