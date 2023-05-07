package collections;

import java.util.Iterator;
import java.util.function.Predicate;

public class  ArrayList<T> extends AbstractList<T> {
    private T[] objects;

    /**
     *@cpu O(1)
     *@ram O(1)
     * @return size of the  ArrayList
     */
    @Override
    public int size() {
        return super.size();
    }

    /**
     * Check have or not ArrayList any elements
     * @cpu O(1)
     * @ram O(1)
     * @return true when ArrayList have not any elements and false in other cases
     */
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * Add elements from collection to the current list
     * @cpu O(n), n - collection.size;
     * @ram O(m), m - this.objects.length
     * @param collection argument
     * @return true when elements was added and false when was not
     */
    @Override
    public  boolean addAll(Collections<? extends T> collection) {
      return super.addAll(collection);
    }

    /**
     * Add elements from the collection to the ArrayList by the index
     * @cpu O(n + m), n -size, m - collection.size()
     * @ram O(n + m), n -size, m - collection.size()
     * @param index argument
     * @param collection argument
     * @return true when element was added, false when was not
     */
    public  boolean addAll(int index, Collections<? extends T> collection ) {
        if (collection.size() == 0 || index > this.size() - 1) {
            return false;
        }
        ArrayList<T> list = new ArrayList<>();
        for (int i = 0; i < index; i ++) {
            list.add(this.get(i));
        }
        for (T n: collection) {
            list.add(n);
        }
        for (int i = index; i < this.size; i++) {
            list.add(this.get(i));
        }

        for (int i = 0; i < this.size; i++) {
            this.set(i, list.get(i));
        }
        for (int i = this.size; i < list.size(); i++) {
            this.add(list.get(i));
        }
        return true;
    }

    /**
     * Create empty arrayList and set size 16 for field objects[]
     * @cpu O(1)
     * @ram O(1)
     * return object without logical data by ArrayList class
     */
    public ArrayList() {
        this.objects =(T[]) new Object[16];
    }

    /**
     * Create empty arrayList and set size with value from argument
     * @cpu O(n), n - capacity
     * @ram O(n), n - capacity
     * @param capacity argument
     * return object without logical data by ArrayList class
     */
    public ArrayList(int capacity) {
        this.objects = (T[])new Object[capacity];
    }

    /**
     * Add element to arrayList
     * @cpu O(1)
     * @ram O(n), n - this.objects.length
     * @param element argument
     * return true when element was added and false when was not
     */
    public boolean add(T element) {
        size++;
        if (this.size >= this.objects.length) {
            T[] newObjects =(T[]) new Object[this.objects.length * 2];
            System.arraycopy(this.objects, 0, newObjects, 0, this.objects.length);
            this.objects = newObjects;
        }
        if (element == null) {
            return true;
        }
        this.objects[this.size - 1] = element;
        return true;
    }

    /**
     * Add element to arrayList by the index
     * @cpu O(n), n - this.objects.length
     * @ram O(n), n - this.objects.length
     * @param index argument
     * @param element argument
     * return true when element was added and false when was not
     */
    @Override
    public  boolean add(int index, T element) {
        if (index < 0 || index > size - 1) {
            return false;
        }
        size++;
        if (this.size >= this.objects.length) {
            T[] newObjects =(T[]) new Object[this.objects.length * 2];
            System.arraycopy(this.objects, 0, newObjects,0, index);
            System.arraycopy(this.objects, index, newObjects,index + 1, size - index);
            this.objects = newObjects;
            this.objects[index] = element;
            return true;
        }
        T firstBuffer = this.objects[index];
        for (int i = index; i < size - 1; i ++) {
            T secondBuffer = this.objects[i + 1];
            this.objects[i + 1] = firstBuffer;
            firstBuffer = secondBuffer;
        }
        this.objects[index] = element;
        return true;
    }

    /**
     * Сhecks whether the current ArrayList contains an element from the argument
     * @cpu O(n * m) , n - super.size, m - asymptotic of the element.equals() function
     * @ram O(1)
     * @param element argument
     * @return true when ArrayList have element from argument and false when have not
     */
    @Override
    public boolean contains(T element) {
        return super.contains(element);
    }

    /**
     * Сhecks contains or not ArrayList all elements from the argument
     * @cpu O(n * m * k) , n - super.size, m - collection.size, k - asymptotic of the T item.equals() function
     * @ram O(1)
     * @param collection argument
     * @return true when ArrayList have all elements from the argument, false when have not
     */
    @Override
    public boolean containsAll(Collections<? extends T> collection) {
      return super.containsAll(collection);
    }

    /**
     * Compare current ArrayList with object from the argument
     * @cpu O(n) , n - super.size
     * @ram O(1)
     * @param objects argument
     * @return true when both objects are same( from the list class and have same elements), false
    when are not
     */
    public boolean equals(Object objects) {
        return super.equals(objects);
    }

    /**
     * Set element in arraylist by index
     * @cpu O(1)
     * @ram O(1)
     * @param index argument
     * @param element argument
     */
    public void set(int index, T element) {
        this.objects[index] = element;
    }

    /**
     * Get element from arrayList by index
     * @cpu O(1)
     * @ram O(1)
     * @param index argument
     * @return element from arrayList by index
     */
    public T get(int index) {
        return this.objects[index];
    }

    /**
     * Get data to array from arraylist
     * @cpu O(n), n - this.size
     * @ram O(n), n - this.size
     * @return array with data from arrayList
     */
    public T[] toArray() {
        T[] array = (T[]) new Object[this.size];
        System.arraycopy(this.objects, 0, array, 0,this.size);
        return array;
    }

    /**
     * Remove element from arrayList by index and return this element
     * @cpu O(n), n - this.size
     * @ram O(1)
     * @param index argument
     * @return element from arraylist by index
     */
    public T remove(int index) {
        T result = this.objects[index];
        this.size--;
        for (int i = index; i < this.size; i++) {
            this.objects[i] = this.objects[i+1];
        }
        return result;
    }

    /**
     * Remove all elements from current collection that includes in collection from argument
     * @cpu O(n * m * k) , n - this.size, m - collection.size, m - asymptotic of the item.equals() function
     * @ram O(1)
     * @param collection argument
     */
    @Override
    public void removeAll(Collections<? extends T> collection) {
        for (T item : collection) {
          this.removeAll(item);
        }
    }

    /**
     * Remove element from the list
     * @cpu O(n * m) , n - this.size, m - asymptotic of the element.equals() function
     * @ram O(1)
     * @param element argument
     * @return true when element was removed and false when was not
     */
    private void removeAll(T element) {
       Iterator<T> iterator = this.iterator();
       while (iterator.hasNext()) {
           if (iterator.next().equals(element)){
            iterator.remove();
           }
       }
    }

    /**
     * Remove element from the list
     * @cpu O(n * m) , n - this.size, m - asymptotic of the element.equals() function
     * @ram O(1)
     * @param element argument
     * @return true when element was removed and false when was not
     */
    @Override
    public boolean remove(T element) {
        boolean result = false;
        int i = 0;
        for (T item : this) {
            if(element.equals(item)) {
                this.remove(i);
                return true;
            }
            i++;
        }
        return result;
    }

    /**
     * Remove element from the list when element meets the requirements of the argument
     * @cpu O(n * m * k * l) , n - this.size, m - asymptotic of the predicate.test(item) function
     *
     * @ram O(1)
     * @param predicate argument
     */
    @Override
    public void removeIf(Predicate<? super T> predicate) {
        ArrayList<T>  list = new ArrayList<>();
        for (T item : this) {
            if (predicate.test(item)) {
              list.add(item);
            }
        }
        this.removeAll(list);
    }

    /**
     * Create arrayList with data by argument
     * @cpu O(n), n - elements.length
     * @ram O(n), n - elements.length
     * @param elements argument
     * @return arrayList with data by argument
     */
    public static<T> ArrayList of(T ... elements) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (int i = 0 ; i < elements.length; i ++) {
            arrayList.add(elements[i]);
        }
        return arrayList;
    }

    /**
     * Create object from the ListIterator class
     * @cpu O(1)
     * @ram O(1)
     * return object from the ListIterator class
     */
    public ListIterator<T> iterator() {
        return new ListIterator<T>() {
            private int iteratorSize;

            /**
             * Set element to the current position to the ArrayList that was called from ListIterator
             * @cpu O(1)
             * @ram O(1)
             * @param  element argument
             */
            @Override
            public void set(T element) {
                if (iteratorSize > 0) {
                    objects[iteratorSize - 1] = element;
                }
            }

            /**
             * Set element before the current position to the ArrayList that was called from ListIterator
             * @cpu O(n), n - size
             * @ram O(n), n - size
             * @param  element argument
             */
            @Override
            public void insertBefore(T element) {
                if (iteratorSize == 0) {
                    return;
                }
                add(iteratorSize - 1, element);
            }

            /**
             * Checks have  or not ListIterator one more element
             * @cpu O(1)
             * @ram O(1)
             * @return true when ListIterator have one more element and false when have not
             */
            @Override
            public boolean hasNext() {
                return iteratorSize < size;
            }

            /**
             * Call next element from the ListIterator
             * @cpu O(1)
             * @ram O(1)
             * @return next element from the ListIterator
             */
            @Override
            public T next() {
                return get(iteratorSize++);
            }

            /**
             * Delete current element from the Iterator
             * @cpu O(n), n - size
             * @ram O(1)
             */
            public void remove() {
                size--;
                for (int i = iteratorSize - 1; i < size; i++) {
                    objects[i] = objects[i+1];
                }
                iteratorSize--;
            }
        };
    }
}
