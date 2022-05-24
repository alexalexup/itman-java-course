package tasks;

import entities.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task551Test {

    @Test
    public void buildLinkedListShouldReturnListWithCorrectValuesWhenMethodWasCalled() {
        Node list = Task551.buildLinkedList();
        Assertions.assertEquals(list.getElement(), 12);
        Assertions.assertEquals(list.getNext().getElement(), 99);
        Assertions.assertEquals(list.getNext().getNext().getElement(), 37);
    }
}