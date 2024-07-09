

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
import javax.servlet.http.HttpSession;

@WebServlet("/ReturnBooks")
public class ReturnServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String message = "";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "system", "admin");

            String sqlUpdateBook = "UPDATE books SET is_borrowed = FALSE WHERE book_id = ?";
            PreparedStatement pstmtUpdateBook = con.prepareStatement(sqlUpdateBook);
            pstmtUpdateBook.setInt(1, bookId);
            int rowsUpdated = pstmtUpdateBook.executeUpdate();

            if (rowsUpdated > 0) {
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("user");

                String sqlUpdateUserBooks = "DELETE FROM user_books WHERE user_id = ? AND book_id = ?";
                PreparedStatement pstmtUpdateUserBooks = con.prepareStatement(sqlUpdateUserBooks);
                pstmtUpdateUserBooks.setInt(1, user.getUserId());
                pstmtUpdateUserBooks.setInt(2, bookId);
                int rowsDeleted = pstmtUpdateUserBooks.executeUpdate();

                if (rowsDeleted > 0) {
                    message = "Book returned successfully!";
                } else {
                    message = "Failed to return book. User-book association not found.";
                }

                pstmtUpdateUserBooks.close();
            } else {
                message = "Failed to update book status.";
            }

            pstmtUpdateBook.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            message = "Database error: " + e.getMessage();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            message = "Error loading Oracle JDBC Driver: " + e.getMessage();
        }

        request.setAttribute("returnMessage", message);

        request.getRequestDispatcher("/returnResult.jsp").forward(request, response);
    }
}





