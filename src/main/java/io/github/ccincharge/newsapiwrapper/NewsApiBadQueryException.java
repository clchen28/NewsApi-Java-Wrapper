package io.github.ccincharge.newsapiwrapper;

public class NewsApiBadQueryException extends RuntimeException {
    NewsApiBadQueryException(String message) {
        super(message);
    }
}
