package JavaEnterpriseComponents.view;

import JavaEnterpriseComponents.controller.TicketManager;
import JavaEnterpriseComponents.model.BookDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class BookConsole {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean flag = true;

        do {
            System.out.println("\n\t *** Welcome to Aptech Library *** \t");
            System.out.println("1. Display All books in the library");
            System.out.println("2. Find by book id");
            System.out.println("3. Find by book name");
            System.out.println("4. Stuendt borrow book");
            System.out.println("5. Stuendt return book");
            System.out.println("6. Display All details books");
            System.out.println("7. Display details by id books");
            System.out.println("8. Exit");
            System.out.println("--------------------------------------------");
            System.out.println("Please enter your selection: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    TicketManager.displayAllBook();
                    break;
                case 2:
                    TicketManager.findBookById();
                    break;
                case 3:
                    TicketManager.findBookByName();
                    break;
                case 4:
                    TicketManager.studentBorrowBook();
                    break;
                case 5:
                    TicketManager.studentReturnBook();
                    break;
                case 6:
                    TicketManager.displayDetailBook();
                    break;
                case 7:
                    TicketManager.displayDetailBookId();
                    break;
                case 8:
                    System.out.println("Exit...");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid selection");
                    System.out.println("Please choose again");
                    break;

            }
        } while (flag);



    }
}
