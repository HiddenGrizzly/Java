package slot11.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
    public static Connection createConnection(){
        String dbUrl = "jdbc:mySQL://localhost:3306/slot11";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, "root", "");
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return connection;
    }
}

