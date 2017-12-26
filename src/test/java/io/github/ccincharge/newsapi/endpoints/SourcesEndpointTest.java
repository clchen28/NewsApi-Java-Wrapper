package io.github.ccincharge.newsapi.endpoints;

import io.github.ccincharge.newsapi.datamodels.Source;
import io.github.ccincharge.newsapi.responses.ApiSourcesResponse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for SourcesEndpoint. Checks to see that a new ApiSourcesResponse object is
 * correctly mapped from raw JSON. Uses a text file with raw JSON instead of an actual call to
 * the REST API.
 */
class SourcesEndpointTest extends EndpointTest {
    @Test
    void getDataFromResponseBody() throws Exception {
        SourcesEndpoint sourcesEndpoint = new SourcesEndpoint();
        String filename = "SourcesEndpointExampleResponse.txt";

        String responseBody = getBodyFromFile(filename);

        ApiSourcesResponse apiSourcesResponse = sourcesEndpoint.getDataFromResponseBody(responseBody);
        assertEquals("ok", apiSourcesResponse.status());
        assertEquals(responseBody, apiSourcesResponse.rawJSON());
        assertNull(apiSourcesResponse.code());
        assertNull(apiSourcesResponse.message());

        ArrayList<Source> sources = apiSourcesResponse.sources();
        assertEquals("abc-news", sources.get(0).id());
        assertEquals("ABC News", sources.get(0).name());
        assertEquals("Your trusted source for breaking news, analysis, exclusive interviews, "
                + "headlines, and videos at ABCNews.com.", sources.get(0).description());
        assertEquals("http://abcnews.go.com", sources.get(0).url());
        assertEquals("general", sources.get(0).category());
        assertEquals("en", sources.get(0).language());
        assertEquals("us", sources.get(0).country());
    }

}