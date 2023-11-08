package slot12.view;

import slot12.entity.Admin;
import slot12.entity.Employee;
import slot12.model.LoginAdmin;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    LoginAdmin loginAdmin = new LoginAdmin();
    Scanner sc = new Scanner(System.in);
    public void mainMenu(){
        boolean flag = true;
        while (flag){
            System.out.println("Please login to continue!");
            System.out.println("Enter username: ");
            String adminName = sc.nextLine();
            System.out.println("Enter password: ");
            String adminPassword = sc.nextLine();
            Admin admin = new Admin(adminName, adminPassword);
            if (loginAdmin.checkLoginAdmin(admin)){
                System.out.println("Login sucess!");
                adminMenu();
                flag = false;
            } else{
                System.out.println("Login fail!");
            }
        }
    }
    public void adminMenu(){
        boolean adminFlag = true;
        while (adminFlag){
            System.out.println("1. Add employee");
            System.out.println("2. Update employee");
            System.out.println("3. Delete employee");
            System.out.println("4. Search by name");
            System.out.println("5. Search by id");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter first name: ");
                    String firstName = sc.nextLine();
                    System.out.println("Enter last name: ");
                    String lastName = sc.nextLine();
                    System.out.println("Enter salary: ");
                    double salary = sc.nextDouble();
                    Employee em = new Employee(firstName, lastName, salary);
                    loginAdmin.addEmployee(em);
                    break;
                case 2:
                    System.out.println("Enter id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter first name: ");
                    String firstNameUp = sc.nextLine();
                    System.out.println("Enter last name: ");
                    String lastNameUp = sc.nextLine();
                    System.out.println("Enter salary: ");
                    double salaryUp = sc.nextDouble();
                    loginAdmin.updateEmployee(id, firstNameUp, lastNameUp, salaryUp);
                    break;
                case 3:
                    System.out.println("Enter id: ");
                    int idDelete = sc.nextInt();
                    sc.nextLine();
                    loginAdmin.deleteEmployee(idDelete);
                    break;
                case 4:
                    System.out.println("Enter first name: ");
                    String firstNameSearch = sc.nextLine();
                    List<Employee> employees = loginAdmin.searchEmployee(firstNameSearch);
                    loginAdmin.printEmployees(employees);
                    break;
                case 5:
                    System.out.println("Enter id: ");
                    int idSearch = sc.nextInt();
                    List<Employee> employeess = loginAdmin.searchEmployee(idSearch);
                    loginAdmin.printEmployees(employeess);
                    break;
                case 6:
                    System.out.println("Exit.");
                    adminFlag = false;
                    break;
                default:
                    System.out.println("Wrong choice!");
                    break;
            }
        }
    }
}
