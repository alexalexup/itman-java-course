package tasks;

public class Task406 {
    /**
     * find second max element from array
     * @cpu O(n), n - a.length
     * @ram O(1)
     * @param a array with numbers
     * @return second max element from a array
     */
    public static int findSecondMax (int[] a ) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int n = a.length;
        if (n == 1) {
            return a[0];
        }
        for (int i = 0; i < n; i++) {
            if ( max <= a[i]) {
                max2 = max;
                max = a[i];
            } else if (max2 < a[i]) {
                max2 = a[i];
            }
        }
        return max2;
    }
}
