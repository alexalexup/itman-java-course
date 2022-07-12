package collections;

public interface Queue {
    public void offer(Object element);
    public Object peek();
    public Object poll();
    public int size();
    public boolean isEmpty();
    public Object[] toArray();
}


