package collections;

import java.util.Comparator;

public class CollectionUtils {

    public static <T> T findMin(Lists<T> list, Comparator comparator){
        int min = 0;
        for (int i = 0; i < list.size(); i++) {
            if (comparator.compare(list.get(min), list.get(i)) > 0) {
                min = i;
            }
        }
        return list.get(min);
    }
}
