package Lap4;

public class Cylinder extends Circle{
    private double height;

    public Cylinder() {}

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        return 3.14*getRadius()*getRadius()*height;
    }

    @Override
    public double getArea(){
        return (3.14*getRadius()*getRadius())*2 + 2*3.14*height;
    }

    @Override
    public String toString(){
        return ("Radius: " + getRadius() + ". Color: " + getColor() + ". Height: " + height);
    }
}
