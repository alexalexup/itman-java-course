package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTaskTest {

    @Test
    public void sortShouldReturnCountOfDuplicateElementsWhenInputArrayHaveSomeElement() {
        int[] array = new int[]{1, 5, 3, 1, 2};
        int[] actualResult = CountingSortTask.count(array);
        int[] expectedResult = new int[]{0, 2, 1, 1, 0, 1};
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void sortShouldReturnCountOfDuplicateElementWhenInputArrayHaveOneElement() {
        int[] array = new int[]{8};
        int[] actualResult = CountingSortTask.count(array);
        int[] expectedResult = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1};
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void sortShouldReturnEmptyArrayWhenInputArrayHaveNotData() {
        int[] array = new int[]{};
        int[] actualResult = CountingSortTask.count(array);
        int[] expectedResult = new int[]{};
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void restoreShouldReturnResultWhenInputArrayHaveSomeElement() {
        int[] array = new int[]{0, 2, 1, 1, 0, 1};
        int[] actualResult = CountingSortTask.restore(array);
        int[] expectedResult = new int[]{1, 1, 2, 3, 5};
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void restoreShouldReturnEmptyArrayWhenInputArrayHaveNotData() {
        int[] array = new int[]{};
        int[] actualResult = CountingSortTask.restore(array);
        int[] expectedResult = new int[]{};
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void restoreShouldReturnCountOfDuplicateElementWhenInputArrayHaveOneElement() {
        int[] array = new int[]{3};
        int[] actualResult = CountingSortTask.restore(array);
        int[] expectedResult = new int[]{0, 0, 0};
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }
}