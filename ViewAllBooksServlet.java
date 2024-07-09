package test;




	import java.io.IOException;



	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	@WebServlet("/allbooks")
	public class ViewAllBooksServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        Connection con = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        try {
	        	Class.forName("oracle.jdbc.driver.OracleDriver"); 
	            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "admin");

	            stmt = con.prepareStatement("SELECT * FROM books");

	            rs = stmt.executeQuery();

	            List<Books> bookList = new ArrayList<>();

	            while (rs.next()) {
	                Books book= new Books();
	                book.setBookId(rs.getInt("bookid"));
	                book.setTitle(rs.getString("title"));
	                book.setAuthor(rs.getString("author"));
	                book.setIsbn(rs.getInt("isbn"));
	                book.setCategory(rs.getString("category"));
	                book.setDescription(rs.getString("description"));
	                book.setTotalcopies(rs.getInt("total_copies"));
	                book.setAvailablecopies(rs.getInt("available_copies"));
	book.setIs_borrowed(0);              
	                bookList.add(book);
	            }

	        
	            rs.close();
	            stmt.close();
	            con.close();

	            response.setContentType("text/html");

	            response.getWriter().println("Book Details:");
	            for (Books book : bookList) {
	                response.getWriter().println("Book ID: " + book.getBookId());
	                response.getWriter().println("Title: " + book.getTitle());
	                response.getWriter().println("Author: " + book.getAuthor());
	                response.getWriter().println("ISBN: " + book.getIsbn());
	                response.getWriter().println("Category: " + book.getCategory());
	                response.getWriter().println("Description: " + book.getDescription());
	                response.getWriter().println("Total Copies: " + book.getTotalcopies());
	                response.getWriter().println("Available Copies: " + book.getAvailablecopies());
	                response.getWriter().println("is_borrowed:"+book.isIs_borrowed());
	                response.getWriter().println("---------------------------------");
	            }

	        } catch (SQLException e) {
	     
	        	System.out.println(e.toString());
	            response.getWriter().println("Failed to fetch book details.");
	        } catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
	            try {
	                if (rs != null)
	                    rs.close();
	                if (stmt != null)
	                    stmt.close();
	                if (con != null)
	                    con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}




