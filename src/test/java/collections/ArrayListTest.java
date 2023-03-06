package collections;


import org.junit.jupiter.api.Test;

import java.util.Iterator;

class ArrayListTest {
    @Test
    public void sdfjsdfjs() {
        LinkedList list = LinkedList.of(null, 2, "dad", 2.21, "a");
        ListIterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.nextReverse());
        }
    }
}