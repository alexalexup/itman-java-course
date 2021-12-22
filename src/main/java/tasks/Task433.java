package tasks;

public class Task433 {
    /**
     * Calculation gcd from two arguments
     * @cpu O(log(a) + log(b))
     * @ram O(1)
     * @param a argument
     * @param b argument
     * @return gcd from a and b arguments
     */
    public static long gcd(long a, long b) {
        long z = 0l;
        if ( b > a) {
            long x = b;
            b = a;
            a = x;
        }
        if ( a % b == 0) {
            return b;
        }
        while ( b != 0){
            z = b;
            b = a % b;
            a = z;
        }
        return z;
    }
}
