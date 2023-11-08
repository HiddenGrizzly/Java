package slot12.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
    public static Connection createConnection(){
        Connection connection = null;
        String dbUrl = "jdbc:mySQL://localhost:3306/slot12";
        try {
            connection = DriverManager.getConnection(dbUrl, "root", "");
        } catch (SQLException e) {
        }
        return connection;
    }
}
