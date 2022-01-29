package collections;

public class ArrayList {
    private int[] numbers;
    private int size;

    public ArrayList(int capacity) {
            this.numbers = new int[capacity];
    }

    /**
     * Set the value of the array element of the number field
     * @cpu O(1)
     * @ram O(1)
     * @param index argument
     * @param element argument
     */
    public void set(int index, int element) {
        this.numbers[index] = element;
    }

    /**
     * Get array of the numbers field from an object
     * @cpu O(1)
     * @ram O(1)
     * @return array of the numbers field
     */
    public int get(int index) {
        return this.numbers[index];
    }

    /**
     * Get value of the size field from an object
     * @cpu O(1)
     * @ram O(1)
     * @return value of the size field
     */
    public int size() {
        return this.size;
    }

    public void add(int element) {
        if (this.size >= this.numbers.length) {
            int[] newNumbers = new int[numbers.length * 2];
            System.arraycopy(this.numbers, 0, newNumbers, 0, this.numbers.length);
            this.numbers = newNumbers;
        }
        this.size++;
        this.numbers[this.size -1] = element;
    }

    public int[] toArray(){
        if (this.numbers.length == this.size) {
            return this.numbers;
        }
        int[] logicalNumbers = new int[this.size];
        System.arraycopy(this.numbers,0,logicalNumbers,0,this.size);
        this.numbers =logicalNumbers;
        return this.numbers;
    }

    public int remove(int index) {
        int result = this.numbers[index];
        if (this.size == 1) {
            this.numbers = new int[]{0};
            this.size--;
            return result;
        }
        this.size--;
        int[] logicalNumbers = new int[size];
        if (index == 0) {
            System.arraycopy(this.numbers,index + 1,logicalNumbers,0,logicalNumbers.length);
            this.numbers = logicalNumbers;
            return result;
        }
        if (index == this.size) {
            System.arraycopy(this.numbers,0,logicalNumbers,0,logicalNumbers.length);
            this.numbers = logicalNumbers;
            return result;
        }
        System.arraycopy(this.numbers,0,logicalNumbers,0,index);
        System.arraycopy(this.numbers,index + 1,logicalNumbers,index,logicalNumbers.length - index);
        this.numbers = logicalNumbers;
        return result;
    }

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
}
