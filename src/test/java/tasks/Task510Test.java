package tasks;

import benchmarks.SortBenchmark;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.ArrayUtils;

import static org.junit.jupiter.api.Assertions.*;

class Task510Test {

    @Test
    public void mostFrequentShouldReturnResultWhenArrayHaveSomeEqualElementsAndEqualElementsHaveSameCount() {
        int[] array = new int[]{1, 2, 5, 1, 2, 2, 3, 1};
        int result = Task510.mostFrequent(array);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void mostFrequentShouldReturnResultWhenArrayHaveSomeEqualElements() {
        int[] array = new int[]{6, 2, 5, 1, 2, 6, 1, 4, 4, 5, 3,6, 6};
        int result = Task510.mostFrequent(array);
        Assertions.assertEquals(6, result);
    }

    @Test
    public void mostFrequentShouldReturnResultWhenArrayHaveOneElement() {
        int[] array = new int[]{12};
        int result = Task510.mostFrequent(array);
        Assertions.assertEquals(12, result);
    }

    @Test
    public void mostFrequentShouldReturnResultWhenArrayHaveOnlyEqualElement() {
        int[] array = new int[]{3, 3, 3, 3, 3, 3};
        int result = Task510.mostFrequent(array);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void mostFrequentShouldWorkLessOneSecond(){
        int[] array = SortBenchmark.randomArray(100000, 1, 30000);
        long firstTime = System.currentTimeMillis();
        Task510.mostFrequent(array);
        long secondTime = System.currentTimeMillis();
        long result = secondTime - firstTime;
        Assertions.assertTrue(result < 1000);
    }
}