

import controller.Controller;
import view.LibraryConsole;

import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {

        LibraryConsole console=new LibraryConsole();
        Controller controller= new Controller();
        Scanner scanner=new Scanner(System.in);

        while (true){
            console.menu();
            System.out.println("Your choice: ");
            int ch=scanner.nextInt();
            scanner.nextLine();
            switch (ch){
                case 1:
                    System.out.println("new book");
                    controller.create();
                    break;
                case 2:
                    controller.find();
                    break;
                case 3:
                    controller.borrow();
                    break;
                case 4:
                    controller.display();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("wrong choice");
                }

            }

        }

}
