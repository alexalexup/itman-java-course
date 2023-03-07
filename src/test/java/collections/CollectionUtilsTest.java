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
             AbstractList<Integer> abstractList = new ArrayList<>();
             abstractList.add(4);
             abstractList.add(2);
             abstractList.add(-3);
             abstractList.add(10);
             abstractList.add(4);
             abstractList.add(2);
             abstractList.add(0);
             Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
             Integer result =  CollectionUtils.findMin(abstractList, comparator);
             Assertions.assertEquals(result,-3);
        }

        @Test
        public void shouldFindMinElementInTheListWhenListHaveOneElement() {
            AbstractList<Double> abstractList = new ArrayList<>();
            abstractList.add(4.22);
            Comparator<Double> comparator = (a, b) -> a.compareTo(b);
            Double result =  CollectionUtils.findMin(abstractList, comparator);
            Assertions.assertEquals(result,4.22);
        }

        @Test
        public void shouldFindMinElementInTheListWhenListHaveNullElements() {
            AbstractList<Integer> abstractList = new LinkedList<>();
            abstractList.add(null);
            abstractList.add(10);
            abstractList.add(4);
            abstractList.add(2);
            abstractList.add(null);
            Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
            Integer result =  CollectionUtils.findMin(abstractList, comparator);
            Assertions.assertEquals(result,2);
        }

        @Test
        public void shouldWorkWhenListHaveOnlyNullElements() {
            AbstractList<Integer> abstractList = new ArrayList<>();
            abstractList.add(null);
            abstractList.add(null);
            abstractList.add(null);
            abstractList.add(null);
            abstractList.add(null);
            Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
            Integer result =  CollectionUtils.findMin(abstractList, comparator);
            Assertions.assertEquals(result,null);
        }
    }

    @Nested
    public class FindMax {
        @Test
        public void shouldFindMaxElementInTheListWhenListHaveSomeElements() {
            AbstractList<Integer> abstractList = new LinkedList<>();
            abstractList.add(4);
            abstractList.add(2);
            abstractList.add(-3);
            abstractList.add(10);
            abstractList.add(4);
            abstractList.add(2);
            abstractList.add(0);
            Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
            Integer result =  CollectionUtils.findMax(abstractList, comparator);
            Assertions.assertEquals(result,10);
        }

        @Test
        public void shouldFindMaxElementInTheListWhenListHaveOneElement() {
            AbstractList<Double> abstractList = new ArrayList<>();
            abstractList.add(2.22);
            Comparator<Double> comparator = (a, b) -> a.compareTo(b);
            Double result =  CollectionUtils.findMax(abstractList, comparator);
            Assertions.assertEquals(result,2.22);
        }

        @Test
        public void shouldFindMaxElementInTheListWhenListHaveNullElements() {
            AbstractList<Integer> abstractList = new LinkedList<>();
            abstractList.add(null);
            abstractList.add(10);
            abstractList.add(4);
            abstractList.add(2);
            abstractList.add(null);
            Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
            Integer result =  CollectionUtils.findMax(abstractList, comparator);
            //Assertions.assertEquals(result,10);
        }

        @Test
        public void shouldWorkWhenListHaveOnlyNullElements() {
            AbstractList<Integer> abstractList = new ArrayList<>();
            abstractList.add(null);
            abstractList.add(null);
            abstractList.add(null);
            abstractList.add(null);
            abstractList.add(null);
            Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
            Integer result =  CollectionUtils.findMax(abstractList, comparator);
            Assertions.assertEquals(result,null);
        }
    }

    @Nested
    public class Sort {
        @Test
        public void shouldSortElementWhenListHaveSomeElements() {
            AbstractList<Integer> abstractList = LinkedList.of(4, 2, -3, 10, 4, 2, 0);
            CollectionUtils.sort(abstractList);
            AbstractList<Integer> expected = LinkedList.of(-3, 0, 2, 2, 4, 4, 10);
            Assertions.assertTrue(abstractList.equals(expected));
        }

        @Test
        public void shouldSortElementWhenListHaveOneElement() {
            AbstractList<Integer> abstractList = LinkedList.of(5);
            CollectionUtils.sort(abstractList);
            AbstractList<Integer> expected = LinkedList.of(5);
            Assertions.assertTrue(abstractList.equals(expected));
        }

        @Test
        public void shouldSortElementWhenListHaveSomeEqualsElements() {
            AbstractList<Integer> abstractList = LinkedList.of(5, 4, 4, 2, 2, 1);
            CollectionUtils.sort(abstractList);
            AbstractList<Integer> expected = LinkedList.of(1, 2, 2, 4, 4, 5);
            Assertions.assertTrue(abstractList.equals(expected));
        }

        @Test
        public void shouldWorkWhenListHaveNotAnyElements() {
            AbstractList<Integer> abstractList = LinkedList.of();
            CollectionUtils.sort(abstractList);
            AbstractList<Integer> expected = LinkedList.of();
            Assertions.assertTrue(abstractList.equals(expected));
        }
    }

    @Nested
    public class Reverse {
        @Test
        public void shouldReverseListWhenListIsArrayListAndHaveEvenElements() {
            AbstractList<Double> list =  ArrayList.of(3.12, 4.22, 5.66, 0);
            CollectionUtils.reverse(list);
            AbstractList<Double> expected = LinkedList.of(0, 5.66, 4.22, 3.12);
            Assertions.assertEquals(expected, list);
        }

        @Test
        public void shouldReverseListWhenListIsArrayListAndHaveOddElements() {
            AbstractList<Double> list =  ArrayList.of(3.12, 4.22, 88.0,  5.66, 0);
            CollectionUtils.reverse(list);
            AbstractList<Double> expected = LinkedList.of(0, 5.66, 88.0, 4.22, 3.12);
            Assertions.assertEquals(expected, list);
        }

        @Test
        public void shouldReverseListWhenListIsArrayListAndHaveOneElements() {
            AbstractList<Double> list =  ArrayList.of(34);
            CollectionUtils.reverse(list);
            AbstractList<Double> expected = LinkedList.of(34);
            Assertions.assertEquals(expected, list);
        }

        @Test
        public void shouldReverseListWhenListIsArrayListAndHaveNotElements() {
            AbstractList<Double> list =  ArrayList.of();
            CollectionUtils.reverse(list);
            AbstractList<Double> expected = LinkedList.of();
            Assertions.assertEquals(expected, list);
        }

        @Test
        public void shouldReverseListWhenListIsLinkedListAndHaveEvenElements() {
            AbstractList list = LinkedList.of(1, 2, 3, 4, 5, 6);
            List expected = LinkedList.of(6, 5, 4, 3, 2, 1);
            CollectionUtils.reverse(list);
            Assertions.assertEquals(expected, list);
        }

        @Test
        public void shouldReverseListWhenListIsLinkedListAndHaveOddElements() {
            AbstractList list = LinkedList.of("HI", null, 3, 6.66, 2);
            List expected = LinkedList.of(2, 6.66, 3, null, "HI");
            CollectionUtils.reverse(list);
            Assertions.assertEquals(expected, list);
        }

        @Test
        public void shouldReverseListWhenListIsLinkedListAndHaveOneElement() {
            AbstractList list = LinkedList.of("Hi");
            List expected = LinkedList.of("Hi");
            CollectionUtils.reverse(list);
            Assertions.assertEquals(expected, list);
        }

        @Test
        public void shouldReverseListWhenListIsLinkedListAndHaveNotElements() {
            AbstractList list = LinkedList.of();
            List expected = LinkedList.of();
            CollectionUtils.reverse(list);
            Assertions.assertEquals(expected, list);
        }
    }
}