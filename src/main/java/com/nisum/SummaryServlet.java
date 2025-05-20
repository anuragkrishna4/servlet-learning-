package com.nisum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SummaryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        String name = (String) session.getAttribute("name");
        String age = (String) session.getAttribute("age");
        String email = (String) session.getAttribute("email");
        String phone = (String) session.getAttribute("phone");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>User Summary</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Age: " + age + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Phone: " + phone + "</p>");
        out.println("</body></html>");
    }
}
