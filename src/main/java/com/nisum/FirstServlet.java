package com.nisum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        request.setAttribute("userName", name);

        RequestDispatcher dispatcher = request.getRequestDispatcher("second");
        dispatcher.forward(request, response);
    }
}
