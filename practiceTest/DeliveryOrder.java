package practiceTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DeliveryOrder extends Order {
    private String address;

    public DeliveryOrder(String customerName, LocalDateTime transactionTime, ArrayList<LineItem> lineItems, String address) {
        super(customerName, transactionTime, lineItems);
        this.address = address;
    }

    public DeliveryOrder(String customerName, LocalDateTime transactionTime, String address) {
        super(customerName, transactionTime);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Details:\n");
        sb.append(String.format("%-20s %-20s %-10s %-10s\n", "Product", "Category", "Quantity", "Cost"));
        sb.append("--------------------------------------------------------------\n");
        for (LineItem item : getLineItems()) {
            sb.append(String.format("%-20s %-20s %-10d $%.2f\n", item.getProduct().getName(),
                    item.getProduct().getCategory(), item.getQuantity(), item.cost()));
        }
        sb.append("--------------------------------------------------------------\n");
        sb.append(String.format("%-40s Total Cost: $%.2f\n", " ", cost()));
        return sb.toString();
    }
}
