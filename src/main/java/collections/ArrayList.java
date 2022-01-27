package collections;

public class ArrayList {
    private int[] numbers;
    private int size;

    public ArrayList(int capacity) {
            this.numbers = new int[capacity];
    }

    public void set(int index, int element) {
        this.numbers[index] = element;
    }

    public int get(int index) {
        return this.numbers[index];
    }

    public int size() {
        return this.size;
    }

    public void add(int element) {
        this.size++;
        if (this.size >= this.numbers.length) {
            int[] newNumbers = new int[numbers.length * 2];
            System.arraycopy(this.numbers, 0, newNumbers, 0, this.numbers.length);
            newNumbers[size -1] = element;
            this.numbers = newNumbers;
        }
        this.numbers[size -1] = element;
    }
}
