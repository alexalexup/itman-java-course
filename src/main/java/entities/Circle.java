package entities;

public class Circle implements Shape {
    private Double radius;

    /**
     * Get radius from the circle
     * @cpu O(1)
     * @ram O(1)
     * @return radius from the circle
     */
    public Double getRadius() {
        return this.radius;
    }

    /**
     * Set radius for circle
     * @cpu O(1)
     * @ram O(1)
     * @param radius argument
     */
    public Circle (Double radius) {
        this.radius = radius;
    }

    /**
     * Calculate perimeter for circle
     * @cpu O(1)
     * @ram O(1)
     * @return  perimeter of the circle
     */
    @Override
    public Double calcPerimeter() {
        return Math.PI * 2 * this.radius;
    }

    /**
     * Calculate square for circle
     * @cpu O(1)
     * @ram O(1)
     * @return  square of the circle
     */
    @Override
    public Double calcSquare() {
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
        Circle check = (Circle)that;
        return this.radius.equals(check.radius);
    }
}
