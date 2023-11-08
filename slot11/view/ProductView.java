package slot11.view;

import slot11.controller.ProductController;
import slot11.model.Product;

import java.util.Scanner;

public class ProductView {
    public void menu(){
        ProductController pc = new ProductController();
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("Choosen one!");
            System.out.println("1. Add product");
            System.out.println("2. Search product by name");
            System.out.println("3. Delete product by name");
            System.out.println("4. Show all products");
            System.out.println("5. Show all sold out products");
            System.out.println("6. Show best seller products");
            System.out.println("7. Teminator!");
            int choose = scan.nextInt();
            switch (choose){
                case 1:
                    pc.addProduct();
                    break;
                case 2:
                    pc.searchProduct();
                    break;
                case 3:
                    pc.deleteProduct();
                    break;
                case 4:
                    pc.showAllProduct();
                    break;
                case 5:
                    pc.soldAllProduct();
                    break;
                case 6:
                    pc.bestSellProduct();
                    break;
                case 7:
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong choice!");
                    break;
            }
        }
    }
}
