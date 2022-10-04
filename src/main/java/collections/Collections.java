package collections;

public interface Collections <T> extends java.lang.Iterable {

    public int size();

    public boolean isEmpty();

    public boolean add(T element);

    public boolean addAll(Collections<T> collection);

    public boolean contains(T element);

    public boolean remove(T element);

    public boolean containsAll(T collection);

    public void removeAll(T element);

    public Object[] toArray();






}
