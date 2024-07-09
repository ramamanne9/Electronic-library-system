package test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchBooksServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
	private static final int d = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int isbn = Integer.parseInt(request.getParameter("isbn"));
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        int totalCopies = Integer.parseInt(request.getParameter("totalCopies"));
        int availableCopies = Integer.parseInt(request.getParameter("availableCopies"));
        int isBorrowed = Integer.parseInt(request.getParameter("is_borrowed"));

        Books searchBook = new Books();
        searchBook.setBookId(bookId);
        searchBook.setTitle(title);
        searchBook.setAuthor(author);
        searchBook.setIsbn(isbn);
        searchBook.setCategory(category);
        searchBook.setDescription(description);
        searchBook.setTotalcopies(totalCopies);
        searchBook.setAvailablecopies(availableCopies);
		boolean isIs_Borrowed = false;
		searchBook.setIs_borrowed(1);
        SearchBooksDAO searchBooksDAO = new SearchBooksDAO();
        List<Books> searchResults = searchBooksDAO.searchBooks(searchBook);

        request.setAttribute("searchResults", searchResults);

        request.getRequestDispatcher("/displaySearchResults.jsp").forward(request, response);
    }
}
