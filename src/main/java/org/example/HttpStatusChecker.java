package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public static final String BASE_URL = "https://http.cat";

    public String getStatusImage(int code) throws IOException {
        URL url = new URL(BASE_URL + "/" + code);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        int responseCode = connection.getResponseCode();
        connection.disconnect();

        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("There is no image for HTTP status " + code);
        }
        return url.toString();
    }
}



