package collections;

import utils.ArrayUtils;
import utils.StringBuilder;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public abstract  class AbstractList<T> implements List<T> {
    protected int size;

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
     * Add elements from collection to the current list
     * @param collection argument
     * @return true when elements was added and false when was not
     */
    @Override
    public  boolean addAll(Collections<? extends T> collection) {
        if (collection.size() == 0) {
            return false;
        }
        for (T item: collection) {
            this.add(item);
        }
        return true;
    }

    /**
     * Сhecks whether the current list contains an element from the argument
     * @cpu O(n) , n - this.size
     * @ram O(1)
     * @param element argument
     * @return true when list have element from argument and false when have not
     */
    @Override
    public boolean contains(T element) {
        for (T item: this) {
            if(item != null && item.equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Сhecks contains or not list all elements from the argument
     * @cpu O(n * m) , n - this.size, m - collection.size
     * @ram O(1)
     * @param collection argument
     * @return true when list have all elements from the argument, false when have not
     */
    @Override
    public boolean containsAll(Collections<? extends T> collection) {
        for(T item: collection) {
            if (!this.contains(item)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Remove all elements from current collection that includes in collection from argument
     * @param collection argument
     */
    @Override
    public void removeAll(Collections<? extends T> collection) {
        for (T item : collection) {
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
        if (!(objects instanceof AbstractList)){
           return false;
        }
        AbstractList<T> that = (AbstractList<T>) objects;
        if (this.size != that.size) {
            return false;
        }
        Iterator<T> iterator = that.iterator();
        for (T firstItem: this) {
            T secondItem = iterator.next();
            if (!(firstItem == null ? secondItem == null : firstItem.equals(secondItem))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Remove element from the list when element meets the requirements of the argument
     * @param predicate argument
     */
    @Override
    public void removeIf(Predicate<? super T> predicate) {
        ListIterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            if (predicate.test(iterator.next())) {
                iterator.remove();
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
        int i = 0;
        for (T item: this) {
            result[i] =  factory.apply(i);
            i++;
        }
        return result;
    }

    /**
     * Sort elements in the list
     * @cpu O(n * log(n) , n - this.size
     * @ram O(n), n - this.size
     * @param comparator argument, this is condition by which the sorting
     */
    @Override
    public void sort(Comparator<? super T> comparator) {
        T[] items = (T[]) this.toArray();
        ArrayUtils.mergeSort(items, 0, size, comparator);
        ListIterator<T> iterator = this.iterator();
        for (T item : items) {
            iterator.next();
            iterator.set(item);
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
        StringBuilder result = new StringBuilder();
        result.append("[");
        int i =0;
        for (Object item: this) {
            if (i < this.size -1) {
                if (item == null) {
                    result.append(null);
                    result.append(", ");
                } else {
                    result.append(item.toString());
                    result.append(", ");
                }
            } else {
                if (item == null) {
                    result.append(null);
                    result.append("]");
                } else {
                    result.append(item.toString());
                    result.append("]");
                }
            }
            i++;
        }
        return result.toString();
    }
}
