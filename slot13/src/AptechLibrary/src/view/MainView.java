package AptechLibrary.src.view;

public class MainView {
    public void showMenu() {
        System.out.println("Welcome to AptechLibrary! Please choose an option:");
        System.out.println("1. Staff login or register");
        System.out.println("2. Student login or register");
        System.out.println("3. Exit");
    }
    public void showStaffMenu() {
        System.out.println("Welcome, staff! Please choose an option:");
        System.out.println("1. View all books");
        System.out.println("2. Search book by id");
        System.out.println("3. Search book by name");
        System.out.println("4. Create ticket");
        System.out.println("5. Change book status");
        System.out.println("6. Logout");
    }
    public void showStudentMenu() {
        System.out.println("Welcome, student! Please choose an option:");
        System.out.println("1. View all books");
        System.out.println("2. Search book by id");
        System.out.println("3. Search book by name");
        System.out.println("4. View your ticket");
        System.out.println("5. Logout");
    }
}

