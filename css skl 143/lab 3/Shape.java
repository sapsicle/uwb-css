import java.awt.Color;
public class Shape {
    /* invariants
     * x must be non-negative
     * y must be non-negative
     * shape must have an area
     * shape must have a color?
     */

    private int x, y;
    Color color;

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Shape() {
        this.x = 0;
        this.y = 0;
    }

    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;                                                                     // color has no copy constructor
    }

    public Shape(Shape other) {
        this.x = other.x;
        this.y = other.y;
        this.color = other.color;                                                               // color has no copy constructor
    }

    @Override
    public String toString() {
        return "Shape is located at (" + this.x + ", " + this.y + ") with a color of " + this.color + " and an area of " + this.getArea();
    }

    public double getArea() {
        return -1;
    }

    // Graphics cannot be resolved to type
    // Commenting out so program may compile
    // public void draw(Graphics g) {

    // }
}