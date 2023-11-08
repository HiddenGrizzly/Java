package slot12.model;

import slot12.connect.GetConnection;
import slot12.entity.Admin;
import slot12.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginAdmin implements LoginInterface{
    private static final Connection connect = GetConnection.createConnection();
    private static PreparedStatement prep = null;
    private static ResultSet resultSet = null;
    @Override
    public boolean checkLoginAdmin(Admin admin) {
        String dbQuery = "SELECT adminName FROM admin WHERE adminName = ? AND adminPassword = ?";
        try {
            prep = connect.prepareStatement(dbQuery);
            prep.setString(1, admin.getAdminName());
            prep.setString(2, admin.getAdminPassword());
            resultSet = prep.executeQuery();
            if (resultSet.next()){
                System.out.println("Hello " + resultSet.getString("adminName"));
                return true;

            } else {
                System.out.println("Wrong name or password!");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Login error!");
            return false;
        }
    }
    public boolean addEmployee(Employee employee){
        String addQuery = "INSERT INTO employee (firstName, lastName, salary) VALUES (?, ?, ?)";
        try {
            prep = connect.prepareStatement(addQuery);
            prep.setString(1, employee.getFirstName());
            prep.setString(2, employee.getLastName());
            prep.setDouble(3, employee.getSalary());
            int rowsAffected = prep.executeUpdate();
            if (rowsAffected > 0){
                System.out.println("Add employee successful.");
                return true;
            } else {
                System.out.println("Add employee fail.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateEmployee(int id, String firstName, String lastName, double salary){
        String updateQuery = "UPDATE employee SET firstName = ?, lastName = ?, salary = ? WHERE id = ?";
        try {
            prep = connect.prepareStatement(updateQuery);
            prep.setString(1, firstName);
            prep.setString(2, lastName);
            prep.setDouble(3, salary);
            prep.setInt(4, id);
            int rowsAffected = prep.executeUpdate();
            if (rowsAffected > 0){
                System.out.println("Update employee successful.");
                return true;
            } else {
                System.out.println("Update employee fail.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteEmployee(int id){
        String deleteQuery = "DELETE FROM employee WHERE id = ?";
        try {
            prep = connect.prepareStatement(deleteQuery);
            prep.setInt(1, id);
            int rowsAffected = prep.executeUpdate();
            if (rowsAffected > 0){
                System.out.println("Delete employee successful.");
                return true;
            } else {
                System.out.println("Delete employee fail. No employee with such ID exists.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<Employee> searchEmployee(int id){
        List<Employee> employees = new ArrayList<>();
        String searchQuery = "SELECT * FROM employee WHERE id = ?";
        try {
            prep = connect.prepareStatement(searchQuery);
            prep.setInt(1, id);
            resultSet = prep.executeQuery();
            while (resultSet.next()){
                int empID = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                double salary = resultSet.getDouble("salary");
                Employee employee = new Employee(empID, firstName, lastName, salary);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
    public List<Employee> searchEmployee(String name){
        List<Employee> employees = new ArrayList<>();
        String searchQuery = "SELECT * FROM employee WHERE firstName = ?";
        try {
            prep = connect.prepareStatement(searchQuery);
            prep.setString(1, name);
            resultSet = prep.executeQuery();
            while (resultSet.next()){
                int empID = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                double salary = resultSet.getDouble("salary");
                Employee employee = new Employee(empID, firstName, lastName, salary);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
    public void printEmployees(List<Employee> employees){
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getEmpID());
            System.out.println("First Name: " + employee.getFirstName());
            System.out.println("Last Name: " + employee.getLastName());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("-------------------------");
        }
    }
}
