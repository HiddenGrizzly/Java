package JavaEnterpriseComponents.model;

import JavaEnterpriseComponents.dao.DBConnection;
import JavaEnterpriseComponents.entity.Staff;
import JavaEnterpriseComponents.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StaffDAO implements DAOInterface<Staff> {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet= null;

    public static StaffDAO getInstance() {
        return new StaffDAO();
    }
    @Override
    public void insert(Staff staff) throws SQLException {
        connection = DBConnection.getConnection();

        String query ="INSERT INTO staff(id, name )" +
                " VALUES (?, ?) ";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, staff.getId());
        preparedStatement.setString(2, staff.getName());

        preparedStatement.executeUpdate();

        DBConnection.closePreparedstatement(preparedStatement);
        DBConnection.closeConnection(connection);
    }

    @Override
    public Staff selectById(String id) throws SQLException {
        Staff staff = new Staff();
        connection = DBConnection.getConnection();

        String query ="SELECT * FROM staff WHERE id = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,id);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            staff.setId(resultSet.getString(1));
            staff.setName(resultSet.getString(2));
        }

        DBConnection.closePreparedstatement(preparedStatement);
        DBConnection.closeConnection(connection);

        return staff;
    }

    @Override
    public Staff selectByName(String name) throws SQLException {
        Staff staff = new Staff();
        connection = DBConnection.getConnection();

        String query ="SELECT * FROM staff WHERE name = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,name);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            staff.setId(resultSet.getString(1));
            staff.setName(resultSet.getString(2));
        }

        DBConnection.closePreparedstatement(preparedStatement);
        DBConnection.closeConnection(connection);

        return staff;
    }

    @Override
    public ArrayList<Staff> selectAll() throws SQLException {
        Staff staff = new Staff();
        ArrayList<Staff> list = new ArrayList<>();

        connection = DBConnection.getConnection();

        String query ="SELECT * FROM staff";
        preparedStatement = connection.prepareStatement(query);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            staff.setId(resultSet.getString(1));
            staff.setName(resultSet.getString(2));
            list.add(staff);
        }

        return list;
    }
}
