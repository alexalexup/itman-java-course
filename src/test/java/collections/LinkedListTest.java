package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LinkedListTest {

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
            LinkedList expectedResult = LinkedList.of(3, 2, 1, 12, 10, 56);
            Assertions.assertTrue(list.equals(expectedResult));
        }

        @Test
        public void shouldWorkWhenLinkedListHaveNotElements() {
            LinkedList list = new LinkedList();
            list.addFirst(4);
            LinkedList expectedResult = LinkedList.of(4);
            Assertions.assertTrue(list.equals(expectedResult));
        }

        @Test
        public void shouldWorkWhenLinkedListHaveSomeElements() {
            LinkedList list = LinkedList.of(1, 2, 3, 4, 5);
            list.addFirst(6);
            LinkedList expectedResult = LinkedList.of(6, 1, 2, 3, 4, 5);
            Assertions.assertTrue(list.equals(expectedResult));
        }
    }

    @Nested
    public class Peek{
        @Test
        public void shouldReturnFirstElementWhenLinkedListHaveSomeElements() {
            LinkedList list = LinkedList.of(2, 3, 4, 5, 6, 7);
            Object actualResult = list.getFirst();
            Assertions.assertEquals(2, actualResult);
        }

        @Test
        public void shouldReturnFirstElementWhenLinkedListHaveOneElement() {
            LinkedList list = LinkedList.of(54);
            Object actualResult = list.getFirst();
            Assertions.assertEquals(54, actualResult);
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldNotBeEqualWhenLinkedListHaveDifferentSize() {
            LinkedList first = LinkedList.of(1, 2, 3, 4);
            LinkedList second = LinkedList.of(1, 2, 3, 4, 5);
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void shouldNotBeEqualWhenLinkedListHaveOnlyOneDifferentElement() {
            LinkedList first = LinkedList.of(1, 2, 1, 4, 5);
            LinkedList second = LinkedList.of(1, 2, 3, 4, 5);
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void shouldBeEqualWhenLinkedListHaveSameElementsAndSize() {
            LinkedList first = LinkedList.of(1, 2, 3, 4, 5);
            LinkedList second = LinkedList.of(1, 2, 3, 4, 5);
            Assertions.assertEquals(first, second);
        }

        @Test
        public void shouldBeEqualWhenBothLinkedListHaveNotElements() {
            LinkedList first = LinkedList.of();
            LinkedList second = LinkedList.of();
            Assertions.assertEquals(first, second);
        }

        @Test
        public void shouldNotBeEqualWhenOneLinkedListHaveNotElementsAndSecondHave() {
            LinkedList first = LinkedList.of(3, 4, 5, 6);
            LinkedList second = LinkedList.of();
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void shouldNotBeEqualWhenOneObjectIsNotFromLinkedListClass() {
            LinkedList first = LinkedList.of(3, 4, 5, 6);
            Object second = new Object();
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void shouldNotBeEqualWhenOneObjectIsNull() {
            LinkedList first = LinkedList.of(3, 4, 5, 6);
            LinkedList second = null;
            Assertions.assertNotEquals(first, second);
        }
    }

    @Nested
    public class Poll {
        @Test
        public void shouldReturnFirstElementWhenLinkedListHaveSomeElements() {
            LinkedList list = LinkedList.of(2, 3, 4);
            Object actualResult = list.removeFirst();
            Assertions.assertEquals(2, actualResult);
        }

        @Test
        public void shouldReturnFirstElementWhenLinkedListHaveOneElement() {
            LinkedList list = LinkedList.of(4);
            Object actualResult = list.removeFirst();
            Assertions.assertEquals(4, actualResult);
        }

        @Test
        public void shouldRemoveFirstNodeWhenLinkedListHaveSomeElements() {
            LinkedList list = LinkedList.of(4, 3 ,4, 5, 6);
            list.removeFirst();
            LinkedList expectedList = LinkedList.of( 3 ,4, 5, 6);
            Assertions.assertTrue(list.equals(expectedList));
        }

        @Test
        public void shouldRemoveFirstNodeWhenLinkedListHaveOneElement() {
            LinkedList list = LinkedList.of(6);
            list.removeFirst();
            LinkedList expectedList = LinkedList.of();
            Assertions.assertTrue(list.equals(expectedList));
        }
    }

    @Nested
    public class Offer {
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
            LinkedList expectedResult = LinkedList.of(36, 42, 56);
            Assertions.assertTrue(list.equals(expectedResult));
        }
        @Test
        public void shouldWorkWhenLinkedListHaveSomeElements() {
            LinkedList list = LinkedList.of(2, 3, 4, 5);
            list.addLast(99);
            LinkedList expectedResult = LinkedList.of(2, 3, 4, 5, 99);
            Assertions.assertTrue(list.equals(expectedResult));
        }
    }

    @Nested
    public class GetLast {
        @Test
        public void shouldReturnLastElementWhenLinkedListHaveSomeElements() {
            LinkedList list = LinkedList.of(6, 9, 14);
            Object actualResult = list.getLast();
            Assertions.assertEquals(14, actualResult);
        }

        @Test
        public void shouldReturnLastElementWhenListHaveOneElement() {
            LinkedList list = new LinkedList();
            list.addFirst(4);
            Object actualResult = list.getLast();
            Assertions.assertEquals(4, actualResult);
        }
    }

    @Nested
    public class RemoveLast {
        @Test
        public void shouldReturnLastElementWhenListHaveOneElement() {
            LinkedList list = new LinkedList();
            list.addLast(12);
            Object actualResult = list.removeLast();
            Assertions.assertEquals(12, actualResult);
        }

        @Test
        public void shouldReturnLastElementWhenListHaveSomeElements() {
            LinkedList list = LinkedList.of(3, 6, 11);
            Object actualResult = list.removeLast();
            Assertions.assertEquals(11, actualResult);
        }

        @Test
        public void removeLastShouldReturnLastElementWhenMethodWasCalledSeveralTimes() {
            LinkedList list = LinkedList.of(2, 7, 8, 9, 10);
            list.removeLast();
            list.removeLast();
            Object actualResult = list.removeLast();
            Assertions.assertEquals(8, actualResult);
        }

        @Test
        public void removeLastShouldDeleteLastNodeWhenLinkedListHaveSomeElements() {
            LinkedList list = LinkedList.of(2, 7, 8, 9, 10);
            list.removeLast();
            LinkedList expectedResult = LinkedList.of(2, 7, 8, 9);
            Assertions.assertTrue(list.equals(expectedResult));
        }

        @Test
        public void removeLastShouldDeleteLastNodeWhenLinkedListHaveOneElement() {
            LinkedList list = LinkedList.of(2);
            list.removeLast();
            LinkedList expectedResult = LinkedList.of();
            Assertions.assertTrue(list.equals(expectedResult));
        }
    }

    @Nested
    public class LinkkedList {
        @Test
        public void shouldCopyElementsFromAnotherLinkedList() {
            LinkedList firstList = LinkedList.of(1, 2, 3, 4);
            LinkedList secondList = new LinkedList(firstList);
            LinkedList expectedResult = LinkedList.of(1, 2, 3, 4);
            Assertions.assertTrue(secondList.equals(expectedResult));
        }

        @Test public void shouldWorkWhenAnotherLinkedHaveFirstNodeWithNullValue() {
            LinkedList firstList = new LinkedList();
            LinkedList secondList = new LinkedList(firstList);
            Assertions.assertEquals(secondList.getNode(), null);
        }
    }
}
