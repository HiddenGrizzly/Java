import AptechLibrary.src.connection.GetConnection;
import AptechLibrary.src.controller.BookController;
import AptechLibrary.src.controller.StaffController;
import AptechLibrary.src.controller.StudentController;
import AptechLibrary.src.controller.TicketController;
import AptechLibrary.src.view.MainView;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainView mainView = new MainView();
        StaffController staffController = new StaffController();
        StudentController studentController = new StudentController();
        BookController bookController = new BookController();
        TicketController ticketController = new TicketController();
        Scanner scanner = new Scanner(System.in);
        Connection connection = GetConnection.createConnection();
        boolean flag = true;
        while (flag) {
            mainView.showMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    // Staff login or register
                    staffController.staffLoginProcess(scanner);
                    boolean flagStaff = true;
                    while (flagStaff){
                        mainView.showStaffMenu();
                        System.out.print("Enter your choice: ");
                        int choiceStaff = scanner.nextInt();
                        scanner.nextLine();  // Consume newline left-over
                        switch (choiceStaff){
                            case 1:
                                System.out.println(bookController.showAllBooks());
                                break;
                            case 2:
                                System.out.println("Enter book id: ");
                                int id = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println(bookController.findBookById(id));
                                break;
                            case 3:
                                System.out.println("Enter book name: ");
                                String name = scanner.nextLine();
                                System.out.println(bookController.findBookByName(name));
                                break;
                            case 4:
                                System.out.println("Enter staff id: ");
                                int stafftId = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Enter student id: ");
                                int studentId = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Enter book id: ");
                                int bookId = scanner.nextInt();
                                scanner.nextLine();
                                if (ticketController.createNewTicket(stafftId, studentId, bookId)){
                                    System.out.println("Ticket create success.");
                                } else {
                                    System.out.println("Ticket create fail.");
                                }
                                break;
                            case 5:
                                System.out.println("Enter book id: ");
                                int bookStatusId = scanner.nextInt();
                                scanner.nextLine();
                                if(bookController.updateBookStatus(bookStatusId)){
                                    System.out.println("Book status updated!");
                                } else {
                                    System.out.println("Book status update fail!");
                                }
                                break;
                            case 6:
                                System.out.println("Logout!");
                                flagStaff = false;
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }
                    }
                    break;
                case 2:
                    // Student login or register
                    studentController.studentLoginProcess(scanner);
                    boolean flagStudent = true;
                    while (flagStudent){
                        mainView.showStudentMenu();
                        System.out.print("Enter your choice: ");
                        int choiceStudent = scanner.nextInt();
                        scanner.nextLine();  // Consume newline left-over
                        switch (choiceStudent){
                            case 1:
                                System.out.println(bookController.showAllBooks());
                                break;
                            case 2:
                                System.out.println("Enter book id: ");
                                int id = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println(bookController.findBookById(id));
                                break;
                            case 3:
                                System.out.println("Enter book name: ");
                                String name = scanner.nextLine();
                                System.out.println(bookController.findBookByName(name));
                                break;
                            case 4:
                                System.out.println("Enter your id: ");
                                int yourId = scanner.nextInt();
                                scanner.nextLine();
                                ticketController.displayAllTicketsForStudent(yourId);
                            case 5:
                                System.out.println("Logout!");
                                flagStudent = false;
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    flag = false;
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

