package JavaEnterpriseComponents.model;

import JavaEnterpriseComponents.dao.DBConnection;
import JavaEnterpriseComponents.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO implements DAOInterface<Book> {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet= null;

    public static BookDAO getInstance() {
        return new BookDAO();
    }

    @Override
    public void insert(Book book) throws SQLException {
        connection = DBConnection.getConnection();

        String query ="INSERT INTO book(id, title, author, category, price, status)" +
                " VALUES (?, ?, ?, ?, ?, ?) ";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, book.getId());
        preparedStatement.setString(2, book.getTitle());
        preparedStatement.setString(3, book.getAuthor());
        preparedStatement.setString(4, book.getCatalogy());
        preparedStatement.setDouble(5, book.getPrice());
        preparedStatement.setBoolean(6, book.isStatus());

        preparedStatement.executeUpdate();

        DBConnection.closePreparedstatement(preparedStatement);
        DBConnection.closeConnection(connection);
    }

    @Override
    public Book selectById(String id) throws SQLException {
        Book book = null;
        connection = DBConnection.getConnection();

        String query ="SELECT * FROM book WHERE id = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,id);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            book = new Book();
            book.setId(resultSet.getString(1));
            book.setTitle(resultSet.getString(2));
            book.setAuthor(resultSet.getString(3));
            book.setCatalogy(resultSet.getString(4));
            book.setPrice(resultSet.getDouble(5));
            book.setStatus(resultSet.getBoolean(6));
        }

        DBConnection.closePreparedstatement(preparedStatement);
        DBConnection.closeConnection(connection);

        return book;
    }

    @Override
    public Book selectByName(String title) throws SQLException {
        Book book = null;
        connection = DBConnection.getConnection();

        String query ="SELECT * FROM book WHERE title = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, title);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            book = new Book();
            book.setId(resultSet.getString(1));
            book.setTitle(resultSet.getString(2));
            book.setAuthor(resultSet.getString(3));
            book.setCatalogy(resultSet.getString(4));
            book.setPrice(resultSet.getDouble(5));
            book.setStatus(resultSet.getBoolean(6));
        }

        DBConnection.closePreparedstatement(preparedStatement);
        DBConnection.closeConnection(connection);

        return book;
    }

    @Override
    public ArrayList<Book> selectAll() throws SQLException {
        ArrayList<Book> list = new ArrayList<>();

        connection = DBConnection.getConnection();

        String query ="SELECT * FROM book";
        preparedStatement = connection.prepareStatement(query);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Book book = new Book();
            book.setId(resultSet.getString(1));
            book.setTitle(resultSet.getString(2));
            book.setAuthor(resultSet.getString(3));
            book.setCatalogy(resultSet.getString(4));
            book.setPrice(resultSet.getDouble(5));
            book.setStatus(resultSet.getBoolean(6));
            list.add(book);
        }

        return list;
    }

    public String checkNameBook(String name) throws SQLException{
        connection = DBConnection.getConnection();
        String check = null;
        String query ="SELECT name FROM book WHERE name = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);

        System.out.println(query);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            check = resultSet.getString("name");
        }

        return check;
    }

    public void updateStatus(Book book) throws SQLException {

        int result = 0;
        connection = DBConnection.getConnection();

        String query ="UPDATE book SET status = ? WHERE id = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setBoolean(1, book.isStatus());
        preparedStatement.setString(2, book.getId());

        result = preparedStatement.executeUpdate();
        if (result>0) {
            System.out.println("Updated status successfully");
        } else {
            System.out.println("Update failed status");
        }


    }





}
