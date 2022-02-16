package collections;
import utils.StringBuilder;

public class ArrayList {
    private int[] numbers;
    private int size;

    /**
     * Create empty arrayList and set size for field numbers[]
     * @cpu O(n), n - capacity
     * @ram O(n), n - capacity
     * @param capacity argument
     * return object without logical data by ArrayList class
     */
    public ArrayList(int capacity) {
            this.numbers = new int[capacity];
    }

    /**
     * Create arrayList with data from arrayList that
     * @cpu O(n), n - that.size
     * @ram O(n), n - that.size
     * @param that argument
     * return object by ArrayList class with data from argument
     */
    public ArrayList(ArrayList that) {
        this.numbers = new int[that.size];
        for (int i = 0 ; i < that.size; i++) {
            this.add(that.numbers[i]);
        }
    }

    /**
     * Create empty arrayList and set size 16 for field numbers[]
     * @cpu O(1)
     * @ram O(1)
     * return object without logical data by ArrayList class
     */
    public ArrayList() {
        this.numbers = new int[16];
    }

    /**
     * Set the value of the arrayList element
     * @cpu O(1)
     * @ram O(1)
     * @param index argument
     * @param element argument
     */
    public void set(int index, int element) {
        this.numbers[index] = element;
    }

    /**
     * Get value of element from arrayList by index
     * @cpu O(1)
     * @ram O(1)
     * @param index argument
     * @return element from arrayList by index
     */
    public int get(int index) {
        return this.numbers[index];
    }

    /**
     * Get value of the size arrayList
     * @cpu O(1)
     * @ram O(1)
     * @return value of the size field
     */
    public int size() {
        return this.size;
    }

    /**
     * Add argument to arrayList
     * @cpu Θ(1)
     * @ram O(n), n - this.numbers.length
     * @param element argument
     */
    public void add(int element) {
        if (this.size >= this.numbers.length) {
            int[] newNumbers = new int[numbers.length * 2];
            System.arraycopy(this.numbers, 0, newNumbers, 0, this.numbers.length);
            this.numbers = newNumbers;
        }
        this.size++;
        this.numbers[this.size -1] = element;
    }

    /**
     * Get data in to array from object by ArrayList class
     * @cpu O(n), n - this.size
     * @ram O(n), n - this.size
     * @return array with data from arrayList
     */
    public int[] toArray(){
        if (this.numbers.length == this.size) {
            return this.numbers;
        }
        int[] logicalNumbers = new int[this.size];
        System.arraycopy(this.numbers,0,logicalNumbers,0,this.size);
        this.numbers =logicalNumbers;
        return this.numbers;
    }

    /**
     * Remove element from arrayList by index
     * @cpu O(n), n - this.size
     * @ram O(1)
     * @param index argument
     * @return array with data from arrayList by index
     */
    public int remove(int index) {
        int result = this.numbers[index];
        this.size--;
        for (int i = index; i < this.size; i++) {
            this.numbers[i] = this.numbers[i+1];
        }
        return result;
    }

    /**
     * Comparing arrayLists
     * @cpu O(n), n - this.size
     * @ram O(1)
     * @param that argument
     * @return true when arrayLists are equal, false are not equal
     */
    public boolean equals(ArrayList that) {
        if (that == null || this.size != that.size) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if(this.numbers[i] != that.numbers[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sort elements in arrayList in order of increasing
     * @cpu O(n^2), n - this.size
     * @ram O(1)
     */
    public void sort() {
        for (int i = 0; i < size; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (this.numbers[minIndex] > this.numbers[j]) {
                    minIndex = j;
                }
            }
            int buffer = this.numbers[i];
            this.numbers[i] = this.numbers[minIndex];
            this.numbers[minIndex] = buffer;
        }
    }

    /**
     * Create arrayList with data by argument
     * @cpu Θ(n), n - elements.length
     * @ram O(n), n - elements.length
     * @param elements argument
     * @return arrayList with data by argument
     */
    public static ArrayList of(int... elements) {
        ArrayList result = new ArrayList();
        if (elements.length < 1) {
            return result;
        }
        for (int i = 0; i < elements.length; i++) {
            result.add(elements[i]);
        }
        return result;
    }

    /**
     * Create and return object by StringBuilder class with logical data from current arrayList
     * @cpu O(n), n - this.size
     * @ram O(n), n - this.size
     * @return string with logical data by current object
     */
    public String toString() {
        if ( this.size == 0 ) {
            return "[]";
        }
        if (this.size == 1) {
            StringBuilder result = new StringBuilder(3);
            return result.append("[")
                         .append(this.numbers[0])
                         .append("]")
                         .toString();
        }
        StringBuilder result = new StringBuilder(this.size * 3);
        result.append("[")
              .append(this.numbers[0]);
        for (int i = 1; i < size; i++) {
            result.append(", ")
                  .append(this.numbers[i]);
        }
        return result.append("]")
                     .toString();
    }
}
