package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListsTest {
    @Nested
    public class Equals {
        @Test
        public void shouldReturnTrueWhenListsAreDifferentClassesAndHaveEqualsElements() {
            Lists firstList = ArrayList.of("Hi,", null, false, 2.34, 2, 3);
            Lists secondList = LinkedList.of("Hi,", null, false, 2.34, 2, 3);
            Assertions.assertTrue(firstList.equals(secondList));
        }

        @Test
        public void shouldReturnTrueWhenListsAreDifferentClassesAndHaveEqualsElementsFromSameClass() {
            Lists<String> firstList = ArrayList.of("Hi,", "null", "false", "2.34", "2", "3");
            Lists<String> secondList = LinkedList.of("Hi,", "null", "false", "2.34", "2", "3");
            Assertions.assertTrue(firstList.equals(secondList));
        }

        @Test
        public void shouldReturnTrueWhenListsAreSameClassesAndHaveEqualsElementsFromSameClass() {
            Lists<String> firstList = ArrayList.of("Hi,", "null", "false", "2.34", "2", "3");
            Lists<String> secondList = ArrayList.of("Hi,", "null", "false", "2.34", "2", "3");
            Assertions.assertTrue(firstList.equals(secondList));
        }

        @Test
        public void shouldReturnFalseWhenListsAreDifferentClassesAndHaveEqualsElementsAndHaveDifferentSizes() {
            Lists firstList = ArrayList.of("Hi,", null, false, 2.34, 2);
            Lists secondList = LinkedList.of("Hi,", null, false, 2.34, 2, 3);
            Assertions.assertFalse(firstList.equals(secondList));
        }

        @Test
        public void shouldReturnFalseWhenListsAreSameClassesAndHaveEqualsElementsAndHaveDifferentSizes() {
            Lists firstList = LinkedList.of("Hi,", null, false, 2.34, 2);
            Lists secondList = LinkedList.of("Hi,", null, false, 2.34, 2, 3);
            Assertions.assertFalse(firstList.equals(secondList));
        }

        @Test
        public void shouldReturnFalseWhenListsAreDifferentClassesAndHaveNotEqualsElements() {
            Lists firstList = ArrayList.of("Hi,", "Harry", false, 2.34, 2, 3);
            Lists secondList = LinkedList.of("Hi,", null, 100, 2.34, 2, 3);
            Assertions.assertFalse(firstList.equals(secondList));
        }
    }

    @Nested
    public class AddAll {
        @Test
        public void shouldAddAllElementsToListFromSourceWhenSourceIsDifferentClass() {
            Lists firstList = ArrayList.of("Hi", true, 2, 2.34);
            Lists secondList = LinkedList.of(5, 5, null);
            firstList.addAll(secondList);
            Assertions.assertEquals(firstList, LinkedList.of("Hi", true, 2, 2.34, 5, 5, null));
        }

        @Test
        public void shouldAddAllElementsToListFromSourceWhenSourceIsSameClass() {
            Lists firstList = ArrayList.of("Hi", true, 2, 2.34);
            Lists secondList = ArrayList.of(5, 5, null);
            firstList.addAll(secondList);
            Assertions.assertEquals(firstList, ArrayList.of("Hi", true, 2, 2.34, 5, 5, null));
        }

        @Test
        public void shouldAddAllElementsToListFromSourceWhenSourceAndDestinationAreLinkedList() {
            Lists firstList = LinkedList.of("Hi", true, 2, 2.34);
            Lists secondList = LinkedList.of(5, 5, null);
            firstList.addAll(secondList);
            Assertions.assertEquals(firstList, LinkedList.of("Hi", true, 2, 2.34, 5, 5, null));
        }

        @Test
        public void shouldReturnFalseWhenSourceHaveNotElements() {
            Lists firstList = LinkedList.of("Hi", true, 2, 2.34);
            Lists secondList = ArrayList.of();
            Assertions.assertFalse(firstList.addAll(secondList));
        }

        @Test
        public void shouldReturnTrueWhenSourceHaveSomeElements() {
            Lists firstList = LinkedList.of("Hi", true, 2, 2.34);
            Lists secondList = ArrayList.of(4.4, null, true, true);
            Assertions.assertTrue(firstList.addAll(secondList));
        }
    }

    @Nested
    public class AddAllByIndex {
        @Test
        public void shouldAddAllElementsByIndexToListFromSourceWhenSourceIsDifferentClass() {
            Lists firstList = ArrayList.of("Hi", true, 2, 2.34);
            Lists secondList = LinkedList.of(5, 5, null, 6, 8, "Hello");
            firstList.addAll(3, secondList);
            Assertions.assertEquals(firstList, LinkedList.of("Hi", true, 2, 5, 5, null, 6, 8, "Hello", 2.34));
        }

        @Test
        public void shouldAddAllElementsByIndexToListFromSourceWhenSourceIsSameClass() {
            Lists firstList = ArrayList.of("Hi", true, 2, 2.34);
            Lists secondList = ArrayList.of(5, 5, null, 6, 8, "Hello");
            firstList.addAll(3, secondList);
            Assertions.assertEquals(firstList, LinkedList.of("Hi", true, 2, 5, 5, null, 6, 8, "Hello", 2.34));
        }

        @Test
        public void shouldAddAllElementsByIndexToListWhenSourceAndDestinationAreLinkedList() {
            Lists firstList = LinkedList.of("Hi", true, 2, 2.34);
            Lists secondList = LinkedList.of(5, 5, null, 6, 8, "Hello");
            firstList.addAll(0, secondList);
            Assertions.assertEquals(firstList, LinkedList.of(5, 5, null, 6, 8, "Hello", "Hi", true, 2, 2.34));
        }

        @Test
        public void shouldReturnFalseWhenSourceHaveNotElements() {
            Lists firstList = LinkedList.of("Hi", true, 2, 2.34);
            Lists secondList = LinkedList.of();
            firstList.addAll(0, secondList);
            Assertions.assertFalse(firstList.addAll(0, secondList));
        }

        @Test
        public void shouldReturnTrueWhenSourceHaveSomeElements() {
            Lists firstList = LinkedList.of("Hi", true, 2, 2.34);
            Lists secondList = LinkedList.of(null, "B", 4, 4);
            firstList.addAll(0, secondList);
            Assertions.assertTrue(firstList.addAll(1, secondList));
        }
    }

    @Nested
    public class Contains {
        @Test
        public void shouldReturnTrueWhenListHaveElementFromSource() {
            Lists firsList = ArrayList.of(1, "HI", null, 2, -1, 2.34);
            Lists secondList = LinkedList.of(1, "HI", null, 2, -1, 2.34);
            Assertions.assertTrue(firsList.contains("HI") && secondList.contains(2.34));
        }

        @Test
        public void shouldReturnFalseWhenListHaveNotElementFromSource() {
            Lists firsList = ArrayList.of(1, "HI", null, 2, -1, 2.34);
            Lists secondList = LinkedList.of(1, "HI", null, 2, -1, 2.34);
            Assertions.assertFalse(firsList.contains(55) || secondList.contains(102));
        }

        @Test
        public void shouldReturnTrueWhenListHaveElementFromSourceAndThisElementIsNull() {
            Lists firsList = ArrayList.of(1,"HI", null , 2,  -1, 2.34);
            Lists secondList = LinkedList.of(1,"HI", null , 2,  -1, 2.34);
            Assertions.assertTrue(firsList.contains(null) && secondList.contains(null));
        }
    }
}