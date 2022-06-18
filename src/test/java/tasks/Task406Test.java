package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class Task406Test {

    @Nested
    public class FindSecondMax {
        @Test
        public void shouldReturnFirstElementOfArrayWhenSecondMaxIsFirst() {
            int[] a = new int[]{2, 10, 1};
            Assertions.assertEquals(2, Task406.findSecondMax(a));
        }

        @Test
        public void shouldReturnLastElementOfArrayWhenSecondMaxIsLast() {
            int[] a = new int[]{5, 2, 4};
            Assertions.assertEquals(4, Task406.findSecondMax(a));
            Assertions.assertArrayEquals(new int[]{5, 2, 4}, a);
        }

        @Test
        public void shouldReturnMiddleElementOfArrayWhenSecondMaxInMiddle() {
            int[] a = new int[]{8, 7, 2};
            Assertions.assertEquals(7, Task406.findSecondMax(a));
            Assertions.assertArrayEquals(new int[]{8, 7, 2}, a);
        }

        @Test
        public void shouldReturnThirdElementOfArrayWhenArrayHaveTwoSameSecondMaxElements() {
            int[] a = new int[]{6, 0, 7, 8, 7};
            Assertions.assertEquals(7, Task406.findSecondMax(a));
            Assertions.assertArrayEquals(new int[]{6, 0, 7, 8, 7}, a);

        }

        @Test
        public void shouldReturnFirstElementOfArrayWhenArrayContainOneElement() {
            int[] a = new int[]{-5};
            Assertions.assertEquals(-5, Task406.findSecondMax(a));
        }
    }
}