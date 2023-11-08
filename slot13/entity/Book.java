package JavaEnterpriseComponents.entity;

public class Book {
    private String id;
    private String title;
    private String author;
    private String catalogy;
    private double price;
    private boolean status;

    public Book() {
    }

    public Book(String id, String title, String author, String catalogy, double price, boolean status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.catalogy = catalogy;
        this.price = price;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCatalogy() {
        return catalogy;
    }

    public void setCatalogy(String catalogy) {
        this.catalogy = catalogy;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", catalogy='" + catalogy + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
