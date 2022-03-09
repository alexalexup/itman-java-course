package tasks;

public class Task497 {
    /**
     * Merge two arrays
     * cpu O(n), n = a.length + b.length
     * @ram O(1)
     * @param a array with numbers
     * @param b array with numbers
     * @return array with elements from both arrays in increasing order
     */
    public static int[] merge(int[] a, int[] b){
        int[] result = new int[a.length + b.length];
        for (int i = 0, j = 0, k = 0; i < result.length; i++) {
            if (j >= a.length) {
                result[i] = b[k];
                k++;
            } else if (k >= b.length) {
                result[i] = a[j];
                j++;
            } else {
                if (a[j] <= b[k]) {
                    result[i] = a[j];
                    j++;
                } else {
                    result[i] = b[k];
                    k++;
                }
            }
        }
        return result;
    }
}
