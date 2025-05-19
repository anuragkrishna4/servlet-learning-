package com.nisum;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class ContextParamServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ServletContext context = getServletContext();
        String companyName = context.getInitParameter("companyName");
        String supportEmail = context.getInitParameter("supportEmail");

        out.println("<html><body>");
        out.println("<h2>Context Parameters using ServletContext</h2>");
        out.println("<p><strong>Company Name:</strong> " + companyName + "</p>");
        out.println("<p><strong>Support Email:</strong> " + supportEmail + "</p>");
        out.println("</body></html>");
    }
}
