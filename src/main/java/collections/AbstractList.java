package collections;

import utils.StringBuilder;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public abstract  class AbstractList<T> implements List<T> {
    protected int size;

    /**
     * Create object from ListIterator class. This object uses for call some method that are general
     for objects from Lists class.
     * @return object from ListIterator class
     */
    public abstract   ListIterator<T> iterator();

    /**
     *@cpu O(1)
     *@ram O(1)
     * @return size of the  Lists
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Check have or not list any elements
     * @cpu O(1)
     * @ram O(1)
     * @return true when list have not any elements and false in other cases
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Add element to the list
     * @param element argument
     * @return true when element was added and false when was not
     */
    @Override
    public abstract boolean add(T element);

    /**
     * Add element to the List by the index
     * @param index argument
     * @param element argument
     * return true when element added to the List and false when didn't
     */
    @Override
    public abstract boolean add(int index, T element);


    /**
     * Add elements from collection to the current list
     * @param collection argument
     * @return true when elements was added and false when was not
     */
    @Override
    public  boolean addAll(Collections<T> collection) {
        if (collection.size() == 0) {
            return false;
        }
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next());

        }
        return true;
    }

    /**
     * Add elements from collection to the current list starting since index from argument
     * @param index argument
     * @param collection argument
     * @return true when elements was added and false when was not
     */
    @Override
    public abstract boolean addAll(int index, Collections<? extends T> collection);

    /**
     * Сhecks whether the current list contains an element from the argument
     * @cpu O(n) , n - this.size
     * @ram O(1)
     * @param element argument
     * @return true when list have element from argument and false when have not
     */
    @Override
    public boolean contains(T element) {
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            T checkItem = iterator.next();
            if(checkItem != null && checkItem.equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove element from the list
     * @cpu O(n^2) , n - this.size
     * @ram O(1)
     * @param element argument
     * @return true when element was removed and false when was not
     */
    @Override
    public boolean remove(T element) {
        ListIterator<T> iterator = this.iterator();
        boolean result = false;
        while (iterator.hasNext()) {
            T checkItem = iterator.next();
            if(element.equals(checkItem)) {
                this.remove(iterator.getIteratorSize() - 1);
                iterator.decreaseIteratorSize();
                result = true;
            }
        }
        return result;
    }

    /**
     * Сhecks contains or not list all elements from the argument
     * @cpu O(n * m) , n - this.size, m - collection.size
     * @ram O(1)
     * @param collection argument
     * @return true when list have all elements from the argument, false when have not
     */
    @Override
    public boolean containsAll(Collections<T> collection) {
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            T item = iterator.next();
            if (this.contains(item) != true) {
                return false;
            }
        }
        return true;
    }

    /**
     * Remove all elements from current collection that includes in collection from argument
     * @cpu O(n^2 * m) , n - this.size, m - collection.size
     * @ram O(1)
     * @param collection argument
     */
    @Override
    public void removeAll(Collections<T> collection) {
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            T item = iterator.next();
            this.remove(item);
        }
    }

    /**
     * Compare current list with object from the argument
     * @cpu O(n) , n - this.size
     * @ram O(1)
     * @param objects argument
     * @return true when both objects are same( from the list class and have same elements), false
     when are not
     */
    public boolean equals(Object objects) {
        if (this == objects) {
            return true;
        }
        if ((!(objects instanceof AbstractList)) || this.size() != ((AbstractList<?>) objects).size()) {
            return false;
        }
        Iterator<T> firstIterator = this.iterator();
        Iterator<T> secondIterator =((AbstractList<T>) objects).iterator();
        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            T firstObject = firstIterator.next();
            T secondObject = secondIterator.next();
            if (!(firstObject == null ? secondObject == null : firstObject.equals(secondObject))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Set element by index to the list
     * @param index argument
     * @param element argument
     */
    @Override
    public abstract void  set(int index, T element);

    /**
     * Get element from the list by index
     * @param index argument
     */
    @Override
    public abstract T get(int index);

    /**
     * Create Array with data from the list
     * @return Array with data from the list
     */
    @Override
    public abstract Object[] toArray();


    /**
     * Remove element from the list when element meets the requirements of the argument
     * @cpu O(n) , n - this.size
     * @ram O(1)
     * @param predicate argument
     */
    @Override
    public void removeIf(Predicate<T> predicate) {
        ListIterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            if (predicate.test( iterator.next())) {
                this.remove(iterator.getIteratorSize() - 1);
                iterator.decreaseIteratorSize();
            }
        }
    }

    /**
     * Converts the data from the list according to the requirements from the argument and passes
     the data to the array
     * @param factory argument
     * @return array with  data that was converted with requirements from the argument
     */
    @Override
    public  T[] toArray(IntFunction<T> factory){
        T[] result = (T[]) new Object[this.size];
        ListIterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            result[iterator.getIteratorSize()] =  factory.apply(iterator.getIteratorSize());
            iterator.next();
        }
        return result;
    }

    /**
     * Remove and return element from the list by the index
     * @param index argument
     * @return element from the list by the index
     */
    @Override
    public abstract T remove(int index);

    /**
     * Sort elements in the list
     * @param comparator argument, this is condition by which the sorting
     */
    @Override
    public void sort(Comparator comparator) {
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i; j <size; j++ ) {
                if (comparator.compare(this.get(min), this.get(j)) > 0) {
                    min = j;
                }
            }
            T t = this.get(i);
            this.set(i, this.get(min));
            this.set(min, t);
        }
    }

    /**
     * Return String with values of elements from List
     * @cpu O(n), n - size of List
     * @ram O(n), n - size of List
     * @return String with values of elements from List
     */
    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        ListIterator iterator = this.iterator();
        StringBuilder result = new StringBuilder();
        result.append("[");
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (iterator.getIteratorSize() < this.size) {
                if (object == null) {
                    result.append(null);
                    result.append(", ");
                } else {
                    result.append(object.toString());
                    result.append(", ");
                }
            } else {
                if (object == null) {
                    result.append(null);
                    result.append("]");
                } else {
                    result.append(object.toString());
                    result.append("]");
                }
            }
        }
        return result.toString();
    }
}
