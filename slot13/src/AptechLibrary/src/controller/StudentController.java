package AptechLibrary.src.controller;

import AptechLibrary.src.connection.GetConnection;
import AptechLibrary.src.model.Staff;
import AptechLibrary.src.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentController {
    private Connection connection = GetConnection.createConnection();
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public boolean registerStudent(Student student){
        String registerStudentSQL = "INSERT INTO student (studentName, studentPassword) VALUES (?, ?)";
        try {
            preparedStatement = connection.prepareStatement(registerStudentSQL);
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setString(2, student.getStudentPassword());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean loginStudent(String studentName, String studentPassword){
        String loginStudentSQL = "SELECT * FROM student WHERE studentName = ? AND studentPassword = ?";
        try {
            preparedStatement = connection.prepareStatement(loginStudentSQL);
            preparedStatement.setString(1, studentName);
            preparedStatement.setString(2, studentPassword);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean studentLoginProcess(Scanner scanner) {
        while (true) {
            System.out.println("Enter student name:");
            String studentName = scanner.nextLine();
            System.out.println("Enter student password:");
            String studentPassword = scanner.nextLine();
            if (loginStudent(studentName, studentPassword)){
                System.out.println("Login successful!");
                return true;
            } else {
                System.out.println("Wrong name or password!");
                System.out.println("Do you want to try again or register as a new staff? Enter 1 to try again, 2 to register, or any other number to exit.");
                int option = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over
                if (option == 2) {
                    // Register as student
                    return registerStudent(new Student(studentName, studentPassword));
                } else if (option != 1) {
                    return false;
                }
            }
        }
    }
}

