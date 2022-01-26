package example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    @Test
    public void sumShouldReturnPositiveValueWhenAllArgumentsArePositive() {
        Assertions.assertEquals(15, Example.sum(5, 10));
    }

    @Test
    public void sumShouldReturnNegativeValueWhenAllArgumentsAreNegative() {
        Assertions.assertEquals(-10, Example.sum(-7, -3));
    }
}