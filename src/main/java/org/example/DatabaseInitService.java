package org.example;

import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseInitService {
    private String getUrl() {
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream("hibernate.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties.getProperty("hibernate.connection.url");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void dbInit() {
        String hibernateUrl = getUrl();
        Flyway flyway = Flyway
                .configure().
                dataSource(hibernateUrl, null, null)
                .load();

        flyway.migrate();
    }
}
