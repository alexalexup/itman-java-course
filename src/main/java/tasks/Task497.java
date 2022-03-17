package tasks;

public class Task497 {
    /**
     * Merge two arrays
     * cpu O(n), n = a.length + b.length
     * @ram O(n), n = a.length + b.length
     * @param a array with numbers
     * @param b array with numbers
     * @return array with elements from both arrays in increasing order
     */
    public static int[] merge(int[] a, int[] b){
        int[] result = new int[a.length + b.length];
        for (int i = 0, j = 0, k = 0; i < result.length; i++) {
            if (k < b.length && (j >= a.length || a[j] > b[k])) {
                result[i] = b[k];
                k++;
            } else {
                result[i] = a[j];
                j++;
            }
        }
        return result;
    }
}
