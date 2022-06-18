package collections;

import entities.Node;
import utils.StringBuilder;


public class LinkedList {
    private Node node;
    private Node lastNode;
    private int size;


    public LinkedList(Node node) {
        this.node = node;
    }

    public LinkedList() {
    }

    public LinkedList(LinkedList that) {
        if (that == null) {
            return;
        }
        Node link = that.node;
        while (link != null) {
            this.addLast(link.getElement());
            link = link.getNext();
        }
    }

    public Node getNode() {
        return this.node;
    }

    public Node getLastNode() {
        return this.lastNode;
    }

    public int size() {
        return this.size;
    }

    public static LinkedList of(int ... elements) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < elements.length; i++) {
            list.addLast(elements[i]);
        }
        return list;
    }

    public int[] toArray(){
        int[] result = new int[this.size];
        Node link = this.node;
        for (int i = 0; i < this.size; i++) {
            result[i] = link.getElement();
            link = link.getNext();
        }
        return result;
    }

    public int get(int index) {
        int size = this.size();
        if (index <= size / 2) {
            Node link = this.getNode();
            for (int i = 0; i < index; i++) {
                link = link.getNext();
            }
            return link.getElement();
        } else {
            Node link = this.getLastNode();
            for (int i = 0; i < size - index - 1; i++) {
                link = link.getPrev();
            }
            return link.getElement();
        }
    }

    public void set(int index, int element) {
        if (index == this.size -1) {
            this.getLastNode().setElement(element);
            return;
        }
        Node link = this.node;
        for (int i = 0; i < index; i++ ) {
            link = link.getNext();
        }
        link.setElement(element);
    }

    public boolean equals(LinkedList that) {
        if (that == null || this.size() != that.size()) {
            return false;
        }
        Node firstLink = this.node;
        Node secondLink =that.node;
        for (int i = 0; i < this.size(); i++) {
            if (firstLink.getElement() != secondLink.getElement()) {
                return false;
            }
            firstLink = firstLink.getNext();
            secondLink = secondLink.getNext();
        }
        return true;
    }

    public int remove(int index) {
        if (index == 0) {
            return this.removeFirst();
        }
        if (index == (size - 1)) {
            return this.removeLast();
        }
        int size = this.size();
        if (index <= size / 2) {
            Node link = this.getNode();
            for (int i = 0; i < index; i++) {
                link = link.getNext();
            }
            this.size--;
            return removeNode(link);
        } else {
            Node link = this.getLastNode();
            for (int i = 0; i < size - index - 1; i++) {
                link = link.getPrev();
            }
            this.size--;
            return removeNode(link);
        }
    }

    private int removeNode(Node link) {
        int result = link.getElement();
        link.getPrev().setNext(link.getNext());
        link.getNext().setPrev(link.getPrev());
        return result;
    }

    public  void addFirst(int element) {
        this.size++;
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
        this.size--;
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
        this.size++;
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
        this.size--;
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
