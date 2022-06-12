package collections;

import entities.Node;
import utils.StringBuilder;


public class LinkedList {
    private Node node;
    private Node lastNode;


    public LinkedList(Node node) {
        this.node = node;
    }

    public LinkedList() {
    }

    public Node getNode() {
        return this.node;
    }

    public Node getLastNode() {
        return this.lastNode;
    }

    public  void addFirst(int element) {
        Node link = this.getNode();
        if (link == null) {
            this.node = new Node(element, null,null);
            this.lastNode = this.node;
            return;
        }
        this.node = new Node(element, link, null);
        link.setPrev(this.node);
        return;
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
        this.node = this.node.getNext();
        this.node.setPrev(null);
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
            this.node = new Node(element, null, null);
            this.lastNode = this.node;
            return;
        }
        this.lastNode.setNext(new Node(element, null, this.lastNode));
        this.lastNode = this.lastNode.getNext();
    }



    public int getLast() {
        return this.lastNode.getElement();
    }

    public int removeLast(){
       int result = this.getLast();
       if (this.getLastNode().getPrev() == null) {
           this.node = null;
           this.lastNode = null;
           return result;
       }
       this.getLastNode().getPrev().setNext(null);
       this.lastNode = this.lastNode.getPrev();
       return result;
    }

}
