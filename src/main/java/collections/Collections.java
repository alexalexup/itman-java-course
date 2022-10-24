package collections;
import java.util.function.Predicate;
import java.util.function.IntFunction;

public interface Collections <T> extends java.lang.Iterable {

    public int size();

    public boolean isEmpty();

    public boolean add(T element);

    public boolean addAll(Collections<T> collection);

    public boolean contains(T element);

    public boolean remove(T element);

    public boolean containsAll(Collections<T> collection);

    public void removeAll(Collections<T> element);

    public T[] toArray();

    public void removeIf(Predicate<T> predicate);

    public T[] toArray(IntFunction factory);
}
