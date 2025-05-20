package com.nisum;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class SetSessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("username", "Anurag");
        session.setAttribute("role", "Admin");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Session attributes have been set!</h2>");
        out.println("<p><a href='readsession'>Click here</a> to read session attributes.</p>");
        out.println("</body></html>");
    }
}
