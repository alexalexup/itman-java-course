package tasks;

public class MyString {
    private char[] smb;

    public MyString(char[] smb) {
        if (smb != null) {
            this.smb = new char[smb.length];
            System.arraycopy(smb, 0, this.smb, 0, smb.length);
        } else if (smb == null) {
            this.smb = null;
        }
    }
    /**
     * concatenation two objects by MyString class
     * @cpu O(n + m), n - smb.length, m - that.smb.length
     * @ram O(m), m - resultLength
     * @param that Object by MyString class
     * @return concatenation two strings
     */
    public MyString plus(MyString that) {
        if(smb.length == 0 && that.smb.length == 0) {
            MyString resultString = new MyString(new char[]{});
            return resultString;
        }
        int resultLength = smb.length + that.smb.length;
        char[] result = new char[resultLength];
        System.arraycopy(smb, 0, result, 0, smb.length);
        System.arraycopy(that.smb, 0, result, smb.length, that.smb.length);
        MyString resultString = new MyString(result);
        return resultString;
    }
    /**
     * concatenation two objects by MyString class
     * @cpu O(n + m), n - a.smb.length, m - b.smb.length
     * @ram O(m), m - resultLength
     * @param a Object by MyString class
     * @param b Object by MyString class
     * @return concatenation two strings
     */
    public static MyString plus(MyString a, MyString b) {
        if (a.smb.length == 0 && b.smb.length == 0) {
            MyString resultString = new MyString(new char[]{});
            return resultString;
        }
        int resultLength = a.smb.length + b.smb.length;
        char[] result = new char[resultLength];
        for (int i = 0; i < a.smb.length; i++) {
            result[i] = a.smb[i];
        }
        for (int i = 0; i < b.smb.length; i++) {
            result[i + a.smb.length] = b.smb[i];
        }
        MyString resultString = new MyString(result);
        return resultString;
    }
    /**
     * convert field smb to String
     * @cpu O(1)
     * @ram O(1)
     * @return String with symbols from smb field
     */
    public String toString() {
        if ( smb == null) {
            return null;
        }
        String result = new String(smb);
        return result;
    }
    /**
     * determining length array smb
     * @cpu O(1)
     * @ram O(1)
     * @return length of array smb
     */
    public int length() {
        if ( smb == null) {
            int result = 0;
            return result;
        }
        int result = smb.length;
        return result;
    }
    /**
     * find symbol from smb array by index
     * @cpu O(1)
     * @ram O(1)
     * @param index argument
     * @return symbol from smb array
     */
    public char charAt(int index) {
        char result = smb[index];
        return result;
    }
    /**
     * compares two field smb
     * @cpu O(n), n - smb.length
     * @ram O(1)
     * @param that Object from class MyString
     * @return negative number if this < that, positive number if this > that, zero if this == that
     */
    public int compareTo(MyString that) {
        int result = 0;
        for (int i = 0; i < smb.length && i < that.smb.length; i ++) {
            if (smb[i] < that.smb[i]) {
                result = -1;
                return result;
            }
            if (smb[i] > that.smb[i]) {
                result = 1;
                return result;
            }
        }
        if (smb.length < that.smb.length ) {
            result = -1;
            return result;
        }
        if (smb.length > that.smb.length ) {
            result = 1;
            return result;
        }
        return result;
    }
    /**
     * compares two strings
     * @cpu O(n), n - smb.length
     * @ram O(1)
     * @param that Object from class MyString
     * @return true if both strings are equal, false if two strings aren't equal
     */
    public boolean equals(MyString that) {
        if (that == null) {
            return false;
        }
        if (compareTo(that) == 0) {
            return true;
        }
        return false;
    }
    /**
     * find and replace target symbol on replacement
     * @cpu O(n), n - smb.length
     * @ram O(n), n - smb.length
     * @param target argument
     * @param replacement argument
     * @return concatenation two strings
     */
    public MyString replace(char target, char replacement){
        if( smb == null) {
            MyString result = new MyString(null);
            return result;
        }
        if (smb.length == 0) {
            MyString result = new MyString(new char[]{});
            return result;
        }
        char[] res = new char[smb.length];
        System.arraycopy(smb,0, res,0,smb.length);
        for (int i = 0; i < res.length; i++) {
            if (res[i] == target){
                res[i] = replacement;
            }
        }
        MyString result = new MyString(res);
        return result;
    }
}
