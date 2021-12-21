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
    public void calcShouldReturnLongTypeWhenXIsIntType() {
        long x = 99854562;
        long[] actual = Task432.calcPrimeNumbers(x);
        long[] expected = new long[] {2l, 3l, 173l, 96199l};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcShouldReturnResultInAcceptableTimeWhenPrimeNumberIsMax() {
        long x = 999999999999998l;
        long[] actual = Task432.calcPrimeNumbers(x);
        long[] expected = new long[] {2l, 499999999999999l};
         Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcShouldReturnResultInAcceptableTimeWhenXIsMax() {
        long x = 1000000000000000l;
        Task432.calcPrimeNumbers(x);
        long[] actual = Task432.calcPrimeNumbers(x);
        long[] expected = new long[] {2l, 5l};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void calcShouldReturnXWhenXIsPrimeNumber() {
        long x = 997l;
        Task432.calcPrimeNumbers(x);
        long[] actual = Task432.calcPrimeNumbers(x);
        long[] expected = new long[] {997l};
        Assertions.assertArrayEquals(expected, actual);
    }
}