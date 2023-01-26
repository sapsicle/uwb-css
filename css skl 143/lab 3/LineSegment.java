public class LineSegment {
    /* invariants
     * points should never be null
     */

    private Point2D startPoint, endPoint;

    public LineSegment() {
        this.startPoint = new Point2D();                                                                    // no args initializes to origin    
        this.endPoint = new Point2D();
    }

    public LineSegment(Point2D start, Point2D end) throws NullPointerException {
        if (start == null || end == null)                                                                   // object null checking, coords inside cannot be null as no-args will set to origin
            throw new NullPointerException("One or both points are null");
            
        this.startPoint = new Point2D(start);                                                               // no privacy leaks, make copies
        this.endPoint = new Point2D(end);
    }

    public LineSegment(LineSegment other) throws NullPointerException {
        if (other == null)
            throw new NullPointerException("Segment to be copied is null");

        this.startPoint = new Point2D(other.startPoint);
        this.endPoint = new Point2D(other.endPoint);
    }

    public Point2D getStartPoint() {
        return new Point2D(this.startPoint);                                                                // copies remove privacy leaks
    }

    public void setStartPoint(Point2D startPoint) {
        this.startPoint = new Point2D(startPoint);                                                          // copies remove privacy leaks
    }

    public Point2D getEndPoint() {
        return new Point2D(this.endPoint);                                                                  // copies remove privacy leaks
    }

    public void setEndPoint(Point2D endPoint) {
        this.endPoint = new Point2D(endPoint);                                                              // copies remove privacy leaks
    }

    @Override
    public String toString() {
        return "startPoint = " + this.startPoint.toString() + "" +
            ", endPoint = " + this.endPoint.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LineSegment) || o == null)
            return false;
        LineSegment lineSegment = (LineSegment) o;
        return this.startPoint.equals(new Point2D(lineSegment.startPoint)) && this.endPoint.equals(new Point2D(lineSegment.endPoint));      // absolutely no leaks
    }

    public double distance() {
        int dX = Math.abs(this.startPoint.getX() - this.endPoint.getX());                                   // delta is absolute value of difference between points
        int dY = Math.abs(this.startPoint.getY() - this.endPoint.getY());                                   // delta is absolute value of difference between points
        double distance = Math.sqrt((dX * dX) + (dY * dY));                                                 // find hypotenuse via pythagorean, c = sqrt(a^2 + b^2)
        return distance;
    }   
}

/* answers:
 * privacy leak is where a private field is unintentionally able to be modified due to tying references together
 * they do not
 * can't think of anywhere i missed
 */