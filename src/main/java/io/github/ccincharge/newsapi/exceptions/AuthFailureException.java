package io.github.ccincharge.newsapi.exceptions;

public class AuthFailureException extends RuntimeException {
    /**
     * Exception thrown upon failure to authenticate to the NewsAPI. Due to incorrect API Key.
     * @param message The message to attach to this Exception upon throwing.
     */
    public AuthFailureException(String message) {
        super(message);
    }
}
