package slot11.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private int sold;

    public Product(String name, double price, int quantity, int sold) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sold = sold;
    }

    public Product() {
    }

    public Product(int id, String name, double price, int quantity, int sold) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sold = sold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
}
