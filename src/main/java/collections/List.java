package collections;

import java.util.Comparator;

public interface List <T> extends Collections <T> {
    /**
     * Set element in List by index
     * @cpu O(1)
     * @ram O(1)
     * @param index argument
     * @param element argument
     */
    public void set(int index, T element);

    public boolean addAll(int index, Collections<T> collection);

    /**
     * Get element from List by index
     * @cpu O(1)
     * @ram O(1)
     * @param index argument
     * @return element from List by index
     */
    public T get(int index);


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

    public ListIterator<T> iterator();

    public <T> void sort(Comparator<T> comparator);
}
