package collections;

public class Queue {
    private LinkedList list;

    public Queue() {
        this.list = new LinkedList();
    }

    /**
     * Add one element to the queue
     * @cpu O(1)
     * @ram O(1)
     * @param element argument
     */
    public void offer(Object element) {
        this.list.add(element);
    }

    /**
     * Get first element from the queue
     * @cpu O(1)
     * @ram O(1)
     * @return first element from the queue
     */
    public Object peek() {
        return this.list.getFirst();
    }

    /**
     * Get first element from the queue and delete it
     * @cpu O(1)
     * @ram O(1)
     * @return first element from the queue
     */
    public Object poll() {
        return this.list.removeFirst();
    }

    /**
     * Return size of the queue
     * @cpu O(1)
     * @ram O(1)
     * @return size of the queue
     */
    public int size() {
        return this.list.size();
    }

    /**
     * Check Do have queue elements or not
     * @cpu O(1)
     * @ram O(1)
     * @return true if queue have not elements, otherwise - false
     */
    public boolean isEmpty() {
        if (this.list.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Create and return array with elements from the queue
     * @cpu O(n), n - size of the queue
     * @ram O(n), n - size of the queue
     * @return array with elements from the queue
     */
    public Object[] toArray() {
        return this.list.toArray();
    }
}
