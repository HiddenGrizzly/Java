package AptechLibrary.src.controller;

import AptechLibrary.src.connection.GetConnection;

import java.sql.*;
import java.util.Calendar;

public class TicketController {
    private Connection connection = GetConnection.createConnection();
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public String displayTicket(int ticketId) {
        String displayTicketSQL = "SELECT * FROM ticket WHERE ticketId = ?";
        try {
            preparedStatement = connection.prepareStatement(displayTicketSQL);
            preparedStatement.setInt(1, ticketId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return "Ticket id: " + resultSet.getInt(1) + ". Staff id: " + resultSet.getInt(2) + ". Student id: " + resultSet.getInt(3) + ". Book id: " + resultSet.getInt(4) + ". Create day: " + resultSet.getDate(5) + ". Resolve day: " + resultSet.getDate(6) + ". Borrow day: " + resultSet.getDate(7) + ". Return day: " + resultSet.getDate(8) + ".";
            }
            return "Can't find ticket with id " + ticketId;
        } catch (SQLException e){
            e.printStackTrace();
            return "Error!";
        }
    }
    public String displayAllTicketsForStudent(int studentId) {
        String displayAllTicketsSQL = "SELECT ticketId FROM ticket WHERE studentId = ?";
        try {
            preparedStatement = connection.prepareStatement(displayAllTicketsSQL);
            preparedStatement.setInt(1, studentId);
            resultSet = preparedStatement.executeQuery();
            StringBuilder allTickets = new StringBuilder();
            while (resultSet.next()){
                int ticketId = resultSet.getInt(1);
                String ticketDetails = displayTicket(ticketId);
                allTickets.append(ticketDetails).append("\n");
            }
            return allTickets.toString();
        } catch (SQLException e){
            e.printStackTrace();
            return "Error!";
        }
    }
    public boolean createNewTicket(int staffId, int studentId, int bookId) {
        String createNewTicketSQL = "INSERT INTO ticket (staffId, studentId, bookId, createDay, resolveDay, borrowDay, returnDay) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(createNewTicketSQL);
            preparedStatement.setInt(1, staffId);
            preparedStatement.setInt(2, studentId);
            preparedStatement.setInt(3, bookId);

            // Current date
            Date currentDate = new Date(System.currentTimeMillis());
            preparedStatement.setDate(4, currentDate);
            preparedStatement.setDate(6, currentDate);

            // 30 days after borrow
            Calendar cal = Calendar.getInstance();
            cal.setTime(currentDate);
            cal.add(Calendar.DATE, 30);
            Date returnDate = new Date(cal.getTimeInMillis());
            preparedStatement.setDate(7, returnDate);

            // 31 days after borrow
            cal.add(Calendar.DATE, 1);
            Date resolveDate = new Date(cal.getTimeInMillis());
            preparedStatement.setDate(5, resolveDate);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}

