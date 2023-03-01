package collections;

public interface Queue<T> {
    /**
     * Add one element to the end of the Queue
     * @param element
     */
    public void offer(T element);

    /**
     * Get first element from the Queue
     * @return first element from the queue
     */
    public T peek();

    /**
     * Get first element from the Queue and delete it
     * @return first element from the Queue
     */
    public T poll();

    /**
     * Return size of the Queue
     * @return size of the Queue
     */
    public int size();

    /**
     * Check Do have Queue elements or not
     * @return true if Queue have not elements, otherwise - false
     */
    public boolean isEmpty();

    /**
     * Create and return array with elements from the Queue
     * @return array with elements from the Queue
     */
    public T[] toArray();
}


