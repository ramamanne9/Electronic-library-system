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
	@WebServlet("/DeleteServlet")
	public class DeleteServlet extends HttpServlet {
		
		 

		private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        int bookId = Integer.parseInt(request.getParameter("bookId"));
	        
	        Connection con = null;
	        PreparedStatement stmt = null;
	        
			try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "admin");
	            
	            stmt = con.prepareStatement("DELETE FROM books WHERE  BOOK_ID=?");
	            
	            stmt.setInt(1, bookId);
	            
	            int rowsDeleted = stmt.executeUpdate();
	            
	            if (rowsDeleted > 0) {
	                response.getWriter().println("Book deleted successfully.");
	            } else {
	            	response.getWriter().println("No book found with ID " + bookId);
	            }
	            
	        } 
	        catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            response.getWriter().println("Failed to delete book.");
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
	            


