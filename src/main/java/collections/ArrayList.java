package collections;

import utils.StringBuilder;

import java.util.Iterator;

public class  ArrayList <T> extends Lists <T>  {
    private T[] objects;

    /*
    public class ArrayIterator extends ListsIterator<T> {

        @Override
        public T next() {
            if (current < size) {
                return objects[current++];
            }
            return objects[size - 1];
        }

        @Override
        public void set(T element) {
            if (current > 0) {
                objects[current - 1] = element;
            }
        }

        @Override
        public void insertBefore(T element) {
            size++;
            if (current > 0) {
                T[] newObjects =(T[]) new Object[size];
                System.arraycopy(objects, 0, newObjects, 0, current - 1);
                System.arraycopy(objects, current - 1, newObjects, current , size - current);
                objects = newObjects;
            }
            objects[current - 1] = element;
        }
    }

     */

    public ListIterator iterator() {
        return new ListIterator<T>() {
           private int iteratorSize;

            public int getIteratorSize() {
                return iteratorSize;
            }

            public void decreaseIteratorSize() {
                iteratorSize--;
            }

            @Override
            public void set(T element) {
                if (iteratorSize > 0) {
                    objects[iteratorSize - 1] = element;
                }
            }

            @Override
            public void insertBefore(T element) {
                size++;
                if (iteratorSize> 0) {
                    T[] newObjects =(T[]) new Object[size];
                    System.arraycopy(objects, 0, newObjects, 0, iteratorSize - 1);
                    System.arraycopy(objects, iteratorSize- 1, newObjects, iteratorSize , size - iteratorSize);
                    objects = newObjects;
                }
                objects[iteratorSize - 1] = element;

            }

            @Override
            public boolean hasNext() {
                return iteratorSize < size;
            }

            @Override
            public T next() {
                if (iteratorSize < size) {
                    return objects[iteratorSize++];
                }
                return objects[size - 1];
            }
        };
    }

    @Override
    public boolean remove(T element) {
        ListIterator<T> iterator = this.iterator();
        boolean result = false;
        while (iterator.hasNext()) {
            T checkItem = iterator.next();
            if(checkItem != null ? checkItem.equals(element) : element == null) {
                this.remove(iterator.getIteratorSize() - 1);
                iterator.decreaseIteratorSize();
                result = true;
            }
        }
        return result;
    }

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
     * @cpu O(n) , n - capacity
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
     * @ram O(n), n - this.numbers.length
     * @param element argument
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
    public static <T> ArrayList of(T ... elements) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0 ; i < elements.length; i ++) {
            arrayList.add(elements[i]);
        }
        return arrayList;
    }

    /**
     * Return String with data from arraylist
     * @cpu O(n), n - this.size
     * @ram O(n), n - this.size
     * @return string with logical data by current object
     */
    public String toString() {
        if ( this.size == 0 ) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < this.size; i++) {
            if (i != this.size - 1) {
                if (this.objects[i] == null) {
                    result.append(null)
                            .append(", ");
                } else {
                    result.append(this.objects[i].toString())
                            .append(", ");
                }
            } else {
                if (this.objects[i] == null) {
                    result.append(null)
                            .append("]");
                } else {
                    result.append(this.objects[i].toString())
                            .append("]");
                }
            }
        }
        return result.toString();
    }
}
