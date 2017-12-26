# NewsApi Java Wrapper
[![Build Status](https://travis-ci.org/CCInCharge/NewsApi-Java-Wrapper.svg?branch=master)](https://travis-ci.org/CCInCharge/NewsApi-Java-Wrapper)
[![codecov](https://codecov.io/gh/CCInCharge/NewsApi-Java-Wrapper/branch/master/graph/badge.svg)](https://codecov.io/gh/CCInCharge/NewsApi-Java-Wrapper)

A Java wrapper for V2 of the [NewsApi](https://newsapi.org/). 

## Usage
Instantiate a new instance of the NewsApi class with your API key.
```java
NewsApi newsApi = new NewsApi(<API_KEY>);
```

### Requests
Build up a request with desired parameters. For a full listing of available request parameters, consult the official 
NewsAPI docs:

https://newsapi.org/docs/endpoints/top-headlines

https://newsapi.org/docs/endpoints/everything

https://newsapi.org/docs/endpoints/sources

For this example, we'll search for English articles about bitcoin.

```java
RequestBuilder bitcoinRequest = new RequestBuilder()
    .setQ("bitcoin")
    .setLanguage("en");
```

There are numerous parameters available. Q and Language are an example of two of the parameters. For the full set of 
available parameters, consult the RequestBuilder Javadoc.

### Top Headlines Endpoint
The top-headlines endpoint returns a list of top headlines that match the given request parameters.
```java
RequestBuilder bitcoinRequest = new RequestBuilder()
    .setQ("bitcoin")
    .setLanguage("en");

ApiArticlesResponse apiArti = newsApi.sendTopRequest(bitcoinRequest);
```

### Everything Endpoint
The everything endpoint returns a list of all articles that match the given request parameters.
It is possible that there are more articles that match given query criteria than the REST API will return in one 
response.
To page through different pages of results, use the .setPage() method for the request.
```java
RequestBuilder bitcoinRequest = new RequestBuilder()
    .setQ("bitcoin")
    .setLanguage("en")
    .setPage(2);

ApiArticlesResponse apiArticlesResponse = newsApi.sendEverythingRequest(bitcoinRequest);
```

### Sources Endpoint
The sources endpoint returns a list of all news sources that match the given query criteria.
```java
RequestBuilder sourcesRequest = new RequestBuilder().setLanguage("en");

ApiSourcesResponse apiSourcesResponse = newsApi.sendSourcesRequest(sourcesRequest);
```

### ApiArticlesResponse Object
The top-headlines and the everything endpoints return an ApiArticlesResponse object. To work with this object, simply 
issue a method call with the name of the desired response attribute, in order to access the value associated with that 
attribute. Some examples are provided below:
```java
RequestBuilder bitcoinRequest = new RequestBuilder()
    .setQ("bitcoin")
    .setLanguage("en");

ApiArticlesResponse apiArticlesResponse = newsApi.sendTopRequest(bitcoinRequest);

String responseStatus = apiArticlesResponse.status();
// .articles() method returns an ArrayList of articles
ArrayList<Article> newsArticles = apiArticlesResponse.articles();
Article firstArticle = newsArticles.get(0);
String firstArticleTitle = firstArticle.title();
```

For the full list of available method calls, consult the Javadoc.

### ApiSourcesResponse Object
The sources endpoint returns an ApiSourcesResponse object. To work with this object, simply issue a method call with 
the name of the desired response attribute, in order to access the value associated with that attribute. Some examples 
are provided below:

```java
RequestBuilder sourcesRequest = new RequestBuilder().setLanguage("en");

ApiSourcesResponse apiSourcesResponse = newsApi.sendSourcesRequest(sourcesRequest);
// .sources() method returns an ArrayList of sources
ArrayList<Source> newsSources = apiSourcesResponse.sources();
Source firstSource = newsSources.get(0);
String firstSourceName = firstSource.name();
```

## Contributing
Create a fork of this repo, and commit your changes to a branch of your fork. Issue a PR to this repository when done.

Before beginning any PR, see if your changes correspond to an existing issue. If not, create a new issue. It is best 
to leave a comment asking to be assigned to an issue before starting your PR. Attach your PR to an issue before 
tarting.

Your PR must pass all tests and must not break the CI build to be merged.