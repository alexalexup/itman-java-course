package tasks;

import collections.IntArrayList;

public class CountingSortTask {

    /**
     * Count duplicate elements from input array and return data in new array where index is element from input array
     * @cpu O(n + m), n - array.length, m - max(array)
     * @ram O(m),  m - m - max(array)
     * @param array array with numbers
     * @return array with count of duplicate elements from input array
     */
    public static int[] count(int[] array) {
        if (array.length == 0) {
            return new int[]{};
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

    /**
     * Restores the sorted array based on input data and the counting method
     * @cpu O(n + k), n - array.length, k - sum(array) sum of all elements from array
     * @ram O(k),  k - sum(array) sum of all elements from array
     * @param array array with numbers
     * @return array with count of duplicate elements from input array
     */
     public static int[] restore(int[] array) {
         if (array.length == 0) {
             return new int[]{};
         }
        IntArrayList sortNumb = new IntArrayList();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i]; j++) {
                sortNumb.add(i);
            }
        }
        return sortNumb.toArray();
     }

    /**
     * Sort array in increasing order.The counting algorithm is used
     * @cpu O(n + m), n - array.length, m - max(array)
     * @ram O(n + m), n - array.length, m - max(array)
     * @param array array with numbers
     */
     public static void sort(int[] array) {
        int[] result = restore(count(array));
        System.arraycopy(result,0,array,0,result.length);
     }
}
