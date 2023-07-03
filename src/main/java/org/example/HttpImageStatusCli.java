package org.example;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    private final Scanner scanner = new Scanner(System.in);
    private final HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
    void askStatus() {
        while(true) {
            try {
                System.out.println("Enter HTTP status code");
                int value = scanner.nextInt();
                httpStatusImageDownloader.downloadStatusImage(value);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage()+"\n");
            }
        }
        scanner.close();
    }
}
