package com.nisum;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class ConfigServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ServletConfig config = getServletConfig();
        String adminName = config.getInitParameter("adminName");
        String adminEmail = config.getInitParameter("adminEmail");

        out.println("<html><body>");
        out.println("<h2>Initialization Parameters using ServletConfig</h2>");
        out.println("<p><strong>Admin Name:</strong> " + adminName + "</p>");
        out.println("<p><strong>Admin Email:</strong> " + adminEmail + "</p>");
        out.println("</body></html>");
    }
}
