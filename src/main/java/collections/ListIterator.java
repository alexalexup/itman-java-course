package collections;

import java.util.Iterator;

public interface ListIterator<T> extends Iterator<T> {

    /**
     * Method uses for set element to the current position that was  called from ListIterator Class
     * @param element argument
     * @return element from list by index
     */
    void set(T element);

    /**
     * Method uses for set element to the current position that was  called from ListIterator Class for reverse operation
     * @param element argument
     * @return element from list by index
     */
    void setReverse(T element);

    /**
     * Method uses for set element to the before current position that was  called from ListIterator Class
     * @param element argument
     * @return element from list by index
     */
    void insertBefore(T element);

    /**
     * @return count of the elements that was called by the iterator
     */
    int getIteratorSize();

    /**
     * Decrease by one count of the elements that was called by the iterator
     */
    void decreaseIteratorSize();

    /**
     * Return next element from the iterator in reverse direction
     */
    T nextReverse();

    /**
     * Set iterator size
     */
    void setIteratorSize(int size);
}
