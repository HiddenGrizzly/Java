package AptechLibrary.src.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
    public static Connection createConnection(){
        String dbUrl = "jdbc:mySQL://localhost:3306/slot13";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, "root", "");
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return connection;
    }
}
