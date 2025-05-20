package com.nisum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ContactDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        session.setAttribute("phone", phone);

        response.sendRedirect("summary");
    }
}
