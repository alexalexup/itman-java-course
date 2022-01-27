package collections;

public class ArrayList {
    private int[] numbers;

    public ArrayList(int capacity) {
        if (capacity > 0) {
            this.numbers = new int[capacity];
        } else {
            this.numbers = new int[]{};
        }
    }

    public void set(int index, int element) {
        this.numbers[index] = element;
    }

    public int get(int index) {
        return this.numbers[index];
    }

    public int size() {
        return this.numbers.length;
    }
}
