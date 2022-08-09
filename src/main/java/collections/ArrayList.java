package collections;

import utils.StringBuilder;

public class ArrayList implements List {
    private Object[] objects;
    private int size;

    /**
     * Create empty arrayList and set size 16 for field objects[]
     * @cpu O(1)
     * @ram O(1)
     * return object without logical data by ArrayList class
     */
    public ArrayList() {
        this.objects = new Object[16];
    }

    /**
     * Create empty arrayList and set size with value from argument
     * @cpu O(n) , n - capacity
     * @ram O(n), n - capacity
     * @param capacity argument
     * return object without logical data by ArrayList class
     */
    public ArrayList(int capacity) {
        this.objects = new Object[capacity];
    }

    /**
     * Add element to arrayList
     * @cpu O(1)
     * @ram O(n), n - this.numbers.length
     * @param element argument
     */
    public void add(Object element) {
        this.size++;
        if (this.size >= this.objects.length) {
            Object[] newObjects = new Object[this.objects.length * 2];
            System.arraycopy(this.objects, 0, newObjects, 0, this.objects.length);
            this.objects = newObjects;
        }
        if (element == null) {
            return;
        }
        this.objects[this.size - 1] = element;
    }

    /**
     * Set element in arraylist by index
     * @cpu O(1)
     * @ram O(1)
     * @param index argument
     * @param element argument
     */
    public void set(int index, Object element) {
        this.objects[index] = element;
    }

    /**
     * Get element from arrayList by index
     * @cpu O(1)
     * @ram O(1)
     * @param index argument
     * @return element from arrayList by index
     */
    public Object get(int index) {
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
    public Object[] toArray() {
        Object[] array = new Object[this.size];
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
    public Object remove(int index) {
        Object result = this.objects[index];
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
    public static ArrayList of(Object ... elements) {
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
            if (this.objects[i] != null ? this.objects[i].equals(thatArray.objects[i]) : thatArray.objects[i] == null) {
            } else {
                return false;
            }
        }
        return true;
    }
}
