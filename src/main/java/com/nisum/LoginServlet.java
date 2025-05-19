package com.nisum;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    // Hardcoded credentials
    private final String USERNAME = "admin";
    private final String PASSWORD = "secret123";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            // Create a session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            out.println("<html><body>");
            out.println("<h2>Login Successful</h2>");
            out.println("<p>Welcome, " + username + "!</p>");
            out.println("<a href='logout'>Logout</a>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h2>Login Failed</h2>");
            out.println("<p>Invalid username or password.</p>");
            out.println("<a href='login.html'>Try again</a>");
            out.println("</body></html>");
        }
    }
}
