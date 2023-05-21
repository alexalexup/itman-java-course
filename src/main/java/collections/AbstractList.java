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
     * @return size of the  Lists
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Check have or not list any elements
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
     * @param element argument
     * @return true when list have element from argument and false when have not
     */
    @Override
    public boolean contains(Object element) {
        for (Object item: this) {
            if(item == null ? element == null : item.equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get data to array from the list
     * @cpu O(n), n - this.size
     * @ram O(n), n - this.size
     * @return array with data from the List
     */
    public Object[] toArray() {
        Object[] result = new Object[this.size];
        int i = 0;
        for (T item: this) {
            result[i++] = item;
        }
        return result;
    }

    /**
     * Сhecks contains or not list all elements from the argument
     * @param collection argument
     * @return true when list have all elements from the argument, false when have not
     */
    @Override
    public boolean containsAll(Collections<?> collection) {
        for(Object item: collection) {
            if (!this.contains(item)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compare current list with object from the argument
     * @param objects argument
     * @return true when both objects are same( from the list class and have same elements), false
     when are not
     */
    public boolean equals(Object objects) {
        if (this == objects) {
            return true;
        }
        if (!(objects instanceof List)){
           return false;
        }
        Iterator<T> first = this.iterator();
        Iterator<?> second = ((List<?>) objects).iterator();
        while (first.hasNext() && second.hasNext()) {
            T o1 = first.next();
            Object o2 = second.next();
            if (!(o1==null ? o2==null : o1.equals(o2))) {
                return false;
            }
        }
        return !(first.hasNext() || second.hasNext());
    }

    /**
     * Remove element from the list
     * @param element argument
     * @return true when element was removed and false when was not
     */
    @Override
    public boolean remove(Object element) {
        boolean result = false;
        int i = 0;
        for (Object item : this) {
            if(element.equals(item)) {
                this.remove(i);
                return true;
            }
            i++;
        }
        return result;
    }

    /**
     * Converts the data from the list according to the requirements from the argument and passes
     the data to the array
     * @param factory argument
     * @return array with  data that was converted with requirements from the argument
     */
    public  T[] toArray(IntFunction<T[]> factory){
        T[] result = factory.apply(this.size);
        Iterator<T> iterator = this.iterator();
        for (int i = 0; i <result.length; i++) {
            result[i] = iterator.next();
        }
        return result;
    }

    /**
     * Remove all elements from current collection that includes in collection from argument
     * @param collection argument
     */
    @Override
    public void removeAll(Collections<?> collection) {
        for (Object item : collection) {
            this.removeAll(item);
        }
    }

    /**
     * Remove element from the list
     * @param element argument
     * @return true when element was removed and false when was not
     */
    protected void removeAll(Object element) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(element)){
                iterator.remove();
            }
        }
    }

    /**
     * Sort elements in the list
     * @param comparator argument, this is condition by which the sorting
     */
    @Override
    public void sort(Comparator<? super T> comparator) {
        Object[] items =  this.toArray();
        ArrayUtils.mergeSort(items, 0, size, comparator);
        ListIterator iterator = this.iterator();
        for (Object item : items) {
            iterator.next();
            iterator.set(item);
        }
    }

    /**
     * Return String with values of elements from List
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
