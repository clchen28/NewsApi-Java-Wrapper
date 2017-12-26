package io.github.ccincharge.newsapi.endpoints;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Provides a common method used for Endpoint unit tests.
 */
class EndpointTest {
    /**
     * Takes a text file that contains one line of text, representing a real API call, and
     * parses this into either an Article or Source datamodel from the
     * io.github.ccincharge.newsapi.datamodels package.
     * @param filename Filename of text file that contains one line of JSON response text
     * @return String of raw JSON test
     * @throws Exception
     */
    String getBodyFromFile(String filename) throws Exception {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());
        FileInputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String responseBody = reader.readLine();

        inputStream.close();
        return responseBody;
    }
}
