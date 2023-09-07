package Lap2.Ex1;

public class Entry {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(7, 3);
        rectangle.display();
        rectangle.setWidth(10);
        rectangle.setHeight(8);
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getParameter());
    }
}
