package io.github.ccincharge.newsapi;

class NewsApiAuthFailureException extends RuntimeException {
    NewsApiAuthFailureException(String message) {
        super(message);
    }
}
