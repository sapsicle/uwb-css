import java.awt.*;
public class Circle extends Shape {
    
    private int width;
    private Color shapeColor;
    
    // constructor
    public Circle(int x, int y, int newWidth, Color color) {
        super(x, y);
        this.width = newWidth;
        this.shapeColor = color;
    }

    /**
     * @return double representing shape area
     * Area = pi * radius^2
     * radius = width (diameter) / 2
     */
    @Override
    public double getArea() {
        return Math.PI * Math.pow((width / 2), 2);
    }

    /**
     * Draws shape to screen for each update
     */
    @Override
    public void draw(Graphics g) {
        int x = getX();                                                                                             // x coord
        int y = getY();                                                                                             // y coord

        g.setColor(this.shapeColor);                                                                                // set color
        g.drawOval(x, y, this.width, this.width);                                                                   // send position and dimension to drawOval
    }

    // getters & setters

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getShapeColor() {
        return this.shapeColor;
    }

    public void setShapeColor(Color shapeColor) {
        this.shapeColor = shapeColor;
    }
}