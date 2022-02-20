package benchmarks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import entities.Event;

import static org.junit.jupiter.api.Assertions.*;

class SortBenchmarkTest {

    @Test
    public void randomArrayShouldReturnArraysWithEqualDataWhenArgumentsAreSame() {
        int[] firstArray = SortBenchmark.randomArray(24, 2, 28);
        int[] secondArray = SortBenchmark.randomArray(24, 2, 28);
        Assertions.assertArrayEquals(firstArray,secondArray);
    }

    @Test
    public void randomArrayShouldReturnResultWhenDataIncludeValueBetweenInclusiveMinArgumentAndExclusiveMaxArgument() {
        int[] randomArray = SortBenchmark.randomArray(100,5, 124);
        for (int i = 0; i < randomArray.length; i++) {
            Assertions.assertFalse(randomArray[i] < 5 || randomArray[i] >= 124);
        }
    }

    @Test
    public void randomEventsShouldReturnArraysWithEqualDataWhenArgumentsAreSame() {
        Event[] firstEvents = SortBenchmark.randomEvents(32, 1920, 1954);
        Event[] secondEvents = SortBenchmark.randomEvents(32, 1920, 1954);
        Assertions.assertEquals(firstEvents.length, secondEvents.length);
        for (int i = 0; i < firstEvents.length; i++) {
            Assertions.assertTrue(firstEvents[i].equals(secondEvents[i]));
        }
    }

    @Test
    public void randomEventsShouldReturnResultWhenYearIncludeValueBetweenInclusiveMinArgumentAndExclusiveMaxArgument() {
        Event[] firstEvents = SortBenchmark.randomEvents(32, 1920, 1954);
        for (int i = 0; i < firstEvents.length; i++) {
            int year = firstEvents[i].getYear();
            Assertions.assertFalse(year < 1920 || year >= 1954);
        }
    }

    @Test
    public void randomEventsShouldReturnResultWhenMonthIsInclusiveBetweenOneAndTwelve() {
        Event[] firstEvents = SortBenchmark.randomEvents(32, 1920, 1954);
        for (int i = 0; i < firstEvents.length; i++) {
            int month = firstEvents[i].getMonth();
            Assertions.assertTrue(month >= 1 || month <= 12);
        }
    }

    @Test
    public void randomEventsShouldReturnResultWhenDayIsInclusiveBetweenOneAndThirtyOne() {
        Event[] firstEvents = SortBenchmark.randomEvents(32, 1920, 1954);
        for (int i = 0; i < firstEvents.length; i++) {
            int month = firstEvents[i].getMonth();
            Assertions.assertTrue(month >= 1 || month <= 31);
        }
    }
}