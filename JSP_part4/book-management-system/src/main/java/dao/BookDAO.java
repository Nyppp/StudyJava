package dao;

import dto.Book;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private static BookDAO instance = new BookDAO();
    private BookDAO() {}

    public static BookDAO getInstance(){
        return instance;
    }

    public List<Book> getAllBooks(){
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()){
                Book book = new Book();
                book.setBook_id(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getInt("price"));
                book.setPublishDate(rs.getDate("publish_date"));
                book.setDescription(rs.getString("description"));
                book.setCreatedAt(rs.getTimestamp("created_at"));
                book.setUpdatedAt(rs.getTimestamp("updated_at"));
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    public Book getBook(int book_id){
        String sql = "SELECT * FROM books WHERE book_id=?";
        Book book = new Book();

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, book_id);

            ResultSet rs = pstmt.executeQuery();


            if (rs.next()){
                book.setBook_id(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getInt("price"));
                book.setPublishDate(rs.getDate("publish_date"));
                book.setDescription(rs.getString("description"));
                book.setCreatedAt(rs.getTimestamp("created_at"));
                book.setUpdatedAt(rs.getTimestamp("updated_at"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public int insertBook(Book b){
        String sql = "INSERT INTO books" +
                "(title, author, price, publish_date, description)" +
                "VALUES(?, ?, ?, ?, ?)";
        int result = 0;

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, b.getTitle());
            pstmt.setString(2, b.getAuthor());
            pstmt.setInt(3,b.getPrice());
            pstmt.setDate(4, b.getPublishDate());
            pstmt.setString(5, b.getDescription());
            result = pstmt.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public int deleteBook(int book_id){
        String sql = "DELETE FROM books WHERE book_id=?";
        int result = 0;
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, book_id);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updateBook(Book b){
        String sql = "UPDATE books SET " +
                "title = ?, " +
                "author = ?, " +
                "price = ?, " +
                "publish_date = ?, " +
                "description = ?, " +
                "updated_at = ? " +
                "WHERE book_id = ?";
        int result = 0;

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, b.getTitle());
            pstmt.setString(2, b.getAuthor());
            pstmt.setInt(3,b.getPrice());
            pstmt.setDate(4, b.getPublishDate());
            pstmt.setString(5, b.getDescription());
            pstmt.setTimestamp(6, b.getUpdatedAt());
            pstmt.setInt(7, b.getBook_id());
            result = pstmt.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
