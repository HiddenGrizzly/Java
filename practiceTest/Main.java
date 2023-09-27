package practiceTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        // Initialize products
        Product tomato = new Product("F523", "Tomato", "Food", 1.5, 589);
        Product zaraShirt = new Product("A763", "Zara shirt", "Appearance", 12.0, 90);
        Product kitchenTable = new Product("H320", "Kitchen table", "Household", 299.0, 13);
        Product iPhone = new Product("E092", "IPhone", "Electronic", 1000.0, 4);
        Product football = new Product("S108", "Football", "Sport", 19.9, 2);
        // Create a new Order for Mike Tyson
        LocalDateTime orderTime1 = LocalDateTime.parse("2023-08-08 11:30:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Order mikeTysonOrder = new Order("Mike Tyson", orderTime1);
        // Add products to Mike Tyson's order
        mikeTysonOrder.addProduct(tomato, 5);
        mikeTysonOrder.addProduct(iPhone, 2);
        mikeTysonOrder.addProduct(football, 4);
        // Print order information and total cost
        System.out.println("Mike Tyson's Order:");
        System.out.println(mikeTysonOrder);
        System.out.println("Total Cost: $" + mikeTysonOrder.cost());
        // Create a new Delivery Order for Chris Evans
        LocalDateTime orderTime2 = LocalDateTime.parse("2023-08-09 13:14:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        DeliveryOrder chrisEvansOrder = new DeliveryOrder("Chris Evans", orderTime2, "123 Cau Giay");
        // Add products to Chris Evans' delivery order
        chrisEvansOrder.addProduct(zaraShirt, 3);
        chrisEvansOrder.addProduct(iPhone, 3);
        // Print delivery order information
        System.out.println("\nChris Evans' Delivery Order:");
        System.out.println(chrisEvansOrder);
        System.out.println("Total Cost: $" + chrisEvansOrder.cost());
    }
}
