package practiceTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private String customerName;
    private LocalDateTime transactionTime;
    private ArrayList<LineItem> lineItems = new ArrayList<>();

    public Order(String customerName, LocalDateTime transactionTime, ArrayList<LineItem> lineItems) {
        this.customerName = customerName;
        this.transactionTime = transactionTime;
        this.lineItems = lineItems;
    }

    public Order(String customerName, LocalDateTime transactionTime) {
        this.customerName = customerName;
        this.transactionTime = transactionTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Details:\n");
        sb.append(String.format("%-20s %-20s %-10s %-10s\n", "Product", "Category", "Quantity", "Cost"));
        sb.append("--------------------------------------------------------------\n");
        for (LineItem item : lineItems) {
            sb.append(String.format("%-20s %-20s %-10d $%.2f\n", item.getProduct().getName(),
                    item.getProduct().getCategory(), item.getQuantity(), item.cost()));
        }
        sb.append("--------------------------------------------------------------\n");
        sb.append(String.format("%-40s Total Cost: $%.2f\n", " ", cost()));
        return sb.toString();
    }
    public double cost(){
        double totalCost=0;
        for (LineItem lineItem : lineItems) {
            totalCost += (double) lineItem.cost();
        }
        return totalCost;
    }
    public void addProduct(Product product, int quantity) {
        if (quantity<= product.getQuantity()){
            LineItem lineItem = new LineItem(product, quantity);
            lineItems.add(lineItem);
            product.setQuantity(product.getQuantity() - quantity);
            System.out.println("Add product " + product.getName() + " success.");
        } else {
            System.out.println("Add product " + product.getName() + " fail.");
        }
    }
}
