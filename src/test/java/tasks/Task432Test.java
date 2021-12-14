package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task432Test {
    @Test
    public void calcPrimeNumbersWhenNumberIsMaxValue () {
        long x = 10000000000000000l;
        long[] actual = Task432.calcPrimeNumbers(x);
        long[] expected = new long[] {2l, 5l};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void calcPrimeNumbersWhenNumberIsMinValue () {
        long x = 1L;
        long[] actual = Task432.calcPrimeNumbers(x);
        long[] expected = new long[] {};;
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void calcPrimeNumbersWhenNumberIsMiddleValue () {
        long x = 99854562l;
        long[] actual = Task432.calcPrimeNumbers(x);
        long[] expected = new long[] {2l, 3l, 173l, 96199l};
        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void calcPrimeNumbersWhenPrimeNumberHaveMaxValue () {
        long x = 999999999999998l;
        long[] actual = Task432.calcPrimeNumbers(x);
        long[] expected = new long[] {2l, 499999999999999l};
        Assertions.assertArrayEquals(expected, actual);

    }

}