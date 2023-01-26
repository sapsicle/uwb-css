import java.awt.Color;
import java.awt.Dimension;

/*
 * Lab2 Driver:   ClassDesignIIDriver.java
 * Author: Rob Nash
 * 
 * Purpose: This is a test file to be included in the same (working) directory as your 
 * new class definitions.  Once you define a class (say, the Date class), uncomment the driver code
 * associated with that class to test it.  Match your output with the provided output, and pay 
 * particular attention to each new technique as we make use of it (Overloading, Constructors, Copy 
 * Constructors, Access Modifiers, Class Invariants, etc.)
 * 
 */


public class ClassDesignIIDriver {
    private int foo = -1;  //used in one of the mutator functions below
    
    
    public static void main(String[] args) {
        //uncomment the desired Driver or Demo below and run this code to test your progress
        dateDriver();
        System.out.println();                                                                               // line space to separate tests
        shapeDriver();
        System.out.println();                                                                               // line space to separate tests
        charListDriver();
        System.out.println();                                                                               // line space to separate tests
        lineSegmentDriver();
        System.out.println();                                                                               // line space to separate tests
        immutableFractionDriver();
        System.out.println();                                                                               // line space to separate tests
        math2Driver();
        System.out.println();                                                                               // line space to separate tests
        passByReferenceDemo();
    }
    
    
    public static void dateDriver() {
        Date a = new Date();
        Date b = new Date(1,2,2030);
        Date c = new Date(b);
        
        
        System.out.println("a is: " + a.toString());
        System.out.println("b is: " + b.toString());
        System.out.println("c is: " + c.toString());
        
        a.setDate(5,5,2010);
        
        
        System.out.println("B and A are equal: " + b.equals(a));
        System.out.println("B and C are equal: " + b.equals(c));
        
    }

    private static void shapeDriver() {
        // System.out.println("uncomment the code to use the shapeDriver");
        Shape a = new Shape();
        Shape b = new Shape(10, 10, Color.DARK_GRAY);
        Shape c = new Shape(b);
        
        a.setX(120);
        b.setY(140);
        
        System.out.println("a: " + a.toString());
        System.out.println("b: " + b.toString());
        System.out.println("c: " + c.toString());
    }
    
    private static void charListDriver() {
        // System.out.println("uncomment the code to use the charListDriver");
        CharList a = new CharList();
        CharList b = new CharList("Batman");
        CharList c = new CharList(b);
        
        a.add('k');
        a.add('a');
        a.add('t');
        a.add('n');
        a.add('i');
        a.add('s');
        
        System.out.println("a is: " + a.toString() +" and has " + a.size() + " chars");
        System.out.println("b is: " + b.toString() +" and has " + b.size() + " chars");
        System.out.println("c is: " + c.toString() +" and has " + c.size() + " chars");
    
        
        
        System.out.println("B and A are equal: " + b.equals(a));
        System.out.println("B and C are equal: " + b.equals(c));
    }
    
    public static void lineSegmentDriver() {
        // System.out.println("uncomment the code to use the lineSegmentDriver");
        LineSegment a = new LineSegment();
        LineSegment b = new LineSegment(new Point2D(1, 1), new Point2D(2, 2));
        LineSegment c = new LineSegment(b);
        
        a.setStartPoint(new Point2D(3, 3));
        a.setEndPoint(new Point2D(4, 4));
        
        System.out.println("Line a: " + a.toString());
        System.out.println("Line b: " + b.toString());
        System.out.println("Line c: " + c.toString());
        
        System.out.println("Line b's distance between points: " + b.distance());
        
        System.out.println("Does a equal b? " + a.equals(b));
        System.out.println("Does a equal c? " + a.equals(c));
        System.out.println("Does b equal c? " + b.equals(c));
    }
    
    
    public static void immutableFractionDriver() {
        // System.out.println("uncomment the code to use the immutableFractionDriver");
        Fraction a = new Fraction(1,2);
        Fraction b = new Fraction(3,4);
        Fraction c = new Fraction(b);
    
        
        System.out.println("a:"+a.toString());
        System.out.println("b:"+b.toString());
        System.out.println("c:"+c.toString());
        
        //(1)uncomment out to discover errors
        //a.setNum(3);
        //a.setDenom(5);
        
        //(2)fix the following 2 errors
        System.out.println("a.num:"+a.getNum());
        System.out.println("b.denom:"+b.getDenom());
        
        
        //(3)which of the following code is correct to change the fraction a?
        a.add(b);
        a = a.add(b);
        
        System.out.println("a:"+a.toString());
        System.out.println("b:"+b.toString());
        System.out.println("c:"+c.toString());
        
        System.out.println("a.equals(b):" + a.equals(b));
        System.out.println("b.equals(c):" + b.equals(c));
    }

    private static void math2Driver() {
        // System.out.println("uncomment the code to use the math2Driver");
        double a = Math2.PI;
        double b = Math2.E;
        double c = a + b;
        System.out.println(c);                                                                                      // c was not used, print to demo
        
        System.out.println("The larger of the two is " + Math2.max(10, 20));
        System.out.println("And the larger of the two is " + Math2.max(10.34, 10.31));
        System.out.println("2^8 is " + Math2.pow(2, 8) );
    }

    
    public static void passByReferenceDemo() {
        int a = 3;                      //a primitive (pass-by-value)
        Dimension b = new Dimension();  //an Object (pass-by-reference)
        
        System.out.println("a is: " + a);
        System.out.println("b is: " + b);
        
        mutate(a);
        mutate(b);
        
        System.out.println("a is: " + a);
        System.out.println("b is: " + b);
        

        /* answers
         * primitives are passed by value and objects are passed by reference meaning they can cause privacy leaks
         * no, a copy is made with the value of the primitive passed in
         * yes, the scope is increased as the reference is now being accessed in the calling method
         * the scope is inside wherever it is created and expands to individual methods as it's passed in
         */
    }
    
    public static void mutate(int z) {  //does it matter that I called my input data "z" here?
        z = -1000;  //if z is only a copy, this won't affect the variable a's value in main
        
        //this.foo = -1000;
        //why does the line above cause compiler errors?
    }
    
    public static void mutate(Dimension c) {  
        c.height = -1000;
        c.width = -1000;
        //if I didn't hand this function a copy of b from main, but rather a reference to the object that is known in main as b, what happens here?
        //if I make a change to c, are my changes reflected back in the code that called this function?  In other words, did this change b of main?
    }
}