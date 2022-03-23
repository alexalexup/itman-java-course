package benchmarks;

import java.util.Random;
import entities.Event;
import utils.ArrayUtils;

public class SortBenchmark {

    /**
     * Create array  with random numbers
     * @cpu O(n), n - array.length
     * @ram O(n), n - array.length
     * @param n argument
     * @param min argument
     * @param max argument
     * return array with random numbers
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
     * Create array with events. Method generate array with random data
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

    // bsp1: 0.2s
    // bsp2: 0.2S
    // bsp3: 20.57s
    // bsp4: 20.83s
    // bsp01: 0.61s
    // bsp02: 0.47s
    // bsp03: 92.67s
    // bsp04: 90.47s
    // сsp1: 0.002s
    // csp2: OutOfMemory
    // csp3: 0.006s
    // csp4: OutOfMemory
    // cso1: 0.007s
    // cso2: OutOfMemory
    // cso3: 0.026s
    // cso4: OutOfMemory
    // msp1: 0.004s
    // msp2: 0.005s
    // msp3: 0.022s
    // msp4: 0.020s
    // mso1: 0.008s
    // mso2: 0.010s
    // mso3: 0.055s
    // mso4: 0.056s
    public static void main (String[] args) {
        int[] numbersArray = randomArray(10000, -10000, 10000);
        Event[] events = randomEvents(10000, 2000, 2021);
        String[] name = new String[]{"bsp", "bspo", "csp", "cso", "msp", "mso"};
        long[] time = new long[7];
        time[0] = System.currentTimeMillis();
        ArrayUtils.bubbleSort(numbersArray);
        time[1] = System.currentTimeMillis();
        ArrayUtils.bubbleSort(events);
        time[2] = System.currentTimeMillis();
        ArrayUtils.countingSort(numbersArray);
        time[3] = System.currentTimeMillis();
        ArrayUtils.countingSort(events);
        time[4] = System.currentTimeMillis();
        ArrayUtils.mergeSort(numbersArray);
        time[5] = System.currentTimeMillis();
        ArrayUtils.mergeSort(events);
        time[6] = System.currentTimeMillis();
        for (int i = 0; i < time.length - 1; i++) {
            long result = time[i + 1] - time[i];
            System.out.println(name[i] + ":" + result + "ms");
        }
    }
}
