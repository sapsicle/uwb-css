public class Circle {
    private int xPos, yPos;
    private double radius;
    private String shape = "O";

    public int getXPos() {
        return this.xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return this.yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    public Circle() {

    }

    public Circle(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    public Circle(int x, int y, int radius) {
        this.xPos = x;
        this.yPos = y;
        this.radius = radius;
    }

    public void draw() {
        System.out.println(this.shape);
    }

    @Override
    public String toString() {
        return this.shape;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Circle)) {
            return false;
        }
        Circle circle = (Circle) o;
        return this.xPos == circle.xPos && this.yPos == circle.yPos && this.radius == circle.radius && this.shape == circle.shape;
    }
}
