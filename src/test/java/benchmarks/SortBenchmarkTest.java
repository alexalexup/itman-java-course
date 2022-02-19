package benchmarks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortBenchmarkTest {

    @Test
    public void sdfsdf() {
        int[] a = SortBenchmark.randomArray(5, 2, 135);
        for (int i = 0; i < a.length; i++) {
            if ( a[i] == 135 || a[i] == 2) {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
            System.out.println(a[i] + " ");
        }
    }

}