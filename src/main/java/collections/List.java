package collections;

public interface List {
    public void add(Object element);
    public void set(int index, Object element);
    public Object get(int index);
    public int size();
    public Object[] toArray();
    public Object remove(int index);
}
