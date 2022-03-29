package tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task679Test {
    @Test
    public void repSortShouldWork() {
        int[] a = new int[]{4, 2, 1, 4, 2, 1, -3, 8, -100, 10, 2};
        Task679.repSort(a);
        for (int i = 0 ; i < a.length; i ++) {
            System.out.println(a[i]);
        }
    }
    @Test
    public void bubbleSortShouldWork() {
        int[] a = new int[]{4, 2, 1, 4, 2, 1, -3, 8, -100, 10, 2};
        Task679.bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    @Test
    public void countingSortShouldWork() {
        int[] a = new int[]{4, 2, 1, 4, 2, 1, -3, 8, -100, 10, 2};
        Task679.countingSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}