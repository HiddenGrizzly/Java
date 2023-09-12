package Lap5.Ex1;

public class Triangle extends Shape{
    private double base;
    private double height;

    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public Triangle() {
    }

    @Override
    public double getArea() {
        return base*height/2;
    }

    @Override
    public String toString() {
        return "Triangle has base of " + base + " and height of " + height + " and area of " + getArea();
    }
}
