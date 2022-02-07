package benchmarks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringBuilderBenchmarkTest {

    @Test
    public void concatenateUsingOperatorShouldReturnResultWhenArgumentIsZero() {
        String expectedResult = " ";
        String actualResult = StringBuilderBenchmark.concatenateUsingOperator(0);
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void concatenateUsingOperatorShouldReturnResultWhenMethodWasCalled() {
        String expectedResult = "  0 1 2 3";
        String actualResult = StringBuilderBenchmark.concatenateUsingOperator(4);
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void concatenateUsingStringBuilderShouldReturnResultWhenArgumentIsZero() {
        String expectedResult = " ";
        String actualResult = StringBuilderBenchmark.concatenateUsingStringBuilder(0).toString();
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void concatenateUsingStringBuilderShouldReturnResultWhenMethodWasCalled() {
        String expectedResult = "  0 1 2 3";
        String actualResult = StringBuilderBenchmark.concatenateUsingStringBuilder(4).toString();
        Assertions.assertEquals(expectedResult,actualResult);
    }
}