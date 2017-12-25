package io.github.ccincharge.newsapi.exceptions;

public class BadQueryException extends RuntimeException {
    public BadQueryException(String message) {
        super(message);
    }
}
