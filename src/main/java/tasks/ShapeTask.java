package tasks;

import collections.LinkedList;
import entities.Shape;

public class ShapeTask {
    /**
     * Returns the average value of parameters from the list shapes
     * @cpu O(n), n - list.size()
     * @ram O(1)
     * @param list LinkedList with shapes
     * @return the average value of parameters from the list shapes
     */
    public static double calcAvrPerimeter(LinkedList list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + ((Shape) list.get(i)).calcPerimeter();
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
    public static Object findMinSquareShape (LinkedList list) {
        double min = ((Shape) list.get(0)).calcSquare();
        int index = 0;
        for (int i = 0 ; i < list.size(); i++) {
            if ( ((Shape) list.get(i)).calcSquare() < min ) {
                min = ((Shape) list.get(i)).calcSquare();
                index = i;
            }
        }
        return list.get(index);
    }
}
