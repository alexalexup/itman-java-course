package tasks;

import collections.LinkedList;
import entities.Shape;

public class AvrPerimeter {
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
}
