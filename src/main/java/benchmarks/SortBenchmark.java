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
    // cso1: 0.026s
    // cso2: OutOfMemory
    // cso3: 0.026s
    // cso4: OutOfMemory
       /*
    msp1: randomArray(10_000, -10_000, 10_000)
    msp2: randomArray(10_000, -1_000_000_000, 1_000_000_000)
    msp3: randomArray(100_000, -10_000, 10_000)
    msp4: randomArray(100_000, -1_000_000_000, 1_000_000_000)
    mso1: randomEvents(10_000, 2000, 2021)
    mso2: randomEvents(10_000, -1_000_000, 1_000_000)
    mso3: randomEvents(100_000, 2000, 2021)
    mso4: randomEvents(100_000, -1_000_000, 1_000_000)
     */
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
        long firstTime = System.currentTimeMillis();
        ArrayUtils.bubbleSort(numbersArray);
        ArrayUtils.bubbleSort(events);
        ArrayUtils.countingSort(numbersArray);
        ArrayUtils.countingSort(events);
        ArrayUtils.mergeSort(numbersArray);
        ArrayUtils.mergeSort(events);
        long secondTime = System.currentTimeMillis();
        System.out.println(secondTime-firstTime + " ms");
    }
}
