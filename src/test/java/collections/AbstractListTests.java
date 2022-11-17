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
    public class Remove {
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
            List<String> third = of ("AAA");
            Assertions.assertNotEquals(first, second);
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
            System.out.println("firstList");
            List secondList = new LinkedList();
            secondList.add(5);
            secondList.add(5);
            secondList.add(5);
            List expectedResult = of (1, 2, 3, 4, 5, 5, 5);
            firstList.addAll(secondList);
            Assertions.assertEquals(firstList, expectedResult);
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


