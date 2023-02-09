import java.awt.*;
public class Pentagon extends Shape {
    
    //instance variables
    private int width;
    private Color shapeColor;

    // internal global variables, not static as will be different for different pentagons, but no getters as should not leave class
    private double apothem, sideLength, area, height /*redundant var height but makes syntax simpler*/;

    // constructor
    public Pentagon(int x, int y, int width, Color color) {
        super(x, y);
        this.width = width;
        this.shapeColor = color;
        this.height = this.width;
        this.area = this.getArea();                                                                                 // set global area, method will set other vars while running
    }

    /**
     * @return double representing shape area
     * general formula for Area = s^2 * sqrt(25 + 10sqrt5) / 4
     * where s is the side length
     * 
     * User defined width will determine dimensions of a square on which the pentagon will be drawn, height (H) will equal this width (shape will be slightly wider, however)
     * H = s * sqrt(5 + 2sqrt5) / 2 for reference where s is side length
     * by this we can derive side length from height, s = (2 * H) / sqrt(5 + 2sqrt5)
     * 
     * alternatively, A = p * a / 2 where p is the perimeter and p = 5 * s where s is side length, so A = 5 * s * a / 2
     * apothem (a) = 0.5 * s / tan(pi/5) where s is the side length
     * alt alt are formula is to divide the pentagon into 5 triangles, run b * h / 2 for each resulting triangle which is 5 * A_x
     * Base b is equal to side length and height h is the apothem, so by simplifying 5(bh/2) you still result in the above A_pent = 5sa/2
     */
    @Override
    public double getArea() {
        // user defined width is equal to pentagon height

        // determine side length
        double sideLength = (2.0 * height) / Math.sqrt(5.0 + (2.0 * Math.sqrt(5.0)));
        this.sideLength = sideLength;                                                                               // set global variable

        // possible to calculate area and return now
        // continuing with alternate method as it could prove useful to have the apothem calculation later
        // double area = Math.pow(sideLength, 2.0) * Math.sqrt(25.0 + (10 * Math.sqrt(5.0))) / 4;
        
        // determine apothem
        double apothem = (0.5 * sideLength) / Math.tan(Math.PI / 5.0);
        this.apothem = apothem;                                                                                     // set global variable

        //determine area
        double area = ((5.0 * sideLength) * apothem) / 2.0;
        this.area = area;                                                                                           // set global variable

        return area;
    }

    @Override
    public void draw(Graphics g) {
        int x = getX();                                                                                             // shape coords
        int y = getY();

        g.setColor(this.shapeColor);                                                                                // set color

        // all points must be in ints as graphics cannot use doubles 
        // meaning pentagon will not display the true calculated area
        // shouldn't be too much of a disparity
        
        // points (naming-wise) will start on the bottom left and move clockwise
        int p1y = y + (int)this.apothem;
        int p1x = x - (int)(this.sideLength / 2);

        // going clockwise, p5 is the last one and will be bottom right
        int p5y = y + (int)this.apothem;
        int p5x = x + (int)(this.sideLength / 2);

        // creating right triangles we can (using law of cosines and pythagorean),
        // find lengths a and b to find x and y offsets
        // use each point as a springboard for the next by offsetting coords
        double yOffset = this.sideLength * Math.sin((2.0 * Math.PI) / 5.0);
        double xOffset = Math.sqrt((this.sideLength * this.sideLength) - (yOffset * yOffset));
        int p2y = p1y - (int)yOffset;
        int p2x = p1x - (int)xOffset;

        // p4 would be second to last and the mirror of p2
        int p4y = p5y - (int)yOffset;
        int p4x = p5x + (int)xOffset;

        // topmost point p3 is inline with x coord of center
        // also at peak height which is width / 2 offset from center y coord
        int p3y = y - (this.width / 2);
        int p3x = x;

        int[] xCoords = {p1x, p2x, p3x, p4x, p5x};
        int[] yCoords = {p1y, p2y, p3y, p4y, p5y};

        g.drawPolygon(xCoords, yCoords, 5);                                                                         // pass points to draw closed polygon
    }

    // getters and setters
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
