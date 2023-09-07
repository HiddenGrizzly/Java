package Test8;

import java.util.Scanner;

public class Student {
    private String name;
    private int age;
    public Student(){

    }
    public void getInformation(){
        Scanner sc = new Scanner(System.in);
        this.name = sc.next();
        this.age = sc.nextInt();
    }
    public void display(){

    }
}
