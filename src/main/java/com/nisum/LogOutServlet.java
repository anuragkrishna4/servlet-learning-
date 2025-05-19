package com.nisum;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogOutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false); // Get existing session
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("login.html");
    }
}
