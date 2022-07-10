package collections;

import utils.StringBuilder;

public class ArrayList implements List {
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
        if (element == null) {
            return;
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

    public String toString() {
        if ( this.size == 0 ) {
            return "[]";
        }
        if (this.size == 1) {
            StringBuilder result = new StringBuilder(3);
            return result.append("[")
                    .append(this.objects[0].toString())
                    .append("]")
                    .toString();
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < this.size; i++) {
            if (i != this.size - 1) {
                if (this.objects[i] == null) {
                    result.append(null)
                            .append(", ");
                } else {
                    result.append(this.objects[i].toString())
                            .append(", ");
                }
            } else {
                if (this.objects[i] == null) {
                    result.append(null)
                            .append("]");
                } else {
                    result.append(this.objects[i].toString())
                            .append("]");
                }
            }
        }
        return result.toString();
    }

    public boolean equals(Object that) {
        if (that == null || that.getClass() != ArrayList.class) {
            return false;
        }
        ArrayList thatArray = (ArrayList) that;
        if (this.size != thatArray.size()) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (this.objects[i] == null) {
              if (thatArray.objects[i] != null) {
                  return false;
              }
            } else {
                if (this.objects[i].equals(thatArray.objects[i])) {
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
