package collections;

public interface List <T> {
    public void add(T element);
    public void set(int index, T element);
    public T get(int index);
    public int size();
    public T[] toArray();
    public T remove(int index);
}
