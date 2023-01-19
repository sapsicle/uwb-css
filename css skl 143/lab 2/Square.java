public class Square {
    private int xPos, yPos;
    private double sideLength;
    private String shape = "[]";

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

    public double getSideLength() {
        return this.sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getArea() {
        return this.sideLength * this.sideLength;
    }

    public Square() {

    }

    public Square(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    public Square(int x, int y, int sideLength) {
        this.xPos = x;
        this.yPos = y;
        this.sideLength = sideLength;
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
        if (!(o instanceof Square)) {
            return false;
        }
        Square square = (Square) o;
        return this.xPos == square.xPos && this.yPos == square.yPos && this.sideLength == square.sideLength && this.shape == square.shape;
    }
}
