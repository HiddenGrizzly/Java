package controller;


import java.sql.SQLException;

public interface LibraryDAO {
    public void create() throws SQLException;
    public void  borrow() throws SQLException;
    public void findByAuthor() throws SQLException;
    public void display() throws SQLException;
    public void findById() throws SQLException;
    public void findByPublisher() throws SQLException;
}
