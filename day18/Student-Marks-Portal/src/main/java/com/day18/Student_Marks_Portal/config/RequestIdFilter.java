package com.day18.Student_Marks_Portal.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class RequestIdFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(RequestIdFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestId = UUID.randomUUID().toString();
        httpRequest.setAttribute("Request-ID", requestId);

        logger.info("Request [{}] started: {} {}", requestId, httpRequest.getMethod(), httpRequest.getRequestURI());

        chain.doFilter(request, response);

        logger.info("Request [{}] ended: {} {}", requestId, httpRequest.getMethod(), httpRequest.getRequestURI());
    }
}
