public class Point2D {
    private int x, y;

    public static void main(String[] args) {
        Point2D a = new Point2D();
        a.setX(5);
        a.setY(2);
        System.out.println("Point at (" + a.getX() + ", " + a.getX() ); 
        a.translate(-1,-1);
        System.out.println("Point at (" + a.getX() + ", " + a.getX() );
        a.resetToOrigin();
        System.out.println("Point at (" + a.getX() + ", " + a.getX() ); 
        Point2D b = new Point2D();
        Point2D c = new Point2D();
        System.out.println(b.toString());
        System.out.println(c); //Question: why don’t I need c.toString() here?
        System.out.println("Are b and c equal:" + b.equals(c));
    }

    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(Point2D point) {
        this.x = point.x;
        this.y = point.y;
    }

    public void resetToOrigin() {
        this.x = 0;
        this.y = 0;
    }

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Point2D)) {
            return false;
        }
        Point2D point2D = (Point2D) o;
        return x == point2D.x && y == point2D.y;
    }

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
}