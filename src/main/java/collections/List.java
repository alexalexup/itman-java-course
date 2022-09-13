package collections;

public interface List {

    /**
     * Add one element to the end of the List
     * @cpu O(1)
     * @ram O(1)
     * @param element
     */
    public void add(Object element);

    /**
     * Set  element to the List by index
     * @cpu O(1) for the ArrayList, @cpu O(n) for the LinkedList, n - size
     * @ram O(1)
     * @param index
     * @param element
     */
    public void set(int index, Object element);

    /**
     * Get  element from the List by index
     * @cpu O(1) for the ArrayList, @cpu O(n) for the LinkedList, n - size of the LinkedList
     * @ram O(1)
     * @param index
     * return element from List
     */
    public Object get(int index);

    /**
     * Get size of the List
     * @cpu O(1)
     * @ram O(1)
     * return size of the List
     */
    public int size();

    /**
     * Return array with elements from the List
     * @cpu O(n) , n - size of the List
     * @ram O(n), n - size of the List
     * return array with elements from the List
     */
    public Object[] toArray();

    /**
     * Remove element from the List by index
     * @cpu O(n) , n - size of the List
     * @ram O(1)
     * return array with elements from the List
     */
    public Object remove(int index);
}
