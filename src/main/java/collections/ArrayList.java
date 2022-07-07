package collections;

public class ArrayList {
    private Object[] objects;
    private int size;

    public ArrayList() {
        this.objects = new Object[16];
    }

    public ArrayList(int capacity) {
        this.objects = new Object[capacity];
    }

    public void add(Object element) {
        this.size++;
        if (this.size >= this.objects.length) {
            Object[] newObjects = new Object[this.objects.length * 2];
            System.arraycopy(this.objects, 0, newObjects, 0, this.objects.length);
            this.objects = newObjects;
        }
        this.objects[this.size - 1] = element;
    }

    public void set(int index, Object element) {
        this.objects[index] = element;
    }

    public Object get(int index) {
        return this.objects[index];
    }

    public int size() {
        return this.size;
    }

    public Object[] toArray() {
        Object[] array = new Object[this.size];
        System.arraycopy(this.objects, 0, array, 0,this.size);
        return array;
    }

    public Object remove(int index) {
        Object result = this.objects[index];
        this.size--;
        for (int i = index; i < this.size; i++) {
            this.objects[i] = this.objects[i+1];
        }
        return result;
    }

    public static ArrayList of (Object ... elements) {
        ArrayList arrayList = new ArrayList(elements.length);
        for (int i = 0 ; i < elements.length; i ++) {
            arrayList.add(elements[i]);
        }
        return arrayList;
    }
}
