package com.nisum;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AuthLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "admin123".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            response.sendRedirect("dashboard");
        } else {
            response.sendRedirect("login.html?error=true");
        }
    }
}