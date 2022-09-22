package collections;

public interface List <T> {
    /**
     * Add element to List
     * @cpu O(1)
     * @ram O(n), n - size of the List
     * @param element argument
     */
    public void add(T element);

    /**
     * Set element in List by index
     * @cpu O(1)
     * @ram O(1)
     * @param index argument
     * @param element argument
     */
    public void set(int index, T element);

    /**
     * Get element from List by index
     * @cpu O(1)
     * @ram O(1)
     * @param index argument
     * @return element from List by index
     */
    public T get(int index);

    /**
     * Return size of the List
     * @cpu O(1)
     * @ram O(1)
     * @return size of the List
     */
    public int size();

    /**
     * Get data to array from list
     * @cpu O(n), n - size of the List
     * @ram O(n), n - size of the List
     * @return array with data from List
     */
    public T[] toArray();

    /**
     * Remove element from List by index and return this element
     * @cpu O(n), n -size of the List
     * @ram O(1)
     * @param index argument
     * @return element from list by index
     */
    public T remove(int index);
}
