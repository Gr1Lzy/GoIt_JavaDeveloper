package org.example;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public static final String BASE_URL = "https://http.cat";
    public String getStatusImage(int code) throws Exception {
        URL url = new URL(BASE_URL + "/" + code);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        int responseCode = connection.getResponseCode();
        connection.disconnect();
        if (responseCode == 404) {
            throw new Exception("Unexpected response code: " + responseCode);
        } else {
            return url.toString();
        }
    }
}


