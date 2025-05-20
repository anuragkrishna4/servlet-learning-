package com.nisum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ValidationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        boolean hasError = false;

        if (name == null || name.trim().isEmpty()) {
            out.println("<p style='color:red;'>Name is required.</p>");
            hasError = true;
        }

        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
            out.println("<p style='color:red;'>Valid email is required.</p>");
            hasError = true;
        }

        if (!hasError) {
            out.println("<h2>Validation Successful!</h2>");
            out.println("<p>Name: " + name + "</p>");
            out.println("<p>Email: " + email + "</p>");
        }

        out.println("</body></html>");
    }
}
