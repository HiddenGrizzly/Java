package AptechLibrary.src.model;

public class Book {
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private boolean bookStatus;

    public Book(String bookName, String bookAuthor, boolean bookStatus) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }
}
