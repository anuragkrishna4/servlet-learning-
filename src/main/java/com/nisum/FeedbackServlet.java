package com.nisum;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FeedbackServlet extends HttpServlet {
    private List<String> feedbackList;

    @Override
    public void init() throws ServletException {
        feedbackList = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String message = request.getParameter("message");

        String entry = "<strong>" + username + "</strong>: " + message;
        feedbackList.add(entry);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Thank you for your feedback, " + username + "!</h2>");
        out.println("<a href='feedback.html'>Submit Another</a><br><br>");

        out.println("<h3>All Feedback:</h3>");
        synchronized (feedbackList) {
            for (String feedback : feedbackList) {
                out.println("<p>" + feedback + "</p>");
            }
        }
        out.println("</body></html>");
    }
}

