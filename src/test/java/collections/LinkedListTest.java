package collections;

import entities.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test public void somth() {
        LinkedList list = new LinkedList(new Node(3, new Node(4, null)));
        list.addFirst(5);
        System.out.println(list.node.getElement());
    }

}