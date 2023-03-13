package collections;

import utils.StringBuilder;

import java.util.Iterator;

public class  ArrayList<T> extends AbstractList<T> {
    private T[] objects;

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
             * Return count of the elements that was called by the ListIterator
             * @cpu O(1)
             * @ram O(1)
             * @return count of the elements that was called by the ListIterator
             */
            public int getIteratorSize() {
                return iteratorSize;
            }

            /**
             * Set iterator size
             * @cpu O(1)
             * @ram O(1)
             */
            public void setIteratorSize(int size) {
                iteratorSize = size;
            }

            /**
             * Decrease by one count of the elements that was called by the iterator
             * @cpu O(1)
             * @ram O(1)
             */
            public void decreaseIteratorSize() {
                iteratorSize--;
            }

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
             * Set element to the current position to the ArrayList that was called from ListIterator for reverse direction
             * @cpu O(1)
             * @ram O(1)
             * @param  element argument
             */
            @Override
            public void setReverse(T element) {
                if (iteratorSize > 0) {
                    objects[iteratorSize] = element;
                }
            }

            /**
             * Increase size of ArrayList and Iterator by one
             * @cpu O(1)
             * @ram O(1)
             */
            private void increase() {
                size++;
                iteratorSize++;
            }

            /**
             * Set element before the current position to the ArrayList that was called from ListIterator
             * @cpu O(n), n - size
             * @ram O(n), n - size
             * @param  element argument
             */
            @Override
            public void insertBefore(T element) {
                if (size == 0) {
                    objects[0] = element;
                    increase();
                    return;
                }
                if (size != iteratorSize) {
                    increase();
                } else {
                    size++;
                }
                T[] newObjects =(T[]) new Object[size];
                System.arraycopy(objects, 0, newObjects, 0, iteratorSize - 1);
                System.arraycopy(objects, iteratorSize - 1, newObjects, iteratorSize , size - iteratorSize);
                objects = newObjects;
                objects[iteratorSize - 1] = element;
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
                if (iteratorSize < size) {
                    return objects[iteratorSize++];
                }
                return objects[size - 1];
            }

            /**
             * Call next element from the ListIterator in reverse direction
             * @cpu O(1)
             * @ram O(1)
             * @return next element from the ListIterator in reverse direction
             */
            public T nextReverse() {
                if (iteratorSize > 0 ) {
                    T result = objects[iteratorSize - 1];
                    iteratorSize--;
                    return result;
                }
                return objects[0];
            }
        };
    }

    /**
     * Add elements from the collection to the ArrayList by the index
     * @cpu O(n + m), n -size, m - collection.size()
     * @ram O(n + m), n -size, m - collection.size()
     * @param index argument
     * @param collection argument
     * @return true when element was added, false when was not
     */
    public boolean addAll(int index, Collections<T> collection ) {
        if (collection.size() == 0 || index > this.size() - 1) {
            return false;
        }
        ArrayList<T> list = new ArrayList<>();
        for (int i = 0; i < index; i ++) {
            list.add(this.get(i));
        }
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
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
     * Create arrayList with data by argument
     * @cpu O(n), n - elements.length
     * @ram O(n), n - elements.length
     * @param elements argument
     * @return arrayList with data by argument
     */
    public static<T> ArrayList of(T ... elements) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0 ; i < elements.length; i ++) {
            arrayList.add(elements[i]);
        }
        return arrayList;
    }
}
