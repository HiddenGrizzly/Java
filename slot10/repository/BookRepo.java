package repository;

import model.Book;
import model.Student;
import org.w3c.dom.ls.LSInput;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepo {
    public static Connection getConnect() throws SQLException {
        String url = "jdbc:mysql://localhost:3307/new_db";
        String username = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public static void close(Statement statement) throws SQLException {
        statement.close();

    }

    public static void close(Connection connection) throws SQLException {
        connection.close();

    }

    public static void close(ResultSet resultSet) throws SQLException {
        resultSet.close();
    }

    public int create(Book book) throws SQLException {
        Connection connection = getConnect();
        PreparedStatement statement = connection.prepareStatement("insert into book(name,author,price,datein,publish,status) values (?,?,?,?,?,?)");
        statement.setString(1, book.getName());
        statement.setString(2, book.getAuthor());
        statement.setDouble(3, book.getPrice());
        statement.setString(4, book.getImportDate());
        statement.setString(5, book.getPublisher());
        statement.setBoolean(6, true);
        int res = statement.executeUpdate();
        close(statement);
        close(connection);
        return res;
    }

    public int update(Book book) throws SQLException {
        Connection connection = getConnect();
        PreparedStatement statement = connection.prepareStatement("update  book set name=?,author=?,price=?,datein=?,publish=?,status=?) where id=?");
        statement.setString(1, book.getName());
        statement.setString(2, book.getAuthor());
        statement.setDouble(3, book.getPrice());
        statement.setString(4, book.getImportDate());
        statement.setString(5, book.getPublisher());
        statement.setBoolean(6, book.getStatus());
        statement.setInt(7, book.getId());
        int res = statement.executeUpdate();
        close(statement);
        close(connection);
        return res;
    }

    public int delete(Book book) throws SQLException {
        Connection connection = getConnect();
        PreparedStatement statement = connection.prepareStatement("update book set status=0 where id=?");
        statement.setInt(1, book.getId());
        int res = statement.executeUpdate();
        close(statement);
        close(connection);
        return res;
    }

    public Book findById(int id) throws SQLException {
        Book book = new Book();
        Connection connection = getConnect();
        PreparedStatement statement = connection.prepareStatement("select * from book where id=?");
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            book.setId(set.getInt(1));
            book.setName(set.getString(2));
            book.setPrice(set.getDouble(4));
            book.setStatus((set.getBoolean(7)));
            book.setAuthor(set.getString(3));
            book.setImportDate(set.getString(5));
            book.setPublisher(set.getString(6));
        }
        close(set);
        close(statement);
        close(connection);
        return book;
    }

    public String borrow(int sid, int bid) throws SQLException {
        Connection connection = getConnect();
        PreparedStatement statement = connection.prepareStatement("insert into borrow (bid,sid) values (?,?)");
        statement.setInt(1, bid);
        statement.setInt(2, sid);
        int c = statement.executeUpdate();
        if (c > 0) return "ss";
        return "fail";
    }

    public List<Student> show() throws SQLException {
        Connection connection = getConnect();
        PreparedStatement statement = connection.prepareStatement("select s.* from student s, borrow b where s.id=b.sid");
        List<Student> students = new ArrayList<>();
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            students.add(new Student(set.getInt(1), set.getString(2)));
        }
        close(set);
        close(statement);
        close(connection);
        return students;
    }

    public List<Book> findByAuthor(String author) throws SQLException {
        List<Book> books = new ArrayList<>();
        Connection connection = getConnect();
        PreparedStatement statement = connection.prepareStatement("select * from book where author=?");
        statement.setString(1, author);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Book book = new Book();
            book.setId(set.getInt(1));
            book.setName(set.getString(2));
            book.setPrice(set.getDouble(4));
            book.setStatus((set.getBoolean(7)));
            book.setAuthor(set.getString(3));
            book.setImportDate(set.getString(5));
            book.setPublisher(set.getString(6));
            books.add(book);
        }
        close(set);
        close(statement);
        close(connection);
        return books;
    }

    public List<Book> findByPublisher(String pub) throws SQLException {
        List<Book> books = new ArrayList<>();
        Connection connection = getConnect();
        PreparedStatement statement = connection.prepareStatement("select * from book where publish=?");
        statement.setString(1, pub);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Book book = new Book();
            book.setId(set.getInt(1));
            book.setName(set.getString(2));
            book.setPrice(set.getDouble(4));
            book.setStatus((set.getBoolean(7)));
            book.setAuthor(set.getString(3));
            book.setImportDate(set.getString(5));
            book.setPublisher(set.getString(6));
            books.add(book);
        }
        close(set);
        close(statement);
        close(connection);
        return books;
    }
}
