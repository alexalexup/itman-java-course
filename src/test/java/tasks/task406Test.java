package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class task406Test {

    @Test
    void findSecondMaxWhenMaxInFirst() {
        int[] a = new int[]{2, 10, 1};
        Assertions.assertEquals(2, task406.findSecondMax(a));
    }

    @Test
    void findSecondMaxWhenMaxInLast() {
        int[] a = new int[]{5, 2, 4};
        Assertions.assertEquals(4, task406.findSecondMax(a));
        Assertions.assertArrayEquals(new int[]{5, 2, 4}, a);

    }

    @Test
    void findSecondMaxWhenMaxInMiddle() {
        int[] a = new int[]{8, 7, 2};
        Assertions.assertEquals(7, task406.findSecondMax(a));
        Assertions.assertArrayEquals(new int[]{8, 7, 2}, a);
    }

    @Test
    void findSecondMaxWhenArrayContainsFewSecondMaxElements() {
        int[] a = new int[]{6, 0, 7, 8, 7};
        Assertions.assertEquals(7, task406.findSecondMax(a));
        Assertions.assertArrayEquals(new int[]{6, 0, 7, 8, 7}, a);

    }

    @Test
    void findSecondMaxWhenArrayContainsSingleElements() {
        int[] a = new int[]{-5};
        Assertions.assertEquals(-5, task406.findSecondMax(a));
    }


}