package utils;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayUtilsTest {

    public void checkEqualsValues(Event[] events, Event[] expectedValues) {
        for (int i = 0; i < events.length; i++) {
            boolean expectedResult = events[i].equals(expectedValues[i]);
            Assertions.assertTrue(expectedResult);
        }
    }

    @Test
    public void bubbleSortShouldNotChangeLinksOnEventsWhenMethodWasCalled() {
        entities.Event[] events = new entities.Event[] {
                new entities.Event(2010, 8, 21, "birthday"),
                new entities.Event(2009, 12, 20, "jobOffer"),
                new entities.Event(2008, 12, 25, "christmas"),
                new entities.Event(2014, 5, 14 , "startHolidays")
        };
        entities.Event[] expectedEvents = events;
        entities.Event[] expectedLinks = new entities.Event[] {
                events[2],
                events[1],
                events[0],
                events[3]
        };
        ArrayUtils.bubbleSort(events);
        Assertions.assertArrayEquals(expectedLinks, events);
        Assertions.assertSame(expectedEvents, events);
    }

    @Test
    public void bubbleSortShouldSortEventsWhenAllEventsHaveDifferenceYears() {
        entities.Event[] events = new entities.Event[]{
                new entities.Event(2010, 4, 8, "jodOffer"),
                new entities.Event(2012, 3, 12, "birthday"),
                new entities.Event(1996, 10, 4, "wedding"),
                new entities.Event(1995, 10, 5, "holidays")
        };
        entities.Event[] expectedValues = new entities.Event[]{
                new entities.Event(1995, 10, 5, "holidays"),
                new entities.Event(1996, 10, 4, "wedding"),
                new entities.Event(2010, 4, 8, "jodOffer"),
                new entities.Event(2012, 3, 12, "birthday")
        };
        ArrayUtils.bubbleSort(events);
        checkEqualsValues(events, expectedValues);
    }

    @Test
    public void bubbleSortShouldSortEventsWhenEventsHaveSameYears() {
        entities.Event[] events = new entities.Event[]{
                new entities.Event(2018, 7, 8, "jodOffer"),
                new entities.Event(2018, 6, 12, "birthday"),
                new entities.Event(2018, 5, 29, "wedding"),
                new entities.Event(2018, 4, 5, "holidays")
        };
        entities.Event[] expectedValues = new entities.Event[]{
                new entities.Event(2018, 4, 5, "holidays"),
                new entities.Event(2018, 5, 29, "wedding"),
                new entities.Event(2018, 6, 12, "birthday"),
                new entities.Event(2018, 7, 8, "jodOffer")
        };
        ArrayUtils.bubbleSort(events);
        checkEqualsValues(events, expectedValues);
    }

    @Test
    public void bubbleSortShouldSortEventsWhenYeasAndMonthAreSame() {
        entities.Event[] events = new entities.Event[]{
                new entities.Event(2018, 8, 14, "jodOffer"),
                new entities.Event(2018, 8, 12, "birthday"),
                new entities.Event(2018, 8, 25, "wedding"),
                new entities.Event(2018, 8, 24, "holidays")
        };
        entities.Event[] expectedValues = new entities.Event[]{
                new entities.Event(2018, 8, 12, "birthday"),
                new entities.Event(2018, 8, 14, "jodOffer"),
                new entities.Event(2018, 8, 24, "holidays"),
                new entities.Event(2018, 8, 25, "wedding")
        };
        ArrayUtils.bubbleSort(events);
        checkEqualsValues(events, expectedValues);
    }

    @Test
    public void bubbleSortShouldSortEventsWhenEventsHaveThreeSameEvent() {
        entities.Event[] events = new entities.Event[]{
                new entities.Event(2018, 8, 25, "jodOffer"),
                new entities.Event(2018, 8, 25, "birthday"),
                new entities.Event(2018, 8, 14, "wedding"),
                new entities.Event(2018, 8, 25, "holidays")
        };
        entities.Event[] expectedValues = new entities.Event[]{
                new entities.Event(2018, 8, 14, "wedding"),
                new entities.Event(2018, 8, 25, "jodOffer"),
                new entities.Event(2018, 8, 25, "birthday"),
                new entities.Event(2018, 8, 25, "holidays")
        };
        ArrayUtils.bubbleSort(events);
        checkEqualsValues(events, expectedValues);
    }

    @Test
    public void bubbleSortShouldNotSwapElementsOfEventsWhenAllElementsAreSame() {
        entities.Event[] events = new entities.Event[]{
                new entities.Event(2018, 8, 25, "jodOffer"),
                new entities.Event(2018, 8, 25, "birthday"),
                new entities.Event(2018, 8, 25, "wedding"),
                new entities.Event(2018, 8, 25, "holidays")
        };
        entities.Event[] expectedValues = new entities.Event[]{
                new entities.Event(2018, 8, 25, "jodOffer"),
                new entities.Event(2018, 8, 25, "birthday"),
                new entities.Event(2018, 8, 25, "wedding"),
                new entities.Event(2018, 8, 25, "holidays")
        };
        ArrayUtils.bubbleSort(events);
        checkEqualsValues(events, expectedValues);
    }

    @Test
    public void bubbleSortShouldNotChangeEventsWhenEventsHaveOneEvent() {
        entities.Event[] events = new entities.Event[]{new entities.Event(2018, 8, 25, "jodOffer")};
        entities.Event[] expectedValues = new entities.Event[]{new entities.Event(2018, 8, 25, "jodOffer")};
        ArrayUtils.bubbleSort(events);
        checkEqualsValues(events, expectedValues);
    }

    @Test
    public void bubbleSortShouldNotChangeEventsWhenEventsWithoutElements() {
        entities.Event[] events = new entities.Event[]{};
        entities.Event[] expectedValues = new entities.Event[]{};
        ArrayUtils.bubbleSort(events);
        checkEqualsValues(events, expectedValues);
    }

    @Test
    public void bubbleSortShouldSortEventsWhenEventsHaveSameMonthAndDifferenceYearsAndDays() {
        entities.Event[] events = new entities.Event[]{
                new entities.Event(2014, 6, 5, "jodOffer"),
                new entities.Event(2010, 6, 1, "birthday"),
                new entities.Event(2016, 6, 6, "wedding"),
                new entities.Event(2009, 6, 24, "holidays"),
                new entities.Event(2008, 6, 25, "meeting")
        };
        entities.Event[] expectedValues = new entities.Event[]{
                new entities.Event(2008, 6, 25, "meeting"),
                new entities.Event(2009, 6, 24, "holidays"),
                new entities.Event(2010, 6, 1, "birthday"),
                new entities.Event(2014, 6, 5, "jodOffer"),
                new entities.Event(2016, 6, 6, "wedding")
        };
        ArrayUtils.bubbleSort(events);
        checkEqualsValues(events, expectedValues);
    }

    @Test
    public void bubbleSortShouldSortEventsWhenEventsHaveTwoSameEvents() {
        entities.Event[] events = new entities.Event[]{
                new entities.Event(2020, 10, 25, "A"),
                new entities.Event(2020, 5, 20, "B"),
                new entities.Event(2020, 7, 15, "C"),
                new entities.Event(2021, 1, 1, "D"),
                new entities.Event(2020, 7, 15, "E")
        };
        entities.Event[] expectedValues = new entities.Event[]{
                new entities.Event(2020, 5, 20, "B"),
                new entities.Event(2020, 7, 15, "C"),
                new entities.Event(2020, 7, 15, "E"),
                new entities.Event(2020, 10, 25, "A"),
                new entities.Event(2021, 1, 1, "D")
        };
        ArrayUtils.bubbleSort(events);
        checkEqualsValues(events, expectedValues);
    }

    @Test
    public void bubbleSortShouldSortArrayInIncreasingOrderWhenArrayHaveSomeElements() {
        int[] array = new int[]{5, 2, 4, 1, 3, 3};
        ArrayUtils.bubbleSort(array);
        int[] expectedArray = new int[]{1, 2, 3, 3, 4, 5};
        Assertions.assertArrayEquals(array, expectedArray);
    }

    @Test
    public void bubbleSortShouldSortArrayInIncreasingOrderWhenArrayHaveOneElement() {
        int[] array = new int[]{4};
        ArrayUtils.bubbleSort(array);
        int[] expectedArray = new int[]{4};
        Assertions.assertArrayEquals(array, expectedArray);
    }

    @Test
    public void bubbleSortShouldWorkWhenArrayHaveNotElements() {
        int[] array = new int[]{};
        ArrayUtils.bubbleSort(array);
        int[] expectedArray = new int[]{};
        Assertions.assertArrayEquals(array, expectedArray);
    }

    @Test
    public void countingShouldSortSortArrayWhenArrayHaveSomeElements() {
        int[] actualArray = new int[]{4, 2, 2, 10, 1, 3, 5, 2, 7};
        int[] expectedArray = new int[]{1, 2, 2, 2, 3, 4, 5, 7, 10};
        ArrayUtils.countingSort(actualArray);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void countingSortShouldWorkWhenArrayHaveOneElement() {
        int[] actualArray = new int[]{6};
        int[] expectedArray = new int[]{6};
        ArrayUtils.countingSort(actualArray);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void countingSortShouldWorkWhenArrayHaveNotElements() {
        int[] actualArray = new int[]{};
        int[] expectedArray = new int[]{};
        ArrayUtils.countingSort(actualArray);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void countingSortShouldWorkWhenArrayHaveEqualElements() {
        int[] actualArray = new int[]{3, 3, 3, 3, 3};
        int[] expectedArray = new int[]{3, 3, 3, 3, 3};
        ArrayUtils.countingSort(actualArray);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void countingSortShouldSortArrayWhenElementsArePositiveAndHaveMaxRangeBetweenMaxAndMinElements() {
        int[] actualArray = new int[]{2147483647, 2147383648, 2147283648};
        int[] expectedArray = new int[]{2147283648, 2147383648, 2147483647};
        ArrayUtils.countingSort(actualArray);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void countingSortShouldSortArrayWhenElementsAreNegativeAndHaveMaxRangeBetweenMaxAndMinElements() {
        int[] actualArray = new int[]{-2146483649, -2147483648};
        int[] expectedArray = new int[]{-2147483648, -2146483649};
        ArrayUtils.countingSort(actualArray);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void countingSortShouldSortArrayWhenElementsFromArrayAreNegativeAndPositive() {
        int[] actualArray = new int[]{-25, -4, 0, 12, 4, -2, -4, -5};
        int[] expectedArray = new int[]{-25, -5, -4, -4, -2,  0, 4, 12};
        ArrayUtils.countingSort(actualArray);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void countingSortShouldSortArrayWhenElementsAreNegativeAndPositiveAndHaveMaxRangeBetweenMaxAndMinElements() {
        int[] actualArray = new int[]{2, -999998, 0, 1, 1, -3};
        int[] expectedArray = new int[]{-999998, -3, 0, 1, 1, 2};
        ArrayUtils.countingSort(actualArray);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void distinctShouldReturnArrayWithUniqueNumbersWhenNumbersPositiveAndNegative(){
        int[] array= new int[]{5, 2, 2, 4, -6, -5, -2, -5, 0, 0};
        int[] expectedArray = new int[]{5, 2, 4, -6, -5, -2, 0};
        int[] actualArray = ArrayUtils.distinct(array);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void distinctShouldReturnArrayWithUniqueNumbersWhenElementsAreNegativeAndPositive() {
        int[] array = new int[]{2, -999998, -999998, 0, 1, 1, -3};
        int[] expectedArray = new int[]{2, -999998, 0, 1, -3};
        int[] actualArray = ArrayUtils.distinct(array);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void distinctShouldReturnResultWhenArrayIsEmpty() {
        int[] array = new int[]{};
        int[] expectedArray = new int[]{};
        int[] actualArray = ArrayUtils.distinct(array);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void distinctShouldReturnResultWhenElementsArePositiveAndHaveMaxRangeBetweenMaxAndMinElements() {
        int[] array = new int[]{2147483647, 2147383648, 2147283648, 2147483647};
        int[] expectedArray = new int[]{2147483647, 2147383648, 2147283648};
        int[] actualArray = ArrayUtils.distinct(array);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void distinctShouldReturnResultWhenElementsAreNegativeAndHaveMaxRangeBetweenMaxAndMinElements() {
        int[] array = new int[]{-2147483647, -2147383648, -2147283648, -2147483647};
        int[] expectedArray = new int[]{-2147483647, -2147383648, -2147283648};
        int[] actualArray = ArrayUtils.distinct(array);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void mostFrequentShouldReturnResultWhenArrayHaveOneElement() {
        int[] array = new int[]{-12};
        int actualResult = ArrayUtils.mostFrequent(array);
        Assertions.assertEquals(-12, actualResult);
    }

    @Test
    public void mostFrequentShouldReturnResultWhenElementsAreNegativeAndHaveMaxRangeBetweenMaxAndMinElements() {
        int[] array = new int[]{-2147483647, -2147383648, -2147283648, -2147283648, -2147483647};
        int actualResult = ArrayUtils.mostFrequent(array);
        Assertions.assertEquals(-2147483647, actualResult);
    }

    @Test
    public void mostFrequentShouldReturnResultWhenElementsArePositiveAndHaveMaxRangeBetweenMaxAndMinElements() {
        int[] array = new int[]{2147483647, 2147383648, 2147283648, 2147283648, 2147483647};
        int actualResult = ArrayUtils.mostFrequent(array);
        Assertions.assertEquals(2147283648, actualResult);
    }

    @Test
    public void mostFrequentShouldReturnResultWhenElementsArePositiveAndNegative() {
        int[] array = new int[]{5, 2, -7, -3, -3, 5, 5, 5, 9, 2};
        int actualResult = ArrayUtils.mostFrequent(array);
        Assertions.assertEquals(5, actualResult);
    }

    @Test
    public void mostFrequentShouldReturnResultWhenAllElementsAreZero() {
        int[] array = new int[]{0, 0, 0, 0, 0};
        int actualResult = ArrayUtils.mostFrequent(array);
        Assertions.assertEquals(0, actualResult);
    }
}
