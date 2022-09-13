package collections;

public interface Queue {

    /**
     * Add one element to the queue
     * @cpu O(1)
     * @ram O(1)
     * @param element argument
     */
    public void offer(Object element);

    /**
     * Get first element from the queue
     * @cpu O(1)
     * @ram O(1)
     * return first element from the queue
     */
    public Object peek();

    /**
     * Get and delete first element from the queue
     * @cpu O(1)
     * @ram O(1)
     * return first element from the queue
     */
    public Object poll();

    /**
     * Return size of the queue
     * @cpu O(1)
     * @ram O(1)
     * return size of the queue
     */
    public int size();

    /**
     * Check queue is empty or not
     * @cpu O(1)
     * @ram O(1)
     * return true when queue is empty and false when queue have some elements
     */
    public boolean isEmpty();

    /**
     * Return array with elements from the queue
     * @cpu O(n), n - size of the queue
     * @ram O(n), n - size of the queue
     * return array with elements from the queue
     */
    public Object[] toArray();
}


