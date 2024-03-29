package utils;

import collections.AbstractList;
import entities.Shape;

import java.util.Comparator;

public class ShapeUtils {
    /**
     * Returns the average value of parameters from the list shapes
     * @cpu O(n), n - list.size()
     * @ram O(1)
     * @param list LinkedList with shapes
     * @return the average value of parameters from the list shapes
     */
    public static double calcAvrPerimeter(AbstractList<? extends Shape> list) {
        double sum = 0;
        for (Shape shape: list) {
            sum = sum + shape.calcPerimeter();
        }
        return sum / list.size();
    }

    /**
     * Find shape with minimum square from the list
     * @cpu O(n), n - list.size()
     * @ram O(1)
     * @param list LinkedList with shapes
     * @return shape with minimum square
     */
    public static Shape findMinSquareShape (AbstractList<? extends Shape> list) {
        Comparator<? super Shape> comparator = Comparator.comparing(Shape::calcSquare);
        return CollectionUtils.findMin(list, comparator);
    }
}
