package collections;


public class Stack {
    private ArrayList arrayList;

    /**
     * Create empty object by Stack class without logical data
     * @cpu O(1)
     * @ram O(1)
     * return object without logical data by Stack class
     */
    public Stack(){
        this.arrayList = new ArrayList();
    }

    /**
     * Add argument to Stack
     * @cpu O(1)
     * @ram O(n), n - arrayList.numbers.length
     * @param element argument
     */
    public  void push(int element){
        this.arrayList.add(element);
    }

    /**
     * Return value of the last element from object by Stack class
     * @cpu O(1)
     * @ram O(1)
     * return last element from object by Stack class
     */
    public int peek() {
        return this.arrayList.get(this.arrayList.size() -1);
    }

    /**
     * Takes the last element from object by Stack class
     * @cpu O(1)
     * @ram O(1)
     * return last element from object by Stack class
     */
    public int pop() {
        int result = this.peek();
        this.arrayList.remove(this.arrayList.size() -1);
        return result;
    }

    /**
     * Return the size of the object by Stack class
     * @cpu O(1)
     * @ram O(1)
     * return size of the object by Stack class
     */
    public int size() {
        return this.arrayList.size();
    }

    /**
     * Determined whether there are elements in the stack
     * @cpu O(1)
     * @ram O(1)
     * return true when stack have not any elements, false when stack have any elements
     */
    public boolean isEmpty() {
        return this.size() == 0 ? true : false;
    }

    /**
     * Get data in to array from object by Stack class
     * @cpu O(n), n - arrayList.size()
     * @ram O(n), n - arrayList.size()
     * @return array with data from object by Stack class
     */
    public int[] toArray() {
        return this.arrayList.toArray();
    }
}
