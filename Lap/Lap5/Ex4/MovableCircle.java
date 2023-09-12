package Lap5.Ex4;

public class MovableCircle implements Movable {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int radius, MovablePoint center) {
        this.radius = radius;
        this.center = center;
    }

    @Override
    public void moveUp() {
        center.setY(center.getY() + center.getySpeed());
    }

    @Override
    public void moveDown() {
        center.setY(center.getY() - center.getySpeed());
    }

    @Override
    public void moveLeft() {
        center.setX(center.getX() - center.getxSpeed());
    }

    @Override
    public void moveRight() {
        center.setX(center.getX() + center.getxSpeed());
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }
}
