package com.nisum;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {


    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "Happy@1008";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Student List</title></head><body>");
        out.println("<h2>Student Data</h2>");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            conn = DriverManager.getConnection(URL, USER, PASSWORD);


            String sql = "SELECT id, name, age, email FROM student";
            ps = conn.prepareStatement(sql);

            // Execute query
            rs = ps.executeQuery();


            out.println("<table border='1' cellpadding='10'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Age</th><th>Email</th></tr>");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");


                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + age + "</td>");
                out.println("<td>" + email + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");

        } catch (ClassNotFoundException e) {
            out.println("<p>Error: JDBC Driver not found.</p>");
        } catch (SQLException e) {
            out.println("<p>Database error: " + e.getMessage() + "</p>");
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {

            }
        }

        out.println("</body></html>");
    }
}
