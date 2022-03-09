package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task497Test {

    @Test
    public void mergeShouldReturnResultWhenArraysHaveSameLength() {
        int[] a = new int[]{1, 3, 3, 5, 7, 10};
        int[] b = new int[]{1, 2, 5, 6, 6, 9};
        int[] expectedResult = new int[]{1, 1, 2, 3, 3, 5, 5, 6, 6, 7, 9, 10};
        int[] actualResult = Task497.merge(a, b);
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void mergeShouldReturnResultWhenArraysHaveDifferentLength() {
        int[] a = new int[]{1, 3, 3, 5, 7, 10};
        int[] b = new int[]{1, 2, 5, 6, 6, 9, 11, 12, 12};
        int[] expectedResult = new int[]{1, 1, 2, 3, 3, 5, 5, 6, 6, 7, 9, 10, 11, 12, 12};
        int[] actualResult = Task497.merge(a, b);
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void mergeShouldReturnResultWhenOneArrayHaveNotElements() {
        int[] a = new int[]{};
        int[] b = new int[]{1, 2, 5, 6, 6, 9, 11, 12, 12};
        int[] expectedResult = new int[]{1, 2, 5, 6, 6, 9, 11, 12, 12};
        int[] actualResult = Task497.merge(a, b);
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void mergeShouldReturnResultWhenBothArraysHaveNotElements() {
        int[] a = new int[]{};
        int[] b = new int[]{};
        int[] expectedResult = new int[]{};
        int[] actualResult = Task497.merge(a, b);
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }
}