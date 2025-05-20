package com.nisum;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class RedirectServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Redirect user to external website
        response.sendRedirect("https://www.google.com");
    }
}
