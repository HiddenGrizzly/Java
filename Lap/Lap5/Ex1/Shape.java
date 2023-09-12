package Lap5.Ex1;

public abstract class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public Shape() {
    }

    public abstract double getArea();
    public abstract String toString();
}
