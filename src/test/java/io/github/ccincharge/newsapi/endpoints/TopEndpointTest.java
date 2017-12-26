package io.github.ccincharge.newsapi.endpoints;

import io.github.ccincharge.newsapi.datamodels.Article;
import io.github.ccincharge.newsapi.responses.ApiArticlesResponse;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TopEndpointTest {
    @Test
    void getDataFromResponseBodySources() throws Exception {
        TopEndpoint topEndpoint = new TopEndpoint();
        String filename = "TopEndpointExampleResponseWithSource.txt";

        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());
        FileInputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String responseBody = reader.readLine();

        ApiArticlesResponse apiArticlesResponse = topEndpoint.getDataFromResponseBody(responseBody);
        assertEquals("ok", apiArticlesResponse.status());
        assertEquals(new Integer(10), apiArticlesResponse.totalResults());
        assertEquals(responseBody, apiArticlesResponse.rawJSON());
        assertNull(apiArticlesResponse.code());
        assertNull(apiArticlesResponse.message());

        ArrayList<Article> articles = apiArticlesResponse.articles();
        assertEquals(10, articles.size());
        assertEquals(articles.get(0).author(), "BBC Sport");
        assertEquals(articles.get(0).title(), "Boxing Day Test - Australia v England");
        assertEquals(articles.get(0).description(), "Australia bat first on a "
                + "fantastic-looking pitch in the fourth Ashes Test at the MCG - live TMS & text commentary.");
        assertEquals(articles.get(0).url(), "http://www.bbc.co.uk/sport/live/cricket/41784757");
        assertEquals(articles.get(0).urlToImage(), "https://m.files.bbci.co.uk/modules/bbc-"
                + "morph-sport-opengraph/1.1.1/images/bbc-sport-logo.png");
        assertEquals(articles.get(0).publishedAt(), "2017-12-25T23:36:08Z");

        assertEquals(articles.get(0).source().id(), "bbc-news");
        assertEquals(articles.get(0).source().name(), "BBC News");

        assertEquals(articles.get(2).author(), "BBC News");
        assertEquals(articles.get(2).title(), "Russia football head quits amid doping ban");
        assertEquals(articles.get(2).description(), "Russia's most senior football official, "
                + "Vitaly Mutko, quits temporarily after being given a lifetime Olympic ban over doping scandal.");
        assertEquals(articles.get(2).url(), "http://www.bbc.co.uk/news/world-europe-42480603");
        assertEquals(articles.get(2).urlToImage(), "https://ichef.bbci.co.uk/news/1024/cpsprodpb/"
                + "7A23/production/_97176213_breaking_news_bigger.png");
        assertEquals(articles.get(2).publishedAt(), "2017-12-25T17:55:19Z");

        assertEquals(articles.get(2).source().id(), "bbc-news");
        assertEquals(articles.get(2).source().name(), "BBC News");
    }

    @Test
    void getDataFromResponseBodyQuery() throws Exception {
        TopEndpoint topEndpoint = new TopEndpoint();
        String filename = "TopEndpointExampleResponseWithQuery.txt";

        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());
        FileInputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String responseBody = reader.readLine();

        ApiArticlesResponse apiArticlesResponse = topEndpoint.getDataFromResponseBody(responseBody);
        assertEquals("ok", apiArticlesResponse.status());
        assertEquals(new Integer(18), apiArticlesResponse.totalResults());
        assertEquals(responseBody, apiArticlesResponse.rawJSON());
        assertNull(apiArticlesResponse.code());
        assertNull(apiArticlesResponse.message());

        ArrayList<Article> articles = apiArticlesResponse.articles();
        assertEquals(18, articles.size());

        assertNull(articles.get(2).author());
        assertEquals(articles.get(2).title(), "Foreign Exchange Strategist Warns Against Buying "
                + "Bitcoin During Price Drop");
        assertEquals(articles.get(2).description(), "Get Trading Recommendations and Read "
                + "Analysis on Hacked.com for just $39 per month.Boris Schlossberg, a foreign "
                + "exchange strategist at BK Asset Management, has warned investors that "
                + "bitcoin’s price decline has lured many people to mistakenly think the price "
                + "decline represents a good buying opportunity. Schlossberg warns people not to "
                + "fall victim to what he considers");
        assertEquals(articles.get(2).url(), "https://www.ccn.com/foreign-exchange-strategist-"
                + "warns-against-buying-bitcoin-amidst-price-drop/");
        assertEquals(articles.get(2).urlToImage(), "https://www.ccn.com/wp-content/uploads/"
                + "2017/08/Bitcoin-slt.jpg");
        assertEquals(articles.get(2).publishedAt(), "2017-12-25T21:34:58Z");

        assertEquals(articles.get(2).source().id(), "crypto-coins-news");
        assertEquals(articles.get(2).source().name(), "Crypto Coins News");

        assertNull(articles.get(16).author());
        assertEquals(articles.get(16).title(), "Bitcoin Has Already Bounced Back 40% After the "
                + "Huge Crash");
        assertNull(articles.get(16).description());
        assertEquals(articles.get(16).url(), "http://fortune.com/2017/12/23/bitcoin-has-already-"
                + "bounced-back-40-after-the-huge-crash/");
        assertEquals(articles.get(16).urlToImage(), "https://fortunedotcom.files.wordpress.com/"
                + "2017/12/gettyimages-891494080.jpg");
        assertEquals(articles.get(16).publishedAt(), "2017-12-23T16:36:28Z");

        assertEquals(articles.get(16).source().id(), "fortune");
        assertEquals(articles.get(16).source().name(), "Fortune");
    }

}