package collections;

import entities.Node;
import collections.LinkedList;

public class LinkedList {

    private Node node;

    public LinkedList(Node node) {
        this.node = node;
    }

    public LinkedList() {
    }

    public Node getNode() {
        return node;
    }

    public  void addFirst(int element) {
        if (this.node == null) {
            this.node = new Node( element, null);
        }
        Node link = this.node;
        do {
            if (link.getNext() != null) {
                int buffer = link.getElement();
                link.setElement(element);
                element = link.getNext().getElement();
                link.getNext().setElement(buffer);
                link = link.getNext();
            } else {
              link.setNext( new Node(element, null));
              link = null;
            }

        } while (link != null);
    }

    public int getFirst() {
        return this.node.getElement();
    }

    public int removeFirst() {
        int result = this.getFirst();
        Node link = this.node;
        if (link.getNext() == null) {
          this.node = null;
        }
        do {
            if (link.getNext().getNext() != null) {
                link.setElement(link.getNext().getElement());
                link = link.getNext();
            } else {
                link.setElement(link.getNext().getElement());
                link.setNext(null);
                link = null;
            }
        } while (link != null);
        return result;
    }
}
