package collections;
import java.util.function.Predicate;
import java.util.function.IntFunction;

public interface Collections<T> extends Iterable<T> {

    /**
     * @return  return size of the collection
     */
    int size();

    /**
     * Check that collection is empty or not
     * @return  true when collection have some elements and false when have not
     */
    boolean isEmpty();

    /**
     * Add element to the collection
     * @param element argument
     * @return true when element was added to the collection and false when was not
     */
    boolean add(T element);

    /**
     * Add all elements from argument to the collection
     * @param collection argument
     * @return true when elements was added to the collection and false when was not
     */
    boolean addAll(Collections<? extends T> collection);

    /**
     * Checks whether the collection contains an element from the argument
     * @param element argument
     * @return true when collection contains element from the argument and false when doesn't
     */
    boolean contains(T element);

    /**
     * Remove all elements from the collection that correspond to argument
     * @param element argument
     * @return true when elemnt(s) was removed and false when was not
     */
    boolean remove(Object element);

    /**
     * Checks whether the collection contains  elements from the argument
     * @param collection argument
     * @return true when collection contains elements from the argument and false when doesn't
     */
    boolean containsAll(Collections<?> collection);

    /**
     * Remove all elements from the collection that correspond to argument
     * @param element argument
     * @return true when elemnt(s) was removed and false when was not
     */
    void removeAll(Collections<?> element);

    /**
     * Create and return array with elements from the collection
     * @return array with elements from the collection
     */
    Object[] toArray();

    /**
     * Remove  element from the collection if element correspond to predicate
     * @param predicate argument
     */
    void  removeIf(Predicate<? super T> predicate);

    /**
     * Create and return array with elements from the collection that
       was converted used IntFunction object
     * @return array with edit elements from the collection
     */
     T[] toArray(IntFunction<T[]> factory);
}
