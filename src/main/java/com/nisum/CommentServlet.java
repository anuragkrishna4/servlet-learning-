package com.nisum;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class CommentServlet extends HttpServlet {
    private static final List<String> feedbackList = Collections.synchronizedList(new ArrayList<>());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String feedback = request.getParameter("feedback");
        if (feedback != null && !feedback.trim().isEmpty()) {
            feedbackList.add(feedback);
        }
        response.sendRedirect("comments");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h2>All Feedbacks</h2><ul>");
        synchronized (feedbackList) {
            for (String fb : feedbackList) {
                out.println("<li>" + fb + "</li>");
            }
        }
        out.println("</ul><a href='feedback.html'>Go Back</a></body></html>");
    }
}