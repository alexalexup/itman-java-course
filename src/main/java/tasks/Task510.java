package tasks;
import utils.ArrayUtils;

public class Task510 {

    /**
     * Find and return most frequent element from array
     * cpu O(n * logn), n - array.length
     * @ram O(n), array.length
     * @param array array with numbers
     * @return most frequent element from array
     */
    public static int mostFrequent(int array[]) {
        int[] sortArray = new int[array.length];
        System.arraycopy(array,0,sortArray,0, array.length);
        ArrayUtils.mergeSort(sortArray);
        int result = sortArray[0];
        int cntFirst = 0;
        int cntSecond = 0;
        for (int i = 0; i < sortArray.length - 1; i ++) {
            if (sortArray[i] == sortArray[i + 1]) {
                cntFirst++;
                if (cntFirst > cntSecond) {
                    result = sortArray[i];
                }
            } else if (cntFirst > 1) {
                    cntSecond = cntFirst;
                    cntFirst = 0;
            }
        }
        return result;
    }
}
