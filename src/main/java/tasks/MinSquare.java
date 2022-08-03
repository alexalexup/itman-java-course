package tasks;
import collections.LinkedList;
import entities.Shape;


public class MinSquare {
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
