package com.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(value = "/time")
public class TimeServlet extends HttpServlet {
    TemplateEngine engine;

    @Override
    public void init() {
        engine = new TemplateEngine();

        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setOrder(engine.getTemplateResolvers().size());
        resolver.setCacheable(false);
        engine.addTemplateResolver(resolver);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        String param = req.getParameter("timezone");

        if (param == null) {
            param = getCookie(req);
        }
        param = param.replaceAll(" ", "+");


        setCookie(param, resp);

        Context context = new Context();
        context.setVariable("time", getFormattedTimezone(param));

        engine.process("time", context, resp.getWriter());
        resp.getWriter().close();
    }

    private String getCookie(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                return cookie.getValue();
            }
        }
        return "UTC";
    }

    private void setCookie(String value, HttpServletResponse resp) {
        Cookie cookie = new Cookie("lastTimezone", value);
        System.out.println(cookie.getValue());
        resp.addCookie(cookie);
    }

    private String getFormattedTimezone(String value) {
        return (ZonedDateTime.now(ZoneId.of(value)).
                format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm 'UTC'X")));
    }
}