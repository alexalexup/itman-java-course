package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task432Test {

    @Test
    public void calcShouldReturnEmptyArrayWhenXIsMinValue() {
        long x = 1L;
        long[] actual = Task432.calcPrimeNumbers(x);
        long[] expected = new long[] {};;
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcShouldWorkWhenInputValueHaveIntType() {
        long x = 99854562;
        long[] actual = Task432.calcPrimeNumbers(x);
        long[] expected = new long[] {2L, 3L, 173L, 96199L};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcShouldReturnResultInAcceptableTimeWhenPrimeNumberIsMax() {
        long x = 999999999999998L;
        long[] actual = Task432.calcPrimeNumbers(x);
        long[] expected = new long[] {2L, 499999999999999L};
         Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcShouldReturnResultInAcceptableTimeWhenXIsMax() {
        long x = 10000000000000000L;
        Task432.calcPrimeNumbers(x);
        long[] actual = Task432.calcPrimeNumbers(x);
        long[] expected = new long[] {2L, 5L};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcShouldReturnXWhenXIsPrimeNumber() {
        long x = 997L;
        Task432.calcPrimeNumbers(x);
        long[] actual = Task432.calcPrimeNumbers(x);
        long[] expected = new long[] {997L};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void calcShouldReturnResultInAcceptableTimeWhenXHaveMaxCountPrimeNumbers() {
        long x = 304250263527210L;
        Task432.calcPrimeNumbers(x);
        long[] actual = Task432.calcPrimeNumbers(x);
        long[] expected = new long[] {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L};
        Assertions.assertArrayEquals(expected, actual);
    }
}