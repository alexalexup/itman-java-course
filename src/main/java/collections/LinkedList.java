package collections;

import entities.Node;
import utils.StringBuilder;


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
          return result;
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

    public String toString() {
        Node link = this.node;
        if (link == null) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        while (link.getNext() != null) {
            result.append(link.getElement());
            result.append(", ");
            link = link.getNext();
        }
        result.append(link.getElement());
        result.append("]");
        return result.toString();
    }

    public void addLast(int element) {
        Node link = this.getNode();
        if (link == null) {
            this.node = new Node(element, null);
            return;
        }
        while (link.getNext() != null) {
            link = link.getNext();
        }
        link.setNext(new Node(element,null));
    }

    public int getLast() {
        Node link = this.node;
        while (link.getNext() != null) {
            link = link.getNext();
        }
        return link.getElement();
    }

    public int removeLast(){
        Node link = this.getNode();
        int result;
        if (link.getNext() == null) {
            result = link.getElement();
            this.node = null;
            return result;
        }
        while (link.getNext().getNext() != null) {
            link = link.getNext();
        }
        result = link.getNext().getElement();
        link.setNext(null);
        return result;
    }
}
