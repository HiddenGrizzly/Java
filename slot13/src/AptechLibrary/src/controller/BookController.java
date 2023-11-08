package AptechLibrary.src.controller;

import AptechLibrary.src.connection.GetConnection;
import AptechLibrary.src.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookController {
    private Connection connection = GetConnection.createConnection();
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    public boolean addBook(Book book){
        String addBookSQL = "INSERT INTO book (bookName, bookAuthor, bookStatus) VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(addBookSQL);
            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setString(2, book.getBookAuthor());
            preparedStatement.setBoolean(3, book.isBookStatus());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public String findBookById(int id) {
        String findBookByIdSQL = "SELECT * FROM book WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(findBookByIdSQL);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return "Book id: " + resultSet.getInt(1) + ". Book name: " + resultSet.getString(2) + ". Book Author: " + resultSet.getString(3) + ". Book Status: " + resultSet.getBoolean(4) + ".";
            }
            return "Can't find book with id " + id;
        } catch (SQLException e){
            e.printStackTrace();
            return "Error!";
        }
    }
    public String findBookByName(String name) {
        String findBookByNameSQL = "SELECT * FROM book WHERE name LIKE ?";
        try {
            preparedStatement = connection.prepareStatement(findBookByNameSQL);
            preparedStatement.setString(1, "%" + name + "%");  // Use "%" for wildcard search
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return "Book id: " + resultSet.getInt(1) + ". Book name: " + resultSet.getString(2) + ". Book Author: " + resultSet.getString(3) + ". Book Status: " + resultSet.getBoolean(4) + ".";
            }
            return "Can't find book with name " + name;
        } catch (SQLException e){
            e.printStackTrace();
            return "Error!";
        }
    }

    public String showAllBooks() {
        String showAllBooksSQL = "SELECT id FROM book";
        try {
            preparedStatement = connection.prepareStatement(showAllBooksSQL);
            resultSet = preparedStatement.executeQuery();
            StringBuilder allBooks = new StringBuilder();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String bookDetails = findBookById(id);
                allBooks.append(bookDetails).append("\n");
            }
            return allBooks.toString();
        } catch (SQLException e){
            e.printStackTrace();
            return "Error!";
        }
    }
    public boolean updateBookStatus(int id) {
        String updateBookStatusSQL = "UPDATE book SET bookStatus = NOT bookStatus WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(updateBookStatusSQL);
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
