package servlet;

import dto.Book;
import dao.BookDAO;
import util.SecurityUtil;
import validator.BookValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/books/edit")
public class EditBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try{
            int book_id = Integer.parseInt(request.getParameter("book_id"));
            BookDAO dao = BookDAO.getInstance();

            Book b = dao.getBook(book_id);
            String title = SecurityUtil.sanitizeInput(request.getParameter("title"));
            String author = SecurityUtil.sanitizeInput(request.getParameter("author"));
            String price = request.getParameter("price");
            String publishDate = request.getParameter("publishDate");
            String description = SecurityUtil.sanitizeInput(request.getParameter("description"));

            Map<String, String> errors = new HashMap<>();

            if (!BookValidator.checkTitle(title)) {
                errors.put("title", "제목이 유효하지 않습니다. (필수 입력, 최대 200자)");
            }
            if (!BookValidator.checkAuthor(author)) {
                errors.put("author", "저자가 유효하지 않습니다. (필수 입력, 최대 100자)");
            }
            if (!BookValidator.checkPrice(price)) {
                errors.put("price", "가격이 유효하지 않습니다.(필수 입력, 0 ~ 1,000,000)");
            }
            if (!BookValidator.checkDate(publishDate)) {
                errors.put("publishDate", "출간일이 올바르지 않습니다. (날짜 형식 : YYYY-MM-DD)");
            }
            if (!BookValidator.checkDescription(description)) {
                errors.put("description", "설명이 유효하지 않습니다 (1000자 이하)");
            }

            if (!errors.isEmpty()) {
                request.setAttribute("errors", errors);
                request.setAttribute("book",b);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/editBook.jsp");
                dispatcher.forward(request, response);
                return;
            }

            b.setTitle(title);
            b.setAuthor(author);
            b.setPrice(Integer.parseInt(price));
            b.setPublishDate(Date.valueOf(publishDate));
            b.setDescription(description);
            b.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));

            dao.updateBook(b);

            request.setAttribute("updatedBookTitle", b.getTitle());

            List<Book> books = dao.getAllBooks();

            request.setAttribute("books", books);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/bookList.jsp");
            dispatcher.forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int book_id = Integer.parseInt(request.getParameter("book_id"));
        BookDAO dao = BookDAO.getInstance();
        Book book = dao.getBook(book_id);

        request.setAttribute("book", book);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/editBook.jsp");
        dispatcher.forward(request, response);
    }
}
