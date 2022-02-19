package benchmarks;

import java.util.Random;

public class SortBenchmark {

    public static int[] randomArray(int n, int min, int max) {
        Random random  = new Random(3);
        int delta = max - min;
        int length = random.nextInt(n);
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(delta) + min;
        }
        return array;
    }
}
