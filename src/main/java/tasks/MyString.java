package tasks;

public class MyString {
    private char[] symbols;

    /**
     * Gets an array of characters and copies it to a new array which is an object field
     * @cpu O(n), n - symbols.length
     * @ram O(n), n - symbols.length
     * @param symbols array
     */
    public MyString(char[] symbols) {
        this.symbols = new char[symbols.length];
        System.arraycopy(symbols, 0, this.symbols, 0, symbols.length);
    }

    /**
     * concatenation two objects by MyString class
     * @cpu O(n + m), n - symbols.length, m - that.symbols.length
     * @ram O(n + m), n - symbols.length, m - that.symbols.length
     * @param that Object by MyString class
     * @return concatenation two strings
     */
    public MyString plus(MyString that) {
        if(symbols.length == 0 && that.symbols.length == 0) {
            MyString resultString = new MyString(new char[]{});
            return resultString;
        }
        int resultLength = symbols.length + that.symbols.length;
        char[] result = new char[resultLength];
        System.arraycopy(symbols, 0, result, 0, symbols.length);
        System.arraycopy(that.symbols, 0, result, symbols.length, that.symbols.length);
        MyString resultString = new MyString(result);
        return resultString;
    }

    /**
     * concatenation two objects by MyString class
     * @cpu O(n + m), n - a.symbols.length, m - b.symbols.length
     * @ram O(n + m), n - a.symbols.length, m - b.symbols.length
     * @param a Object by MyString class
     * @param b Object by MyString class
     * @return concatenation two strings
     */
    public static MyString plus(MyString a, MyString b) {
      MyString result = a.plus(b);
      return result;
    }

    /**
     * convert characters from field symbols to String
     * @cpu O(n)
     * @ram O(n)
     * @return String with characters from symbols field
     */
    public String toString() {
        String result = new String(symbols);
        return result;
    }

    /**
     * determining length array symbols
     * @cpu O(1)
     * @ram O(1)
     * @return length of array symbols
     */
    public int length() {
        if ( symbols == null) {
            int result = 0;
            return result;
        }
        int result = symbols.length;
        return result;
    }

    /**
     * find symbol from symbols array by index
     * @cpu O(1)
     * @ram O(1)
     * @param index argument
     * @return symbol from smb array
     */
    public char charAt(int index) {
        char result = symbols[index];
        return result;
    }

    /**
     * compares two field symbols
     * @cpu O(n), n - symbols.length
     * @ram O(1)
     * @param that Object from class MyString
     * @return negative number if this < that, positive number if this > that, zero if this == that
     */
    public int compareTo(MyString that) {
        for (int i = 0; i < symbols.length && i < that.symbols.length; i ++) {
            if (symbols[i] < that.symbols[i]) {
                return -1;
            }
            if (symbols[i] > that.symbols[i]) {
                return 1;
            }
        }
        if (symbols.length < that.symbols.length ) {
            return -1;
        }
        if (symbols.length > that.symbols.length ) {
            return 1;
        }
        return 0;
    }

    /**
     * compares two objects
     * @cpu O(n), n - symbols.length
     * @ram O(1)
     * @param obj argument
     * @return true if both strings are equal, false if two strings aren't equal
     */
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != MyString.class) {
            return false;
        }
        MyString that = (MyString) obj;
        if (compareTo(that) == 0) {
            return true;
        }
        return false;
    }

    /**
     * find and replace target symbol on replacement
     * @cpu O(n), n - symbols.length
     * @ram O(n), n - symbols.length
     * @param target argument
     * @param replacement argument
     * @return concatenation two strings
     */
    public MyString replace(char target, char replacement){
        if( symbols == null) {
            MyString result = new MyString(null);
            return result;
        }
        if (symbols.length == 0) {
            MyString result = new MyString(new char[]{});
            return result;
        }
        char[] res = new char[symbols.length];
        System.arraycopy(symbols,0, res,0, symbols.length);
        for (int i = 0; i < res.length; i++) {
            if (res[i] == target){
                res[i] = replacement;
            }
        }
        MyString result = new MyString(res);
        return result;
    }
}
