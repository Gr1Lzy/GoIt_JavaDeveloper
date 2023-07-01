package org.example;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public static final String BASE_URL = "https://http.cat";
    int responseCode;
    public String getStatusImage(int code) {
        try {
            URL url = new URL(BASE_URL + "/" + code);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            responseCode = connection.getResponseCode();
            connection.disconnect();
            return url.toString();
        } catch (Exception e) {
            return "There is not image for HTTP status " + responseCode;
        }
    }
}


