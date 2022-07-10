package collections;

import utils.StringBuilder;


public class LinkedList {

    private static class Node {
        private Object element;
        private Node next;
        private Node prev;

        public Node(Object element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public Node() {
        }

        public Object getElement() {
            return element;
        }

        public void setElement(Object element) {
            this.element = element;
        }

        public Node getNext() {
            return this.next;
        }

        public Node getPrev() {
            return this.prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    private Node node;
    private Node lastNode;
    private int size;



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

    public int size() {
        return this.size;
    }

    /**
     * Create LinkedList with numbers from argument LinkedList
     * @cpu O(n), n - size of LinkedList (that)
     * @ram O(n), n - size of LinkedList (that)
     * @param that LinkedList from argument
     * @return LinkedList with values from argument
     */
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

    /**
     * Create LinkedList with elements from array
     * @cpu O(n), n - elements.length
     * @ram O(n), n - elements.length
     * @param elements array with numbers
     * @return LinkedList with values from argument
     */
    public static LinkedList of(Object ... elements) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < elements.length; i++) {
            list.addLast(elements[i]);
        }
        return list;
    }

    /**
     * Create array with numbers from LinkedList
     * @cpu O(n), n - size of LinkedList
     * @ram O(n), n - size of LinkedList
     * @return array with numbers from LinkedList
     */
    public Object[] toArray(){
        Object[] result = new Object[this.size];
        Node link = this.node;
        for (int i = 0; i < this.size; i++) {
            result[i] = link.getElement();
            link = link.getNext();
        }
        return result;
    }

    /**
     * Get element from LinkedList by index
     * @cpu O(n), n - size of LinkedList
     * @ram O(1), n - size of LinkedList
     * @param index argument
     * @return number from LinkedList by index
     */
    public Object get(int index) {
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

    /**
     * Set element in LinkedList by index
     * @cpu O(n), n - size of LinkedList
     * @ram O(1), n - size of LinkedList
     * @param index argument
     * @param element argument
     */
    public void set(int index, Object element) {
        int size = this.size();
        if (index <= size / 2) {
            Node link = this.getNode();
            for (int i = 0; i < index; i++) {
                link = link.getNext();
            }
            link.setElement(element);
            return;
        }
        Node link = this.getLastNode();
        for (int i = 0; i < size - index - 1; i++) {
            link = link.getPrev();
        }
        link.setElement(element);
    }

    /**
     * Compare two objects
     * @cpu O(n), n - size of LinkedList
     * @ram O(1), n - size of LinkedList
     * @param  obj argument
     * @return true when elements and size from LinkedLists are same. In another way - false.
     */
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != LinkedList.class) {
            return false;
        }
        LinkedList that = (LinkedList) obj;
        if (this.size() != that.size()) {
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

    /**
     * Get element by the index and delete it
     * @cpu O(n)
     * @ram O(1)
     * @param index argument
     * @return first element from LinkedList
     */
    public Object remove(int index) {
        if (index == 0) {
            return this.removeFirst();
        }
        if (index == (this.size - 1)) {
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

    /**
     * Get element from node by the link and delete this node
     * @cpu O(1)
     * @ram O(1)
     * @param link by node
     * @return element from node
     */
    private Object removeNode(Node link) {
        Object result = link.getElement();
        link.getPrev().setNext(link.getNext());
        link.getNext().setPrev(link.getPrev());
        return result;
    }

    /**
     * Add one element in the head of LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @param element argument
     */
    public  void addFirst(Object element) {
        this.size++;
        Node link = this.getNode();
        if (link == null) {
            if (element == null) {
                this.node = new Node(null, null,null);
                this.lastNode = this.node;
                return;
            }
            this.node = new Node(element, null,null);
            this.lastNode = this.node;
            return;
        }
        if (element == null) {
            this.node = new Node(null, link, null);
            link.setPrev(this.node);
            return;
        }
        this.node = new Node(element, link, null);
        link.setPrev(this.node);
        return;
    }

    /**
     * Get first element from LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @return first element from LinkedList
     */
    public Object getFirst() {
        return this.node.getElement();
    }

    /**
     * Get first element and delete first node from LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @return first element from LinkedList
     */
    public Object removeFirst() {
        this.size--;
        Object result = this.getFirst();
        Node link = this.node;
        if (link.getNext() == null) {
          this.node = null;
          return result;
        }
        this.node = this.node.getNext();
        this.node.setPrev(null);
        return result;
    }

    /**
     * Return String with values of elements from LinkedList
     * @cpu O(n), n - size of LinkedList
     * @ram O(n), n - size of LinkedList
     * @return String with values of elements from LinkedList
     */
    public String toString() {
        Node link = this.node;
        if (link == null) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        while (link.getNext() != null) {
            result.append(link.getElement().toString());
            result.append(", ");
            link = link.getNext();
        }
        result.append(link.getElement().toString());
        result.append("]");
        return result.toString();
    }

    /**
     * Add one element to the end of the LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @param element
     */
    public void addLast(Object element) {
        this.size++;
        Node link = this.getNode();
        if (link == null) {
            if (element == null) {
                this.node = new Node(null, null, null);
                return;
            }
            this.node = new Node(element, null, null);
            this.lastNode = this.node;
            return;
        }
        if (element == null) {
            this.lastNode.setNext(new Node(null, null, this.lastNode));
            this.lastNode = this.lastNode.getNext();
            return;
        }
        this.lastNode.setNext(new Node(element, null, this.lastNode));
        this.lastNode = this.lastNode.getNext();
    }

    /**
     * Get last element from LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @return last element from LinkedList
     */
    public Object getLast() {
        return this.lastNode.getElement();
    }

    /**
     * Return last element and delete last node from LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @return last element from LinkedList
     */
    public Object removeLast(){
        this.size--;
       Object result = this.getLast();
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
