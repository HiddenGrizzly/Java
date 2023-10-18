package JavaCore2.aptechBankOnline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BankApp {
    public Connection getSQLConnection() throws SQLException {
        String hostName = "localhost";
        String dbName = "DemoBankAptech";
        String username = "root";
        String password = "";
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        Connection connection = DriverManager.getConnection(connectionURL, username, password);
        return connection;
    }
    public void insert(Customer customer) throws SQLException {
        Connection connection = getSQLConnection();
        String query = "INSERT INTO customer VALUES (?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, customer.getId());
        preparedStatement.setString(2, customer.getName());
        preparedStatement.executeUpdate();
        connection.close();
    }
    public void delete(int id){

    }
    public void update(Customer customer){

    }
    public Customer findById(int id){
        return null;
    }
    public List<Customer> getAllCustomer(String name){

        return null;
    }
}
