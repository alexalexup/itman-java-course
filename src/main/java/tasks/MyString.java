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

    public String toString() {
        if ( smb == null) {
            return null;
        }
        String result = new String(smb);
        return result;
    }

    public int length() {
        if ( smb == null) {
            int result = 0;
            return result;
        }
        int result = smb.length;
        return result;
    }

    public char charAt(int index) {
        char result = smb[index];
        return result;
    }

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

    public boolean equals(MyString that) {
        if (that == null) {
            return false;
        }
        if (compareTo(that) == 0) {
            return true;
        }
        return false;
    }
}
