package com.example.module8;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.ZoneId;

@WebFilter(value = "/time")
public class TimezoneValidateFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setContentType("text/html; charset=utf-8");
        String timezone = request.getParameter("timezone");
        if (timezone == null || isValidTimezone(timezone.replaceAll(" ", "+"))) {
            chain.doFilter(request, response);
        } else {
            response.getWriter().write("<h2>Invalid timezone</h2>" + "400");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().close();
        }
    }

    boolean isValidTimezone(String param) {
        try {
            ZoneId.of(param);
            return true;
        } catch (DateTimeException e){
            return false;
        }
    }
}
