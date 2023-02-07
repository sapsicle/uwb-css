import java.awt.Graphics;
import java.awt.Color;

/**
 * FivePointedStar
 * ---------------
 * This class is for a five pointed star centered at x and y.
 * The constructor takes in a width parameter so that the star can be any size. 
 * The width describes the width of a square that the star fits inside.
 * 
 * @author David Nixon
 * @version March 2021
 */
public class FivePointedStar extends Shape {
    // My star fits in a square whose width is defined here:
    private int width;
    private Color starColor;
    
    /**
     * constructors:
     * PRECONDITIONS:
     *      all parameters must be at least 0, and less than the width of the 
     *      enclosing JFrame
     */
    public FivePointedStar(int x, int y, int newWidth){
        super(x,y);
        this.width = newWidth;
        this.starColor = Color.RED;
        
    }
    
     public FivePointedStar(int x, int y, int newWidth, Color c){
        super(x,y);
        this.width = newWidth;
        this.starColor = c;
        
    }
    
    /**
     * getArea()
     * ---------
     * This returns a VERY ROUGH approximation of the area of my star
     * (basically, I'm imagining it takes up about half the space of the 
     * rectangle that would contain it.)
     */
    public double getArea(){ 
        return (this.width * this.width) / 2.0;
        
    }
    
    /**
     * draw()
     * ------
     * This method actually draws the star.
     */
    public void draw( Graphics g ){
        int x = getX();   // the center of the star is
        int y = getY();   // at these coordinates.
        
        // The next four ints define the coordinates of the square that the star fits inside.
        // Since x and y are at the center of the star, 
        // we can find the outside of square by going half the width from the x and y.
        int left = x - (this.width / 2);
        int right = x + (this.width / 2);
        int top = y - (this.width / 2);
        int bottom = y + (this.width / 2);
        
        // There are 5 points, p1, p2, p3, p4 and p5.  
        // Each has an x and y coordinate: p1x, p1y, p2x, p2y, etc.
        int p1x = left + (int)(.2 * (double)this.width) ;
        int p1y = top + (int)(.35 * (double)this.width) ;
        
        int p2x = right - (int)(.2 * (double)this.width) ;
        int p2y = top + (int)(.35 * (double)this.width) ;
        
        int p3x = left + (int)(.3 * (double)this.width) ;
        int p3y = bottom - (int)(.2 * (double)this.width) ;
        
        int p4x = x; // the top center point;
        int p4y = top + (int)(.2 * (double)this.width) ;
        
        int p5x = right - (int)(.3 * (double)this.width) ;
        int p5y = bottom - (int)(.2 * (double)this.width) ;
        
        // now set the color and draw all the lines:
        g.setColor(this.starColor);
        g.drawLine(p1x, p1y, p2x, p2y);
        g.drawLine(p2x, p2y, p3x, p3y);
        g.drawLine(p3x, p3y, p4x, p4y);
        g.drawLine(p4x, p4y, p5x, p5y);
        g.drawLine(p5x, p5y, p1x, p1y);
    }
    
    //
    // Getters and Setters: 
    // ---------------------
    
    /**
     * setColor()
     * ----------
     * This sets the color using a Color object from the java.awt.Color class
     */
    public void setColor(Color c){ this.starColor = c; }
    
    /**
     * getColor()
     * ----------
     * This returns the color of the star as a Color object from the java.awt.Color class
     */
    public Color getColor(){ return this.starColor;  }
    
    /**
     * setWidth()
     * ----------
     * This sets the rough width of the star; the star fits inside a square whose width is w.
     * PRECONDITION: w should be smaller than the width of the JFrame that the star is to be drawn inside
     *               or else it might not be visible.
     *               w needs also to be greater than 0.
     */
    public void setWidth(int w){ this.width = w; }
    
    /**
     * getWidth()
     * ----------
     * This returns the width of the square that the star fits inside.
     */
    public int getWidth(){ return this.width; }
    
    
}
