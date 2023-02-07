import java.awt.*;
public class Rectangle extends Shape {
    
    private int width, height;
    private Color shapeColor;

    // constructor
    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.shapeColor = color;
    }

    /**
     * @return double representing shape area
     * Area = base * height
     */
    @Override
    public double getArea() {
        return this.width * this.height;
    }

    /**
     * Draws shape to screen for each update
     */
    @Override
    public void draw(Graphics g) {
        int x = getX();                                                                                             // x coord
        int y = getY();                                                                                             // y coord

        g.setColor(this.shapeColor);                                                                                // set color
        g.drawRect(x, y, this.width, this.height);                                                                  // pass position and dimension to draw
    }

    // getters & setters

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getShapeColor() {
        return this.shapeColor;
    }

    public void setShapeColor(Color shapeColor) {
        this.shapeColor = shapeColor;
    }
}