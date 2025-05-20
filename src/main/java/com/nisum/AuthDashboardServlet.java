package com.nisum;


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AuthDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.html");
            return;
        }
        String user = (String) session.getAttribute("user");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h2>Welcome, " + user + "!</h2><a href='logout'>Logout</a></body></html>");
    }
}
