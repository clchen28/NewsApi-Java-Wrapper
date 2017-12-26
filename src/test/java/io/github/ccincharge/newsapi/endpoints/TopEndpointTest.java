package io.github.ccincharge.newsapi.endpoints;

import io.github.ccincharge.newsapi.datamodels.Article;
import io.github.ccincharge.newsapi.responses.ApiArticlesResponse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for TopEndpoint. Checks to see that a new ApiArticlesResponse object is
 * correctly mapped from raw JSON. Uses a text file with raw JSON instead of an actual call to
 * the REST API.
 */
class TopEndpointTest extends EndpointTest {
    @Test
    void getDataFromResponseBodySources() throws Exception {
        TopEndpoint topEndpoint = new TopEndpoint();
        String filename = "TopEndpointExampleResponseWithSource.txt";

        String responseBody = getBodyFromFile(filename);

        ApiArticlesResponse apiArticlesResponse = topEndpoint.getDataFromResponseBody(responseBody);
        assertEquals("ok", apiArticlesResponse.status());
        assertEquals(new Integer(10), apiArticlesResponse.totalResults());
        assertEquals(responseBody, apiArticlesResponse.rawJSON());
        assertNull(apiArticlesResponse.code());
        assertNull(apiArticlesResponse.message());

        ArrayList<Article> articles = apiArticlesResponse.articles();
        assertEquals(10, articles.size());
        assertEquals("BBC Sport", articles.get(0).author());
        assertEquals("Boxing Day Test - Australia v England", articles.get(0).title());
        assertEquals("Australia bat first on a "
                + "fantastic-looking pitch in the fourth Ashes Test at the MCG - live TMS & text "
                + "commentary.", articles.get(0).description());
        assertEquals("http://www.bbc.co.uk/sport/live/cricket/41784757", articles.get(0).url());
        assertEquals("https://m.files.bbci.co.uk/modules/bbc-morph-sport-opengraph/1.1.1/images/"
                + "bbc-sport-logo.png", articles.get(0).urlToImage());
        assertEquals("2017-12-25T23:36:08Z", articles.get(0).publishedAt());

        assertEquals("bbc-news", articles.get(0).source().id());
        assertEquals("BBC News", articles.get(0).source().name());

        assertEquals("BBC News", articles.get(2).author());
        assertEquals("Russia football head quits amid doping ban", articles.get(2).title());
        assertEquals("Russia's most senior football official, Vitaly Mutko, quits temporarily "
                + "after being given a lifetime Olympic ban over doping scandal.", articles.get(2).description());
        assertEquals("http://www.bbc.co.uk/news/world-europe-42480603", articles.get(2).url());
        assertEquals("https://ichef.bbci.co.uk/news/1024/cpsprodpb/7A23/production/_97176213_"
                + "breaking_news_bigger.png", articles.get(2).urlToImage());
        assertEquals("2017-12-25T17:55:19Z", articles.get(2).publishedAt());

        assertEquals("bbc-news", articles.get(2).source().id());
        assertEquals("BBC News", articles.get(2).source().name());
    }

    @Test
    void getDataFromResponseBodyQuery() throws Exception {
        TopEndpoint topEndpoint = new TopEndpoint();
        String filename = "TopEndpointExampleResponseWithQuery.txt";

        String responseBody = getBodyFromFile(filename);

        ApiArticlesResponse apiArticlesResponse = topEndpoint.getDataFromResponseBody(responseBody);
        assertEquals("ok", apiArticlesResponse.status());
        assertEquals(new Integer(18), apiArticlesResponse.totalResults());
        assertEquals(responseBody, apiArticlesResponse.rawJSON());
        assertNull(apiArticlesResponse.code());
        assertNull(apiArticlesResponse.message());

        ArrayList<Article> articles = apiArticlesResponse.articles();
        assertEquals(18, articles.size());

        assertNull(articles.get(2).author());
        assertEquals("Foreign Exchange Strategist Warns Against Buying Bitcoin During Price Drop",
                articles.get(2).title());
        assertEquals("Get Trading Recommendations and Read Analysis on Hacked.com for just $39 "
                + "per month.Boris Schlossberg, a foreign exchange strategist at BK Asset "
                + "Management, has warned investors that bitcoin’s price decline has lured many "
                + "people to mistakenly think the price decline represents a good buying "
                + "opportunity. Schlossberg warns people not to fall victim to what he considers",
                articles.get(2).description());
        assertEquals("https://www.ccn.com/foreign-exchange-strategist-warns-against-buying-"
                + "bitcoin-amidst-price-drop/", articles.get(2).url());
        assertEquals("https://www.ccn.com/wp-content/uploads/2017/08/Bitcoin-slt.jpg",
                articles.get(2).urlToImage());
        assertEquals("2017-12-25T21:34:58Z", articles.get(2).publishedAt());

        assertEquals("crypto-coins-news", articles.get(2).source().id());
        assertEquals("Crypto Coins News", articles.get(2).source().name());

        assertNull(articles.get(16).author());
        assertEquals("Bitcoin Has Already Bounced Back 40% After the Huge Crash",
                articles.get(16).title());
        assertNull(articles.get(16).description());
        assertEquals("http://fortune.com/2017/12/23/bitcoin-has-already-bounced-back-40-after-the-"
                + "huge-crash/", articles.get(16).url());
        assertEquals("https://fortunedotcom.files.wordpress.com/2017/12/gettyimages-891494080.jpg",
                articles.get(16).urlToImage());
        assertEquals("2017-12-23T16:36:28Z", articles.get(16).publishedAt());

        assertEquals("fortune", articles.get(16).source().id());
        assertEquals("Fortune", articles.get(16).source().name());
    }

}