package collections;

public interface Queue<T> {
    /**
     * Add one element to the end of the Queue
     * @param element
     */
    void offer(T element);

    /**
     * Get first element from the Queue
     * @return first element from the queue
     */
    T peek();

    /**
     * Get first element from the Queue and delete it
     * @return first element from the Queue
     */
    T poll();

    /**
     * Return size of the Queue
     * @return size of the Queue
     */
    int size();

    /**
     * Check Do have Queue elements or not
     * @return true if Queue have not elements, otherwise - false
     */
    boolean isEmpty();

    /**
     * Create and return array with elements from the Queue
     * @return array with elements from the Queue
     */
    T[] toArray();
}


