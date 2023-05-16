package collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class LinkedList<T> extends AbstractList<T> implements Queue<T>, List<T> {
    private Node<T> node;
    private Node<T> lastNode;

    private static class Node<T> {
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
        public void  setElement(T element) {
            this.element = element;
        }

        /**
         * Get nextNode from Node
         * @cpu O(1)
         * @ram O(1)
         * @return nextNode from Node
         */
        public Node<T> getNext() {
            return this.next;
        }

        /**
         * Get prevNode from Node
         * @cpu O(1)
         * @ram O(1)
         * @return prevNode from Node
         */
        public Node<T> getPrev() {
            return this.prev;
        }

        /**
         * Set nextNode to Node
         * @cpu O(1)
         * @ram O(1)
         * @return nextNode to Node
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }

        /**
         * Set prevNode to Node
         * @cpu O(1)
         * @ram O(1)
         * @return prevNode to Node
         */
        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }

    /**
     * Custom constructor for LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @return LinkedList with custom value
     */
    public LinkedList(Node<T> node) {
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
    public  Node<T> getNode() {
        return this.node;
    }

    /**
     * Get lastNode from LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @return lastNode from LinkedList
     */
    public Node<T> getLastNode() {
        return this.lastNode;
    }

    /**
     * Create LinkedList with numbers from argument LinkedList
     * @cpu O(n), n - size of LinkedList (that)
     * @ram O(n), n - size of LinkedList (that)
     * @param that LinkedList from argument
     * @return LinkedList with values from argument
     */
    public LinkedList(LinkedList<T> that) {
        if (that == null) {
            return;
        }
        Node<T> link = that.node;
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
    public static<T> LinkedList of(T ... elements) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < elements.length; i++) {
            list.addLast(elements[i]);
        }
        return list;
    }

    /**
     *@cpu O(1)
     *@ram O(1)
     * @return size of the  LinkedList
     */
    @Override
    public int size() {
        return super.size();
    }

    /**
     * Check have or not LinkedList any elements
     * @cpu O(1)
     * @ram O(1)
     * @return true when LinkedList have not any elements and false in other cases
     */
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * Add elements from collection to the current list
     * @cpu O(n), n - collection.size;
     * @ram O(1)
     * @param collection argument
     * @return true when elements was added and false when was not
     */
    @Override
    public  boolean addAll(Collections<? extends T> collection) {
        return super.addAll(collection);
    }

    /**
     * Add Node to the LinkedList from the ListIterator
     * @cpu O(n),  n - iterator.size
     * @ram O(n),  n - iterator.size
     * @param link argument
     * @param iterator argument
     */
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

    /**
     * Add all elements from the collection to the current LinkedList by the index
     * @cpu O(n + m),  n- this.size(), m - collection.size()
     * @ram O(m),  m - collection. size()
     * @param index argument
     * @param collection argument
     * @return true when some elements was added, false when was not
     */
    public boolean addAll(int index, Collections<? extends T> collection) {
        if (collection.size() == 0 || index > this.size() - 1) {
            return false;
        }
        if (index == this.size - 1) {
            for (T n : collection) {
                this.addLast(n);
            }
            return true;
        }
        Node<T> link;
        if (index <= this.size / 2) {
            link = this.node;
            for (int i = 0; i < index; i++) {
                link = link.getNext();
            }
        } else {
            link = getLastNode();
            for (int i = 0; i < size - index - 1; i++) {
                link = link.getPrev();
            }
        }
        for (T n: collection) {
            this.size++;
            if (link.getPrev() == null) {
                this.node = new Node(n, link, null);
                link.setPrev(this.node);
            } else {
                Node<T> newNode = new Node(n, link, link.getPrev());
                link.setPrev(newNode);
                newNode.getPrev().setNext(newNode);
            }
        }
        return true;
    }

    /**
     * Create array with numbers from LinkedList
     * @cpu O(n), n - size of LinkedList
     * @ram O(n), n - size of LinkedList
     * @return array with numbers from LinkedList
     */
    public T[] toArray(){
       return super.toArray();
    }

    /**
     * Converts the data from the list according to the requirements from the argument and passes
     the data to the array
     * @cpu O(n + m), n - super.size; m - asymptotic of the factory.apply() function
     * @ram O(n), n - super.size
     * @param factory argument
     * @return array with  data that was converted with requirements from the argument
     */
    public  T[] toArray(IntFunction<T[]> factory){
        return super.toArray(factory);
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
            Node<T> link = this.getLastNode();
            for (int i = 0; i < size - index - 1; i++) {
                link = link.getPrev();
            }
            return link.getElement();
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
     * Add one element to the LinkedList by the index
     * @cpu O(n), n - index
     * @ram O(1)
     * @param index argument
     * @param element argument
     * @return true when element was added and false when was not
     */
    @Override
    public boolean add(int index, T element) {
        if (index < 0 || index > size - 1) {
            return false;
        }
        if (index == 0) {
            this.addFirst(element);
            return true;
        }
        size++;
        Node<T> link = this.getNode();
        for (int i = 0; i < index; i++) {
            link = link.getNext();
        }
        Node<T> newNode = new Node<>(element, link, link.getPrev());
        link.getPrev().setNext(newNode);
        link.setPrev(newNode);
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
     * @cpu O(n), n - index
     * @ram O(1)
     * @param index argument
     * @return element by index from LinkedList
     */
    public T remove(int index) {
        if (index == 0) {
            return this.removeFirst();
        }
        if (index == (this.size - 1)) {
            return this.removeLast();
        }
        int size = this.size();
        Node<T> link = this.getNode();;
        if (index <= size / 2) {
            for (int i = 0; i < index; i++) {
                link = link.getNext();
            }
        } else {
            link = this.getLastNode();
            for (int i = 0; i < size - index - 1; i++) {
                link = link.getPrev();
            }
        }
        this.size--;
        return removeNode(link);
    }

    /**
     * Remove element from the list
     * @cpu O(n) , n - this.size
     * @ram O(1)
     * @param element argument
     * @return true when element was removed and false when was not
     */
    @Override
    public boolean remove(Object element) {
       return super.remove(element);
    }

    /**
     * Remove element from the list
     * @cpu O(n * m) , n - this.size, m - asymptotic of the element.equals() function
     * @ram O(1)
     * @param element argument
     * @return true when element was removed and false when was not
     */
    protected void removeAll(Object element) {
        super.removeAll(element);
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
    public void addFirst(T element) {
        this.size++;
        Node<T> link = this.getNode();
        if (link == null) {
            this.node = new Node<T>(element, null,null);
            this.lastNode = this.node;
            return;
        }
        this.node = new Node<T>(element, link, null);
        link.setPrev(this.node);
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
     * Remove all elements from current collection that includes in collection from argument
     * @cpu O(n * (m + k)) , n - this.size, m - collection.size, k -  asymptotic of the element.equals() function
     * @ram O(1)
     * @param collection argument
     */
    @Override
    public void removeAll(Collections<?> collection) {
        super.removeAll(collection);
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
        if (this.node.getNext() == null) {
            this.node = null;
            return result;
        }
        this.node = this.node.getNext();
        this.node.setPrev(null);
        return result;
    }

    /**
     * Add one element to the end of the LinkedList
     * @cpu O(1)
     * @ram O(1)
     * @param element
     */
    public void addLast(T element) {
        this.size++;
        Node<T> link = this.getNode();
        if (link == null) {
            this.node = new Node<T>(element, null, null);
            this.lastNode = this.node;
            return;
        }
        this.lastNode.setNext(new Node<T>(element, null, this.lastNode));
        this.lastNode = this.lastNode.getNext();
    }

    /**
     * Сhecks whether the current LinkedList contains an element from the argument
     * @cpu O(n * m) , n - super.size, m - asymptotic of the element.equals() function
     * @ram O(1)
     * @param element argument
     * @return true when LinkedList have element from argument and false when have not
     */
    @Override
    public boolean contains(Object element) {
        return super.contains(element);
    }

    /**
     * Сhecks contains or not LinkedList all elements from the argument
     * @cpu O(n * m * k) , n - super.size, m - collection.size, k - asymptotic of the T item.equals() function
     * @ram O(1)
     * @param collection argument
     * @return true when LinkedList have all elements from the argument, false when have not
     */
    @Override
    public boolean containsAll(Collections<?> collection) {
        return super.containsAll(collection);
    }

    /**
     * Sort elements in the list
     * @cpu O(n * log(n)) , n - this.size
     * @ram O(n), n - this.size
     * @param comparator argument, this is condition by which the sorting
     */
    @Override
    public void sort(Comparator<? super T> comparator) {
        super.sort(comparator);
    }

    /**
     * Return String with values of elements from List
     * @cpu O(n), n - size of List
     * @ram O(n), n - size of List
     * @return String with values of elements from List
     */
    public String toString() {
        return super.toString();
    }

    /**
     * Compare current LinkedList with object from the argument
     * @cpu O(n + m) , n - super.size; m -
     * @ram O(1)
     * @param objects argument
     * @return true when both objects are same( from the list class and have same elements), false
    when are not
     */
    public boolean equals(Object objects) {
        return super.equals(objects);
    }

    /**
     * Remove element from the list when element meets the requirements of the argument
     * @cpu O(n) , n - this.size
     * @ram O(1)
     * @param predicate argument
     */
    @Override
    public void removeIf(Predicate<? super T> predicate) {
        super.removeIf(predicate);
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
    /**
     * Create object from the ListIterator class
     * @cpu O(1)
     * @ram O(1)
     * return object from the ListIterator class
     */
    public ListIterator<T> iterator() {
        return new ListIterator<T>() {
            private Node<T> currentNode;
            private int  nextIndex;


            /**
             * Set element to the current position to the LinkedList that was called from ListIterator
             * @cpu O(1)
             * @ram O(1)
             * @param  element argument
             */
            @Override
            public void set(T element) {
                currentNode.setElement(element);
            }

            /**
             * Set element before the current position to the LinkedList that was called from ListIterator
             * @cpu O(1)
             * @ram O(1)
             * @param  element argument
             */
            @Override
            public void insertBefore(T element) {
                if (size == 0) {
                    return;
                }
                if (size == 1) {
                    Node<T> newNode = new Node<>(element, node,null);
                    node.setPrev(newNode);
                    node = newNode;
                    size++;
                    return;
                }
                Node<T> newNode = new Node<>(element, currentNode, currentNode.getPrev());
                Node<T> link = currentNode.getPrev();
                currentNode.setPrev(newNode);
                link.setNext(newNode);
                size++;
            }

            /**
             * Checks have  or not ListIterator one more element
             * @cpu O(1)
             * @ram O(1)
             * @return true when ListIterator have one more element and false when have not
             */
            @Override
            public boolean hasNext() {
                return nextIndex < size;
            }

            /**
             * Call next element from the ListIterator
             * @cpu O(1)
             * @ram O(1)
             * @return next element from the ListIterator
             */
            @Override
            public T next() {
                if (nextIndex == 0) {
                    currentNode = node;
                    nextIndex++;
                    return currentNode.getElement();
                } else {
                  currentNode = currentNode.getNext();
                  nextIndex++;
                  return currentNode.getElement();
                }
            }

            /**
             * Delete current Node from the iterator and Linked List
             * @cpu O(1)
             * @ram O(1)
             */
            public void remove() {
                if (currentNode == null) {
                    return;
                }
                if (size == 1) {
                    node = null;
                    lastNode = null;
                } else if (currentNode.getPrev() == null) {
                    node = node.getNext();
                    node.setPrev(null);
                    currentNode = node;
                } else if (currentNode.getNext() == null) {
                    lastNode = lastNode.getPrev();
                    lastNode.setNext(null);
                } else {
                    currentNode.getPrev().setNext(currentNode.getNext());
                    currentNode.getNext().setPrev(currentNode.getPrev());
                }
                size--;
                nextIndex--;
            }
        };
    }
}