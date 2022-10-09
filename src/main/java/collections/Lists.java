package collections;

import java.util.Iterator;

public abstract  class Lists <T> implements List <T> {
    protected int size;

    public abstract class ListsIterator implements Iterator<T> {
        protected int current;

        public int getCurrent() {
            return current;
        }

        public void decreaseCurrent() {
            current--;
        }

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public abstract T next();
    }

    public abstract ListsIterator iterator();

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
    public abstract boolean addAll(int index, Collections<T> collection );

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
        ListsIterator iterator = this.iterator();
        boolean result = false;
        while (iterator.hasNext()) {
            T checkItem = iterator.next();
            if(checkItem != null ? checkItem.equals(element) : element == null) {
                this.remove(iterator.getCurrent() - 1);
                iterator.decreaseCurrent();
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

    @Override
    public abstract void  set(int index, T element);

    @Override
    public abstract T get(int index);


    @Override
    public abstract T[] toArray();

    @Override
    public abstract T remove(int index);

}
