package collections;

import entities.Node;

public class LinkedList {
    public Node node;

    public LinkedList(Node node) {
        this.node = node;
    }

    public  void addFirst(int element ) {
        if (this.node == null) {
            this.node = new Node( element, null);
        }
        Node link = this.node;
        do {
            int buffer = link.getElement();
            link.setElement(element);
            element = link.getNext().getElement();
            link.getNext().setElement(buffer);
            link = link.getNext();

        } while (link != null);
    }

}
