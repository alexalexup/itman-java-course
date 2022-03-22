package utils;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import benchmarks.SortBenchmark;
import java.util.Random;

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

    @Test
    public void countEqualsShouldReturnResultWhenArraysHaveSomeElements() {
        int[] firstArray = new int[]{2, 3, 4, 2, 2, 4, 4};
        int[] secondArray = new int[]{-5, -2, 3, 3, 3, 2, 5, 2};
        int actualResult = ArrayUtils.countEquals(firstArray, secondArray);
        Assertions.assertEquals(3, actualResult);
    }

    @Test
    public void countEqualsShouldReturnZeroWhenOneArrayHaveNotElements() {
        int[] firstArray = new int[]{};
        int[] secondArray = new int[]{-5, -2, 3, 3, 3, 2, 5, 2};
        int actualResult = ArrayUtils.countEquals(firstArray, secondArray);
        Assertions.assertEquals(0, actualResult);
    }

    @Test
    public void countEqualsShouldReturnResultWhenAllElementsAreEqual() {
        int[] firstArray = new int[]{4, 4, 4, 4};
        int[] secondArray = new int[]{4, 4, 4, 4, 4, 4, 4, 4, 4};
        int actualResult = ArrayUtils.countEquals(firstArray, secondArray);
        Assertions.assertEquals(4, actualResult);
    }

    @Test
    public void countEqualsShouldReturnResultWhenEachArrayHaveOnlyOneElement() {
        int[] firstArray = new int[]{1000000000};
        int[] secondArray = new int[]{-1000000000};
        int actualResult = ArrayUtils.countEquals(firstArray, secondArray);
        Assertions.assertEquals(0, actualResult);
    }

    @Test
    public void countEqualsShouldReturnResultWhenOneArrayHaveMaxRangeBetweenMaxAndMinElements() {
        int[] firstArray = new int[]{-2147483647, 2, 3, 3, 2, 5, 2147483647};
        int[] secondArray = new int[]{2, 2, 3, 4};
        int actualResult = ArrayUtils.countEquals(firstArray, secondArray);
        Assertions.assertEquals(3, actualResult);
    }

    @Test
    public void countingSortShouldSortEventsWhenEventsHaveDifferentDates() {
       Event[] events = new Event[] {
                new Event(2010, 8, 21, "birthday"),
                new Event(2009, 12, 20, "jobOffer"),
                new Event(2008, 12, 25, "christmas"),
                new Event(2014, 5, 14 , "startHolidays")
        };
       Event[] expectedEvents = new Event[]{events[2], events[1], events[0], events[3]};
       ArrayUtils.countingSort(events);
       Assertions.assertArrayEquals(expectedEvents, events);
    }

    @Test
    public void countingSortShouldSortEventsWhenEventsHaveDifferentAndSameDates() {
        Event[] events = new Event[]{
                new Event(2020, 10, 25, "a"),
                new Event(2020, 5, 20, "b"),
                new Event(2020, 7, 15, "c"),
                new Event(2021, 1, 1, "d"),
                new Event(2020, 7, 15, "e")};
        Event[] expectedEvents = new Event[]{events[1], events[2], events[4], events[0], events[3]};
        ArrayUtils.countingSort(events);
        Assertions.assertArrayEquals(expectedEvents, events);
    }

    @Test
    public void countingSortShouldWorkWhenEventsHaveNotData() {
        Event[] events = new Event[]{};
        Event[] expectedEvents = new Event[]{};
        ArrayUtils.countingSort(events);
        Assertions.assertArrayEquals(expectedEvents, events);
    }

    @Test
    public void countingSortShouldWorkWhenAllEventsHaveSameDates() {
        Event[] events = new Event[]{
                new Event(2020, 10, 25, "a"),
                new Event(2020, 10, 25, "b"),
                new Event(2020, 10, 25, "c"),
                new Event(2020, 10, 25, "d"),
        };
        Event[] expectedEvents = new Event[]{events[0], events[1], events[2], events[3]};
        ArrayUtils.countingSort(events);
        Assertions.assertArrayEquals(expectedEvents, events);
    }

    @Test
    public void mergeShouldWorkWhenTwoArraysHaveDataThatNeedToMergeToFinalArray() {
        int a[] = new int[]{100, 2, 4, 5, -7};
        int aFrom = 1;
        int aTo = 4;
        int b[] = new int[]{-7, 2, 3};
        int bFrom = 1;
        int bTo = 3;
        int r[] = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        int rFrom = 2;
        int[] expectedResult = new int[]{1, 1, 2, 2, 3, 4, 5, 1};
        ArrayUtils.merge(a, aFrom, aTo, b, bFrom, bTo, r, rFrom);
        Assertions.assertArrayEquals(expectedResult, r);
    }

    @Test
    public void mergeShouldWorkWhenOnlyOneArraysHaveDataThatNeedToMergeToFinalArray() {
        int a[] = new int[]{100, 2, 4, 5, -7};
        int aFrom = 4;
        int aTo = 4;
        int b[] = new int[]{-7, 2, 3};
        int bFrom = 1;
        int bTo = 3;
        int r[] = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        int rFrom = 2;
        int[] expectedResult = new int[]{1, 1, 2, 3, 1, 1, 1, 1};
        ArrayUtils.merge(a, aFrom, aTo, b, bFrom, bTo, r, rFrom);
        Assertions.assertArrayEquals(expectedResult, r);
    }

    @Test
    public void mergeShouldWorkWhenHaveNotArraysThatNeedToMergeToFinalArray() {
        int a[] = new int[]{100, 2, 4, 5, -7};
        int aFrom = 4;
        int aTo = 4;
        int b[] = new int[]{-7, 2, 3};
        int bFrom = 2;
        int bTo = 2;
        int r[] = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        int rFrom = 2;
        int[] expectedResult = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        ArrayUtils.merge(a, aFrom, aTo, b, bFrom, bTo, r, rFrom);
        Assertions.assertArrayEquals(expectedResult, r);
    }

    @Test
    public void mergeShouldWorkWhenOneArrayHaveNotData() {
        int a[] = new int[]{};
        int aFrom = 0;
        int aTo = 0;
        int b[] = new int[]{0, 2, 3};
        int bFrom = 0;
        int bTo = 3;
        int r[] = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        int rFrom = 1;
        int[] expectedResult = new int[]{1, 0, 2, 3, 1, 1, 1, 1};
        ArrayUtils.merge(a, aFrom, aTo, b, bFrom, bTo, r, rFrom);
        Assertions.assertArrayEquals(expectedResult, r);
    }

    @Test
    public void mergeSortShouldSortArrayWhenArrayHasAnEvenNumberOfElements(){
        int[] actualArray = new int[]{13, 9 ,8, 12, 5, 7};
        ArrayUtils.mergeSort(actualArray);
        int[] expectedArray = new int[]{5, 7, 8, 9, 12, 13};
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void mergeSortShouldSortArrayWhenArrayHasAnOddNumberOfElements(){
        int[] actualArray = new int[]{13, 9 ,8, 12, 5, 7, -1};
        ArrayUtils.mergeSort(actualArray);
        int[] expectedArray = new int[]{-1, 5, 7, 8, 9, 12, 13};
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void mergeSortShouldSortArrayLessThanOneSecond(){
        int[] actualArray = SortBenchmark.randomArray(1000000, -3, 10000);
        long firstTime = System.currentTimeMillis();
        ArrayUtils.mergeSort(actualArray);
        long secondTime = System.currentTimeMillis();
        long result = secondTime - firstTime;
        Assertions.assertTrue(result < 1000);
    }

    @Test
    public void mergeSortShouldWorkWhenArrayHasNotElements(){
        int[] actualArray = new int[]{};
        ArrayUtils.mergeSort(actualArray);
        int[] expectedArray = new int[]{};
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void mergeShouldWorkWhenTwoArraysWithEventsHaveDataThatNeedToMergeToFinalArray() {
        Event[] a = new Event[]{
                new Event(2020, 6, 24, "A"),
                new Event(2020, 7, 22, "B"),
                new Event(2021, 8, 3, "C"),
                new Event(2022,8, 2,"D")
        };
        Event[] b = new Event[]{
                new Event(2018, 3, 2, "E"),
                new Event(2019, 4, 21, "F"),
                new Event(2019,6, 4,"H"),
                new Event(2019, 6, 24, "J")
        };
        Event[] result = new Event[] {
                new Event(2014, 1, 1, "R"),
                new Event(2014, 1, 1, "R"),
                new Event(2014, 1, 1, "R"),
                new Event(2014, 1, 1, "R"),
                new Event(2014, 1, 1, "R"),
        };
        ArrayUtils.merge(a,0,2, b,2, 4, result, 0);
        Event[] expectedResult = new Event[]{
                  new Event(2019,6, 4,"H"),
                  new Event(2019, 6, 24, "J"),
                  new Event(2020, 6, 24, "A"),
                  new Event(2020, 7, 22, "B"),
                  new Event(2014, 1, 1, "R")
                };
        checkEqualsValues(expectedResult, result);
    }

    @Test
    public void mergeShouldWorkWhenHaveNotArraysWithEventsThatNeedToMergeToFinalArray() {
        Event[] a = new Event[]{};
        Event[] b = new Event[]{
                new Event(2018, 3, 2, "E"),
                new Event(2011,7, 4,"H"),
                new Event(2017, 4, 21, "F"),
                new Event(2020, 8, 1, "J")
        };
        Event[] result = new Event[]{
                new Event(2014, 1, 1, "R"),
                new Event(2014, 1, 1, "R"),
                new Event(2014, 1, 1, "R"),
                new Event(2014, 1, 1, "R"),
                new Event(2014, 1, 1, "R")
        };
        Event[] expectedResult = new Event[]{
                new Event(2014, 1, 1, "R"),
                new Event(2014, 1, 1, "R"),
                new Event(2011,7, 4,"H"),
                new Event(2017, 4, 21, "F"),
                new Event(2020, 8, 1, "J")
        };
        ArrayUtils.merge(a,0,0, b,1, 4, result, 2);
        checkEqualsValues(expectedResult, result);
    }

    @Test
    public void mergeShouldWorkWhenOneArrayWithEventsHaveNotDataThatNeedToMergeToFinalArray() {
        Event[] a = new Event[]{
                new Event(2020, 6, 24, "A"),
                new Event(2021, 12, 21, "B"),
                new Event(2020, 8, 3, "C"),
                new Event(2012,8, 2,"D")
        };
        Event[] b = new Event[]{
                new Event(2018, 3, 2, "E"),
                new Event(2017, 4, 21, "F"),
                new Event(2011,7, 4,"H"),
                new Event(2020, 8, 1, "J")
        };
        Event[] result = new Event[]{
                new Event(2014, 1, 1, "R"),
                new Event(2014, 1, 1, "R"),
                new Event(2014, 1, 1, "R"),
                new Event(2014, 1, 1, "R"),
                new Event(2014, 1, 1, "R")
        };
        Event[] expectedResult = new Event[]{
                new Event(2014, 1, 1, "R"),
                new Event(2014, 1, 1, "R"),
                new Event(2014, 1, 1, "R"),
                new Event(2014, 1, 1, "R"),
                new Event(2014, 1, 1, "R")
        };
        ArrayUtils.merge(a,0,0, b,3, 3, result, 3);
        checkEqualsValues(expectedResult, result);
    }

    @Test
    public void mergeSortShouldWorkWhenAllEventsHaveDifferentDates() {
        Event[] events = new Event[]{
                new Event(2020, 6, 24, "A"),
                new Event(2021, 12, 21, "B"),
                new Event(2020, 8, 3, "C"),
                new Event(2012,8, 2,"D"),
                new Event(2019,7, 2,"E")
        };
        Event[] expectedResult = new Event[]{events[3], events[4], events[0], events[2], events[1]};
        ArrayUtils.mergeSort(events);
        checkEqualsValues(expectedResult, events);
    }

    @Test
    public void mergeSortShouldWorkWhenSomeEventsHaveSameDates() {
        Event[] events = new Event[]{
                new Event(2020, 6, 24, "A"),
                new Event(2021, 12, 21, "B"),
                new Event(2020, 8, 3, "C"),
                new Event(2020,8, 3,"D"),
                new Event(2019,7, 2,"E"),
                new Event(2012,7, 2,"F"),
                new Event(2020, 6, 24, "J")
        };
        Event[] expectedResult = new Event[]{
                new Event(2012,7, 2,"F"),
                new Event(2019,7, 2,"E"),
                new Event(2020, 6, 24, "A"),
                new Event(2020, 6, 24, "J"),
                new Event(2020, 8, 3, "C"),
                new Event(2020,8, 3,"D"),
                new Event(2021, 12, 21, "B")
        };
        ArrayUtils.mergeSort(events);
        checkEqualsValues(expectedResult, events);
    }

    @Test
    public void mergeSortShouldWorkWhenEventsHaveNotData() {
        Event[] events = new Event[]{};
        Event[] expectedResult = new Event[]{};
        ArrayUtils.mergeSort(events);
        checkEqualsValues(expectedResult, events);
    }

    @Test
    public void mergeSortShouldWorkLessThanOneSecond() {
        Event[] events = SortBenchmark.randomEvents(36000, 1, 3000);
        long firstTime = System.currentTimeMillis();
        ArrayUtils.mergeSort(events);
        long secondTime = System.currentTimeMillis();
        long result = secondTime - firstTime;
        Assertions.assertTrue(result < 1000);
    }

    @Test
    public void mergeSortShouldSortWhenNeedToSortPartOfArray() {
        int[] array = new int[] {4, 2, -1, 4, 2, -5, 3};
        ArrayUtils.mergeSort(array, 3, 7);
        int[] expectedArray = new int[]{4, 2, -1, -5, 2, 3, 4};
        Assertions.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void mergeSortShouldSortWhenNeedToSortOnlyOneElementFromArray() {
        int[] array = new int[] {4, 2, -1, 4, 2, -5, 3};
        ArrayUtils.mergeSort(array, 6, 7);
        int[] expectedArray = new int[]{4, 2, -1, 4, 2, -5, 3};
        Assertions.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void mergeSortShouldSortWhenHaveNotElementForSorting() {
        int[] array = new int[] {4, 2, -1, 4, 2, -5, 3};
        ArrayUtils.mergeSort(array, 7, 7);
        int[] expectedArray = new int[]{4, 2, -1, 4, 2, -5, 3};
        Assertions.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void mergeSortShouldSortWhenNeedToSortAllElementsFromArray() {
        int[] array = new int[] {4, 2, -1, 4, 2, -5, 3};
        ArrayUtils.mergeSort(array, 0, 7);
        int[] expectedArray = new int[]{-5, -1, 2, 2, 3, 4, 4};
        Assertions.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void mergeSortShouldWorkWhenArrayIsEmpty() {
        int[] array = new int[]{};
        ArrayUtils.mergeSort(array, 0, 0);
        int[] expectedArray = new int[]{};
        Assertions.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void mergeSortShouldWorkLessThanOneSecondWhenArrayHaveBigData() {
        int[] array = SortBenchmark.randomArray(100000, 1, 30000);
        long firstTime = System.currentTimeMillis();
        ArrayUtils.mergeSort(array, 4, 9253);
        long secondTime = System.currentTimeMillis();
        long result = secondTime - firstTime;
        Assertions.assertTrue(result < 1000);
    }

    @Test
    public void mergeSortShouldSortWhenNeedToSortPartOfArrayWithEvents() {
        Event[] events = new Event[] {
                new Event (2019, 12, 3, "A"),
                new Event (2018, 4, 2, "B"),
                new Event (2021, 3, 4, "C"),
                new Event (2014, 4, 3, "D"),
                new Event (2015, 2, 12, "E")
        };
        ArrayUtils.mergeSort(events, 2, 5);
        Event[] expectedEvents = new Event[]{
                new Event (2019, 12, 3, "A"),
                new Event (2018, 4, 2, "B"),
                new Event (2014, 4, 3, "D"),
                new Event (2015, 2, 12, "E"),
                new Event (2021, 3, 4, "C")
        };
        checkEqualsValues(expectedEvents, events);
    }

    @Test
    public void mergeSortShouldSortWhenNeedToOnlyOneEvent() {
        Event[] events = new Event[] {
                new Event (2019, 12, 3, "A"),
                new Event (2018, 4, 2, "B"),
                new Event (2021, 3, 4, "C"),
                new Event (2014, 4, 3, "D"),
                new Event (2015, 2, 12, "E")
        };
        ArrayUtils.mergeSort(events, 4, 5);
        Event[] expectedEvents = new Event[]{
                new Event (2019, 12, 3, "A"),
                new Event (2018, 4, 2, "B"),
                new Event (2021, 3, 4, "C"),
                new Event (2014, 4, 3, "D"),
                new Event (2015, 2, 12, "E")
        };
        checkEqualsValues(expectedEvents, events);
    }

    @Test
    public void mergeSortShouldWorkLessThanOneSecondWithBigData() {
        Event[] events = SortBenchmark.randomEvents(36000, 2000, 2022);
        long firstTime = System.currentTimeMillis();
        ArrayUtils.mergeSort(events, 22, 34521);
        long secondTime = System.currentTimeMillis();
        long result = secondTime - firstTime;
        Assertions.assertTrue(result < 1000);
    }
}
