package entities;

public class Rectangle implements Shape {
    private Double width;
    private Double height;

    /**
     * Set height and weight for the rectangle
     * @cpu O(1)
     * @ram O(1)
     * @param width argument
     * @param height argument
     */
    public Rectangle(Double width, Double height) {
        this.height = height;
        this.width = width;
    }

    /**
     * Get weight from the rectangle
     * @cpu O(1)
     * @ram O(1)
     * @return  weight from the rectangle
     */
    public Double getWeight() {
        return width;
    }

    /**
     * Get height from the rectangle
     * @cpu O(1)
     * @ram O(1)
     * @return height from the rectangle
     */
    public Double getHeight() {
        return height;
    }

    /**
     * Calculate perimeter for the rectangle
     * @cpu O(1)
     * @ram O(1)
     * @return perimeter of the rectangle
     */
    @Override
    public Double calcPerimeter() {
        return this.width * 2 + this.height * 2;
    }

    /**
     * Calculate square for the rectangle
     * @cpu O(1)
     * @ram O(1)
     * @return square of the rectangle
     */
    @Override
    public Double calcSquare() {
        return this.width * this.height;
    }

    /**
     * Return information about rectangle
     * @cpu O(1)
     * @ram O(1)
     * @return information about rectangle
     */
    @Override
    public String toString() {
        return "Rectangle{weight=" + this.width  + ", height=" + this.height +"}";
    }

    /**
     * Compare rectangle with another object
     * @cpu O(1)
     * @ram O(1)
     * @return true when both rectangles are same and false in another situation
     */
    @Override
    public boolean equals (Object that) {
        if (that == null || that.getClass() != Rectangle.class) {
            return false;
        }
        Rectangle check = (Rectangle) that;
        return this.width.equals(check.width) && this.height.equals(check.height);
    }
}
