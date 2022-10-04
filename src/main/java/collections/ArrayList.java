package collections;

import utils.StringBuilder;

import java.util.Iterator;

public class  ArrayList <T>  implements List <T> {
    private T[] objects;
    private int size;

    public class ArrayIterator implements Iterator<T> {
        private int current;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public T next() {
            return objects[current++];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean addAll(Collections<T> collection) {
        if (collection.size() == 0) {
            return false;
        }
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next());
        }
        return true;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    @Override
    public boolean containsAll(T collection) {
        return false;
    }

    @Override
    public void removeAll(T element) {

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
        this.size++;
        if (this.size >= this.objects.length) {
            T[] newObjects =(T[]) new Object[this.objects.length * 2];
            System.arraycopy(this.objects, 0, newObjects, 0, this.objects.length);
            this.objects = newObjects;
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
     * Get size from arrayList
     * @cpu O(1)
     * @ram O(1)
     * @return size from arrayList
     */
    public int size() {
        return this.size;
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

    /**
     * Comparing arrayLists
     * @cpu O(n), n - this.size
     * @ram O(1)
     * @return true when arrayLists are equal, false are not equal
     */
    public boolean equals(Object that) {
        if (that == null || that.getClass() != ArrayList.class) {
            return false;
        }
        ArrayList thatArray = (ArrayList) that;
        if (this.size != thatArray.size()) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (this.objects[i] == null) {
              if (thatArray.objects[i] != null) {
                  return false;
              }
            } else {
                if (this.objects[i].equals(thatArray.objects[i])) {
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
