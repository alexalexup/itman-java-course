package collections;

import java.util.Comparator;

public class CollectionUtils {

    public static <T> T findMin(List<T> list, Comparator comparator){
        int min = 0;
        for (int i = 0; i < list.size(); i++) {
            if (comparator.compare(list.get(min), list.get(i)) > 0) {
                min = i;
            }
        }
        return list.get(min);
    }

    public static <T> T findMax(List<T> list, Comparator comparator) {
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (comparator.compare(list.get(max), list.get(i)) < 0) {
                max = i;
            }
        }
        return list.get(max);
    }

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
