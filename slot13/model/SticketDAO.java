package JavaEnterpriseComponents.model;

import JavaEnterpriseComponents.dao.DBConnection;
import JavaEnterpriseComponents.entity.Book;
import JavaEnterpriseComponents.entity.Sticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SticketDAO implements DAOInterface<Sticket>{

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet= null;

    public static SticketDAO getInstance() {
        return new SticketDAO();
    }
    @Override
    public void insert(Sticket sticket) throws SQLException {
        connection = DBConnection.getConnection();

        String query ="INSERT INTO sticket(id, nameTicket, student_id, book_id, borrowDate, returnDate)" +
                " VALUES (?, ?, ?, ?, ?, ?) ";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, sticket.getId());
        preparedStatement.setString(2, sticket.getNameTicket());
        preparedStatement.setString(3, sticket.getStudent_id());
        preparedStatement.setString(4, sticket.getBook_id());
        preparedStatement.setDate(5, sticket.getBorrowDate());
        preparedStatement.setDate(6, sticket.getReturnDate());

        preparedStatement.executeUpdate();

        DBConnection.closePreparedstatement(preparedStatement);
        DBConnection.closeConnection(connection);
    }

    @Override
    public Sticket selectById(String id) throws SQLException {
        Sticket sticket = null;
        connection = DBConnection.getConnection();

        String query ="SELECT * FROM sticket WHERE id = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,id);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            sticket = new Sticket();
            sticket.setId(resultSet.getString(1));
            sticket.setNameTicket(resultSet.getString(2));
            sticket.setStudent_id(resultSet.getString(3));
            sticket.setBook_id(resultSet.getString(4));
            sticket.setBorrowDate(resultSet.getDate(5));
            sticket.setReturnDate(resultSet.getDate(6));
        }

        DBConnection.closePreparedstatement(preparedStatement);
        DBConnection.closeConnection(connection);

        return sticket;
    }

    @Override
    public Sticket selectByName(String title) throws SQLException {
        Sticket sticket = null;
        connection = DBConnection.getConnection();

        String query ="SELECT * FROM sticket WHERE name = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,title);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            sticket = new Sticket();
            sticket.setId(resultSet.getString(1));
            sticket.setNameTicket(resultSet.getString(2));
            sticket.setStudent_id(resultSet.getString(3));
            sticket.setBook_id(resultSet.getString(4));
            sticket.setBorrowDate(resultSet.getDate(5));
            sticket.setReturnDate(resultSet.getDate(6));
        }

        DBConnection.closePreparedstatement(preparedStatement);
        DBConnection.closeConnection(connection);

        return sticket;
    }

    @Override
    public ArrayList<Sticket> selectAll() throws SQLException {
        ArrayList<Sticket> list = new ArrayList<>();

        connection = DBConnection.getConnection();

        String query ="SELECT * FROM sticket";
        preparedStatement = connection.prepareStatement(query);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Sticket sticket = new Sticket();
            sticket.setId(resultSet.getString(1));
            sticket.setNameTicket(resultSet.getString(2));
            sticket.setStudent_id(resultSet.getString(3));
            sticket.setBook_id(resultSet.getString(4));
            sticket.setBorrowDate(resultSet.getDate(5));
            sticket.setReturnDate(resultSet.getDate(6));
            list.add(sticket);
        }

        return list;
    }

    public Sticket selectByBookId(String book_id) throws SQLException {

        Sticket sticket = null;
        connection = DBConnection.getConnection();

        String query ="SELECT * FROM sticket WHERE book_id = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,book_id);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            sticket = new Sticket();
            sticket.setId(resultSet.getString(1));
            sticket.setNameTicket(resultSet.getString(2));
            sticket.setStudent_id(resultSet.getString(3));
            sticket.setBook_id(resultSet.getString(4));
            sticket.setBorrowDate(resultSet.getDate(5));
            sticket.setReturnDate(resultSet.getDate(6));
        }

        DBConnection.closePreparedstatement(preparedStatement);
        DBConnection.closeConnection(connection);

        return sticket;
    }
}
