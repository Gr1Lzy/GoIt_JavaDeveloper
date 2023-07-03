package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class HttpStatusImageDownloader {
    private final HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
    void downloadStatusImage(int code) throws IOException {
        String strURL = httpStatusChecker.getStatusImage(code);
        URL url = new URL(strURL);
        try (InputStream in = url.openStream()) {
            String path = System.getProperty("user.dir");
            Path targetPath = Paths.get(path + "/src/pictures", code + ".jpg");
            Files.copy(in, targetPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (FileNotFoundException e) {
            System.out.println(code +".png not found");
        }
    }
}
