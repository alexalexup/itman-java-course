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
     * Method uses for set element to the before current position that was  called from ListIterator Class
     * @param element argument
     * @return element from list by index
     */
    void insertBefore(T element);
}
