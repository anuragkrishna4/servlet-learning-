package com.nisum;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShoppingCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String item = request.getParameter("item");
        HttpSession session = request.getSession(true);

        List<String> cart = (List<String>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        if (item != null && !item.trim().isEmpty()) {
            cart.add(item);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Shopping Cart</h2>");
        out.println("<form method='post' action='cart'>");
        out.println("Add Item: <input type='text' name='item'/>");
        out.println("<input type='submit' value='Add'/>");
        out.println("</form><br>");

        out.println("<h3>Items in your cart:</h3>");
        for (String i : cart) {
            out.println("<p>" + i + "</p>");
        }

        out.println("</body></html>");
    }

    // Optional: handle GET to show form
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
