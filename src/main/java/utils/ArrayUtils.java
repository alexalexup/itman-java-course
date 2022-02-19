package utils;

import entities.Event;

public class ArrayUtils {
    /**
     * Sort events in increasing order of date
     * @cpu O(n^2), n- events.length
     * @ram O(1)
     * @param events array
     */
    public static void bubbleSort(Event[] events) {
        int n = events.length;
        if (n < 1) {
           return;
        }
        for (int i = n; i > 1; i--) {
            for (int j = 1; j < i; j++) {
                if (events[j-1].compareTo(events[j]) > 0) {
                    Event t = events[j - 1];
                    events[j - 1] = events[j];
                    events[j] = t;
                }
            }
        }
    }

    /**
     * Sort array in increasing order of numbers
     * @cpu O(n^2), n- events.length
     * @ram O(1)
     * @param array array with numbers
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int buffer = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = buffer;
                }
            }
        }
    }
}


