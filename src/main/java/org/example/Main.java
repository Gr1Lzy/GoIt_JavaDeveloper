package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
//        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
//        System.out.println(httpStatusChecker.getStatusImage(400));
//
//        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
//        httpStatusImageDownloader.downloadStatusImage(404);

        HttpImageStatusCli httpImageStatusCli = new HttpImageStatusCli();
        httpImageStatusCli.askStatus();
    }
}