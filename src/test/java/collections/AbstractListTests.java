package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

abstract public  class AbstractListTests {
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
    }
}

class ArrayListTests extends AbstractListTests {
    @Override
    protected List of(final Object... elements) {
        return ArrayList.of(elements);
    }
}

class LinkedListTests extends AbstractListTests {
    @Override
    protected List of(final Object... elements) {
        return LinkedList.of(elements);
    }
}


