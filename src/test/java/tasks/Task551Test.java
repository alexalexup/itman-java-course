package tasks;

import entities.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import collections.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class Task551Test {

    @Test
    public void buildLinkedListShouldReturnListWithCorrectValuesWhenMethodWasCalled() {
        Node list = Task551.buildLinkedList();
        Assertions.assertEquals(list.getElement(), 12);
        Assertions.assertEquals(list.getNext().getElement(), 99);
        Assertions.assertEquals(list.getNext().getNext().getElement(), 37);
    }

    @Test
    public void buildLinkedListShouldReturnListWithCorrectValuesWhenUsedPrevField() {
        Node list = Task551.buildLinkedList();
        Assertions.assertEquals(99, list.getNext().getNext().getPrev().getElement());
        Assertions.assertEquals(12, list.getNext().getPrev().getElement());
        Assertions.assertEquals(37, list.getNext().getNext().getElement());
    }

    @Test
    public void doSomeThing(){
        LinkedList list = new LinkedList();
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(5);
        list.addLast(10);
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        System.out.println(list.getLast());

    }
}