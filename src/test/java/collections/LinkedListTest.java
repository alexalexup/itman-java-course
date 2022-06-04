package collections;

import entities.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private static void checkElements(LinkedList list, int[] array) {
        Node link = list.getNode();
        int i = 0;
        while (link !=null) {
           Assertions.assertEquals(array[i], link.getElement());
            i++;
            link = link.getNext();
        }
    }

    @Test
    public void addFirstShouldAddElementsWhenMethodWasCalledMultipleTimes() {
        LinkedList list = new LinkedList(new Node(12,new Node(10,new Node(56, null))));
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
        LinkedList list = new LinkedList(new Node(4, new Node(5, null)));
        list.addFirst(9);
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
        LinkedList list = new LinkedList(new Node(12,new Node(10,new Node(56, null))));
        int actualResult = list.removeFirst();
        Assertions.assertEquals(12, actualResult);
    }

    @Test
    public void removeFirstShouldReturnFirstElementWhenListHaveOneElement() {
        LinkedList list = new LinkedList(new Node(12,new Node(10,new Node(56, null))));
        list.removeFirst();
        list.removeFirst();
        int actualResult = list.removeFirst();
        Assertions.assertEquals(56, actualResult);
    }

    @Test
    public void toStringShouldReturnStringWhenLinkedListHaveOneElement() {
        LinkedList list = new LinkedList(new Node(4,null));
        String actualResult = list.toString();
        Assertions.assertTrue(actualResult.equals("[4]"));
    }

    @Test
    public void toStringShouldReturnStringWhenLinkedListHaveSomeElement() {
        LinkedList list = new LinkedList(new Node(12,new Node(10,new Node(56, null))));
        String actualResult = list.toString();
        Assertions.assertTrue(actualResult.equals("[12, 10, 56]"));
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
        Assertions.assertEquals(6,list.getNode().getElement());
    }

    @Test
    public void addLastShouldAddLastElementWhenListHaveOneElement() {
        LinkedList list = new LinkedList(new Node(10,null));
        list.addLast(36);
        int[] expectedResult = new int[] {10, 36};
        checkElements(list, expectedResult);
    }

    @Test
    public void addLastShouldAddLastElementWhenListHaveSomeElements() {
        LinkedList list = new LinkedList(new Node(10,new Node(36, new Node(24, null))));
        list.addLast(87);
        int[] expectedResult = new int[] {10, 36, 24, 87};
        checkElements(list, expectedResult);
    }

    @Test
    public void addLastShouldHaveNullInTheLastNodeWhenMethodWasCalled() {
        LinkedList list = new LinkedList(new Node(5,null));
        list.addLast(6);
        list.addLast(7);
        Node actualResult = list.getNode().getNext().getNext().getNext();
        Assertions.assertEquals(null, actualResult);
    }

    @Test
    public void getLastShouldReturnLastElementWhenMethodWasCalled() {
        LinkedList list = new LinkedList(new Node(6, new Node(9, new Node(14, null))));
        int actualResult = list.getLast();
        Assertions.assertEquals(14, actualResult);
    }

    @Test
    public void removeLastShouldReturnLastElementWhenListHaveOneElement() {
        LinkedList list = new LinkedList(new Node(12,null));
        int actualResult = list.removeLast();
        Assertions.assertEquals(12, actualResult);
    }

    @Test
    public void removeLastShouldReturnLastElementWhenListHaveSomeElements() {
        LinkedList list = new LinkedList(new Node(12,new Node(9, new Node(11, null))));
        int actualResult = list.removeLast();
        Assertions.assertEquals(11, actualResult);
    }

    @Test
    public void removeLastShouldReturnLastElementWhenMethodWasCalledSeveralTimes() {
        LinkedList list = new LinkedList(new Node(6,null));
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        list.addLast(10);
        list.removeLast();
        list.removeLast();
        int actualResult = list.removeLast();
        Assertions.assertEquals(8, actualResult);
    }
}