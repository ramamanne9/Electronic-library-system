package test;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
	public class UpdateServlet extends HttpServlet {
		
	    private static final long serialVersionUID = 1L;
	  @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int bookId = Integer.parseInt(request.getParameter("bookId"));
	        String title = request.getParameter("title");
	        String author = request.getParameter("author");
	        int isbn = Integer.parseInt(request.getParameter("isbn"));
	        String category = request.getParameter("category");
	        String description = request.getParameter("description");
	        int totalCopies = Integer.parseInt(request.getParameter("totalcopies"));
	        int availableCopies = Integer.parseInt(request.getParameter("availablecopies"));
	        int is_borrowed = Integer.parseInt(request.getParameter("is_borrowed"));

	        Connection con = null;
	        PreparedStatement stmt = null;
	        
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            
	            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "admin");
	            stmt = con.prepareStatement("UPDATE books SET TITLE=?, AUTHOR=?, ISBN=?, CATEGORY=?, DESCRIPTION=?, TOTAL_COPIES=?, AVAILABLE_COPIES=?, IS_BORROWED=? WHERE BOOK_ID=?");

	            
	           
	            stmt.setString(1, title);
	            stmt.setString(2, author);
	            stmt.setInt(3, isbn);
	            stmt.setString(4, category);
	            stmt.setString(5, description);
	            stmt.setInt(6, totalCopies);
	            stmt.setInt(7, availableCopies);
	            stmt.setInt(8,is_borrowed);
	            stmt.setInt(9,bookId);
	            
	            int rowsUpdated = stmt.executeUpdate();
	            
	            if (rowsUpdated > 0) {
	                response.getWriter().println("Book updated successfully.");

	            	
	                
	            } else {
	                response.getWriter().println("No book found with ID " + bookId);
	            }
	            
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            response.getWriter().println("Failed to update book.");
	        } finally {
	            try {
	                if (stmt != null) {
	                    stmt.close();
	                }
	                if (con != null) {
	                    con.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	}
	}

			    



