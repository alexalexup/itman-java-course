package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTaskTest {

    @Nested
    public class Sort {
        @Test
        public void shouldReturnCountOfDuplicateElementsWhenInputArrayHaveSomeElement() {
            int[] array = new int[]{1, 5, 3, 1, 2};
            int[] actualResult = CountingSortTask.count(array);
            int[] expectedResult = new int[]{0, 2, 1, 1, 0, 1};
            Assertions.assertArrayEquals(expectedResult, actualResult);
        }

        @Test
        public void shouldReturnCountOfDuplicateElementWhenInputArrayHaveOneElement() {
            int[] array = new int[]{8};
            int[] actualResult = CountingSortTask.count(array);
            int[] expectedResult = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1};
            Assertions.assertArrayEquals(expectedResult, actualResult);
        }

        @Test
        public void shouldReturnEmptyArrayWhenInputArrayHaveNotData() {
            int[] array = new int[]{};
            int[] actualResult = CountingSortTask.count(array);
            int[] expectedResult = new int[]{};
            Assertions.assertArrayEquals(expectedResult, actualResult);
        }

        @Test
        public void shouldSortArrayByIncreasingValue() {
            int[] array = new int[]{6, 5, 3, 4, 1, 1, 1, 5, 2, 0};
            CountingSortTask.sort(array);
            int[] expectedResult = new int[]{0, 1, 1, 1, 2, 3, 4, 5, 5, 6};
            Assertions.assertArrayEquals(expectedResult, array);
        }

        @Test
        public void shoudlWorktWhenInputArrayHaveOneElement() {
            int[] array = new int[]{5};
            CountingSortTask.sort(array);
            int[] expectedResult = new int[]{5};
            System.out.println(Integer.MAX_VALUE);
            Assertions.assertArrayEquals(expectedResult, array);
        }

        @Test
        public void shouldWorkWhenInputArrayHaveEqualElements() {
            int[] array = new int[]{7, 7, 7, 7, 7};
            CountingSortTask.sort(array);
            int[] expectedResult = new int[]{7, 7, 7, 7, 7};
            Assertions.assertArrayEquals(expectedResult, array);
        }

        @Test
        public void shouldWorkWhenInputArrayHaveNotElements() {
            int[] array = new int[]{};
            CountingSortTask.sort(array);
            int[] expectedResult = new int[]{};
            Assertions.assertArrayEquals(expectedResult, array);
        }
    }

    @Nested
    public class Restore {
        @Test
        public void shouldReturnResultWhenInputArrayHaveSomeElement() {
            int[] array = new int[]{0, 2, 1, 1, 0, 1};
            int[] actualResult = CountingSortTask.restore(array);
            int[] expectedResult = new int[]{1, 1, 2, 3, 5};
            Assertions.assertArrayEquals(expectedResult, actualResult);
        }

        @Test
        public void shouldReturnEmptyArrayWhenInputArrayHaveNotData() {
            int[] array = new int[]{};
            int[] actualResult = CountingSortTask.restore(array);
            int[] expectedResult = new int[]{};
            Assertions.assertArrayEquals(expectedResult, actualResult);
        }

        @Test
        public void shouldReturnCountOfDuplicateElementWhenInputArrayHaveOneElement() {
            int[] array = new int[]{3};
            int[] actualResult = CountingSortTask.restore(array);
            int[] expectedResult = new int[]{0, 0, 0};
            Assertions.assertArrayEquals(expectedResult, actualResult);
        }
    }
}