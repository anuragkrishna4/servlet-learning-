package com.nisum;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class CookieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Read cookies from the request
        Cookie[] cookies = request.getCookies();
        String userName = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    userName = cookie.getValue();
                    break;
                }
            }
        }

        out.println("<html><body>");
        if (userName != null) {
            out.println("<h2>Welcome back, " + userName + "!</h2>");
        } else {
            out.println("<h2>No cookie found. Setting cookie now.</h2>");

            // Set a new cookie
            Cookie cookie = new Cookie("username", "Anurag");
            cookie.setMaxAge(60 * 60 * 24); // 1 day expiry
            response.addCookie(cookie);

            out.println("<p>Cookie named 'username' has been set.</p>");
        }
        out.println("</body></html>");
    }
}
