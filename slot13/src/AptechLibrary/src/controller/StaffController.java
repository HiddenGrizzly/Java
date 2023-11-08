package AptechLibrary.src.controller;

import AptechLibrary.src.connection.GetConnection;
import AptechLibrary.src.model.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StaffController {
    private Connection connection = GetConnection.createConnection();
    private PreparedStatement preparedStatement = null;

    public boolean registerStaff(Staff staff){
        String registerStaffSQL = "INSERT INTO staff (staffName, staffPassword) VALUES (?, ?)";
        try {
            preparedStatement = connection.prepareStatement(registerStaffSQL);
            preparedStatement.setString(1, staff.getStaffName());
            preparedStatement.setString(2, staff.getStaffPassword());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean loginStaff(String staffName, String staffPassword){
        String loginStaffSQL = "SELECT * FROM staff WHERE staffName = ? AND staffPassword = ?";
        try {
            preparedStatement = connection.prepareStatement(loginStaffSQL);
            preparedStatement.setString(1, staffName);
            preparedStatement.setString(2, staffPassword);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
        public boolean staffLoginProcess(Scanner scanner) {
            while (true) {
                System.out.println("Enter staff name:");
                String staffName = scanner.nextLine();
                System.out.println("Enter staff password:");
                String staffPassword = scanner.nextLine();
                if (loginStaff(staffName, staffPassword)){
                    System.out.println("Login successful!");
                    return true;
                } else {
                    System.out.println("Wrong name or password!");
                    System.out.println("Do you want to try again or register as a new staff? Enter 1 to try again, 2 to register, or any other number to exit.");
                    int option = scanner.nextInt();
                    scanner.nextLine();  // Consume newline left-over
                    if (option == 2) {
                        // Register as staff
                        return registerStaff(new Staff(staffName, staffPassword));
                    } else if (option != 1) {
                        return false;
                    }
                }
            }
        }

}

