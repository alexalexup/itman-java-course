package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;



class Task433Test {

    @Nested
    public class Gcd {
        @Test
        public void shouldReturnBWhenBothElementsAreEqual() {
            long a = 4928340L;
            long b = 4928340L;
            long result = Task433.gcd(a, b);
            Assertions.assertEquals(b, result);
        }

        @Test
        public void shouldReturnBWhenBIsGcd() {
            long a = 6456465L;
            long b = 5L;
            long result = Task433.gcd(a, b);
            Assertions.assertEquals(b, result);
        }

        @Test
        public void shouldReturnAWhenAIsGcd() {
            long a = 167L;
            long b = 1169L;
            long result = Task433.gcd(a, b);
            Assertions.assertEquals(a, result);
        }

        @Test
        public void shouldReturnMinValueWhenAHaveMaxValueAndBIsNotGcd() {
            long a = 10000000000000000L;
            long b = 3L;
            long result = Task433.gcd(a, b);
            Assertions.assertEquals(1, result);
        }

        @Test
        public void shouldReturnMaxValueWhenElementsHaveMaxValues() {
            long a = 10000000000000000L;
            long b = 10000000000000000L;
            long result = Task433.gcd(a, b);
            Assertions.assertEquals(10000000000000000l, result);
        }

        @Test
        public void shouldReturnMinValueWhenElementsHaveMinValues() {
            long a = 1l;
            long b = 1l;
            long result = Task433.gcd(a, b);
            Assertions.assertEquals(1l, result);
        }

        @Test
        public void shouldReturnMinValueWhenElementsArePrimeNumbers() {
            long a = 863l;
            long b = 617l;
            long result = Task433.gcd(a, b);
            Assertions.assertEquals(1l, result);
        }
    }
}