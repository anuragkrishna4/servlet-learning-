package com.nisum;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class DemoServlet extends HttpServlet {

    // Handles GET requests
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>This is a response from doGet()</h2>");
        out.println("<form method='post' action='demo'>");
        out.println("Enter your name: <input type='text' name='name'><br>");
        out.println("<input type='submit' value='Submit via POST'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    // Handles POST requests
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        out.println("<html><body>");
        out.println("<h2>This is a response from doPost()</h2>");
        out.println("<p>Hello, " + name + "!</p>");
        out.println("</body></html>");
    }
}

