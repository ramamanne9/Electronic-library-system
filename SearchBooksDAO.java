package test;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchBooksDAO {
    private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private String jdbcUsername = "system";
    private String jdbcPassword = "admin";

    private static final String SELECT_BOOKS_SQL = "SELECT * FROM books WHERE " +
            "(? = 0 OR bookId = ?) AND " +
            "(? IS NULL OR title LIKE ?) AND " +
            "(? IS NULL OR author LIKE ?) AND " +
            "(? = 0 OR isbn = ?) AND " +
            "(? IS NULL OR category LIKE ?) AND " +
            "(? IS NULL OR description LIKE ?) AND " +
            "(? = 0 OR totalCopies = ?) AND " +
            "(? = 0 OR availableCopies = ?) AND " +
            "(? = 0 OR isBorrowed = ?)";

    public List<Books> searchBooks(Books searchBook) {
        List<Books> books = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKS_SQL)) {

            preparedStatement.setInt(1, searchBook.getBookId());
       
            preparedStatement.setString(2, searchBook.getTitle());
        
            preparedStatement.setString(3, searchBook.getAuthor());
         
            preparedStatement.setInt(4, (int) searchBook.getIsbn());
          
            preparedStatement.setString(5, searchBook.getCategory());
          
            preparedStatement.setString(6, searchBook.getDescription());
          
            preparedStatement.setInt(7, searchBook.getTotalcopies());
         
            preparedStatement.setInt(8, searchBook.getAvailablecopies());
            preparedStatement.setInt(9, searchBook.isIs_borrowed());
                                                          
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int bookId = resultSet.getInt("bookId");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int isbn = resultSet.getInt("isbn");
                String category = resultSet.getString("category");
                String description = resultSet.getString("description");
                int totalCopies = resultSet.getInt("totalCopies");
                int availableCopies = resultSet.getInt("availableCopies");
                int is_Borrowed = resultSet.getInt("is_Borrowed");

  Books book = new Books( bookId, title, author, isbn, category,description, totalCopies, availableCopies,is_Borrowed);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
