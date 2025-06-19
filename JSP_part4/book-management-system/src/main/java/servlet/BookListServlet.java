package servlet;

import dto.Book;
import dao.BookDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class BookListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try{
            BookDAO dao = BookDAO.getInstance();
            List<Book> books;
            books = dao.getAllBooks();
            request.setAttribute("books", books);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/bookList.jsp");
            dispatcher.forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
