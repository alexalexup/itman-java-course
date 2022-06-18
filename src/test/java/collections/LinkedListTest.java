package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LinkedListTest {
    private static void checkElements(LinkedList list, int[] array) {
        int size = list.size();
        Assertions.assertEquals(size, array.length);
        for(int i = 0; i < size; i++) {
            Assertions.assertEquals(list.get(i), array[i]);
        }
    }

    @Nested
    public class AddFirst{
        @Test
        public void shouldAddElementsWhenMethodWasCalledMultipleTimes() {
            LinkedList list = new LinkedList();
            list.addFirst(56);
            list.addFirst(10);
            list.addFirst(12);
            list.addFirst(1);
            list.addFirst(2);
            list.addFirst(3);
            int[] expectedResult = new int[]{3, 2, 1, 12, 10, 56};
            checkElements(list,expectedResult);
        }

        @Test
        public void shouldWorkWhenListHaveNotElements() {
            LinkedList list = new LinkedList();
            list.addFirst(4);
            Assertions.assertEquals(4, list.get(0));
        }
    }

    @Nested
    public class GetFirst{
        @Test
        public void shouldReturnFirstElementWhenMethodWasCalled() {
            LinkedList list = LinkedList.of(2, 3, 4);
            int actualResult = list.getFirst();
            Assertions.assertEquals(2, actualResult);
        }
    }

    @Nested
    public class Remove {
        @Test
        public void shouldRemoveElementsWhenWethodWasCalledSeveralTimes(){
            LinkedList list = LinkedList.of(10, 8, 4, 2);
            list.removeFirst();
            list.removeFirst();
            int[] expectedResult = new int[] {4, 2};
            checkElements(list, expectedResult);
        }

        @Test
        public void shouldReturnFirstElement() {
            LinkedList list = LinkedList.of(12, 6, 15);
            int actualResult = list.removeFirst();
            Assertions.assertEquals(12, actualResult);
        }

        @Test
        public void shouldReturnFirstElementWhenListHaveOneElement() {
            LinkedList list = LinkedList.of(6);
            int actualResult = list.removeFirst();
            Assertions.assertEquals(6, actualResult);
        }
    }

    @Nested
    public class ToString {
        @Test
        public void shouldReturnStringWhenLinkedListHaveOneElement() {
            LinkedList list = new LinkedList();
            list.addFirst(4);
            String actualResult = list.toString();
            Assertions.assertTrue(actualResult.equals("[4]"));
        }

        @Test
        public void shouldReturnStringWhenLinkedListHaveSomeElement() {
            LinkedList list = LinkedList.of(6, 3, 4, 1, 9);
            String actualResult = list.toString();
            Assertions.assertTrue(actualResult.equals("[6, 3, 4, 1, 9]"));
        }

        @Test
        public void shouldReturnStringWhenLinkedListHaveNotAnyElement() {
            LinkedList list = new LinkedList();
            String actualResult = list.toString();
            Assertions.assertTrue(actualResult.equals("[]"));
        }
    }

    @Nested
    public class AddLast {
        @Test
        public void shouldAddLastElementWhenListHaveNotElements() {
            LinkedList list = new LinkedList();
            list.addLast(6);
            Assertions.assertEquals(6,list.getLast());
        }

        @Test
        public void shouldWorkWhenAddLastWasCalledSomeTimes() {
            LinkedList list = new LinkedList();
            list.addLast(36);
            list.addLast(42);
            list.addLast(56);
            int[] expectedResult = new int[] {36, 42, 56};
            checkElements(list, expectedResult);
        }
    }

    @Nested
    public class GetLast {
        @Test
        public void shouldReturnLastElementWhenMethodWasCalled() {
            LinkedList list = LinkedList.of(6, 9, 14);
            int actualResult = list.getLast();
            Assertions.assertEquals(14, actualResult);
        }

        @Test
        public void shouldReturnLastElementWhenListHaveOneElement() {
            LinkedList list = new LinkedList();
            list.addFirst(4);
            int actualResult = list.getLast();
            Assertions.assertEquals(4, actualResult);
        }
    }

    @Nested
    public class RemoveLast {
        @Test
        public void shouldReturnLastElementWhenListHaveOneElement() {
            LinkedList list = new LinkedList();
            list.addLast(12);
            int actualResult = list.removeLast();
            Assertions.assertEquals(12, actualResult);
        }

        @Test
        public void shouldReturnLastElementWhenListHaveSomeElements() {
            LinkedList list = LinkedList.of(3, 6, 11);
            int actualResult = list.removeLast();
            Assertions.assertEquals(11, actualResult);
        }

        @Test
        public void removeLastShouldReturnLastElementWhenMethodWasCalledSeveralTimes() {
            LinkedList list = LinkedList.of(2, 7, 8, 9, 10);
            list.removeLast();
            list.removeLast();
            int actualResult = list.removeLast();
            Assertions.assertEquals(8, actualResult);
        }
    }

    @Nested
    public class LinkkedList {
        @Test
        public void shouldCopyElementsFromAnotherLinkedList() {
            LinkedList firstList = LinkedList.of(1, 2, 3, 4);
            LinkedList secondList = new LinkedList(firstList);
            int[] expectedResult = new int[] {1, 2, 3, 4};
            checkElements(secondList, expectedResult);
        }

        @Test public void shouldWorkWhenAnotherLinkedHaveFirstNodeWithNullValue() {
            LinkedList firstList = new LinkedList();
            LinkedList secondList = new LinkedList(firstList);
            Assertions.assertEquals(secondList.getNode(), null);
        }
    }
}
