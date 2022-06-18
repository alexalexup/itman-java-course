package tasks;

import entities.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class Task551Test {

    @Nested
    public class  BuildLinkedList {
        @Test
        public void shouldReturnListWithCorrectValuesWhenMethodWasCalled() {
            Node list = Task551.buildLinkedList();
            Assertions.assertEquals(list.getElement(), 12);
            Assertions.assertEquals(list.getNext().getElement(), 99);
            Assertions.assertEquals(list.getNext().getNext().getElement(), 37);
        }

        @Test
        public void shouldReturnListWithCorrectValuesWhenUsedPrevField() {
            Node list = Task551.buildLinkedList();
            Assertions.assertEquals(99, list.getNext().getNext().getPrev().getElement());
            Assertions.assertEquals(12, list.getNext().getPrev().getElement());
            Assertions.assertEquals(37, list.getNext().getNext().getElement());
        }
    }
}