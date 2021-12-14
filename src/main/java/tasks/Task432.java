package tasks;

public class Task432 {
    public static long[] calcPrimeNumbers( long x) {
        long b = x;
        long p =x;
        int max = 0;
        int max2 = 0;
        int j = 0;
        if (x < 2) {
            long[] actual = new long[] {1};
            return actual;
        }
        for (int i = 2; i < (long)Math.sqrt(b) + 1; i++) {
            if (b % i == 0) {
                b = b/ i;
                if (i > max) {
                    max =i;
                    j++;
                }
                i = 1;
            }
        }
        if (max >= b) {
            int index = 0;
            long[] actual = new long[j];
            for (int i =2; i < (long)Math.sqrt(x) + 1; i++ ) {

                if (x % i == 0) {
                    x = x / i;
                    if (i > max2 ) {
                        max2 = i;
                        actual[index] = i;
                        index++;
                    }
                    i = 1;
                }
            }
            return actual;
        }
        if (max < b) {
            int index = 0;
            long[] actual = new long[j+1];
            for (int i =2; i < (long)Math.sqrt(x) + 1; i++ ) {
                if (x % i == 0) {
                    x = x / i;
                    if (i > max2) {
                        max2 = i;
                        actual[index] = i;
                        index++;
                    }
                    i = 1;
                }
            }
            actual[j] =b;
            return actual;
        }
        return null;
    }
}
