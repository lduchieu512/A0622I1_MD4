package com.example.ss14_bt_bai1.filter;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class CustomFilter implements Filter {
    List<String> listMethodController = new ArrayList<>(Arrays.asList("post", "patch", "put", "delete"));

    @Autowired
    HttpServletRequest servletRequest;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
