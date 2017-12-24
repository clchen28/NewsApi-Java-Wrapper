package io.github.ccincharge.newsapiwrapper;

class NewsApiAuthFailureException extends RuntimeException {
    NewsApiAuthFailureException(String message) {
        super(message);
    }
}
