package test;


import java.io.IOException;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertBooksServlet")
public class InsertBooksServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    static final String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
    static final String username = "system"; 
    static final String password = "admin"; 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        
        int bookid = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        long isbn = Long.parseLong(request.getParameter("isbn")); 
        String category = request.getParameter("catogery");
        String description = request.getParameter("description");
        int totalCopies = Integer.parseInt(request.getParameter("totalCopies"));
        int availableCopies = Integer.parseInt(request.getParameter("availableCopies"));
        int is_borrowed = Integer.parseInt(request.getParameter("is_borrowed"));

        String sql = "INSERT INTO books VALUES (?,?,?,?,?,?,?,?,?)";
        try (
            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
            pstmt.setInt(1, bookid);
            pstmt.setString(2, title);
            pstmt.setString(3, author);
            pstmt.setLong(4, isbn);
            pstmt.setString(5, category);
            pstmt.setString(6, description);
            pstmt.setInt(7, totalCopies);
            pstmt.setInt(8, availableCopies);
            pstmt.setInt(9, is_borrowed);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                response.getWriter().println("Book inserted successfully!");
            } 
            else {
                response.getWriter().println("Failed to insert book.");
            }
        } 
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Database operation failed", e);
        }
    

        }
}