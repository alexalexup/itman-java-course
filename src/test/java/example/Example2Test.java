package example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Example2Test {

    @Test
    public void fShouldReturnResult() {
        int n = 10;
        int[] a = new int[]{11, 5, 6, 20, 1, 4, 38, 1, 9, 9};

        int result = Example2.f(n, a);
        System.out.println("result " + result);
    }
}