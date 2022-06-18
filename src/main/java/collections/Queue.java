package collections;

public class Queue {
    private LinkedList list;

    public Queue() {
        this.list = new LinkedList();
    }

    public void offer(int Element) {
        this.list.addLast(Element);
    }

    public int peek() {
        return this.list.getFirst();
    }

    public int poll() {
        return this.list.removeFirst();
    }

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        if (this.list.size() == 0) {
            return true;
        }
        return false;
    }

    public int[] toArray() {
        return this.list.toArray();
    }
}
