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

    /**
     * Sort array in increasing order.The counting algorithm is used
     * @cpu O(n), n- array.length
     * @ram O(1)
     * @param array array with numbers
     */
    public static void countingSort(int[] array) {
        if (array.length == 0) {
            return;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]){
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
        }
        int[] sortArray = new int[Math.abs(max - min) + 1];
        for (int i = 0 ; i < array.length; i++) {
            int index = array[i] - min;
            sortArray[index]++;
        }
        for (int i = 0, j = 0; i < sortArray.length; i++) {
            for (int k = sortArray[i]; k > 0; k--) {
                array[j++] = i + min;
            }
        }
    }

    /**
     * Return array with unique numbers from input array
     * @cpu O(n + m), n- array.length, m - (max - min)(array)
     * @ram O(n + m), n- array.length, m - (max - min)(array)
     * @param array array with unique numbers
     */
    public static int[] distinct(int[] array) {
        if (array.length == 0) {
            return new int[]{};
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
        }
        int[] uniqueNumb = new int[Math.abs(max - min) + 1];
        int cnt = 0;
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - min;
            if (uniqueNumb[index] < 1) {
                uniqueNumb[index]++;
                cnt++;
            }
        }
        int[] result = new int[cnt];
        for (int i = 0, j = 0; i < array.length; i++){
            if(uniqueNumb[array[i] - min] == 1) {
                uniqueNumb[array[i] - min]--;
                result[j++] = array[i];
            }
        }
        return result;
    }

    /**
     * Find and return most frequent element. When array have some frequent elements return element with lower value.
     * @cpu O(n + m), n- array.length, m - (max - min)(array)
     * @ram O(m),  m - (max - min)(array)
     * @param array array with  numbers
     * @returm most frequent element with lower value
     */
    public static int mostFrequent(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
        }
        int[] sortArray = new int[Math.abs(max - min) + 1];
        int maxIndex = array[0] - min;
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - min;
            sortArray[index]++;
            if (sortArray[index] == sortArray[maxIndex] && index < maxIndex) {
                maxIndex = index;
            } else if (sortArray[index] > sortArray[maxIndex]) {
                maxIndex = index;
            }
        }
        return min + maxIndex;
    }
}


