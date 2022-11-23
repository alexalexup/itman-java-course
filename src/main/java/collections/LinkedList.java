package collections;

import tasks.Task551;
import utils.StringBuilder;

import java.util.Comparator;
import java.util.Iterator;

public class LinkedList <T> extends Lists <T> implements Queue <T> {
    private Node<T> node;
    private Node<T> lastNode;

    /**
     * Create object from the ListIterator class
     * @cpu O(1)
     * @ram O(1)
     * return object from the ListIterator class
     */
    public ListIterator iterator() {
        return new ListIterator<T>() {
            private Node<T> currentNode = node;
            private int iteratorSize;

            /**
             * Set element to the current position to the LinkedList that was called from ListIterator
             * @cpu O(1)
             * @ram O(1)
             * @param  element argument
             */
            @Override
            public void set(T element) {
                if (iteratorSize > 0) {
                    if (iteratorSize == size) {
                        currentNode.setElement(element);
                        return;
                    }
                    currentNode.getPrev().setElement(element);
                }
            }

            /**
             * Set element before the current position to the LinkedList that was called from ListIterator
             * @cpu O(1)
             * @ram O(1)
             * @param  element argument
             */
            @Override
            public void insertBefore(T element) {
               if (iteratorSize > 0) {
                   Node<T> link = currentNode.getPrev();
                   if (iteratorSize == 0) {
                       node = new Node<>(element, link, null);
                       size++;
                       return;
                   }
                   if (iteratorSize == size) {
                       Node<T> newNode = new Node<>(element, currentNode, currentNode.getPrev());
                       currentNode.setPrev(newNode);
                       size++;
                       return;
                   }
                   Node<T> newNode = new Node<>(element, link, link.getPrev());
                   link.getPrev().setNext(newNode);
                   link.setPrev(newNode);
                   size++;
               }
            }

            /**
             * Return count of the elements that was called by the ListIterator
             * @cpu O(1)
             * @ram O(1)
             * @return count of the elements that was called by the ListIterator
             */
            @Override
            public int getIteratorSize() {
                return iteratorSize;
            }

            /**
             * Decrease by one count of the elements that was called by the iterator
             * @cpu O(1)
             * @ram O(1)
             */
            @Override
            public void decreaseIteratorSize() {
                iteratorSize--;

            }

            /**
             * Checks have  or not ListIterator one more element
             * @cpu O(1)
             * @ram O(1)
             * @return true when ListIterator have one more element and false when have not
             */
            @Override
            public boolean hasNext() {
                return iteratorSize < size;
            }

            /**
             * Call next element from the ListIterator
             * @cpu O(1)
             * @ram O(1)
             * @return next element from the ListIterato
             */
            @Override
            public T next() {
                T result = currentNode.getElement();
                if (iteratorSize < size  ) {
                    if (currentNode.next !=null) {
                        currentNode = currentNode.next;
                    }
                    iteratorSize++;
                    return result;
                }
                return result;
            }
        };
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

    private void addElement(Node<T> link, Iterator<T> iterator) {
        while (iterator.hasNext()) {
            if(link == this.node) {
                this.addFirst(iterator.next());
            } else {
                size++;
                Node<T> newNode = new Node<>(iterator.next(), link, link.getPrev());
                link.getPrev().setNext(newNode);
                link.setPrev(newNode);
            }
        }
    }

    public boolean addAll(int index, Collections<T> collection) {
        if (collection.size() == 0 || index > this.size() - 1) {
            return false;
        }
        int size = this.size();
        Iterator<T> iterator = collection.iterator();
        if (index <= size / 2) {
        Node<T> link = this.getNode();
            for (int i = 0; i < index; i++) {
                link = link.getNext();
            }
            this.addElement(link, iterator);
            return true;
        }
        Node link = this.getLastNode();
        for (int i = 0; i < size - index - 1; i++) {
            link = link.getPrev();
        }
        this.addElement(link, iterator);
        return true;
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