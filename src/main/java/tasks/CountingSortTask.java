package tasks;

public class CountingSortTask {

    /**
     * Count duplicate elements from input array and return data in new array where index is element from input array
     * @cpu O(n + m), n - array.length, m - array[max]: max value from array
     * @ram O(m),  m - array[max]: max value from array
     * @param array array with numbers
     * @return array with count of duplicate elements from input array
     */
    public static int[] count(int[] array) {
        if (array.length == 0) {
            return new int[]{};
        }
        if (array == null) {
            return null;
        }
        int max = 0;
        for (int i = 0 ; i < array.length; i++) {
            if (max < array[i]) {
                max  = array[i];
            }
        }
        int [] result = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            int index = array[i];
            result[index]++;
        }
        return  result;
    }
}
