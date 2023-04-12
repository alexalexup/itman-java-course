package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

abstract public  class AbstractListTests  {
    abstract protected List of(Object... elements);

    @Nested
    public class Add {
        @Test
        public void shouldAddElementWhenListIsEmpty() {
            List list = of();
            list.add(1);
            Assertions.assertArrayEquals(new Object[]{1}, list.toArray());
        }

        @Test
        public void shouldAddElementMultiplyTimes() {
            List list = of();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            Assertions.assertArrayEquals(new Object[]{1, 2, 3, 4, 5}, list.toArray());
        }

        @Test
        public void shouldAddElementWhenElementIsNull() {
            List list = of();
            list.add(null);
            list.add(null);
            list.add(null);
            Assertions.assertArrayEquals(new Object[]{null, null, null}, list.toArray());
        }

        @Test
        public void shouldAddElementWhenElementIsFromDifferentTypes() {
            List list =of();
            list.add(1);
            list.add(null);
            list.add(true);
            list.add("Hi");
            Assertions.assertArrayEquals(new Object[]{1, null, true, "Hi"}, list.toArray());
        }

        @Test
        public void shouldAddElementWhenListHaveSomeElements() {
            List list = of(1, 3, 4);
            list.add(5);
            list.add(null);
            list.add(5);
            Assertions.assertArrayEquals(new Object[]{1, 3, 4, 5, null, 5}, list.toArray());
        }

        @Test
        public void shouldAddNullToEmptyArray() {
            List list = of();
            list.add(null);
            Assertions.assertArrayEquals(new Object[]{null}, list.toArray());
        }
    }

    @Nested
    public class Contains {
        @Test
        public void shouldReturnTrueWhenListHaveElementFromSource() {
            List firsList = of(1, "HI", null, 2, -1, 2.34);
            List secondList = of(1, "HI", null, 2, -1, 2.34);
            Assertions.assertTrue(firsList.contains("HI") && secondList.contains(2.34));
        }

        @Test
        public void shouldReturnFalseWhenListHaveNotElementFromSource() {
            List firsList = of(1, "HI", null, 2, -1, 2.34);
            List secondList = of(1, "HI", null, 2, -1, 2.34);
            Assertions.assertFalse(firsList.contains(55) || secondList.contains(102));
        }

        @Test
        public void shouldReturnTrueWhenListHaveElementFromSourceSecondOption() {
            List firsList = of(1,"HI", null , 2,  -1, 2.34);
            List secondList = of(1,"HI", null , 2,  -1, 2.34);
            Assertions.assertTrue(firsList.contains(2) && secondList.contains(-1));
        }
    }

    @Nested
    public class Set {
        @Test
        public void shouldSetElementWhenListHaveSomeElement() {
            List list = of(1, 2, 3, 5);
            list.set(3, 10);
            Assertions.assertArrayEquals(new Object[]{1, 2, 3, 10}, list.toArray());
        }

        @Test
        public void shouldSetElementWhenListHaveOneElement() {
            List list = of(5);
            list.set(0, 100);
            Assertions.assertArrayEquals(new Object[]{100}, list.toArray());
        }

        @Test
        public void shouldSetElementSeveralTimesWhenElementsFromDifferentTypes() {
            List list = of(1, 2, 3, 4);
            list.set(0, 100);
            list.set(1, "Hi");
            list.set(2, true);
            Assertions.assertArrayEquals(new Object[]{100, "Hi", true, 4}, list.toArray());
        }
    }

    @Nested
    public class Get {
        @Test
        public void shouldGetElementWhenListHaveOneElement() {
            List list = of(100);
            Assertions.assertEquals(100, list.get(0));
        }

        @Test
        public void shouldGetElementWhenListHaveSomeElements() {
            List list = of(100, null, "Hi");
            Assertions.assertEquals(100, list.get(0));
            Assertions.assertEquals(null, list.get(1));
            Assertions.assertEquals("Hi", list.get(2));
        }
    }

    @Nested
    public class Size {
        @Test
        public void shouldReturnSizeWhenListHaveSomeElement() {
            List list = of(1, 2, 3, 4);
            Assertions.assertEquals(4, list.size());
        }

        @Test
        public void shouldReturnSizeWhenListHaveOneElement() {
            List list = of(10);
            Assertions.assertEquals(1, list.size());
        }

        @Test
        public void shouldReturnSizeWhenListHaveNotElements() {
            List list = of();
            Assertions.assertEquals(0, list.size());
        }

        @Test
        public void shouldReturnSizeWhenListHaveNull() {
            List list = of(null, null, null);
            Assertions.assertEquals(3, list.size());
        }

        @Test
        public void shouldReturnSizeWhenListHaveObjectsFromDifferentClasses() {
            List list = of(null, 1, "null", 2.25, true);
            Assertions.assertEquals(5, list.size());
        }
    }

    @Nested
    public class ToArray {
        @Test
        public void shouldReturnArrayWhenListHaveSomeElementsFromDifferentTypes() {
            List list = of(1, null, "hi", true, 3.14);
            Assertions.assertArrayEquals(new Object[]{1, null, "hi", true, 3.14}, list.toArray());
        }

        @Test
        public void shouldReturnArrayWhenElementsAreNull() {
            List list = of(null, null, null);
            Assertions.assertArrayEquals(new Object[]{null, null, null}, list.toArray());
        }

        @Test
        public void shouldReturnArrayWhenListHaveOneElement() {
            List list = of(54);
            Assertions.assertArrayEquals(new Object[]{54}, list.toArray());
        }

        @Test
        public void shouldReturnEmptyArrayWhenListHaveNotElements() {
            List list = of();
            Assertions.assertArrayEquals(new Object[]{}, list.toArray());
        }
    }

    @Nested
    public class RemoveByIndex {
        @Test
        public void shouldReturnElementByIndexWhenListHaveSomeElements() {
            List list = of (1, 2, 3, 4);
            Assertions.assertEquals(3, list.remove(2));
        }

        @Test
        public void shouldReturnElementByIndexWhenListHaveOneElement() {
            List list = of (5);
            Assertions.assertEquals(5, list.remove(0));
        }

        @Test
        public void shouldRemoveElementByIndexWhenListHaveSomeElements() {
            List list = of (1, 2, 3, 4, 6, 7);
            list.remove(2);
            Assertions.assertArrayEquals(new Object[] {1, 2, 4, 6, 7}, list.toArray());
        }

        @Test
        public void shouldRemoveElementByIndexWhenListHaveOneElement() {
            List list = of (100);
            list.remove(0);
            Assertions.assertArrayEquals(new Object[] {}, list.toArray());
        }

        @Test
        public void shouldRemoveElementByIndexWhenSelectedElementIsNull() {
            List list = of (1, 2, null, 4, 5);
            list.remove(2);
            Assertions.assertArrayEquals(new Object[] {1, 2, 4, 5}, list.toArray());
        }
    }

    @Nested
    public class ToString{
        @Test
        public void shouldReturnStringWhenListHaveSomeElements() {
            List list = of (1, 2, null, "Hi");
            Assertions.assertTrue("[1, 2, null, Hi]".equals(list.toString()));
        }

        @Test
        public void shouldReturnStringWhenListHaveOneElementThatIsNull() {
            List list = of(1);
        }

        @Test
        public void shouldReturnStringWhenListHaveSomeNumbers() {
            List list = of(1, 2, 3, 4);
            Assertions.assertTrue("[1, 2, 3, 4]".equals(list.toString()));
        }

        @Test
        public void shouldReturnStringWhenListHaveOnlyNull() {
            List list = of(null, null, null, null);
            Assertions.assertTrue("[null, null, null, null]".equals(list.toString()));
        }
    }

    @Nested
    public class Of {
        @Test
        public void shouldCreateArrayWithObjectsWhenArgumentsAreNumbers() {
            List list = of (1, 2, 3, 4, 5);
            Assertions.assertArrayEquals(new Object[]{1, 2, 3, 4, 5}, list.toArray());
        }

        @Test
        public void shouldCreateArrayWithObjectWhenArgumentIsNumber() {
            List list = of (5);
            Assertions.assertArrayEquals(new Object[]{5}, list.toArray());
        }

        @Test
        public void shouldCreateArrayWithObjectsWhenArgumentsAreNull() {
            List list = of (null, null, null);
            Assertions.assertArrayEquals(new Object[]{null, null, null}, list.toArray());
;        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldCompareWhenListHaveSameNumbers() {
            List first = of(1, 2, 3, 4);
            List second = of (1, 2, 3, 4);
            Assertions.assertEquals(first, second);
        }

        @Test
        public void shouldCompareWhenListHaveNotSameNumbers() {
            List first = of(1, 3, 3, 4);
            List second = of (1, 2, 3, 4);
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void shouldCompareWhenListHaveSameElementsAndTheyAreFromDifferentClasses() {
            List first = of("Hi", 2, 3.15, null);
            List second = of ("Hi", 2, 3.15, null);
            Assertions.assertEquals(first, second);
        }

        @Test
        public void shouldCompareWhenListHaveNotSameElementsAndTheyAreFromDifferentClasses() {
            List first = of("Hi", 2, 3.15, 10);
            List second = of ("Hi", 2, 3.15, null);
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void shouldCompareWhenOneListHaveNotElementsAndSecondHave() {
            List first = of();
            List second = of (100);
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void shouldCompareWhenListsHaveDifferentSizes() {
            List first = of(1, 2, null, 5);
            List second = of (2, 3, 3, 3, 3, 3);
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void shouldReturnFalseWhenCompareDifferentElementsFromObjectAndList() {
            Assertions.assertFalse(of(1).equals("a"));
        }
    }

    @Nested
    public class IsEmpty {

        @Test
        public void shouldReturnFalseWhenListHaveSomeElements() {
            List list = of (1, "A", null , 2.4);
            Assertions.assertFalse(list.isEmpty());
        }

        @Test
        public void shouldReturnTrueWhenListHaveNotAnyElements() {
            List list = of ();
            Assertions.assertTrue(list.isEmpty());
        }

        @Test
        public void shouldReturnFalseWhenListHaveOneElement() {
            List list = of ("Hi");
            Assertions.assertFalse(list.isEmpty());
        }
    }

    @Nested
    public class AddAll {
        @Test
        public void shouldAddElementsFromWhenSourceHaveSomeElements() {
            List firstList = of(1, 2, 3, 4);
            List secondList = new LinkedList();
            secondList.add(5);
            secondList.add(5);
            secondList.add(5);
            List expectedResult = of (1, 2, 3, 4, 5, 5, 5);
            firstList.addAll(secondList);
            Assertions.assertEquals(firstList, expectedResult);
        }
        @Test
        public void shouldAddAllElementsToListFromSourceWhenSourceIsDifferentClass() {
            List firstList = of("Hi", true, 2, 2.34);
            List secondList = of(5, 5, null);
            firstList.addAll(secondList);
            Assertions.assertEquals(firstList, LinkedList.of("Hi", true, 2, 2.34, 5, 5, null));
        }

        @Test
        public void shouldAddAllElementsToListFromSourceWhenSourceIsSameClass() {
            List firstList = of("Hi", true, 2, 2.34);
            List secondList = of(5, 5, null);
            firstList.addAll(secondList);
            Assertions.assertEquals(firstList, ArrayList.of("Hi", true, 2, 2.34, 5, 5, null));
        }

        @Test
        public void shouldAddAllElementsToListFromSourceWhenSourceAndDestinationAreLinkedList() {
            List firstList = of("Hi", true, 2, 2.34);
            List secondList = of(5, 5, null);
            firstList.addAll(secondList);
            Assertions.assertEquals(firstList, LinkedList.of("Hi", true, 2, 2.34, 5, 5, null));
        }

        @Test
        public void shouldReturnFalseWhenSourceHaveNotElements() {
            List firstList = of("Hi", true, 2, 2.34);
            List secondList = of();
            Assertions.assertFalse(firstList.addAll(secondList));
        }

        @Test
        public void shouldReturnTrueWhenSourceHaveSomeElements() {
            List firstList = of("Hi", true, 2, 2.34);
            List secondList = of(4.4, null, true, true);
            Assertions.assertTrue(firstList.addAll(secondList));
        }
    }

    @Nested
    public class AddAllByIndex {
        @Test
        public void shouldAddAllElementsByIndexToListFromSourceWhenIndexIsTwo() {
            List firstList = of("Hi", true, 2, 2.34);
            List secondList = of(5, 5, null, 6, 8, "Hello");
            firstList.addAll(2, secondList);
            Assertions.assertEquals(firstList, of("Hi", true, 5, 5, null, 6, 8, "Hello", 2, 2.34));
        }

        @Test
        public void shouldAddAllElementsByIndexToListFromSourceWhenSourceIsSameClass() {
            List firstList = of("Hi", true, 2, 2.34);
            List secondList = of(5, 5, null, 6, 8, "Hello");
            firstList.addAll(0, secondList);
            Assertions.assertEquals(firstList, of(5, 5, null, 6, 8, "Hello", "Hi", true, 2, 2.34));
        }

        @Test
        public void shouldAddAllElementsByIndexToList() {
            List firstList = of("Hi", true, 2, 2.34, 9, 9, 9, 9, 9, 9, 9);
            List secondList = of(5, 5, null, 6, 8, "Hello");
            firstList.addAll(4, secondList);
            Assertions.assertEquals(firstList, of("Hi", true, 2, 2.34, 5, 5, null, 6, 8, "Hello", 9, 9, 9, 9, 9, 9, 9));
        }

        @Test
        public void shouldReturnFalseWhenSourceHaveNotElements() {
            List firstList = of("Hi", true, 2, 2.34);
            List secondList = of();
            firstList.addAll(0, secondList);
            Assertions.assertFalse(firstList.addAll(0, secondList));
        }

        @Test
        public void shouldReturnTrueWhenSourceHaveSomeElements() {
            List  firstList =  of("Hi", true, 2, 2.34);
            List  secondList = of(null, "B", 4, 4);
            firstList.addAll(0, secondList);
            Assertions.assertTrue(firstList.addAll(1, secondList));
        }
    }

    @Nested
    public class RemoveByElement {
        @Test
        public void shouldRemoveElementWhenElementIsRepeatedSeveralTimes() {
            List list = of(1, 2, 2, 3, 4, 2, 5);
            list.remove(new Integer(2));
            Assertions.assertEquals(of(1, 3, 4, 5), list);
        }

        @Test
        public void shouldRemoveElementWhenElementMeetsOnce() {
            List list = of(1, 2, 2, 3, 4, 2, 5);
            list.remove(new Integer(4));
            Assertions.assertEquals(of(1, 2, 2, 3, 2, 5), list);
        }

        @Test
        public void shouldNotRemoveElementWhenListHaveNotElementFromArgument() {
            List list = of(1, 2, 2, 3, 4, 2, 5);
            list.remove(new Integer(23));
            Assertions.assertEquals(of(1, 2, 2, 3, 4, 2, 5), list);
        }

        @Test
        public void shouldNotRemoveElementWhenListHaveNotElements() {
            List list = of();
            list.remove(new Integer(4));
            Assertions.assertEquals(of(), list);
        }
    }

    @Nested
    public class Next{
        @Test
        public void shouldReturnFirstElementWhenMethodWasCalleOnce() {
            List list = of(4, 3, 2, 1, 1);
            ListIterator  iterator = list.iterator();
            Assertions.assertEquals(4, iterator.next());
        }

        @Test
        public void shouldReturnThirdElementWhenMethodWasCalleThreeTimes() {
            List list = of(4, 3, 2, 1, 1);
            ListIterator  iterator = list.iterator();
            iterator.next();
            iterator.next();
            Assertions.assertEquals(2, iterator.next());
        }

        @Test
        public void shouldReturnLastElementWhenMethodWasCalledByTheNumberOfElements() {
            List lists = of(4, 3, 2, 10, 1);
            ListIterator  iterator = lists.iterator();
            iterator.next();
            iterator.next();
            iterator.next();
            iterator.next();
            Assertions.assertEquals(1, iterator.next());
        }
    }

    @Nested
    public class HasNext{
        @Test
        public void shouldReturnTrueWhenIteratorHaveElements() {
            List list = of(1, 2, 3, 4);
            ListIterator iterator = list.iterator();
            iterator.next();
            iterator.next();
            Assertions.assertTrue(iterator.hasNext());
        }

        @Test
        public void shouldReturnTrueWhenIteratorHaveNotElements() {
            List list = of(1, 2, 3, 4);
            ListIterator iterator = list.iterator();
            iterator.next();
            iterator.next();
            iterator.next();
            iterator.next();
            Assertions.assertFalse(iterator.hasNext());
        }
    }

    @Nested
    public class SetIterator{
        @Test
        public void shouldSetElementToFirstPositionWhenNextWasCalledOnceFromTheIterator(){
            List list = of(1, 2, 3, 4);
            ListIterator iterator = list.iterator();
            iterator.next();
            iterator.set(100);
            Assertions.assertEquals(of(100,2, 3, 4), list);
        }

        @Test
        public void shouldSetElementToThePositionThatWasCalledFromTheIterator(){
            List list = of(1, 2, 3, 4);
            ListIterator iterator = list.iterator();
            iterator.next();
            iterator.next();
            iterator.next();
            iterator.set(100);
            Assertions.assertEquals(of(1 ,2, 100, 4), list);
        }

        @Test
        public void shouldSetElementToTheLastPositionWhenIteratorWasCalledLastPosition(){
            List list = of(1, 2, 3, 4);
            ListIterator iterator = list.iterator();
            iterator.next();
            iterator.next();
            iterator.next();
            iterator.set(100);
            Assertions.assertEquals(of(1 ,2, 100, 4), list);
        }
    }

    @Nested
    public class InsertBefore {
        @Test
        public void shouldNotInsertElementToTheListFromIteratorWhenArrayListHaveNotElements() {
            List<Integer> list = of();
            ListIterator<Integer> iterator = list.iterator();
            iterator.insertBefore(100);
            Assertions.assertEquals(ArrayList.of(), list);
        }

        @Test
        public void shouldNotInsertElementToTheListWhenElemntsWasNotCalledFromIterator() {
            List<Integer> list = of(1, 2, 3, 4, 5);
            ListIterator<Integer> iterator = list.iterator();
            iterator.insertBefore(100);
            Assertions.assertEquals(ArrayList.of(1, 2, 3, 4, 5), list);
        }

        @Test
        public void shouldInsertElementToTheListFromIteratorBeforeCurrentIndexWhenIndexIsPenultimate() {
            List<Integer> list = of(1, 2, 3, 4, 5);
            ListIterator<Integer> iterator = list.iterator();
            iterator.next();
            iterator.next();
            iterator.next();
            iterator.insertBefore(100);
            Assertions.assertEquals(of(1, 2, 100, 3, 4, 5), list);
        }

        @Test
        public void shouldInsertElementToTheListFromIteratorBeforeCurrentIndexWhenIndexIsLast() {
            List<Integer> list = of(1, 2, 3, 4, 5);
            ListIterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                iterator.next();
            }
            iterator.insertBefore(100);
            Assertions.assertEquals(of(1, 2, 3, 4, 100, 5), list);
        }
    }

    @Nested
    public class AddForAbstractList {
        @Test
        public void shouldAddElementByIndexToTheListWhenIndexIsFirst(){
            List<Integer> list = of(1, 2, 3, 4);
            list.add(0,100);
            Assertions.assertEquals(ArrayList.of(100, 1, 2, 3, 4), list);
        }

        @Test
        public void shouldAddElementByIndexToTheListWhenIndexIsLast(){
            List<Integer> list = of(1, 2, 3, 4);
            list.add(3,100);
            Assertions.assertEquals(ArrayList.of(1, 2, 3, 100, 4), list);
        }

        @Test
        public void shouldAddElementByIndexToTheListWhenIndexInTheMiddle(){
            List<Integer> list = of(1, 2, 3, 4);
            list.add(2,100);
            Assertions.assertEquals(ArrayList.of(1, 2, 100, 3, 4), list);
        }

        @Test
        public void shouldReturnTrueWhenAddElementToTheArrayList(){
            List<Integer> list = of(1, 2, 3, 4, 5);
            Assertions.assertTrue(list.add(3,100));
        }

        @Test
        public void shouldNotAddElementToTheListWhenIndexIsOutOfRange() {
            List<Integer> list = of(1, 2, 3, 4, 5);
            list.add(20,100);
            Assertions.assertEquals(ArrayList.of(1, 2, 3, 4, 5), list);
        }

        @Test
        public void shouldReturnFalseWhenElementWasNotAddedToTheList() {
            List<Integer> list = of(1, 2, 3, 4, 5);
            Assertions.assertFalse(list.add(18,100));
        }
    }
}

class ArrayListTests  extends AbstractListTests  {
    @Override
    protected List of(final Object... elements) {
        return ArrayList.of(elements);
    }
}

class LinkedListTests  extends AbstractListTests  {
    @Override
    protected List of(final Object... elements) {
        return LinkedList.of(elements);
    }
}


