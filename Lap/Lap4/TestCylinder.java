package Lap4;

public class TestCylinder {
    public static void main(String[] args) {
        Circle circle = new Circle(10.5, "Red");
        Cylinder cylinder = new Cylinder(10.5, "Blue", 7.7);
        System.out.println(circle.toString());
        System.out.println(circle.getArea());
        System.out.println(cylinder.toString());
        System.out.println(cylinder.getArea());
        System.out.println(cylinder.getVolume());
    }
}
