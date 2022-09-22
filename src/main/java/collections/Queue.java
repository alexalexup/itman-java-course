package collections;

public interface Queue <T> {
    /**
     * Add one element to the end of the Queue
     * @cpu O(1)
     * @ram O(1)
     * @param element
     */
    public void offer(T element);

    /**
     * Get first element from the Queue
     * @cpu O(1)
     * @ram O(1)
     * @return first element from the queue
     */
    public T peek();

    /**
     * Get first element from the Queue and delete it
     * @cpu O(1)
     * @ram O(1)
     * @return first element from the Queue
     */
    public T poll();

    /**
     * Return size of the Queue
     * @cpu O(1)
     * @ram O(1)
     * @return size of the Queue
     */
    public int size();

    /**
     * Check Do have Queue elements or not
     * @cpu O(1)
     * @ram O(1)
     * @return true if Queue have not elements, otherwise - false
     */
    public boolean isEmpty();

    /**
     * Create and return array with elements from the Queue
     * @cpu O(n), n - size of the Queue
     * @ram O(n), n - size of the Queue
     * @return array with elements from the Queue
     */
    public T[] toArray();
}


