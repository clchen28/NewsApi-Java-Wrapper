package io.github.ccincharge.newsapi.exceptions;

public class NewsApiBadQueryException extends RuntimeException {
    public NewsApiBadQueryException(String message) {
        super(message);
    }
}
