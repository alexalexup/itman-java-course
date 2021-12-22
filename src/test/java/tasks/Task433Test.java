package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task433Test {

    @Test
    public void gcdShouldReturnBWhenBothElementsAreEqual() {
        long a = 4928340L;
        long b = 4928340L;
        long result = Task433.gcd(a, b);
        Assertions.assertEquals(b, result);
    }

    @Test
    public void gcdShouldReturnBWhenBIsGcd() {
        long a = 6456465L;
        long b = 5L;
        long result = Task433.gcd(a, b);
        Assertions.assertEquals(b, result);
    }

    @Test
    public void gcdShouldReturnAWhenAIsGcd() {
        long a = 167L;
        long b = 1169L;
        long result = Task433.gcd(a, b);
        Assertions.assertEquals(a, result);
    }

    @Test
    public void gcdShouldReturnMinValueWhenAHaveMaxValueAndBIsNotGcd() {
        long a = 10000000000000000L;
        long b = 3L;
        long result = Task433.gcd(a, b);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void gcdShouldReturnMaxValueWhenElementsHaveMaxValues() {
        long a = 10000000000000000L;
        long b = 10000000000000000L;
        long result = Task433.gcd(a, b);
        Assertions.assertEquals(10000000000000000l, result);
    }

    @Test
    public void gcdShouldReturnMinValueWhenElementsHaveMinValues() {
        long a = 1l;
        long b = 1l;
        long result = Task433.gcd(a, b);
        Assertions.assertEquals(1l, result);
    }

    @Test
    public void gcdShouldReturnMinValueWhenElementsArePrimeNumbers() {
        long a = 863l;
        long b = 617l;
        long result = Task433.gcd(a, b);
        Assertions.assertEquals(1l, result);
    }
}