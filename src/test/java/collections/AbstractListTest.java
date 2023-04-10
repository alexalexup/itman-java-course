package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import train.Animal;
import train.Cat;

class AbstractListTest {
    @Nested
    public class Equals {
        @Test
        public void shouldReturnTrueWhenListsAreDifferentClassesAndHaveEqualsElements() {
            AbstractList firstList = ArrayList.of("Hi,", null, false, 2.34, 2, 3);
            AbstractList secondList = LinkedList.of("Hi,", null, false, 2.34, 2, 3);
            Assertions.assertTrue(firstList.equals(secondList));
        }

        @Test
        public void shouldReturnTrueWhenListsAreDifferentClassesAndHaveEqualsElementsFromSameClass() {
            AbstractList<String> firstList = ArrayList.of("Hi,", "null", "false", "2.34", "2", "3");
            AbstractList<String> secondList = LinkedList.of("Hi,", "null", "false", "2.34", "2", "3");
            Assertions.assertTrue(firstList.equals(secondList));
        }

        @Test
        public void shouldReturnTrueWhenListsAreSameClassesAndHaveEqualsElementsFromSameClass() {
            AbstractList<String> firstList = ArrayList.of("Hi,", "null", "false", "2.34", "2", "3");
            AbstractList<String> secondList = ArrayList.of("Hi,", "null", "false", "2.34", "2", "3");
            Assertions.assertTrue(firstList.equals(secondList));
        }

        @Test
        public void shouldReturnFalseWhenListsAreDifferentClassesAndHaveEqualsElementsAndHaveDifferentSizes() {
            AbstractList firstList = ArrayList.of("Hi,", null, false, 2.34, 2);
            AbstractList secondList = LinkedList.of("Hi,", null, false, 2.34, 2, 3);
            Assertions.assertFalse(firstList.equals(secondList));
        }

        @Test
        public void shouldReturnFalseWhenListsAreSameClassesAndHaveEqualsElementsAndHaveDifferentSizes() {
            AbstractList firstList = LinkedList.of("Hi,", null, false, 2.34, 2);
            AbstractList secondList = LinkedList.of("Hi,", null, false, 2.34, 2, 3);
            Assertions.assertFalse(firstList.equals(secondList));
        }

        @Test
        public void shouldReturnFalseWhenListsAreDifferentClassesAndHaveNotEqualsElements() {
            AbstractList firstList = ArrayList.of("Hi,", "Harry", false, 2.34, 2, 3);
            AbstractList secondList = LinkedList.of("Hi,", null, 100, 2.34, 2, 3);
            Assertions.assertFalse(firstList.equals(secondList));
        }

        @Test
        public void shouldReturnFalseWhenCompareDifferentElementsFomArrayListAndObject() {
           Assertions.assertFalse(ArrayList.of(1).equals("a"));
        }

        @Test
        public void shouldReturnFalseWhenCompareDifferentElementsFomLinkedListAndObject() {
            Assertions.assertFalse(LinkedList.of(1).equals("a"));
        }
    }

    @Nested
    public class AddAll {
        @Test
        public void shouldAddAllElementsToListFromSourceWhenSourceIsDifferentClass() {
            AbstractList firstList = ArrayList.of("Hi", true, 2, 2.34);
            AbstractList secondList = LinkedList.of(5, 5, null);
            firstList.addAll(secondList);
            Assertions.assertEquals(firstList, LinkedList.of("Hi", true, 2, 2.34, 5, 5, null));
        }

        @Test
        public void shouldAddAllElementsToListFromSourceWhenSourceIsSameClass() {
            AbstractList firstList = ArrayList.of("Hi", true, 2, 2.34);
            AbstractList secondList = ArrayList.of(5, 5, null);
            firstList.addAll(secondList);
            Assertions.assertEquals(firstList, ArrayList.of("Hi", true, 2, 2.34, 5, 5, null));
        }

        @Test
        public void shouldAddAllElementsToListFromSourceWhenSourceAndDestinationAreLinkedList() {
            AbstractList firstList = LinkedList.of("Hi", true, 2, 2.34);
            AbstractList secondList = LinkedList.of(5, 5, null);
            firstList.addAll(secondList);
            Assertions.assertEquals(firstList, LinkedList.of("Hi", true, 2, 2.34, 5, 5, null));
        }

        @Test
        public void shouldReturnFalseWhenSourceHaveNotElements() {
            AbstractList firstList = LinkedList.of("Hi", true, 2, 2.34);
            AbstractList secondList = ArrayList.of();
            Assertions.assertFalse(firstList.addAll(secondList));
        }

        @Test
        public void shouldReturnTrueWhenSourceHaveSomeElements() {
            AbstractList firstList = LinkedList.of("Hi", true, 2, 2.34);
            AbstractList secondList = ArrayList.of(4.4, null, true, true);
            Assertions.assertTrue(firstList.addAll(secondList));
        }
    }

    @Nested
    public class AddAllByIndex {
        @Test
        public void shouldAddAllElementsByIndexToListFromSourceWhenSourceIsDifferentClass() {
            AbstractList firstList = ArrayList.of("Hi", true, 2, 2.34);
            AbstractList secondList = LinkedList.of(5, 5, null, 6, 8, "Hello");
            firstList.addAll(3, secondList);
            Assertions.assertEquals(firstList, LinkedList.of("Hi", true, 2, 5, 5, null, 6, 8, "Hello", 2.34));
        }

        @Test
        public void shouldAddAllElementsByIndexToListFromSourceWhenSourceIsSameClass() {
            AbstractList firstList = ArrayList.of("Hi", true, 2, 2.34);
            AbstractList secondList = ArrayList.of(5, 5, null, 6, 8, "Hello");
            firstList.addAll(0, secondList);
            Assertions.assertEquals(firstList, LinkedList.of(5, 5, null, 6, 8, "Hello", "Hi", true, 2, 2.34));
        }

        @Test
        public void shouldAddAllElementsByIndexToListWhenSourceAndDestinationAreLinkedList() {
            AbstractList firstList = LinkedList.of("Hi", true, 2, 2.34, 9, 9, 9, 9, 9, 9, 9);
            AbstractList secondList = LinkedList.of(5, 5, null, 6, 8, "Hello");
            firstList.addAll(4, secondList);
            Assertions.assertEquals(firstList, LinkedList.of("Hi", true, 2, 2.34, 5, 5, null, 6, 8, "Hello", 9, 9, 9, 9, 9, 9, 9));
        }
        
        @Test
        public void shouldReturnFalseWhenSourceHaveNotElements() {
            AbstractList firstList = LinkedList.of("Hi", true, 2, 2.34);
            AbstractList secondList = LinkedList.of();
            firstList.addAll(0, secondList);
            Assertions.assertFalse(firstList.addAll(0, secondList));
        }

        @Test
        public void shouldReturnTrueWhenSourceHaveSomeElements() {
            AbstractList firstList = LinkedList.of("Hi", true, 2, 2.34);
            AbstractList secondList = LinkedList.of(null, "B", 4, 4);
            firstList.addAll(0, secondList);
            Assertions.assertTrue(firstList.addAll(1, secondList));
        }
    }

    @Nested
    public class Contains {
        @Test
        public void shouldReturnTrueWhenListHaveElementFromSource() {
            AbstractList firsList = ArrayList.of(1, "HI", null, 2, -1, 2.34);
            AbstractList secondList = LinkedList.of(1, "HI", null, 2, -1, 2.34);
            Assertions.assertTrue(firsList.contains("HI") && secondList.contains(2.34));
        }

        @Test
        public void shouldReturnFalseWhenListHaveNotElementFromSource() {
            AbstractList firsList = ArrayList.of(1, "HI", null, 2, -1, 2.34);
            AbstractList secondList = LinkedList.of(1, "HI", null, 2, -1, 2.34);
            Assertions.assertFalse(firsList.contains(55) || secondList.contains(102));
        }

        @Test
        public void shouldReturnTrueWhenListHaveElementFromSourceSecondOption() {
            AbstractList firsList = ArrayList.of(1,"HI", null , 2,  -1, 2.34);
            AbstractList secondList = LinkedList.of(1,"HI", null , 2,  -1, 2.34);
            Assertions.assertTrue(firsList.contains(2) && secondList.contains(-1));
        }

        @Nested
        public class insertBefore{
            @Test
            public void shouldInsertElementToTheArrayListFromIteratorBeforeCurrentIndex() {
                AbstractList<Integer> list = ArrayList.of(1, 2, 3, 4, 5);
                ListIterator<Integer> iterator = list.iterator();
                iterator.next();
                iterator.insertBefore(100);
                Assertions.assertEquals(ArrayList.of(100, 1, 2, 3, 4, 5), list);
            }

            @Test
            public void shouldNotInsertElementToTheArrayListFromIteratorWhenElemntsWasNotCalledFromIterator() {
                AbstractList<Integer> list = new ArrayList<>();
                ListIterator<Integer> iterator = list.iterator();
                iterator.insertBefore(100);
                Assertions.assertEquals(ArrayList.of(), list);
            }

            @Test
            public void shouldInsertElementToTheArrayListFromIteratorBeforeCurrentIndexWhenIndexIsPenultimate() {
                AbstractList<Integer> list = ArrayList.of(1, 2, 3, 4, 5);
                ListIterator<Integer> iterator = list.iterator();
                iterator.next();
                iterator.next();
                iterator.next();
                iterator.insertBefore(100);
                Assertions.assertEquals(ArrayList.of(1, 2, 100, 3, 4, 5), list);
            }

            @Test
            public void shouldInsertElementToTheArrayListFromIteratorBeforeCurrentIndexWhenIndexIsLast() {
                AbstractList<Integer> list = ArrayList.of(1, 2, 3, 4, 5);
                ListIterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()) {
                    iterator.next();
                }
                iterator.insertBefore(100);
                Assertions.assertEquals(ArrayList.of(1, 2, 3, 4, 100, 5), list);
            }

            @Test
            public void shouldInsertElementToTheLinkedListFromIteratorBeforeCurrentIndex() {
                AbstractList<Integer> list = LinkedList.of(1, 2, 3, 4, 5);
                ListIterator<Integer> iterator = list.iterator();
                iterator.next();
                iterator.insertBefore(100);
                Assertions.assertEquals(LinkedList.of(100, 1, 2, 3, 4, 5), list);
            }

            @Test
            public void shouldNotInsertElementToTheLinkedListFromIteratorWhenElemntsWasNotCalledFromIterator() {
                AbstractList<Integer> list = new LinkedList<>();
                ListIterator<Integer> iterator = list.iterator();
                iterator.insertBefore(100);
                Assertions.assertEquals(LinkedList.of(), list);
            }

            @Test
            public void shouldInsertElementToTheLinkedListFromIteratorBeforeCurrentIndexWhenIndexIsPenultimate() {
                AbstractList<Integer> list = LinkedList.of(1, 2, 3, 4, 5);
                ListIterator<Integer> iterator = list.iterator();
                iterator.next();
                iterator.next();
                iterator.next();
                iterator.insertBefore(100);
                Assertions.assertEquals(LinkedList.of(1, 2, 100, 3, 4, 5), list);
            }

            @Test
            public void shouldInsertElementToTheLinkedListFromIteratorBeforeCurrentIndexWhenIndexIsLast() {
                AbstractList<Integer> list = LinkedList.of(1, 2, 3, 4, 5);
                ListIterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()) {
                    iterator.next();
                }
                iterator.insertBefore(100);
                Assertions.assertEquals(LinkedList.of(1, 2, 3, 4, 100, 5), list);
            }
        }

        @Nested
        public class add {
            @Test
            public void shouldAddElementByIndexToTheListWhenIndexIsFirstAndListIsArrayList(){
                AbstractList<Integer> list = ArrayList.of(1, 2, 3, 4);
                list.add(0,100);
                Assertions.assertEquals(ArrayList.of(100, 1, 2, 3, 4), list);
            }

            @Test
            public void shouldAddElementByIndexToTheListWhenIndexIsFirstAndListIsLinkedList(){
                AbstractList<Integer> list = LinkedList.of(1, 2, 3, 4);
                list.add(0,100);
                Assertions.assertEquals(ArrayList.of(100, 1, 2, 3, 4), list);
            }

            @Test
            public void shouldAddElementByIndexToTheListWhenIndexIsLastAndListIsArrayList(){
                AbstractList<Integer> list = ArrayList.of(1, 2, 3, 4);
                list.add(3,100);
                Assertions.assertEquals(ArrayList.of(1, 2, 3, 100, 4), list);
            }

            @Test
            public void shouldAddElementByIndexToTheListWhenIndexIsLastAndListIsLinkedList(){
                AbstractList<Integer> list = LinkedList.of(1, 2, 3, 4);
                list.add(3,100);
                Assertions.assertEquals(ArrayList.of(1, 2, 3, 100, 4), list);
            }

            @Test
            public void shouldAddElementByIndexToTheListWhenIndexInTheMiddletAndListIsArrayList(){
                AbstractList<Integer> list = ArrayList.of(1, 2, 3, 4);
                list.add(2,100);
                Assertions.assertEquals(ArrayList.of(1, 2, 100, 3, 4), list);
            }

            @Test
            public void shouldAddElementByIndexToTheListWhenIndexInTheMiddletAndListIsLinkedList(){
                AbstractList<Integer> list = LinkedList.of(1, 2, 3, 4);
                list.add(2,100);
                Assertions.assertEquals(ArrayList.of(1, 2, 100, 3, 4), list);
            }

            @Test
            public void shouldReturnTrueWhenAddElementToTheArrayList(){
                AbstractList<Integer> list = ArrayList.of(1, 2, 3, 4, 5);
                Assertions.assertTrue(list.add(3,100));
            }

            @Test
            public void shouldReturnTrueWhenAddElementToTheLinkedList(){
                AbstractList<Integer> list = LinkedList.of(1, 2, 3, 4, 5);
                Assertions.assertTrue(list.add(3,100));
            }

            @Test
            public void shouldNotAddElementToTheLinkedListWhenIndexIsOutOfRange() {
                AbstractList<Integer> list = LinkedList.of(1, 2, 3, 4, 5);
                list.add(6,100);
                Assertions.assertEquals(ArrayList.of(1, 2, 3, 4, 5), list);
            }

            @Test
            public void shouldNotAddElementToTheArrayListWhenIndexIsOutOfRange() {
                AbstractList<Integer> list = ArrayList.of(1, 2, 3, 4, 5);
                list.add(20,100);
                Assertions.assertEquals(ArrayList.of(1, 2, 3, 4, 5), list);
            }

            @Test
            public void shouldReturnFalseWhenElementWasNotAddedToTheLinkedList() {
                AbstractList<Integer> list = LinkedList.of(1, 2, 3, 4, 5);
                Assertions.assertFalse(list.add(25,100));
            }

            @Test
            public void shouldReturnFalseWhenElementWasNotAddedToTheArrayList() {
                AbstractList<Integer> list = ArrayList.of(1, 2, 3, 4, 5);
                Assertions.assertFalse(list.add(18,100));
            }
        }
    }
}