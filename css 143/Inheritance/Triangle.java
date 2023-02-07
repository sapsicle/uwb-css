import java.awt.*;
public class Triangle extends Shape {
    
    private int width;
    private Color shapeColor;
    
    // constructor
    public Triangle(int x, int y, int width, Color color) {
        super(x, y);
        this.width = width;
        this.shapeColor = color;
    }

    /**
     * @return double representing shape area
     * Area = (base * height) / 2
     * Triangle dimensions will have base and height equal for ease
     */
    @Override
    public double getArea() {
        return (this.width * this.width) / 2;
    }

    /**
     * Draws shape to screen for each update
     */
    @Override
    public void draw(Graphics g) {
        int x = getX();                                                                                             // x coord
        int y = getY();                                                                                             // y coord

        int topX = x;                                                                                               // set topmost point for triangle
        int topY = y - (this.width / 2);
        
        int leftX = x - (this.width / 2);                                                                           // bottom left point
        int leftY = y + (this.width / 2);
        
        int rightX = x + (this.width / 2);                                                                          // bottom right point
        int rightY = y + (this.width / 2);
        
        int[] xPoints = {topX, leftX, rightX};                                                                      // store x and y points in arrays to send to draw method
        int[] yPoints = {topY, leftY, rightY};
        
        g.setColor(this.shapeColor);                                                                                // set color
        g.drawPolygon(xPoints, yPoints, 3);                                                                         // send point arrays to drawPolygon so it'll draw the polygon for us
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
