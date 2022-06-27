package benchmarks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StringBuilderBenchmarkTest {

    @Nested
    public class ConcatenateUsingOperator{
        @Test
        public void shouldReturnResultWhenArgumentIsZero() {
            String expectedResult = "";
            String actualResult = StringBuilderBenchmark.concatenateUsingOperator(0);
            Assertions.assertEquals(expectedResult,actualResult);
        }

        @Test
        public void shouldReturnResultWhenMethodWasCalled() {
            String expectedResult = " 0 1 2 3";
            String actualResult = StringBuilderBenchmark.concatenateUsingOperator(4);
            Assertions.assertEquals(expectedResult,actualResult);
        }

        @Test
        public void shouldReturnResultWhenArgumentIsTwenty() {
            String expectedResult = " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9";
            String actualResult = StringBuilderBenchmark.concatenateUsingOperator(20);
            Assertions.assertEquals(expectedResult,actualResult);
        }

    }

    @Nested
    public class ConcatenateUsingStringBuilder {
        @Test
        public void shouldReturnResultWhenArgumentIsZero(){
            String expectedResult = "";
            String actualResult = StringBuilderBenchmark.concatenateUsingStringBuilder(0);
            Assertions.assertEquals(expectedResult,actualResult);
        }

        @Test
        public void shouldReturnResultWhenMethodWasCalled() {
            String expectedResult = " 0 1 2 3";
            String actualResult = StringBuilderBenchmark.concatenateUsingStringBuilder(4);
            Assertions.assertEquals(expectedResult,actualResult);
        }

        @Test
        public void shouldReturnResultWhenArgumentIsTwenty() {
            String expectedResult = " 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9";
            String actualResult = StringBuilderBenchmark.concatenateUsingStringBuilder(20);
            Assertions.assertEquals(expectedResult,actualResult);
        }
    }
}