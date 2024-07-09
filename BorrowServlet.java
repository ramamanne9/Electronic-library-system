package test;



	import java.io.IOException;



	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.time.LocalDate;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	@WebServlet("/borrow")
	public class BorrowServlet extends HttpServlet {
		   
		   private static final long serialVersionUID = 1L;

		    protected void doPost(HttpServletRequest request, HttpServletResponse response)
		            throws ServletException, IOException {
		        
		        int bookId = Integer.parseInt(request.getParameter("bookId"));
		        HttpSession session = request.getSession();
		        Borrow br = (Borrow) session.getAttribute("br");

		        if (br == null) {
		            response.sendRedirect("error.jsp");
		            return;
		        }

		        try {
		            Class.forName("oracle.jdbc.driver.OracleDriver");
		            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "admin");

		            String sqlUpdateBook = "UPDATE books SET is_borrowed = ? WHERE book_id = ?";
		            PreparedStatement pstmtUpdateBook = con.prepareStatement(sqlUpdateBook);
		            pstmtUpdateBook.setInt(1, bookId);
		            pstmtUpdateBook.executeUpdate();
		            pstmtUpdateBook.close();

		            String sqlInsertBorrow = "INSERT INTO BORROW (borrowid, userid, bookid, bdate, rdate) VALUES (?, ?, ?, ?, ?, ?)";
		            PreparedStatement pstmtInsertBorrow = con.prepareStatement(sqlInsertBorrow);
		            pstmtInsertBorrow.setInt(1, br.getBorrowid()); 
		            pstmtInsertBorrow.setInt(2, br.getUserid());
		            pstmtInsertBorrow.setInt(3, bookId); 
		            pstmtInsertBorrow.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
		            pstmtInsertBorrow.setDate(5, java.sql.Date.valueOf("LocalDate.of(year, month, date"));

		            pstmtInsertBorrow.executeUpdate();
		            pstmtInsertBorrow.close();

		            con.close();

	            response.sendRedirect("library"); 
		        } catch (ClassNotFoundException | SQLException e) {
		            e.printStackTrace();
		            
		            response.sendRedirect("error.jsp");
		        }
		    }
		}



