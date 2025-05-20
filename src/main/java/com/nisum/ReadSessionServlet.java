package com.nisum;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReadSessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        if (session == null) {
            out.println("<h2>No session found.</h2>");
        } else {
            String username = (String) session.getAttribute("username");
            String role = (String) session.getAttribute("role");

            out.println("<h2>Session Data</h2>");
            out.println("<p><strong>Username:</strong> " + username + "</p>");
            out.println("<p><strong>Role:</strong> " + role + "</p>");
        }

        out.println("</body></html>");
    }
}
