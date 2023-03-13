package collections;

import java.util.Comparator;

public interface List<T> extends Collections<T> {
    /**
     * Set element in List by index
     * @param index argument
     * @param element argument
     */
    public void set(int index, T element);

    /**
     * Add element to the List by the index
     * @param index argument
     * @param element argument
     * return true when element added to the List and false when didn't
     */
    public boolean add(int index, T element);

    /**
     * Add elements from collection to the List since index
     * @param index argument
     * @param collection argument
     * return true when elements added to the List and false when didn't
     */
    public boolean addAll(int index, Collections<T> collection);

    /**
     * Get element from List by index
     * @param index argument
     * @return element from List by index
     */
    public T get(int index);

    /**
     * Get data to array from the list
     * @return array with data from List
     */
    public Object[] toArray();

      /**
       * Remove element from List by index and return this element
       * @param index argument
       * @return element from list by index
       */
    public T remove(int index);

    /**
     * Create and return object by the ListIterator class
     * @return  object by the ListIterator class
     */
    public  ListIterator<T> iterator();

    /**
     * Method sort elements in the List use comparator
     * @param comparator argument
     */
    public<T> void sort(Comparator<T> comparator);
}
