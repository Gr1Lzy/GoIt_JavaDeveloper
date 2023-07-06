package com.example.module8;

import java.io.IOException;
import java.io.PrintWriter;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(value = "/time")
public class TimeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        String parameter = request.getParameter("timezone");
        String value = "UTC";

        if (parameter != null) {
            value = parameter.replace(" ", "+");
        }
        String currentTime = ZonedDateTime.now(ZoneId.of(value)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm 'UTC'X"));
        printWriter.println("<h2>" + currentTime + "</h2>");
    }
}
