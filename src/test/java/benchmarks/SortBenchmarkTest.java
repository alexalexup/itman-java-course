package benchmarks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import entities.Event;


class SortBenchmarkTest {

    @Nested
    public class RandomArray {
        @Test
        public void shouldReturnArrayWithEqualDataWhenArgumentsAreSimilar() {
            int[] firstArray = SortBenchmark.randomArray(1000, -2, 160);
            int[] secondArray = SortBenchmark.randomArray(1000, -2, 160);
            Assertions.assertArrayEquals(firstArray, secondArray);
        }

        @Test
        public void shouldReturnResultWhenDataIncludeValueBetweenInclusiveMinArgumentAndExclusiveMaxArgument() {
            int[] randomArray = SortBenchmark.randomArray(1000, -5, 5);
            for (int i = 0; i < randomArray.length; i++) {
                Assertions.assertTrue(randomArray[i] >= -5 || randomArray[i] < 5);
            }
        }
    }

    @Nested
    public class RandomEvents {
        @Test
        public void shouldReturnArraysWithEqualDataWhenArgumentsAreSame() {
            Event[] firstEvents = SortBenchmark.randomEvents(32, 1920, 1954);
            Event[] secondEvents = SortBenchmark.randomEvents(32, 1920, 1954);
            Assertions.assertEquals(firstEvents.length, secondEvents.length);
            for (int i = 0; i < firstEvents.length; i++) {
                Assertions.assertTrue(firstEvents[i].equals(secondEvents[i]));
            }
        }

        @Test
        public void shouldReturnResultWhenYearIncludeValueBetweenInclusiveMinArgumentAndExclusiveMaxArgument() {
            Event[] firstEvents = SortBenchmark.randomEvents(32, 1920, 1954);
            for (int i = 0; i < firstEvents.length; i++) {
                int year = firstEvents[i].getYear();
                Assertions.assertFalse(year < 1920 || year >= 1954);
            }
        }

        @Test
        public void shouldReturnResultWhenMonthIsInclusiveBetweenOneAndTwelve() {
            Event[] firstEvents = SortBenchmark.randomEvents(32, 1920, 1954);
            for (int i = 0; i < firstEvents.length; i++) {
                int month = firstEvents[i].getMonth();
                Assertions.assertTrue(month >= 1 || month <= 12);
            }
        }

        @Test
        public void shouldReturnResultWhenDayIsInclusiveBetweenOneAndThirtyOne() {
            Event[] firstEvents = SortBenchmark.randomEvents(32, 1920, 1954);
            for (int i = 0; i < firstEvents.length; i++) {
                int month = firstEvents[i].getMonth();
                Assertions.assertTrue(month >= 1 || month <= 31);
            }
        }
    }
}