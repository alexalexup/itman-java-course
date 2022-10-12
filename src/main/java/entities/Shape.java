package entities;

public interface Shape {
    /**
     * Calculate perimeter for the shape
     * @cpu O(1)
     * @ram O(1)
     * @return perimeter of the shape
     */
    double calcPerimeter();

    /**
     * Calculate square for the shape
     * @cpu O(1)
     * @ram O(1)
     * @return square of the shape
     */
     double calcSquare();
}