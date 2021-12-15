package tasks;

public class Task433 {
    /**
     * Calculation gcd from two arguments
     * @ram O(1)
     * @cpu O(log(mod2))
     * @param a argument
     * @param b argument
     * @return gcd from a and b arguments
     */
    public static long gcd(long a, long b) {
        long mod1 = 0l;
        long mod2 = 0l;
        if ( a % b == 0) {
            return b;
        }
        if (b % a == 0) {
            return a;
        }
        if (a > b) {
            mod2 = a % b;
            mod1 = b;
            while ( mod2 != 0){
                long z = mod2;
                mod2 = mod1 % mod2;
                mod1 = z;
            }
            return mod1;
        } else {
            mod2 = b % a;
            mod1 = a;
            while ( mod2 !=0) {
                long z = mod2;
                mod2 = mod1 % mod2;
                mod1 = z;
            }
            return mod1;
        }
    }
}
