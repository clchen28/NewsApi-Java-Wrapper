package io.github.ccincharge.newsapi.exceptions;

public class AuthFailureException extends RuntimeException {
    public AuthFailureException(String message) {
        super(message);
    }
}
