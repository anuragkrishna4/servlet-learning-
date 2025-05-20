package com.nisum;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;

public class HeaderDisplayServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Request Headers</h2>");
        out.println("<table border='1'><tr><th>Header Name</th><th>Value</th></tr>");

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            out.println("<tr><td>" + name + "</td><td>" + value + "</td></tr>");
        }

        out.println("</table></body></html>");
    }
}
