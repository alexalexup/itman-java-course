package collections;


public class Stack {
    private ArrayList arrayList;

    public Stack(){
        this.arrayList = new ArrayList();
    }

    public  void push(int element){
        this.arrayList.add(element);
    }

    public int peek() {
        return this.arrayList.get(this.arrayList.size() -1);
    }

    public int pop() {
        int result = this.peek();
        this.arrayList.remove(this.arrayList.size() -1);
        return result;
    }

    public int size() {
        return this.arrayList.size();
    }

    public boolean isEmpty() {
        return this.size() == 0 ? true : false;
    }

    public int[] toArray() {
        return this.arrayList.toArray();
    }
}
