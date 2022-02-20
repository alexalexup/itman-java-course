package benchmarks;

import java.util.Random;
import entities.Event;
import utils.ArrayUtils;

public class SortBenchmark {

    /**
     * Create array with random length and with random numbers
     * @cpu O(n), n - array.length
     * @ram O(n), n - array.length
     * @param n argument
     * @param min argument
     * @param max argument
     * return array with random length and numbers
     */
    public static int[] randomArray(int n, int min, int max) {
        Random random  = new Random(3);
        int delta = max - min;
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(delta) + min;
        }
        return array;
    }

    /**
     * Create array with events. Method generate array with random length and data
     * @cpu O(n), n - array.length
     * @ram O(n), n - array.length
     * @param n argument
     * @param min argument
     * @param max argument
     * return array with events.
     */
    public static Event[] randomEvents(int n, int min, int max){
        Random random = new Random(6);
        int delta = max - min;
        Event[] events = new Event[n];
        for (int i = 0; i < events.length; i ++) {
            int year = random.nextInt(delta) + min;
            int month = random.nextInt(12) + 1;
            int day = random.nextInt(31) + 1;
            String name = new StringBuilder(20).append(random.nextLong()).toString();
            events[i] = new Event(year, month, day, name);
        }
        return events;
    }

    // bsp1: 0.04s
    // bsp2: 0.03S
    // bsp3: 2.33s
    // bsp4: 2.31s
    // bsp01: 0.26s
    // bsp02: 0.19s
    // bsp03: 27.76s
    // bsp04: 25.12s
    public static void main (String[] args) {
        int[] numbersArray = randomArray(10000, -10000, 10000);
        Event[] events = randomEvents(10000, 2000, 2021);
        long firstTime = System.currentTimeMillis();
        ArrayUtils.bubbleSort(numbersArray);
        ArrayUtils.bubbleSort(events);
        long secondTime = System.currentTimeMillis();
        System.out.println(secondTime-firstTime + " ms");
    }
}
