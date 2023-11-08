package AptechLibrary.src.model;

import java.util.Date;

public class Ticket {
    private int ticketId;
    private int staffId;
    private int studentId;
    private int bookId;
    private Date createDay;
    private Date resolveDay;
    private Date borrowDay;
    private Date returnDay;

    public Ticket(int staffId, int studentId, int bookId, Date createDay, Date resolveDay, Date borrowDay, Date returnDay) {
        this.staffId = staffId;
        this.studentId = studentId;
        this.bookId = bookId;
        this.createDay = createDay;
        this.resolveDay = resolveDay;
        this.borrowDay = borrowDay;
        this.returnDay = returnDay;
    }

    public Ticket(int staffId, int studentId, int bookId, Date createDay, Date borrowDay) {
        this.staffId = staffId;
        this.studentId = studentId;
        this.bookId = bookId;
        this.createDay = createDay;
        this.borrowDay = borrowDay;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getCreateDay() {
        return createDay;
    }

    public void setCreateDay(Date createDay) {
        this.createDay = createDay;
    }

    public Date getResolveDay() {
        return resolveDay;
    }

    public void setResolveDay(Date resolveDay) {
        this.resolveDay = resolveDay;
    }

    public Date getBorrowDay() {
        return borrowDay;
    }

    public void setBorrowDay(Date borrowDay) {
        this.borrowDay = borrowDay;
    }

    public Date getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(Date returnDay) {
        this.returnDay = returnDay;
    }
}
