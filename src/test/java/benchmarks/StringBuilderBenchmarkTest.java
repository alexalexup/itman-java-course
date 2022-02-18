package benchmarks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringBuilderBenchmarkTest {

    @Test
    public void concatenateUsingOperatorShouldReturnResultWhenArgumentIsZero() {
        String expectedResult = "";
        String actualResult = StringBuilderBenchmark.concatenateUsingOperator(0);
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void concatenateUsingOperatorShouldReturnResultWhenMethodWasCalled() {
        String expectedResult = " 0 1 2 3";
        String actualResult = StringBuilderBenchmark.concatenateUsingOperator(4);
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void concatenateUsingOperatorShouldReturnResultWhenArgumentIsTwenty() {
        String expectedResult = " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9";
        String actualResult = StringBuilderBenchmark.concatenateUsingOperator(20);
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void concatenateUsingStringBuilderShouldReturnResultWhenArgumentIsZero() {
        String expectedResult = "";
        String actualResult = StringBuilderBenchmark.concatenateUsingStringBuilder(0);
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void concatenateUsingStringBuilderShouldReturnResultWhenMethodWasCalled() {
        String expectedResult = " 0 1 2 3";
        String actualResult = StringBuilderBenchmark.concatenateUsingStringBuilder(4);
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void concatenateUsingStringBuilderShouldReturnResultWhenArgumentIsTwenty() {
        String expectedResult = " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9";
        String actualResult = StringBuilderBenchmark.concatenateUsingStringBuilder(20);
        Assertions.assertEquals(expectedResult,actualResult);
    }
}