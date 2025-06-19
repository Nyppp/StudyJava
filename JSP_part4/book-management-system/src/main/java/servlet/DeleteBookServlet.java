package servlet;

import dao.BookDAO;
import dto.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/books/delete")
public class DeleteBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int book_id = Integer.parseInt(request.getParameter("book_id"));

        String title = request.getParameter("title");
        request.setAttribute("deletedBookTitle", title);

        BookDAO dao = BookDAO.getInstance();
        dao.deleteBook(book_id);

        List<Book> books = dao.getAllBooks();

        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/bookList.jsp");
        dispatcher.forward(request, response);
    }
}
