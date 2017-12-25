package io.github.ccincharge.newsapi;

public class NewsApiBadQueryException extends RuntimeException {
    NewsApiBadQueryException(String message) {
        super(message);
    }
}
