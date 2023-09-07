package Lap2.Ex1;

public class Rectangle {
    private int width;
    private int height;
    public Rectangle() {

    }
    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }
    public  void display() {
        for (int i = 1; i <= height; i++){
            for (int j = 1; j <= width; j++){
                System.out.print("#");
            }
            System.out.println(" ");
        }
    }
    public int getArea(){
        return width*height;
    }
    public int getParameter(){
        return 2*(width+height);
    }
    public void setHeight(int h){
        this.height = h;
    }
    public int getHeight(){
        return this.height;
    }
    public void  setWidth(int w){
        this.width = w;
    }
    public int getWidth(){
        return this.width;
    }
}
