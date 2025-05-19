package com.nisum;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateUserServlet extends HttpServlet {
    //private Map<String, User> users = new HashMap<>();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String email = req.getParameter("email");

        resp.setContentType("text/html");
        resp.getWriter().write("<h2>User Created Successfully</h2>");
        resp.getWriter().write("<p>Username: " + username + "</p>");
        resp.getWriter().write("<p>Email: " + email + "</p>");
         //users.put(email, new User(username, email));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo =   req.getPathInfo();

        resp.setContentType("application/json");

        String email = pathInfo.substring(1);


        //resp.getWriter().write(users.get(email).toString());
    }



}