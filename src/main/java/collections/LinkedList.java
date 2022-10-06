package collections;

import utils.StringBuilder;

import java.util.Iterator;


public class LinkedList <T> implements List <T>, Queue <T> {
    private Node<T> node;
    private Node<T> lastNode;
    private int size;

    public class LinkedListIterator implements Iterator<T> {
        private Node<T> currentNode;
        private int currentSize;

        public LinkedListIterator() {
            this.currentNode = node;
        }

        public int getCurrentSize() {
            return currentSize;
        }

        public void decreaseCurrentSize() {
            currentSize--;
        }

        @Override
        public boolean hasNext() {
            return currentSize < size;
        }

        @Override
        public T next() {
            T result = currentNode.getElement();
            currentNode = currentNode.next;
            currentSize++;
            return result;
        }
    }

    @Override
    public LinkedListIterator iterator() {
        return new LinkedListIterator();
    }

    private static class Node <T> {
        private T element;
        private Node<T> next;
        private Node<T> prev;

        /**
         * Custom constructor for Node
         * @cpu O(1)
         * @ram O(1)
         * @return Node with custom values
         */
        public Node(T element, Node<T> next, Node<T> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        /**
         * Default constructor for Node
         * @cpu O(1)
         * @ram O(1)
         * @return Node with default values
         */
        public Node() {
        }

        /**
         * Get element from Node
         * @cpu O(1)
         * @ram O(1)
         * @return element from Node
         */
        public  T getElement() {
            return element;
        }

        /**
         * Set element in Node
         * @cpu O(1)
         * @ram O(1)
         * @param element argument
         * @return element from Node
         */
        public void setElement(T element) {
            this.element = element;
        }

        /**
         * Get nextNode from Node
         * @cpu O(1)
         * @ram O(1)
         * @return nextNode from Node
         */
        public Node getNext() {
            return this.next;
        }

        /**
         * Get prevNode from Node
         * @cpu O(1)
         * @ram O(1)
         * @return prevNode from Node
         */
        public Node getPrev() {
            return this.prev;
        }

        /**
         * Set nextNode to Node
         * @cpu O(1)
         * @ram O(1)
         * @return nextNode to Node
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /**
         * Set prevNode to Node
         * @cpu O(1)
         * @ram O(1)
         * @return prevNode to Node
         */
        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    /**
     * Custom constructor for LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @return LinkedList with custom value
     */
    public LinkedList(Node node) {
        this.node = node;
    }

    /**
     * Default constructor for LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @return LinkedList with default values
     */
    public LinkedList() {
    }

    /**
     * Get Node from LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @return Node from LinkedList
     */
    public Node getNode() {
        return this.node;
    }

    /**
     * Get lastNode from LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @return lastNode from LinkedList
     */
    public Node getLastNode() {
        return this.lastNode;
    }

    /**
     * Get size from LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @return size from LinkedList
     */
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
    public static <T> LinkedList of(T ... elements) {
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
    public T[] toArray(){
        T[] result =(T[]) new Object[this.size];
        Node<T> link = this.node;
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
    public T get(int index) {
        int size = this.size();
        if (index <= size / 2) {
            Node<T> link = this.getNode();
            for (int i = 0; i < index; i++) {
                link = link.getNext();
            }
            return link.getElement();
        } else {
            Node link = this.getLastNode();
            for (int i = 0; i < size - index - 1; i++) {
                link = link.getPrev();
            }
            return (T)link.getElement();
        }
    }

    /**
     * Add one element to the end of the LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @param element
     */
    public boolean add(T element) {
        this.addLast(element);
        return true;
    }

    /**
     * Set element in LinkedList by index
     * @cpu O(n), n - size of LinkedList
     * @ram O(1), n - size of LinkedList
     * @param index argument
     * @param element argument
     */
    public  void set(int index, T element) {
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
        Node secondLink = that.node;
        for (int i = 0; i < this.size(); i++) {
            if (firstLink.getElement() != null
                    ? firstLink.getElement().equals(secondLink.getElement())
                    : secondLink.getElement() == null) {
            } else {
                return false;
            }
            firstLink = firstLink.getNext();
            secondLink = secondLink.getNext();
        }
        return true;
    }

    /**
     * Check LinkedList is empty or isn't
     * @cpu O(1)
     * @ram O(1)
     * @return true if LinkedList is empty, false if LinkedList have some elements
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean addAll(Collections<T> collection) {
        if (collection.size() == 0) {
            return false;
        }
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next());
        }
        return true;
    }

    @Override
    public boolean contains(T element) {
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            T checkItem = iterator.next();
            if(checkItem != null ? checkItem.equals(element) : element == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(T element) {
        LinkedListIterator iterator = this.iterator();
        boolean result = false;
        while (iterator.hasNext()) {
            T checkItem = iterator.next();
            if(checkItem != null ? checkItem.equals(element) : element == null) {
                this.remove(iterator.getCurrentSize() - 1);
                iterator.decreaseCurrentSize();
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean containsAll(Collections<T> collection) {
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            T checkItem = iterator.next();
            if (this.contains(checkItem)) {
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public void removeAll(T element) {

    }

    /**
     * Get element by the index and delete it
     * @cpu O(n)
     * @ram O(1)
     * @param index argument
     * @return first element from LinkedList
     */
    public T remove(int index) {
        if (index == 0) {
            return (T)this.removeFirst();
        }
        if (index == (this.size - 1)) {
            return (T)this.removeLast();
        }
        int size = this.size();
        if (index <= size / 2) {
            Node<T> link = this.getNode();
            for (int i = 0; i < index; i++) {
                link = link.getNext();
            }
            this.size--;
            return removeNode(link);
        } else {
            Node<T> link = this.getLastNode();
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
    private T removeNode(Node<T> link) {
        T result = link.getElement();
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
    public <T> void addFirst(T element) {
        this.size++;
        Node<T> link = this.getNode();
        if (link == null) {
            this.node = new Node(element, null,null);
            this.lastNode = this.node;
            return;
        }
        this.node = new Node(element, link, null);
        link.setPrev(this.node);
        return;
    }

    /**
     * Add one element to the end of the LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @param element
     */
    public void offer(T element) {
        this.addLast(element);
    }

    /**
     * Get first element from LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @return first element from LinkedList
     */
    public T getFirst() {
        return this.node.getElement();
    }

    /**
     * Get first element and delete first node from LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @return first element from LinkedList
     */
    public T removeFirst() {
        this.size--;
        T result = this.getFirst();
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
        Object object;
        while (link.getNext() != null) {
            object = link.getElement();
            if (object == null) {
                result.append(null);
                result.append(", ");
                link = link.getNext();
            } else {
                result.append(object.toString());
                result.append(", ");
                link = link.getNext();
            }

        }
        object = link.getElement();
        if (object == null) {
            result.append(null)
                    .append("]");
        } else {
            result.append(object.toString());
            result.append("]");
        }
        return result.toString();
    }

    /**
     * Add one element to the end of the LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @param element
     */
    public <T> void addLast(T element) {
        this.size++;
        Node<T> link = this.getNode();
        if (link == null) {
            this.node = new Node(element, null, null);
            this.lastNode = this.node;
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
    public T getLast() {
        return this.lastNode.getElement();
    }

    /**
     * Get first element from LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @return first element from LinkedList
     */
    public T peek() {
        return this.getFirst();
    }

    /**
     * Return last element and delete last node from LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @return last element from LinkedList
     */
    public T removeLast(){
        this.size--;
        T result = this.getLast();
        if (this.getLastNode().getPrev() == null) {
            this.node = null;
            this.lastNode = null;
            return result;
        }
        this.getLastNode().getPrev().setNext(null);
        this.lastNode = this.lastNode.getPrev();
        return result;
    }

    /**
     * Get first element and delete first node from LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @return first element from LinkedList
     */
    public T poll() {
        return this.removeFirst();
    }
}