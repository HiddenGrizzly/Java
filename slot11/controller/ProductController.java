package slot11.controller;

import slot11.connection.ConnectionDAO;
import slot11.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductController implements ProductDAO {
    Connection connection = ConnectionDAO.createConnection();
    PreparedStatement prep = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);
    @Override
    public void addProduct() {
        System.out.println("Enter product name: ");
        String name = sc.nextLine();
        System.out.println("Enter product price: ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter product quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter product sold: ");
        int sold = sc.nextInt();
        sc.nextLine();
        try {
            prep = connection.prepareStatement("INSERT INTO product (name, price, quantity, sold) VALUES (?, ?, ?, ?)");
            prep.setString(1, name);
            prep.setDouble(2, price);
            prep.setInt(3, quantity);
            prep.setInt(4, sold);
            int rowAdd = prep.executeUpdate();
            if (rowAdd>0){
                System.out.println("Add product success.");
            } else {
                System.out.println("Add product fail.");
            }
        } catch (SQLException e) {
            System.out.println("Error in add product!");
        }
    }

    @Override
    public void searchProduct() {
        System.out.println("Enter product name:");
        String name = sc.nextLine();
        List<Product> products = new ArrayList<>();
        try {
            prep = connection.prepareStatement("SELECT * FROM product WHERE name LIKE ?");
            prep.setString(1, "%" + name + "%");
            rs = prep.executeQuery();
            while (rs.next()) {
                System.out.println("Id " + rs.getInt("id") + ", name " + rs.getString("name") + ", price " + rs.getDouble("price") + ", quantity " + rs.getInt("quantity") + ", sold " + rs.getInt("sold"));
            }
        } catch (SQLException e) {
            System.out.println("Error in search product!");
        }
    }

    @Override
    public void deleteProduct() {
        System.out.println("Enter product name:");
        String name = sc.nextLine();
        try {
            prep = connection.prepareStatement("DELETE FROM product WHERE name = ?");
            prep.setString(1, name);
            int rowDelete = prep.executeUpdate();
            if (rowDelete>0){
                System.out.println("Delete complete.");
            } else {
                System.out.println("Delete fail.");
            }
        } catch (SQLException e) {
            System.out.println("Error at delete product!");
        }
    }

    @Override
    public void showAllProduct() {
        try {
            prep = connection.prepareStatement("SELECT * FROM product");
            rs = prep.executeQuery();
            while (rs.next()){
                System.out.println("Id " + rs.getInt("id") + ", name " + rs.getString("name") + ", price " + rs.getDouble("price") + ", quantity " + rs.getInt("quantity") + ", sold " + rs.getInt("sold"));
            }
        } catch (SQLException e) {
            System.out.println("Error!");
        }
    }

    @Override
    public void soldAllProduct() {
        try {
            prep = connection.prepareStatement("SELECT * FROM product WHERE quantity = 0");
            rs = prep.executeQuery();
            while (rs.next()){
                System.out.println("Id " + rs.getInt("id") + ", name " + rs.getString("name") + ", price " + rs.getDouble("price") + ", quantity " + rs.getInt("quantity") + ", sold " + rs.getInt("sold"));
            }
        } catch (SQLException e) {
            System.out.println("Error!");
        }
    }

    @Override
    public void bestSellProduct() {
        try {
            prep = connection.prepareStatement("SELECT * FROM product ORDER BY sold DESC");
            rs = prep.executeQuery();
            while (rs.next()){
                System.out.println("Id " + rs.getInt("id") + ", name " + rs.getString("name") + ", price " + rs.getDouble("price") + ", quantity " + rs.getInt("quantity") + ", sold " + rs.getInt("sold"));
            }
        } catch (SQLException e) {
            System.out.println("Error!");
        }
    }
}
