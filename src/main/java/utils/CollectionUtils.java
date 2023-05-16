package utils;

import collections.List;
import collections.ListIterator;

import java.util.Comparator;

import static utils.ArrayUtils.mergeSort;

public class CollectionUtils {

    /**
     * Finds the minimum element in the List
     * @cpu O(n), list.size()
     * @ram O(1)
     * @param list List with elements
     * @param comparator argument
     * @return minimum element from the List
     */
    public static <T> T findMin(List<? extends T> list, Comparator<? super T> comparator) {
        T min = list.get(0);
        for (T element: list) {
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
    public static <T> T findMax(List<? extends T> list, Comparator<? super T> comparator) {
        T max = list.get(0);
        for (T element: list) {
            if (comparator.compare(max, element) < 0 ) {
                max = element;
            }
        }
        return max;
    }

    /**
     * Sort in increase order elements in the List
     * @cpu O(n * logn), list.size()
     * @ram O(n), list.size()
     * @param list List with elements
     */
    public static<T extends Comparable<T>> void sort(List<T> list) {
        list.sort(Comparable::compareTo);
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
        ListIterator<T> iterator = list.iterator();
        T[] objects = (T[]) list.toArray();
        for (int i = 0; i < list.size(); i++) {
            iterator.next();
            iterator.set(objects[objects.length - i - 1]);
        }
    }
}
