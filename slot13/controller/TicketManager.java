package JavaEnterpriseComponents.controller;

import JavaEnterpriseComponents.entity.Book;
import JavaEnterpriseComponents.entity.Sticket;
import JavaEnterpriseComponents.model.BookDAO;
import JavaEnterpriseComponents.model.SticketDAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class TicketManager {

    public static void displayAllBook() throws SQLException{
        ArrayList<Book> books = BookDAO.getInstance().selectAll();
        for (Book book: books
             ) {
            System.out.println(book.toString());
        }
    }

    public static void findBookById() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the book id you want to find: ");
        String id = scanner.nextLine();
        Book book = BookDAO.getInstance().selectById(id);
        if (book!=null) {
            System.out.println(book.toString());
        } else {
            System.out.println("Book id not found");
        }
    }

    public static void findBookByName() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the book name you want to find: ");
        String title = sc.nextLine();
        Book book = BookDAO.getInstance().selectByName(title);

        if (book!=null) {
            System.out.println(book.toString());
        } else {
            System.out.println("Book id not found");
        }
    }

    public static void displayDetailBook() throws SQLException {
        ArrayList<Sticket> stickets = SticketDAO.getInstance().selectAll();
        for (Sticket sticket: stickets
             ) {
            System.out.println(sticket.toString());
        }
    }

    public static void studentBorrowBook() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sticket id: "); String sticket_id = sc.nextLine();
        System.out.println("Enter name Ticket: "); String nameTicket = sc.nextLine();
        System.out.println("Enter student id: "); String student_id = sc.nextLine();
        System.out.println("Enter book id: "); String book_id = sc.nextLine();
        System.out.println("Enter borrow date: "); String borrowDate = sc.nextLine();
        System.out.println("Enter return date: "); String returnDate = sc.nextLine();

        Sticket sticket = new Sticket(sticket_id, nameTicket, student_id, book_id, Date.valueOf(borrowDate), Date.valueOf(returnDate));

        SticketDAO.getInstance().insert(sticket);
        Book book = new Book();
        book.setId(book_id);
        book.setStatus(false);
        BookDAO.getInstance().updateStatus(book);
        System.out.println("Successfully borrow book !!!");
    }

    public static void studentReturnBook() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter book id: "); String book_id = sc.nextLine();
        Book book = new Book();
        book.setId(book_id);
        book.setStatus(true);
        BookDAO.getInstance().updateStatus(book);
        System.out.println("Successfully return book !!!");
    }

    public static void displayDetailBookId() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter book id: "); String book_id = sc.nextLine();
        Sticket sticket = SticketDAO.getInstance().selectByBookId(book_id);
        if (sticket!=null) {
            System.out.println(sticket.toString());
        } else {
            System.out.println("Not found");
        }

    }

}
