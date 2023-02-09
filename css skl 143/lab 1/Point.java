public class Point {
    public int int1;
    private int int2;

    public void method1() {
        //stuff
    }

    private void method2() {
        //stuff
    }
}

class PointDriver {
    public static void main(String[] args) {
        Point point = new Point();

        point.method1();

        // point.method2();
        // The method method2() from the type Point is not visible
        
        System.out.println(point.int1);

        // System.out.println(point.int2);
        // The field Point.int2 is not visible
    }
}