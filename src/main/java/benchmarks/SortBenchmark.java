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
    // bsp3: 13.97s
    // bsp4: 20.91s
    // bsp01: 0.61s
    // bsp02: 0.47s
    // bsp03: 100.57s
    // bsp04: 93.990s
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
        String[] name = new String[]{
                "bsp1",
                "bsp2",
                "bsp3",
                "bsp4",
                "bsp01",
                "bsp02",
                "bsp03",
                "bsp04",
                "сsp1",
                "сsp2",
                "сsp3",
                "сsp4",
                "cso1",
                "cso2",
                "cso3",
                "cso4",
                "msp1",
                "msp2",
                "msp3",
                "msp4",
                "mso1",
                "mso2",
                "mso3",
                "mso4"
        };
        long[] time = new long[48];
        int[] numbersArray = randomArray(10000, -10000, 10000);
        time[0] = System.currentTimeMillis();
        ArrayUtils.bubbleSort(numbersArray);
        time[1] = System.currentTimeMillis();
        numbersArray = randomArray(10000, -1000000000, 1000000000);
        time[2] = System.currentTimeMillis();
        ArrayUtils.bubbleSort(numbersArray);
        time[3] = System.currentTimeMillis();
        numbersArray = randomArray(100000, -10000, 10000);
        time[4] = System.currentTimeMillis();
        ArrayUtils.bubbleSort(numbersArray);
        time[5] = System.currentTimeMillis();
        numbersArray = randomArray(100000, -1000000000, 1000000000);
        time[6] = System.currentTimeMillis();
        ArrayUtils.bubbleSort(numbersArray);
        time[7] = System.currentTimeMillis();
        Event[] events = randomEvents(10000, 2000, 2021);
        time[8] = System.currentTimeMillis();
        ArrayUtils.bubbleSort(events);
        time[9] = System.currentTimeMillis();
        events = randomEvents(10000, -1000000000, 1000000000);
        time[10] = System.currentTimeMillis();
        ArrayUtils.bubbleSort(events);
        time[11] = System.currentTimeMillis();
        events = randomEvents(100000, 2000, 2021);
        time[12] = System.currentTimeMillis();
        ArrayUtils.bubbleSort(events);
        time[13] = System.currentTimeMillis();
        events = randomEvents(100000, -1000000000, 1000000000);
        time[14] = System.currentTimeMillis();
        ArrayUtils.bubbleSort(events);
        time[15] = System.currentTimeMillis();
        numbersArray = randomArray(10000, -10000, 10000);
        time[16] = System.currentTimeMillis();
        ArrayUtils.countingSort(numbersArray);
        time[17] = System.currentTimeMillis();
        numbersArray = randomArray(10000, -1000000000, 1000000000);
        time[18] = System.currentTimeMillis();
        ArrayUtils.countingSort(numbersArray);
        time[19] = System.currentTimeMillis();
        numbersArray = randomArray(100000, -10000, 10000);
        time[20] = System.currentTimeMillis();
        ArrayUtils.countingSort(numbersArray);
        time[21] = System.currentTimeMillis();
        numbersArray = randomArray(100000, -1000000000, 1000000000);
        time[22] = System.currentTimeMillis();
        ArrayUtils.countingSort(numbersArray);
        time[23] = System.currentTimeMillis();
        events = randomEvents(10000, 2000, 2021);
        time[24] = System.currentTimeMillis();
        ArrayUtils.countingSort(events);
        time[25] = System.currentTimeMillis();
        events = randomEvents(10000, -1000000000, 1000000000);
        time[26] = System.currentTimeMillis();
        ArrayUtils.countingSort(events);
        time[27] = System.currentTimeMillis();
        events = randomEvents(100000, 2000, 2021);
        time[28] = System.currentTimeMillis();
        ArrayUtils.countingSort(events);
        time[29] = System.currentTimeMillis();
        events = randomEvents(100000, -1000000000, 1000000000);
        time[30] = System.currentTimeMillis();
        ArrayUtils.countingSort(events);
        time[31] = System.currentTimeMillis();
        numbersArray = randomArray(10000, -10000, 10000);
        time[32] = System.currentTimeMillis();
        ArrayUtils.mergeSort(numbersArray);
        time[33] = System.currentTimeMillis();
        numbersArray = randomArray(10000, -1000000000, 1000000000);
        time[34] = System.currentTimeMillis();
        ArrayUtils.mergeSort(numbersArray);
        time[35] = System.currentTimeMillis();
        numbersArray = randomArray(100000, -10000, 10000);
        time[36] = System.currentTimeMillis();
        ArrayUtils.mergeSort(numbersArray);
        time[37] = System.currentTimeMillis();
        numbersArray = randomArray(100000, -1000000000, 1000000000);
        time[38] = System.currentTimeMillis();
        ArrayUtils.mergeSort(numbersArray);
        time[39] = System.currentTimeMillis();
        events = randomEvents(10000, 2000, 2021);
        time[40] = System.currentTimeMillis();
        ArrayUtils.mergeSort(events);
        time[41] = System.currentTimeMillis();
        events = randomEvents(10000, -1000000000, 1000000000);
        time[42] = System.currentTimeMillis();
        ArrayUtils.mergeSort(events);
        time[43] = System.currentTimeMillis();
        events = randomEvents(100000, 2000, 2021);
        time[44] = System.currentTimeMillis();
        ArrayUtils.mergeSort(events);
        time[45] = System.currentTimeMillis();
        events = randomEvents(100000, -1000000000, 1000000000);
        time[46] = System.currentTimeMillis();
        ArrayUtils.mergeSort(events);
        time[47] = System.currentTimeMillis();
        for (int i = 0, j = 0; i < time.length; i = i + 2) {
            long result = time[i + 1] - time[i];
            System.out.println(name[j++] + ":" + result + "ms");
        }
    }
}
