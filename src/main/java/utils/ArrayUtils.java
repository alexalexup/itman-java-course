package utils;

import collections.ArrayList;
import entities.Event;
import collections.IntArrayList;

import java.util.Comparator;
import java.util.function.ToIntFunction;


public class ArrayUtils {
    /**
     * Sort events in increasing order of date
     * @cpu O(n^2), n- events.length
     * @ram O(1)
     * @param objects array
     * @param comparator argument
     */
    public static <T> void bubbleSort(T[] objects, Comparator<? super T> comparator) {
        int n = objects.length;
        if (n < 1) {
           return;
        }
        for (int i = n; i > 1; i--) {
            for (int j = 1; j < i; j++) {
                if (comparator.compare(objects[j-1], objects[j]) > 0) {
                    T t = objects[j - 1];
                    objects[j - 1] = objects[j];
                    objects[j] = t;
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
     * Find max element from array
     * @cpu O(n), n- a.length
     * @ram O(1)
     * @param array array with numbers
     * @return max element from array
     */
    private static int findMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if ( max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * Find min element from array
     * @cpu O(n), n- a.length
     * @ram O(1)
     * @param array array with numbers
     * @return min element from array
     */
    private static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if ( min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * Sort array in increasing order.The counting algorithm is used
     * @cpu O(n + m), n - array.length, m = max(array) - min(array)
     * @ram O(m), m = max(array) - min(array)
     * @param array array with numbers
     */
    public static void countingSort(int[] array) {
        if (array.length == 0) {
            return;
        }
        int max = findMax(array);
        int min = findMin(array);
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
     * @cpu O(n + m), n- array.length, m = (max - min)(array)
     * @ram O(n + m), n- array.length, m = (max - min)(array)
     * @param array array with unique numbers
     */
    public static int[] distinct(int[] array) {
        if (array.length == 0) {
            return new int[]{};
        }
        int max = findMax(array);
        int min = findMin(array);
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
     * @cpu O(n + m), n- array.length, m = (max - min)(array)
     * @ram O(m),  m = (max - min)(array)
     * @param array array with  numbers
     * @returm most frequent element with lower value
     */
    public static int mostFrequent(int[] array) {
        int max = findMax(array);
        int min = findMin(array);
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

    /**
     * Count of Equal elements that are contained in both arrays
     * @cpu O(n + m), n- a.length, m - b.length
     * @ram O(k), k = min(max(a), max(b)) - max(min(a), min(b))
     * @param a array with  numbers
     * @param b array with numbers
     * @returm count of Equal elements from two arrays
     */
    public static  int countEquals(int[] a, int[] b) {
        if (a.length == 0 || b.length == 0) {
            return 0;
        }
        int maxFirst = findMax(a);
        int minFirst = findMin(a);
        int max = findMax(b);
        int min = findMin(b);
        if (max < minFirst || min > maxFirst) {
            return 0;
        }
        if (maxFirst < max) {
            max = maxFirst;
        }
        if (minFirst > min) {
            min = minFirst;
        }
        int[] sortArray = new int[Math.abs(max - min) + 1];
         for (int i = 0; i < a.length; i++) {
            if (a[i] <= max && a[i] >= min) {
                int index = a[i] - min;
                sortArray[index]++;
            }
        }
        int result = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] <= max && b[i] >= min) {
                int index = b[i] - min;
                sortArray[index]--;
                if (sortArray[index] >= 0) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * Sort events in order of increasing by date
     * @cpu O(n + m), n- events.length, m = (max - min)(events)
     * @ram O(n + m), n- events.length, m = (max - min)(events)
     * @param objects array with elements
     * @param function argument
     */
    public static <T> void countingSort(T[] objects, ToIntFunction function) {
        int[] keyArray = new int[objects.length];
        for (int i = 0; i < objects.length; i ++) {
            keyArray[i] = function.applyAsInt(objects[i]);
        }
        int maxDay  = findMax(keyArray);
        int minDay = findMin(keyArray);
        ArrayList[] sortDates = new ArrayList[Math.abs(maxDay-minDay) + 1];
        for (int i = 0; i < sortDates.length; i++) {
           sortDates[i] = new ArrayList();
        }
        for (int i = 0; i < keyArray.length; i++) {
            int index = keyArray[i] - minDay;
            sortDates[index].add(objects[i]);
        }
        for (int i = 0, j = 0; i < sortDates.length; i++) {
            for (int k = 0; k < sortDates[i].size(); k++){
                objects[j] = (T) sortDates[i].get(k);
                j++;
            }
        }
    }

    /**
     * Merge two arrays in increasing order of numbers
     * @cpu O(n + m), n = aTo - aFrom, m = bTo - bFrom
     * @ram O(1)
     * @param a array with numbers
     * @param aFrom argument
     * @param aTo argument
     * @param b array with numbers
     * @param bFrom argument
     * @param bTo argument
     * @param r array with numbers
     * @param rFrom argument
     */
    public static void merge(int[] a, int aFrom, int aTo, int[] b, int bFrom, int bTo, int[] r, int rFrom) {
        int length = rFrom + aTo - aFrom + bTo - bFrom;
        for (int i = rFrom, j = aFrom, k = bFrom; i < length; i++) {
            if (k < bTo && (j >= aTo || a[j] > b[k])) {
                r[i] = b[k];
                k++;
            } else {
                r[i] = a[j];
                j++;
            }
        }
    }

    /**
     * Sort Array use merge method
     * @cpu O(n * logn), n - a.length
     * @ram O(n), n - a.length
     * @param a array with numbers
     */
    public static void mergeSort(int[] a){
       mergeSort(a,0, a.length);
    }

    /**
     * Sort part of array with numbers  use merge method
     * @cpu O(n * logn), n = toIndex - fromIndex
     * @ram O(n), n = toIndex - fromIndex
     * @param array array with numbers
     * @param fromIndex argument
     * @param toIndex argument
     */
    public static void mergeSort(int[] array, int fromIndex, int toIndex){
        int[] sortArray = new int[toIndex  - fromIndex];
        int size = 1;
        while (size < sortArray.length) {
            for (int i = fromIndex; i < toIndex; i = i + 2 * size){
                int aFrom = i;
                int aTo = i + size;
                if (aTo > toIndex) {
                    aTo = toIndex;
                }
                int bFrom = aTo;
                int bTo = aTo + size;
                if (bTo > toIndex) {
                    bTo = toIndex;
                }
                merge(array, aFrom, aTo, array, bFrom, bTo, sortArray, i - fromIndex);
            }
            size = size * 2;
            System.arraycopy(sortArray, 0, array, fromIndex, sortArray.length);
        }
    }

    /**
     * Sort Array with events use merge method with comparator argument
     * @cpu O(n * logn), n - events.length
     * @ram O(n), n- a.length
     * @param objects array with elements
     * @param comparator argument
     */
    public static <T> void mergeSort(T[] objects, Comparator<? super T> comparator) {
        mergeSort(objects, 0, objects.length, comparator);
    }

    /**
     * Sort part of array with events use merge method
     * @cpu O(n * logn), n = toIndex - fromIndex
     * @ram O(n), n = toIndex - fromIndex
     * @param objects array with elements
     * @param fromIndex argument
     * @param toIndex argument
     */
    public static<T> void mergeSort(T[] objects, int fromIndex, int toIndex, Comparator<? super T> comparator) {
        T[] bufferEvents = (T[]) new Object[toIndex - fromIndex];
        int size = 1;
        while (size < bufferEvents.length) {
            for (int i = fromIndex; i < toIndex; i = i + 2 * size) {
                int aFrom = i;
                int aTo = i + size;
                if (aTo > toIndex) {
                    aTo = toIndex;
                }
                int bFrom = aTo;
                int bTo = bFrom + size;
                if (bTo > toIndex) {
                    bTo = toIndex;
                }
                merge(objects, aFrom, aTo, objects, bFrom, bTo, bufferEvents, i - fromIndex, comparator);
            }
            size = size * 2;
            System.arraycopy(bufferEvents, 0, objects, fromIndex, bufferEvents.length);
        }
    }

    /**
     * Merge two arrays with events in increasing order of numbers
     * @cpu O(n + m), n = aTo - aFrom, m = bTo - bFrom
     * @ram O(1)
     * @param a array with elements
     * @param aFrom argument
     * @param aTo argument
     * @param b array with elements
     * @param bFrom argument
     * @param bTo argument
     * @param r array with elements
     * @param rFrom argument
     * @param comparator argument
     */
    public static<T> void merge(T[] a, int aFrom, int aTo, T[] b, int bFrom, int bTo, T[] r, int rFrom,
                                Comparator<? super T> comparator) {
        int length = rFrom + aTo - aFrom + bTo - bFrom;
        for (int i = rFrom, j = aFrom, k = bFrom; i < length; i++) {
            if (k < bTo  && (j >= aTo || comparator.compare(a[j], b[k]) > 0)) {
                r[i] = b[k];
                k++;
            } else {
                r[i] = a[j];
                j++;
            }
        }
    }

    /**
     * Sort Array with events use merge method
     * @cpu O(n * logn), n - events.length
     * @ram O(n), n- a.length
     * @param objects array with elements
     */
    public static<T extends Comparable<T>> void mergeSort(T[] objects) {
        mergeSort(objects, Comparable::compareTo);
    }
}


