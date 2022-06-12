package utils;

public class StringBuilder {
    private char[] data;
    private int size;

    /**
     * Create object by StringBuilder class without logical data with physical array that is data field
     * @cpu O(n), n - capacity
     * @ram O(n), n - capacity
     * @param capacity argument
     * @return string without logical data
     */
    public StringBuilder(int capacity ){
        this.data = new char[capacity];
    }

    /**
     * Create object by StringBuilder class without logical data with physical array that is data field
     * @cpu O(1)
     * @ram O(1)
     * @return string without logical data
     */
    public StringBuilder() {
        this.data = new char[16];
    }

    /**
     * Determining the logical length of a string
     * @cpu O(1)
     * @ram O(1)
     * @return logical length of a string
     */
    public int length() {
        return this.size;
    }

    /**
     * Add symbol to string
     * @cpu O(1)
     * @ram O(n), n - this.data.length
     * @param symbol argument
     */
    private void add(char symbol) {
        if (this.size >= this.data.length) {
            char[] newString = new char[this.length() * 2];
            System.arraycopy(this.data, 0, newString, 0, this.size );
            this.data = newString;
        }
        this.size++;
        this.data[size - 1] = symbol;
    }

    /**
     * Add symbols by string argument to current object
     * @cpu O(n), n - s.length
     * @ram O(n + m), n - s.length, m - this.data.length
     * @param s string
     * return string with added data from the argument
     */
    public StringBuilder append(String s) {
        if(s == null) {
            s = "null";
        }
        char[] stringData = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            this.add(stringData[i]);
        }
        return this;
    }

    /**
     * Add symbols by boolean argument to current object
     * @cpu O(1)
     * @ram O(m), m - this.data.length
     * @param x argument
     * return string with added data from the argument
     */
    public StringBuilder append(boolean x){
        String s = "" + x;
        return this.append(s);
    }

    /**
     * Add symbols by Integer argument to current object
     * @cpu O(1)
     * @ram O(m), m - this.data.length
     * @param x argument
     * return string with added data from the argument
     */
    public StringBuilder append(int x){
        String s = "" + x;
        return this.append(s);
    }

    /**
     * Add symbols by Double argument to current object
     * @cpu O(n), n - x
     * @ram O(m), m - this.data.length
     * @param x argument
     * return string with added data from the argument
     */
    public StringBuilder append(double x){
        String s = "" + x;
        return this.append(s);
    }

    /**
     * Add symbols by Long argument to current object
     * @cpu O(1)
     * @ram O(m), m - this.data.length
     * @param x argument
     * return string with added data from the argument
     */
    public StringBuilder append(long x){
        String s = "" + x;
        return this.append(s);
    }

    /**
     * Create and return new string with logical data from object by StringBuilderClass
     * @cpu O(n), n - this.data.length
     * @ram O(n), n - this.data.length
     * return string with logical data from object by StringBuilderClass
     */
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
