package entities;

public class Square implements Shape {
    private double side;
    /**
     * Set side for the square
     * @cpu O(1)
     * @ram O(1)
     * @param side argument
     */
    public Square (double side) {
        this.side = side;
    }

    /**
     * Get side from the square
     * @cpu O(1)
     * @ram O(1)
     * @return side of the square
     */
    public double getSide() {
        return this.side;
    }

    /**
     * Calculate perimeter for the square
     * @cpu O(1)
     * @ram O(1)
     * @return perimeter of the square
     */
    @Override
    public double calcPerimeter() {
        return this.side * 4;
    }

    /**
     * Calculate square
     * @cpu O(1)
     * @ram O(1)
     * @return square
     */
    @Override
    public double calcSquare() {
        return Math.pow(this.side, 2);
    }

    /**
     * Return information about object
     * @cpu O(1)
     * @ram O(1)
     * @return information about object
     */
    @Override
    public String toString() {
        return "Square{side=" + this.side  + "}";
    }

    /**
     * Compare square with another object
     * @cpu O(1)
     * @ram O(1)
     * @return return true when both squares are same and false in another situation
     */
    @Override
    public boolean equals (Object that) {
        if (that == null || that.getClass() != Square.class) {
            return false;
        }
        if (this.side != ((Square) that).side) {
            return false;
        }
        return  true;
    }
}
