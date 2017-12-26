package io.github.ccincharge.newsapi.endpoints;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class EndpointTest {
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
