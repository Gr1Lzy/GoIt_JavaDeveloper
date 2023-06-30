package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {
    private final Scanner scanner = new Scanner(System.in);
    private final HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
    void askStatus() throws Exception {
        System.out.println("Enter HTTP status code");
        try {
            httpStatusImageDownloader.downloadStatusImage(scanner.nextInt());
        } catch (Exception e) {
            throw new Exception("Please enter valid number");
        }
    }
}
