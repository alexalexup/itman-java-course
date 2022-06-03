package collections;

import entities.Node;


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
        Node link = this.getNode();
        if (link == null) {
            this.node = new Node(element, null);
            return;
        }
        while (link.getNext() != null) {
           int buffer = link.getElement();
           link.setElement(element);
           element = buffer;
           link = link.getNext();
        }
        link.setNext(new Node(link.getElement(),null));
        link.setElement(element);
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
