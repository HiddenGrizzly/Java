package JavaEnterpriseComponents.entity;

import java.sql.Date;

public class Sticket {
    private String id;
    private String nameTicket;
    private String student_id;
    private String book_id;
    private Date borrowDate;
    private Date returnDate;

    public Sticket() {
    }

    public Sticket(String id, String nameTicket, String student_id, String book_id, Date borrowDate, Date returnDate) {
        this.id = id;
        this.nameTicket = nameTicket;
        this.student_id = student_id;
        this.book_id = book_id;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public String getNameTicket() {
        return nameTicket;
    }

    public void setNameTicket(String nameTicket) {
        this.nameTicket = nameTicket;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Sticket{" +
                "id='" + id + '\'' +
                ", nameTicket='" + nameTicket + '\'' +
                ", student_id='" + student_id + '\'' +
                ", book_id='" + book_id + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}

