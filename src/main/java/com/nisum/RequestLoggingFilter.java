package com.nisum;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class RequestLoggingFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code if needed
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURL = httpRequest.getRequestURL().toString();

        System.out.println("Incoming request URL: " + requestURL);

        // Continue the request
        chain.doFilter(request, response);
    }

    public void destroy() {
        // Cleanup code if needed
    }
}
