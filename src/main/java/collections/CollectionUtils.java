package collections;

import java.util.Comparator;
import collections.ListIterator;


public class CollectionUtils {

    /**
     * Find first index when element is not Null
     * @cpu O(n), list.size()
     * @ram O(1)
     * @param list List with elements
     * @return first index without null value
    */
    private static<T> T findFirstNotNullElement(List<T> list) {
        ListIterator<T> iterator = list.iterator();
        T element = list.get(0);
        while (element == null && iterator.hasNext()) {
            element = iterator.next();
        }
        return element;
    }

    /**
     * Finds the minimum element in the List
     * @cpu O(n), list.size()
     * @ram O(1)
     * @param list List with elements
     * @param comparator argument
     * @return minimum element from the List
     */
    public static <T> T findMin(List<T> list, Comparator<? super T> comparator){
        T min = list.get(0);
        ListIterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (element == null) {
                return null;
            }
            if (comparator.compare(min, element) > 0 ) {
                min = element;
            }
        }
        return min;
    }

    /**
     * Finds the maximum element in the List
     * @cpu O(n), list.size()
     * @ram O(1)
     * @param list List with elements
     * @param comparator argument
     * @return minimum element from the List
     */
    public static <T> T findMax(List<T> list, Comparator<? super T> comparator) {
        T max = findFirstNotNullElement(list);
        ListIterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (element != null && comparator.compare(max, element) < 0 ) {
                max = element;
            }
        }
        return max;
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
     */
    private static void merge(Comparable[] a, int aFrom, int aTo, Comparable[] b, int bFrom, int bTo, Comparable[] r, int rFrom) {
        int length = rFrom + aTo - aFrom + bTo - bFrom;
        for (int i = rFrom, j = aFrom, k = bFrom; i < length; i++) {
            if (k < bTo  && (j >= aTo || a[j].compareTo(b[k]) > 0)) {
                r[i] = b[k];
                k++;
            } else {
                r[i] = a[j];
                j++;
            }
        }
    }

    /**
     * Sort part of array with events use merge method
     * @cpu O(n * logn), n = toIndex - fromIndex
     * @ram O(n), n = toIndex - fromIndex
     * @param objects array with elements
     * @param fromIndex argument
     * @param toIndex argument
     */
    private static void mergeSort(Comparable[] objects, int fromIndex, int toIndex) {
        Comparable[] bufferEvents = new Comparable[toIndex - fromIndex];
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
                merge(objects, aFrom, aTo, objects, bFrom, bTo, bufferEvents, i - fromIndex);
            }
            size = size * 2;
            System.arraycopy(bufferEvents, 0, objects, fromIndex, bufferEvents.length);
        }
    }

    /**
     * Sort Array with events use merge method
     * @cpu O(n * logn), n - events.length
     * @ram O(n), n- a.length
     * @param objects array with elements
     */
    private static void mergeSort(Comparable[] objects) {
        mergeSort(objects, 0, objects.length);
    }

    /**
     * Sort in increase order elements in the List
     * @cpu O(n * logn), list.size()
     * @ram O(n), list.size()
     * @param list List with elements
     */
    public static void sort(List<Comparable> list) {
        Comparable[] objects = new Comparable[list.size()];
        ListIterator<Comparable> firstIterator = list.iterator();
        for (int i = 0; i <objects.length; i ++) {
            objects[i] = firstIterator.next();
        }
        mergeSort(objects);
        ListIterator<Comparable> secondIterator = list.iterator();
        for (int k = 0; k <objects.length; k ++) {
            secondIterator.next();
            secondIterator.set(objects[k]);
        }
    }

    /**
     * Reverse order of elements in the list
     * @cpu O(n), list.size()
     * @ram O(n), list.size()
     * @param list List with elements
     */
    public static <T> void reverse(List<T> list) {
        if (list == null || list.size() == 1) {
            return;
        }
        ListIterator<T> firstIterator = list.iterator();
        T[] objects = (T[]) new Object[list.size()];
        for (int i = 0; i < objects.length; i++) {
            objects[objects.length - i - 1] = firstIterator.next();
        }
        ListIterator<T> secondIterator = list.iterator();
        for (int k = 0; k < list.size(); k++) {
            secondIterator.next();
            secondIterator.set(objects[k]);
        }
    }
}
