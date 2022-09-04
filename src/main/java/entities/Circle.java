package entities;

public class Circle implements Shape{
    private double radius;

    /**
     * Get radius from the circle
     * @cpu O(1)
     * @ram O(1)
     * @return radius from the circle
     */
    public double getRadius() {
        return this.radius;
    }

    /**
     * Set radius for circle
     * @cpu O(1)
     * @ram O(1)
     * @param radius argument
     */
    public Circle (double radius) {
        this.radius = radius;
    }

    /**
     * Calculate perimeter for circle
     * @cpu O(1)
     * @ram O(1)
     * @return  perimeter of the circle
     */
    @Override
    public double calcPerimeter() {
        return Math.PI * 2 * this.radius;
    }

    /**
     * Calculate square for circle
     * @cpu O(1)
     * @ram O(1)
     * @return  square of the circle
     */
    @Override
    public double calcSquare() {
        return Math.PI * Math.pow(this.radius, 2.0);
    }

    /**
     * Return information about circle
     * @cpu O(1)
     * @ram O(1)
     * @return  information about circle
     */
    @Override
    public String toString() {
        return "Circle{radius=" + this.radius  + "}";
    }

    /**
     * Compare circle with another object
     * @cpu O(1)
     * @ram O(1)
     * @return  true when two circles are same and false in another situation
     */
    @Override
    public boolean equals (Object that) {
        if (that == null || that.getClass() != Circle.class) {
            return false;
        }
        if (this.radius != ((Circle) that).radius) {
            return false;
        }
        return true;
    }
}
