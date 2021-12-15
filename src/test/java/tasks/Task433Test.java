package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task433Test {

    @Test
    public void gcdWhenBothElementIsEqual() {
        long a = 4928340l;
        long b = 4928340l;
        long result = Task433.gcd(a, b);
        Assertions.assertEquals(b, result);

    }

    @Test
    public void gcdWhenFirstElementBiggerThanSecondAndModIsZero() {
        long a = 6456465l;
        long b = 5l;
        long result = Task433.gcd(a, b);
        Assertions.assertEquals(b, result);

    }

    @Test
    public void gcdWhenSecondElementBiggerThanFirstAndModIsZero() {
        long a = 27l;
        long b = 243l;
        long result = Task433.gcd(a, b);
        Assertions.assertEquals(a, result);

    }

    @Test
    public void gcdWhenSecondElementBiggerThanFirst() {
        long a = 9999999999999996l;
        long b = 99999999999996l;
        long result = Task433.gcd(a, b);
        Assertions.assertEquals(12, result);

    }
    @Test
    public void gcdWhenBothElementAreEqualAndMin() {
        long a = 1l;
        long b = 1l;
        long result = Task433.gcd(a, b);
        Assertions.assertEquals(1, result);

    }

}