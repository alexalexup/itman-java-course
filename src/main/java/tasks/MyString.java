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

}
