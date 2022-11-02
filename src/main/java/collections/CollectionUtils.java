package collections;

import java.util.Comparator;


public class CollectionUtils {

    /**
     * Finds the minimum element in the List
     * @cpu O(n), list.size()
     * @ram O(1)
     * @param list List with elements
     * @param comparator argument
     * @return minimum element from the List
     */
    public static <T> T findMin(List<T> list, Comparator<? super T> comparator){
        int index = 0;
        while (list.get(index) == null && index < list.size()) {
            index++;
        }
        int min = index;
        if (min == list.size()) {
            return null;
        }
        if (min == list.size() - 1) {
            return list.get(min);
        }
        for (int i = index; i < list.size(); i++) {
            if (list.get(i) != null && comparator.compare(list.get(min), list.get(i)) > 0) {
                min = i;
            }
        }
        return list.get(min);
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
        int index = 0;
        while (list.get(index) == null && index < list.size()) {
            index++;
        }
        int max = index;
        if (max == list.size()) {
            return null;
        }
        if (max == list.size() - 1) {
            return list.get(max);
        }
        for (int i = index; i < list.size(); i++) {
            if (list.get(i) != null && comparator.compare(list.get(max), list.get(i)) < 0) {
                max = i;
            }
        }
        return list.get(max);
    }

    /**
     * Sort in increase order elements in the List
     * @cpu O(n^2), list.size()
     * @ram O(1)
     * @param list List with elements
     */
    public static <T> void sort(List<T> list) {
        if (list == null || list.size() == 1) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            int min = i;
            for (int j = i; j <list.size(); j++) {
                if (((Comparable) list.get(min)).compareTo(list.get(j)) > 0) {
                    min = j;
                }
            }
            T buffer = list.get(min);
            list.set(min, list.get(i));
            list.set(i, buffer);
        }
    }

    /**
     * Reverse order of elements in the list
     * @cpu O(n), list.size()
     * @ram O(1)
     * @param list List with elements
     */
    public static <T> void reverse(List<T> list) {
        if (list == null || list.size() == 1) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            T buffer = list.get(size - i - 1);
            list.set(size - i - 1, list.get(i));
            list.set(i, buffer);
        }
    }
}
