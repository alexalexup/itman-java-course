package collections;

import entities.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private static void checkElements(LinkedList list, int[] array) {
        Node link = list.getNode();
        int i = 0;
        while (link != null) {
           Assertions.assertEquals(array[i], link.getElement());
            i++;
            link = link.getNext();
        }
    }

    @Test
    public void addFirstShouldAddElementsWhenMethodWasCalledMultipleTimes() {
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
    public void addFirstShouldWorkWhenListHaveNotElements() {
        LinkedList list = new LinkedList();
        list.addFirst(4);
        Assertions.assertEquals(4, list.getNode().getElement());
    }

    @Test
    public void addFirstShouldHaveNullInTheLastNodeWhenMethodWasCalled() {
        LinkedList list = new LinkedList();
        list.addFirst(9);
        list.addFirst(5);
        list.addFirst(6);
        Node actualResult = list.getNode().getNext().getNext().getNext();
        Assertions.assertEquals(null, actualResult);
    }

    @Test
    public void getFirstShouldReturnFirstElementWhenMethodWasCalled() {
        LinkedList list = new LinkedList();
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        int actualResult = list.getFirst();
        Assertions.assertEquals(2, actualResult);
    }

    @Test
    public void removeFirstShouldRemoveElementsWhenWethodWasCalledSeveralTimes(){
        LinkedList list = new LinkedList();
        list.addFirst(2);
        list.addFirst(4);
        list.addFirst(8);
        list.addFirst(10);
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        int[] expectedResult = new int[] {4, 2};
        checkElements(list, expectedResult);
    }

    @Test
    public void removeFirstShouldReturnFirstElement() {
        LinkedList list = new LinkedList();
        list.addFirst(5);
        list.addFirst(6);
        list.addFirst(12);
        int actualResult = list.removeFirst();
        Assertions.assertEquals(12, actualResult);
    }

    @Test
    public void removeFirstShouldReturnFirstElementWhenListHaveOneElement() {
        LinkedList list = new LinkedList();
        list.addFirst(6);
        list.addFirst(7);
        list.addFirst(8);
        list.removeFirst();
        list.removeFirst();
        int actualResult = list.removeFirst();
        Assertions.assertEquals(6, actualResult);
    }

    @Test
    public void toStringShouldReturnStringWhenLinkedListHaveOneElement() {
        LinkedList list = new LinkedList();
        list.addFirst(4);
        String actualResult = list.toString();
        Assertions.assertTrue(actualResult.equals("[4]"));
    }

    @Test
    public void toStringShouldReturnStringWhenLinkedListHaveSomeElement() {
        LinkedList list = new LinkedList();
        list.addFirst(4);
        list.addFirst(3);
        list.addLast(1);
        list.addFirst(6);
        list.addLast(9);
        String actualResult = list.toString();
        Assertions.assertTrue(actualResult.equals("[6, 3, 4, 1, 9]"));
    }

    @Test
    public void toStringShouldReturnStringWhenLinkedListHaveNotAnyElement() {
        LinkedList list = new LinkedList();
        String actualResult = list.toString();
        Assertions.assertTrue(actualResult.equals("[]"));
    }

    @Test
    public void addLastShouldAddLastElementWhenListHaveNotElements() {
        LinkedList list = new LinkedList();
        list.addLast(6);
        Assertions.assertEquals(6,list.getLast());
    }

    @Test
    public void addLastShouldWorkWhenAddLastWasCalledSomeTimes() {
        LinkedList list = new LinkedList();
        list.addLast(36);
        list.addLast(42);
        list.addLast(56);
        int[] expectedResult = new int[] {36, 42, 56};
        checkElements(list, expectedResult);
    }

    @Test
    public void getLastShouldReturnLastElementWhenMethodWasCalled() {
        LinkedList list = new LinkedList();
        list.addLast(6);
        list.addLast(9);
        list.addLast(14);
        int actualResult = list.getLast();
        Assertions.assertEquals(14, actualResult);
    }

    @Test
    public void removeLastShouldReturnLastElementWhenListHaveOneElement() {
        LinkedList list = new LinkedList();
        list.addLast(12);
        int actualResult = list.removeLast();
        Assertions.assertEquals(12, actualResult);
    }

    @Test
    public void removeLastShouldReturnLastElementWhenListHaveSomeElements() {
        LinkedList list = new LinkedList();
        list.addLast(3);
        list.addLast(6);
        list.addLast(11);
        int actualResult = list.removeLast();
        Assertions.assertEquals(11, actualResult);
    }

    @Test
    public void removeLastShouldReturnLastElementWhenMethodWasCalledSeveralTimes() {
        LinkedList list = new LinkedList();
        list.addLast(2);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        list.addLast(10);
        list.removeLast();
        list.removeLast();
        int actualResult = list.removeLast();
        Assertions.assertEquals(8, actualResult);
    }

    @Test
    public void LinkedListShouldCopyElementsFromAnotherLinkedList() {
        LinkedList firstList = new LinkedList();
        firstList.addLast(1);
        firstList.addLast(2);
        firstList.addLast(3);
        firstList.addLast(4);
        LinkedList secondList = new LinkedList(firstList);
        int[] expectedResult = new int[] {1, 2, 3, 4};
        checkElements(secondList, expectedResult);
    }

    @Test public void LinkedListShouldWorkWhenAnotherLinkedHaveFirstNodeWithNullValue() {
        LinkedList firstList = new LinkedList();
        LinkedList secondList = new LinkedList(firstList);
        Assertions.assertEquals(secondList.getNode(), null);
    }
}
