package com.nisum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PersonalDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String age = request.getParameter("age");

        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("age", age);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Step 1 completed. Enter contact details:</h2>");
        out.println("<form action='contact' method='post'>");
        out.println("Email: <input type='email' name='email'><br>");
        out.println("Phone: <input type='text' name='phone'><br>");
        out.println("<input type='submit' value='Finish'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}
