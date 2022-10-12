package collections;

import java.util.Iterator;

public interface ListIterator<T> extends Iterator <T> {
    public void set(T element);
    public void insertBefore(T element);


}
