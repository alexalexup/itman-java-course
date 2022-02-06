package utils;

public class StringBuilder {
    private char[] data;
    private int size;

    public StringBuilder(int capacity ){
        this.data = new char[capacity];
    }

    public StringBuilder() {
        this.data = new char[16];
    }

    public int length() {
        return this.size;
    }

    private void add(char symbol) {
        if (this.size >= this.data.length) {
            char[] newString = new char[this.length() * 2];
            System.arraycopy(this.data, 0, newString, 0, this.size );
            this.data = newString;
        }
        this.size++;
        this.data[size - 1] = symbol;
    }

    public StringBuilder append(String s) {
        if(s == null) {
            return this;
        }
        for (int i = 0; i < s.length(); i++) {
            this.add(s.toCharArray()[i]);
        }
        return this;
    }

    public StringBuilder append(boolean x){
        String s = "" + x;
        return this.append(s);
    }

    public StringBuilder append(int x){
        String s = "" + x;
        return this.append(s);
    }

    public StringBuilder append(double x){
        String s = "" + x;
        return this.append(s);
    }

    public StringBuilder append(long x){
        String s = "" + x;
        return this.append(s);
    }

    public String toString() {
        if (this.size == 0) {
            String s = "";
            return s;
        }
        if (this.data.length == this.size) {
            String s = new String(this.data);
            return s;
        }
        char[] String = new char[size];
        System.arraycopy(this.data,0,String,0,this.size);
        String s = new String(String);
        return s;
    }
}
