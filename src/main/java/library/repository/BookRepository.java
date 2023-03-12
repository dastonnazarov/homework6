package library.repository;

import library.db.Database;
import library.dto.Book;
import library.dto.Student;
import library.enums.StudentRole;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class BookRepository {
    public void addBook(Book book) {
            try {
                Connection connection = Database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("insert into book (title,author,publishYear,amount)values(?,?,?,now(),?)");
                preparedStatement.setString(1, book.getTitle());
                preparedStatement.setString(2, book.getAuthor());
                preparedStatement.setDouble(3, book.getAmount());
                int i = preparedStatement.executeUpdate();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public List<Book> getBookList() {
        List<Book> bookList = new LinkedList<>();
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from book");
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublishYear(resultSet.getTimestamp("publishYear").toLocalDateTime().toLocalDate());
                book.setAmount(resultSet.getDouble("amount"));
                book.setVisible(Boolean.valueOf(resultSet.getString("visible")));
                bookList.add(book);
            }
            connection.close();
            return bookList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public int deleteBook(Integer id) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from book where id = ?");
            preparedStatement.setInt(1, id);
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Book getBookById(Integer id) {
        try {
            Book book = null;
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from book where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublishYear(resultSet.getTimestamp("publishYear").toLocalDateTime().toLocalDate());
                book.setAmount(resultSet.getDouble("amount"));
                book.setVisible(Boolean.valueOf(resultSet.getString("visible")));
            }
            connection.close();
            return book;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
