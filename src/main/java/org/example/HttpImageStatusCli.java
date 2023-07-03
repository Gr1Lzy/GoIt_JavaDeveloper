package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {
    private final Scanner scanner = new Scanner(System.in);
    private final HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
    void askStatus() {
        while(true) {
            try {
                System.out.println("Enter HTTP status code");
                int value = read();
                httpStatusImageDownloader.downloadStatusImage(value);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage()+"\n");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    int read() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException("Please, enter an integer");
        }
    }
}
