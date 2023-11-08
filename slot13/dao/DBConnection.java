package JavaEnterpriseComponents.dao;
import java.sql.*;


public class DBConnection {
    public static Connection getConnection() throws SQLException {
        Connection connection = null;

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        String url = "jdbc:mySQL://localhost:3306/javaenterprisecomponents";
        String username = "root";
        String password = "";

        connection = DriverManager.getConnection(url, username, password);

        return connection;
    }

    // Ngắt kết nối
    public static void closeConnection(Connection connection) throws SQLException{
        if (connection!=null) {
            connection.close();
        }
    }

    public static void closePreparedstatement(PreparedStatement preparedStatement) throws SQLException {
        if (preparedStatement!=null){
            preparedStatement.close();
        }
    }

    public static void closeResultset(ResultSet resultSet) throws SQLException {
        if (resultSet!=null) {
            resultSet.close();
        }
    }

}
