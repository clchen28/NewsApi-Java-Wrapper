package io.github.ccincharge.newsapi.exceptions;

public class NewsApiAuthFailureException extends RuntimeException {
    public NewsApiAuthFailureException(String message) {
        super(message);
    }
}
