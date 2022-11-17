package collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public abstract  class Lists <T> implements List <T> {
    protected int size;
 /*
    public abstract class ListsIterator<T> implements ListIterator<T>   {
        protected int current;

        public int getCurrent() {
            return current;
        }

        public void decreaseCurrent() {
            current--;
        }

        public  abstract void set(T element);

        public  abstract  void  insertBefore(T element);


        public boolean hasNext() {
            return current < size;
        }

        public abstract T next();
    }

  */

    public  ListIterator <T> iterator() {
        return null;
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public abstract boolean add(T element);

    @Override
    public  boolean addAll(Collections<T> collection) {
        if (collection.size() == 0) {
            return false;
        }
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next());

        }
        return true;
    }

    @Override
    public abstract boolean addAll(int index, Collections<T> collection);

    @Override
    public boolean contains(T element) {
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            T checkItem = iterator.next();
            if(checkItem != null ? checkItem.equals(element) : element == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(T element) {
        ListIterator iterator = this.iterator();
        boolean result = false;
        while (iterator.hasNext()) {
            T checkItem = (T) iterator.next();
            if(checkItem != null ? checkItem.equals(element) : element == null) {
                this.remove(iterator.getIteratorSize() - 1);
                iterator.decreaseIteratorSize();
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean containsAll(Collections<T> collection) {
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            T item = iterator.next();
            if (this.contains(item)) {
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public void removeAll(Collections<T> collection) {
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            T item = iterator.next();
            this.remove(item);
        }
    }


    public boolean equals(Object objects) {
        if (this == objects) {
            return true;
        }
        if ((!(objects instanceof Lists)) || this.size() != ((Lists<?>) objects).size()) {
            return false;
        }
        Iterator<T> firstIterator = this.iterator();
        Iterator<T> secondIterator =((Lists<T>) objects).iterator();
        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            T firstObject = firstIterator.next();
            T secondObject = secondIterator.next();
            if (!(firstObject == null ? secondObject == null : firstObject.equals(secondObject))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public abstract void  set(int index, T element);

    @Override
    public abstract T get(int index);


    @Override
    public abstract T[] toArray();

    @Override
    public void removeIf(Predicate<T> predicate) {
        ListIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            if (predicate.test((T) iterator.next())) {
                this.remove(iterator.getIteratorSize() - 1);
                iterator.decreaseIteratorSize();
            }
        }
    }

    @Override
    public  T[] toArray(IntFunction<T> factory){
        T[] result = (T[]) new Object[this.size];
        ListIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            result[iterator.getIteratorSize()] =  factory.apply(iterator.getIteratorSize());
            iterator.next();
        }
        return result;
    }

    @Override
    public abstract T remove(int index);

    @Override
    public void sort(Comparator comparator) {
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i; j <size; j++ ) {
                if (comparator.compare(this.get(min), this.get(j)) > 0) {
                    min = j;
                }
            }
            T t = this.get(i);
            this.set(i, this.get(min));
            this.set(min, t);
        }
    }
}
