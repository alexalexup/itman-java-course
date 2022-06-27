package example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    @Nested
    public class Sum {
        @Test
        public void shouldReturnPositiveValueWhenAllArgumentsArePositive() {
            Assertions.assertEquals(15, Example.sum(5, 10));
        }

        @Test
        public void shouldReturnNegativeValueWhenAllArgumentsAreNegative() {
            Assertions.assertEquals(-10, Example.sum(-7, -3));
        }
    }
}