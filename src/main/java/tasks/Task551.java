package tasks;

import entities.Node;

public class Task551 {

    public static Node buildLinkedList() {
        Node list = new Node(12, new Node(99, new Node(37, null)));
        return list;
    }
}
