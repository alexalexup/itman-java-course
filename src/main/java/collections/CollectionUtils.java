package collections;

import java.util.Comparator;
import java.util.Iterator;


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
        T min = findFirstNotNullElement(list);
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (element != null && comparator.compare(min, element) > 0 ) {
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
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (element != null && comparator.compare(max, element) < 0 ) {
                max = element;
            }
        }
        return max;
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
        ListIterator<T> iterator = list.iterator();
        ListIterator<T> reverseIterator = list.iterator();
        reverseIterator.setIteratorSize(list.size());
        for(int i = 0; i < list.size() / 2; i++) {
            T buffer = iterator.next();
            iterator.set(reverseIterator.nextReverse());
            reverseIterator.setReverse(buffer);
        }
    }
}
