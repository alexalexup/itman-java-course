package collections;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class CollectionUtilsTest {

    @Nested
    public class FindMin {
        @Test
        public void shouldFindMinElementInTheListWhenListHaveSomeElements() {
             Lists<Integer> lists = new ArrayList<>();
             lists.add(4);
             lists.add(2);
             lists.add(-3);
             lists.add(10);
             lists.add(4);
             lists.add(2);
             lists.add(0);
             Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
             Integer result =  CollectionUtils.findMin(lists, comparator);
             Assertions.assertEquals(result,-3);
        }

        @Test
        public void shouldFindMinElementInTheListWhenListHaveOneElement() {
            Lists<Double> lists = new ArrayList<>();
            lists.add(4.22);
            Comparator<Double> comparator = (a, b) -> a.compareTo(b);
            Double result =  CollectionUtils.findMin(lists, comparator);
            Assertions.assertEquals(result,4.22);
        }

        @Test
        public void shouldFindMinElementInTheListWhenListHaveNullElements() {
            Lists<Integer> lists = new LinkedList<>();
            lists.add(null);
            lists.add(10);
            lists.add(4);
            lists.add(2);
            lists.add(null);
            Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
            Integer result =  CollectionUtils.findMin(lists, comparator);
            Assertions.assertEquals(result,2);
        }

        @Test
        public void shouldWorkWhenListHaveOnlyNullElements() {
            Lists<Integer> lists = new ArrayList<>();
            lists.add(null);
            lists.add(null);
            lists.add(null);
            lists.add(null);
            lists.add(null);
            Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
            Integer result =  CollectionUtils.findMin(lists, comparator);
            Assertions.assertEquals(result,null);
        }
    }

    @Nested
    public class FindMax {
        @Test
        public void shouldFindMaxElementInTheListWhenListHaveSomeElements() {
            Lists<Integer> lists = new LinkedList<>();
            lists.add(4);
            lists.add(2);
            lists.add(-3);
            lists.add(10);
            lists.add(4);
            lists.add(2);
            lists.add(0);
            Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
            Integer result =  CollectionUtils.findMax(lists, comparator);
            Assertions.assertEquals(result,10);
        }

        @Test
        public void shouldFindMaxElementInTheListWhenListHaveOneElement() {
            Lists<Double> lists = new ArrayList<>();
            lists.add(2.22);
            Comparator<Double> comparator = (a, b) -> a.compareTo(b);
            Double result =  CollectionUtils.findMax(lists, comparator);
            Assertions.assertEquals(result,2.22);
        }

        @Test
        public void shouldFindMaxElementInTheListWhenListHaveNullElements() {
            Lists<Integer> lists = new LinkedList<>();
            lists.add(null);
            lists.add(10);
            lists.add(4);
            lists.add(2);
            lists.add(null);
            Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
            Integer result =  CollectionUtils.findMax(lists, comparator);
            //Assertions.assertEquals(result,10);
        }

        @Test
        public void shouldWorkWhenListHaveOnlyNullElements() {
            Lists<Integer> lists = new ArrayList<>();
            lists.add(null);
            lists.add(null);
            lists.add(null);
            lists.add(null);
            lists.add(null);
            Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
            Integer result =  CollectionUtils.findMax(lists, comparator);
            Assertions.assertEquals(result,null);
        }
    }

    @Nested
    public class Sort {
        @Test
        public void shouldSortElementWhenListHaveSomeElements() {
            Lists<Integer> lists = LinkedList.of(4, 2, -3, 10, 4, 2, 0);
            CollectionUtils.sort(lists);
            Lists<Integer>  expected = LinkedList.of(-3, 0, 2, 2, 4, 4, 10);
            Assertions.assertTrue(lists.equals(expected));
        }

        @Test
        public void shouldSortElementWhenListHaveOneElement() {
            Lists<Integer> lists = LinkedList.of(5);
            CollectionUtils.sort(lists);
            Lists<Integer>  expected = LinkedList.of(5);
            Assertions.assertTrue(lists.equals(expected));
        }

        @Test
        public void shouldSortElementWhenListHaveSomeEqualsElements() {
            Lists<Integer> lists = LinkedList.of(5, 4, 4, 2, 2, 1);
            CollectionUtils.sort(lists);
            Lists<Integer>  expected = LinkedList.of(1, 2, 2, 4, 4, 5);
            Assertions.assertTrue(lists.equals(expected));
        }

        @Test
        public void shouldWorkWhenListHaveNotAnyElements() {
            Lists<Integer> lists = LinkedList.of();
            CollectionUtils.sort(lists);
            Lists<Integer>  expected = LinkedList.of();
            Assertions.assertTrue(lists.equals(expected));
        }
    }

    @Nested
    public class Reverse {
        @Test
        public void shouldReverseListWhenListHaveSomeElements() {
            Lists<Double> list =  ArrayList.of(3.12, 4.22, 5.66, 0);
            CollectionUtils.reverse(list);
            Lists<Double> expected = LinkedList.of(0, 5.66, 4.22, 3.12);
            Assertions.assertEquals(expected, list);
        }

        @Test
        public void shouldReverseListWhenListHaveDifferentObjects() {
            Lists list = LinkedList.of("Hi", 3, 3.12, true, null, "Bye");
            List expected = LinkedList.of("Bye", null, true, 3.12, 3, "Hi");
            CollectionUtils.reverse(list);
            Assertions.assertEquals(expected, list);
        }

        @Test
        public void shouldReverseListWhenListHaveOneElement() {
            Lists list = LinkedList.of("Hi");
            List expected = LinkedList.of("Hi");
            CollectionUtils.reverse(list);
            Assertions.assertEquals(expected, list);
        }
    }
}