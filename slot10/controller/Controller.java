package controller;

import model.Book;
import model.Student;
import repository.BookRepo;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Controller implements LibraryDAO {
    BookRepo bookRepo = new BookRepo();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void create() throws SQLException {
        System.out.println("Input book's name:");
        String name = scanner.nextLine();
        System.out.println("Input book's author:");
        String author = scanner.nextLine();
        System.out.println("date import:");
        String date = scanner.nextLine();
        System.out.println("Input book's price:");
        Double d = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Input book's publisher:");
        String pub = scanner.nextLine();

        Book book = new Book();
        book.setAuthor(author);
        book.setName(name);
        book.setImportDate(date);
        book.setPrice(d);
        book.setPublisher(pub);
        book.setStatus(true);
        int re = bookRepo.create(book);
        if (re == 1) System.out.println("ss");
        else throw new SQLException();
    }

    @Override
    public void borrow() throws SQLException {
        System.out.println("Input book's id:");
        int bid = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Input student's id:");
        int sid = scanner.nextInt();
        scanner.nextLine();
        bookRepo.borrow(sid, bid);
        Book book = bookRepo.findById(bid);
        book.setStatus(false);
        int re = bookRepo.update(book);
        if (re == 1) System.out.println("ss");
        else throw new SQLException();
    }

    @Override
    public void findByAuthor() throws SQLException {
        System.out.println("input author's name");
        String au = scanner.nextLine();
        List<Book> book = bookRepo.findByAuthor(au);
        if (book.size() == 0) System.out.println("not found");
        else System.out.println(book);
    }


    @Override
    public void display() throws SQLException {
        List<Student> students = bookRepo.show();
        System.out.println(students);
    }

    @Override
    public void findById() throws SQLException {
        System.out.println("input book's id");
        int id = scanner.nextInt();
        Book book = bookRepo.findById(id);
        if (book == null) System.out.println("not found");
        else System.out.println(book);
    }

    @Override
    public void findByPublisher() throws SQLException {
        System.out.println("input publisher's name");
        String pub = scanner.nextLine();
        List<Book> book = bookRepo.findByPublisher(pub);
        if (book.size() == 0) System.out.println("not found");
        else System.out.println(book);
    }

    public void find() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Boolean flag = false;
        while (!flag) {
            System.out.println("1. find by author");
            System.out.println("2. find by publisher");
            System.out.println("3. Back");
            System.out.println("Your choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine();
            switch (ch) {
                case 1:
                    findByAuthor();
                    break;
                case 2:
                    findByPublisher();
                    break;
                case 3:
                    flag=true;
                    break;
            }
        }
    }
}
