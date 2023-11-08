package JavaEnterpriseComponents.model;

import JavaEnterpriseComponents.dao.DBConnection;
import JavaEnterpriseComponents.entity.Book;
import JavaEnterpriseComponents.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO implements DAOInterface<Student>{

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet= null;

    public static StudentDAO getInstance() {
        return new StudentDAO();
    }

    @Override
    public void insert(Student student) throws SQLException {
        connection = DBConnection.getConnection();

        String query ="INSERT INTO student(id, name )" +
                " VALUES (?, ?) ";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, student.getId());
        preparedStatement.setString(2, student.getName());

        preparedStatement.executeUpdate();

        DBConnection.closePreparedstatement(preparedStatement);
        DBConnection.closeConnection(connection);
    }

    @Override
    public Student selectById(String id) throws SQLException {
        Student student = new Student();
        connection = DBConnection.getConnection();

        String query ="SELECT * FROM student WHERE id = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,id);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            student.setId(resultSet.getString(1));
            student.setName(resultSet.getString(2));
        }

        DBConnection.closePreparedstatement(preparedStatement);
        DBConnection.closeConnection(connection);

        return student;
    }

    @Override
    public Student selectByName(String name) throws SQLException {
        Student student = new Student();
        connection = DBConnection.getConnection();

        String query ="SELECT * FROM student WHERE name = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,name);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            student.setId(resultSet.getString(1));
            student.setName(resultSet.getString(2));
        }

        DBConnection.closePreparedstatement(preparedStatement);
        DBConnection.closeConnection(connection);

        return student;
    }

    @Override
    public ArrayList<Student> selectAll() throws SQLException {
        Student student = new Student();
        ArrayList<Student> list = new ArrayList<>();

        connection = DBConnection.getConnection();

        String query ="SELECT * FROM student";
        preparedStatement = connection.prepareStatement(query);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            student.setId(resultSet.getString(1));
            student.setName(resultSet.getString(2));
            list.add(student);
        }

        return list;
    }
}
