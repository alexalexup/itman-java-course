package entities;

public class Rectangle implements Shape {
    private double weight;
    private double height;

    /**
     * Set height and weight for the rectangle
     * @cpu O(1)
     * @ram O(1)
     * @param weight argument
     * @param height argument
     */
    public Rectangle(double weight, double height) {
        this.height = height;
        this.weight = weight;
    }

    /**
     * Get weight from the rectangle
     * @cpu O(1)
     * @ram O(1)
     * @return  weight from the rectangle
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Get height from the rectangle
     * @cpu O(1)
     * @ram O(1)
     * @return height from the rectangle
     */
    public double getHeight() {
        return height;
    }

    /**
     * Calculate perimeter for the rectangle
     * @cpu O(1)
     * @ram O(1)
     * @return perimeter of the rectangle
     */
    @Override
    public double calcPerimeter() {
        return this.weight * 2 + this.height * 2;
    }

    /**
     * Calculate square for the rectangle
     * @cpu O(1)
     * @ram O(1)
     * @return square of the rectangle
     */
    @Override
    public double calcSquare() {
        return this.weight * this.height;
    }

    /**
     * Return information about rectangle
     * @cpu O(1)
     * @ram O(1)
     * @return information about rectangle
     */
    @Override
    public String toString() {
        return "Rectangle{weight=" + this.weight  + ", height=" + this.height +"}";
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
        if (this.weight != ((Rectangle) that).weight || this.height != ((Rectangle) that).height ) {
            return false;
        }
        return true;
    }
}
