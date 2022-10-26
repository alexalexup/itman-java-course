package utils;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import benchmarks.SortBenchmark;

import java.util.Comparator;
import java.util.function.ToIntFunction;


class ArrayUtilsTest<T> {
    private  Comparator<Event> comparator = (a, b) -> a.compareTo(b);

    public void checkEqualsValues(Event[] events, Event[] expectedValues) {
        for (int i = 0; i < events.length; i++) {
            boolean expectedResult = events[i].equals(expectedValues[i]);
            Assertions.assertTrue(expectedResult);
        }
    }

    @Nested
    public class BubbleSort {
        @Test
        public void shouldNotChangeLinksOnEventsWhenMethodWasCalled() {
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
            ArrayUtils.bubbleSort(events, comparator);
            Assertions.assertArrayEquals(expectedLinks, events);
            Assertions.assertSame(expectedEvents, events);
        }

        @Test
        public void shouldSortEventsWhenAllEventsHaveDifferenceYears() {
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
            ArrayUtils.bubbleSort(events, comparator);
            checkEqualsValues(events, expectedValues);
        }

        @Test
        public void shouldSortEventsWhenEventsHaveSameYears() {
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
            ArrayUtils.bubbleSort(events, comparator);
            checkEqualsValues(events, expectedValues);
        }

        @Test
        public void shouldSortEventsWhenYeasAndMonthAreSame() {
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
            ArrayUtils.bubbleSort(events, comparator);
            checkEqualsValues(events, expectedValues);
        }

        @Test
        public void shouldSortEventsWhenEventsHaveThreeSameEvent() {
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
            ArrayUtils.bubbleSort(events, comparator);
            checkEqualsValues(events, expectedValues);
        }

        @Test
        public void shouldNotSwapElementsOfEventsWhenAllElementsAreSame() {
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
            ArrayUtils.bubbleSort(events, comparator);
            checkEqualsValues(events, expectedValues);
        }

        @Test
        public void shouldNotChangeEventsWhenEventsHaveOneEvent() {
            entities.Event[] events = new entities.Event[]{new entities.Event(2018, 8, 25, "jodOffer")};
            entities.Event[] expectedValues = new entities.Event[]{new entities.Event(2018, 8, 25, "jodOffer")};
            ArrayUtils.bubbleSort(events, comparator);
            checkEqualsValues(events, expectedValues);
        }

        @Test
        public void shouldNotChangeEventsWhenEventsWithoutElements() {
            entities.Event[] events = new entities.Event[]{};
            entities.Event[] expectedValues = new entities.Event[]{};
            ArrayUtils.bubbleSort(events, comparator);
            checkEqualsValues(events, expectedValues);
        }

        @Test
        public void shouldSortEventsWhenEventsHaveSameMonthAndDifferenceYearsAndDays() {
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
            ArrayUtils.bubbleSort(events, comparator);
            checkEqualsValues(events, expectedValues);
        }

        @Test
        public void shouldSortEventsWhenEventsHaveTwoSameEvents() {
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
            ArrayUtils.bubbleSort(events, comparator);
            checkEqualsValues(events, expectedValues);
        }

        @Test
        public void shouldSortArrayInIncreasingOrderWhenArrayHaveSomeElements() {
            int[] array = new int[]{5, 2, 4, 1, 3, 3};
            ArrayUtils.bubbleSort(array);
            int[] expectedArray = new int[]{1, 2, 3, 3, 4, 5};
            Assertions.assertArrayEquals(array, expectedArray);
        }

        @Test
        public void shouldSortArrayInIncreasingOrderWhenArrayHaveOneElement() {
            int[] array = new int[]{4};
            ArrayUtils.bubbleSort(array);
            int[] expectedArray = new int[]{4};
            Assertions.assertArrayEquals(array, expectedArray);
        }

        @Test
        public void shouldWorkWhenArrayHaveNotElements() {
            int[] array = new int[]{};
            ArrayUtils.bubbleSort(array);
            int[] expectedArray = new int[]{};
            Assertions.assertArrayEquals(array, expectedArray);
        }
    }

    @Nested
    public class CountingSort {
        private ToIntFunction<Event> function = a -> a.getDay() + a.getMonth() * 31 + a.getYear() * 12 * 31;
        @Test
        public void shouldSortSortArrayWhenArrayHaveSomeElements() {
            int[] actualArray = new int[]{4, 2, 2, 10, 1, 3, 5, 2, 7};
            int[] expectedArray = new int[]{1, 2, 2, 2, 3, 4, 5, 7, 10};
            ArrayUtils.countingSort(actualArray);
            Assertions.assertArrayEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldWorkWhenArrayHaveOneElement() {
            int[] actualArray = new int[]{6};
            int[] expectedArray = new int[]{6};
            ArrayUtils.countingSort(actualArray);
            Assertions.assertArrayEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldWorkWhenArrayHaveNotElements() {
            int[] actualArray = new int[]{};
            int[] expectedArray = new int[]{};
            ArrayUtils.countingSort(actualArray);
            Assertions.assertArrayEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldWorkWhenArrayHaveEqualElements() {
            int[] actualArray = new int[]{3, 3, 3, 3, 3};
            int[] expectedArray = new int[]{3, 3, 3, 3, 3};
            ArrayUtils.countingSort(actualArray);
            Assertions.assertArrayEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldSortArrayWhenElementsArePositiveAndHaveMaxRangeBetweenMaxAndMinElements() {
            int[] actualArray = new int[]{2147483647, 2147383648, 2147283648};
            int[] expectedArray = new int[]{2147283648, 2147383648, 2147483647};
            ArrayUtils.countingSort(actualArray);
            Assertions.assertArrayEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldSortArrayWhenElementsAreNegativeAndHaveMaxRangeBetweenMaxAndMinElements() {
            int[] actualArray = new int[]{-2146483649, -2147483648};
            int[] expectedArray = new int[]{-2147483648, -2146483649};
            ArrayUtils.countingSort(actualArray);
            Assertions.assertArrayEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldSortArrayWhenElementsFromArrayAreNegativeAndPositive() {
            int[] actualArray = new int[]{-25, -4, 0, 12, 4, -2, -4, -5};
            int[] expectedArray = new int[]{-25, -5, -4, -4, -2,  0, 4, 12};
            ArrayUtils.countingSort(actualArray);
            Assertions.assertArrayEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldSortArrayWhenElementsAreNegativeAndPositiveAndHaveMaxRangeBetweenMaxAndMinElements() {
            int[] actualArray = new int[]{2, -999998, 0, 1, 1, -3};
            int[] expectedArray = new int[]{-999998, -3, 0, 1, 1, 2};
            ArrayUtils.countingSort(actualArray);
            Assertions.assertArrayEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldSortEventsWhenEventsHaveDifferentDates() {
            Event[] events = new Event[] {
                    new Event(2010, 8, 21, "birthday"),
                    new Event(2009, 12, 20, "jobOffer"),
                    new Event(2008, 12, 25, "christmas"),
                    new Event(2014, 5, 14 , "startHolidays")
            };
            Event[] expectedEvents = new Event[]{events[2], events[1], events[0], events[3]};
            ArrayUtils.countingSort(events, function);
            Assertions.assertArrayEquals(expectedEvents, events);
        }

        @Test
        public void shouldSortEventsWhenEventsHaveDifferentAndSameDates() {
            Event[] events = new Event[]{
                    new Event(2020, 10, 25, "a"),
                    new Event(2020, 5, 20, "b"),
                    new Event(2020, 7, 15, "c"),
                    new Event(2021, 1, 1, "d"),
                    new Event(2020, 7, 15, "e")};
            Event[] expectedEvents = new Event[]{events[1], events[2], events[4], events[0], events[3]};
            ArrayUtils.countingSort(events, function);
            Assertions.assertArrayEquals(expectedEvents, events);
        }

        @Test
        public void shouldWorkWhenEventsHaveNotData() {
            Event[] events = new Event[]{};
            Event[] expectedEvents = new Event[]{};
            ArrayUtils.countingSort(events, function);
            Assertions.assertArrayEquals(expectedEvents, events);
        }

        @Test
        public void shouldWorkWhenAllEventsHaveSameDates() {
            Event[] events = new Event[]{
                    new Event(2020, 10, 25, "a"),
                    new Event(2020, 10, 25, "b"),
                    new Event(2020, 10, 25, "c"),
                    new Event(2020, 10, 25, "d"),
            };
            Event[] expectedEvents = new Event[]{events[0], events[1], events[2], events[3]};
            ArrayUtils.countingSort(events, function);
            Assertions.assertArrayEquals(expectedEvents, events);
        }
    }

    @Nested
    public class Distinct {
        @Test
        public void shouldReturnArrayWithUniqueNumbersWhenNumbersPositiveAndNegative(){
            int[] array= new int[]{5, 2, 2, 4, -6, -5, -2, -5, 0, 0};
            int[] expectedArray = new int[]{5, 2, 4, -6, -5, -2, 0};
            int[] actualArray = ArrayUtils.distinct(array);
            Assertions.assertArrayEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldReturnArrayWithUniqueNumbersWhenElementsAreNegativeAndPositive() {
            int[] array = new int[]{2, -999998, -999998, 0, 1, 1, -3};
            int[] expectedArray = new int[]{2, -999998, 0, 1, -3};
            int[] actualArray = ArrayUtils.distinct(array);
            Assertions.assertArrayEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldReturnResultWhenArrayIsEmpty() {
            int[] array = new int[]{};
            int[] expectedArray = new int[]{};
            int[] actualArray = ArrayUtils.distinct(array);
            Assertions.assertArrayEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldReturnResultWhenElementsArePositiveAndHaveMaxRangeBetweenMaxAndMinElements() {
            int[] array = new int[]{2147483647, 2147383648, 2147283648, 2147483647};
            int[] expectedArray = new int[]{2147483647, 2147383648, 2147283648};
            int[] actualArray = ArrayUtils.distinct(array);
            Assertions.assertArrayEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldReturnResultWhenElementsAreNegativeAndHaveMaxRangeBetweenMaxAndMinElements() {
            int[] array = new int[]{-2147483647, -2147383648, -2147283648, -2147483647};
            int[] expectedArray = new int[]{-2147483647, -2147383648, -2147283648};
            int[] actualArray = ArrayUtils.distinct(array);
            Assertions.assertArrayEquals(expectedArray, actualArray);
        }
    }

    @Nested
    public class MostFrequent {
        @Test
        public void shouldReturnResultWhenArrayHaveOneElement() {
            int[] array = new int[]{-12};
            int actualResult = ArrayUtils.mostFrequent(array);
            Assertions.assertEquals(-12, actualResult);
        }

        @Test
        public void shouldReturnResultWhenElementsAreNegativeAndHaveMaxRangeBetweenMaxAndMinElements() {
            int[] array = new int[]{-2147483647, -2147383648, -2147283648, -2147283648, -2147483647};
            int actualResult = ArrayUtils.mostFrequent(array);
            Assertions.assertEquals(-2147483647, actualResult);
        }

        @Test
        public void shouldReturnResultWhenElementsArePositiveAndHaveMaxRangeBetweenMaxAndMinElements() {
            int[] array = new int[]{2147483647, 2147383648, 2147283648, 2147283648, 2147483647};
            int actualResult = ArrayUtils.mostFrequent(array);
            Assertions.assertEquals(2147283648, actualResult);
        }

        @Test
        public void shouldReturnResultWhenElementsArePositiveAndNegative() {
            int[] array = new int[]{5, 2, -7, -3, -3, 5, 5, 5, 9, 2};
            int actualResult = ArrayUtils.mostFrequent(array);
            Assertions.assertEquals(5, actualResult);
        }

        @Test
        public void shouldReturnResultWhenAllElementsAreZero() {
            int[] array = new int[]{0, 0, 0, 0, 0};
            int actualResult = ArrayUtils.mostFrequent(array);
            Assertions.assertEquals(0, actualResult);
        }
    }

    @Nested
    public class CountEquals {
        @Test
        public void shouldReturnResultWhenArraysHaveSomeElements() {
            int[] firstArray = new int[]{2, 3, 4, 2, 2, 4, 4};
            int[] secondArray = new int[]{-5, -2, 3, 3, 3, 2, 5, 2};
            int actualResult = ArrayUtils.countEquals(firstArray, secondArray);
            Assertions.assertEquals(3, actualResult);
        }

        @Test
        public void shouldReturnZeroWhenOneArrayHaveNotElements() {
            int[] firstArray = new int[]{};
            int[] secondArray = new int[]{-5, -2, 3, 3, 3, 2, 5, 2};
            int actualResult = ArrayUtils.countEquals(firstArray, secondArray);
            Assertions.assertEquals(0, actualResult);
        }

        @Test
        public void shouldReturnResultWhenAllElementsAreEqual() {
            int[] firstArray = new int[]{4, 4, 4, 4};
            int[] secondArray = new int[]{4, 4, 4, 4, 4, 4, 4, 4, 4};
            int actualResult = ArrayUtils.countEquals(firstArray, secondArray);
            Assertions.assertEquals(4, actualResult);
        }

        @Test
        public void shouldReturnResultWhenEachArrayHaveOnlyOneElement() {
            int[] firstArray = new int[]{1000000000};
            int[] secondArray = new int[]{-1000000000};
            int actualResult = ArrayUtils.countEquals(firstArray, secondArray);
            Assertions.assertEquals(0, actualResult);
        }

        @Test
        public void shouldReturnResultWhenOneArrayHaveMaxRangeBetweenMaxAndMinElements() {
            int[] firstArray = new int[]{-2147483647, 2, 3, 3, 2, 5, 2147483647};
            int[] secondArray = new int[]{2, 2, 3, 4};
            int actualResult = ArrayUtils.countEquals(firstArray, secondArray);
            Assertions.assertEquals(3, actualResult);
        }
    }

    @Nested
    public class Merge {
        private  Comparator<Event> comparator = (a, b) -> a.compareTo(b);
        @Test
        public void shouldWorkWhenTwoArraysHaveDataThatNeedToMergeToFinalArray() {
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
        public void shouldWorkWhenOnlyOneArraysHaveDataThatNeedToMergeToFinalArray() {
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
        public void shouldWorkWhenHaveNotArraysThatNeedToMergeToFinalArray() {
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
        public void shouldWorkWhenOneArrayHaveNotData() {
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
        public void shouldWorkWhenTwoArraysWithEventsHaveDataThatNeedToMergeToFinalArray() {
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
            ArrayUtils.merge(a,0,2, b,2, 4, result, 0, comparator);
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
        public void shouldWorkWhenHaveNotArraysWithEventsThatNeedToMergeToFinalArray() {
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
            ArrayUtils.merge(a,0,0, b,1, 4, result, 2, comparator);
            checkEqualsValues(expectedResult, result);
        }

        @Test
        public void shouldWorkWhenOneArrayWithEventsHaveNotDataThatNeedToMergeToFinalArray() {
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
            ArrayUtils.merge(a,0,0, b,3, 3, result, 3, comparator);
            checkEqualsValues(expectedResult, result);
        }
    }

    @Nested
    public class MergeSort {
        @Test
        public void shouldSortArrayWhenArrayHasAnEvenNumberOfElements(){
            int[] actualArray = new int[]{13, 9 ,8, 12, 5, 7};
            ArrayUtils.mergeSort(actualArray);
            int[] expectedArray = new int[]{5, 7, 8, 9, 12, 13};
            Assertions.assertArrayEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldSortArrayWhenArrayHasAnOddNumberOfElements(){
            int[] actualArray = new int[]{13, 9 ,8, 12, 5, 7, -1};
            ArrayUtils.mergeSort(actualArray);
            int[] expectedArray = new int[]{-1, 5, 7, 8, 9, 12, 13};
            Assertions.assertArrayEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldSortArrayLessThanOneSecond(){
            int[] actualArray = SortBenchmark.randomArray(1000000, -3, 10000);
            long firstTime = System.currentTimeMillis();
            ArrayUtils.mergeSort(actualArray);
            long secondTime = System.currentTimeMillis();
            long result = secondTime - firstTime;
            Assertions.assertTrue(result < 1000);
        }

        @Test
        public void shouldWorkWhenArrayHasNotElements(){
            int[] actualArray = new int[]{};
            ArrayUtils.mergeSort(actualArray);
            int[] expectedArray = new int[]{};
            Assertions.assertArrayEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldWorkWhenAllEventsHaveDifferentDates() {
            Event[] events = new Event[]{
                    new Event(2020, 6, 24, "A"),
                    new Event(2021, 12, 21, "B"),
                    new Event(2020, 8, 3, "C"),
                    new Event(2012,8, 2,"D"),
                    new Event(2019,7, 2,"E")
            };
            Event[] expectedResult = new Event[]{events[3], events[4], events[0], events[2], events[1]};
            ArrayUtils.mergeSort(events, comparator);
            checkEqualsValues(expectedResult, events);
        }

        @Test
        public void shouldWorkWhenSomeEventsHaveSameDates() {
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
            ArrayUtils.mergeSort(events, comparator);
            checkEqualsValues(expectedResult, events);
        }

        @Test
        public void shouldWorkWhenEventsHaveNotData() {
            Event[] events = new Event[]{};
            Event[] expectedResult = new Event[]{};
            ArrayUtils.mergeSort(events, comparator);
            checkEqualsValues(expectedResult, events);
        }

        @Test
        public void shouldWorkLessThanOneSecond() {
            Event[] events = SortBenchmark.randomEvents(36000, 1, 3000);
            long firstTime = System.currentTimeMillis();
            ArrayUtils.mergeSort(events, comparator);
            long secondTime = System.currentTimeMillis();
            long result = secondTime - firstTime;
            Assertions.assertTrue(result < 1000);
        }

        @Test
        public void shouldSortWhenNeedToSortPartOfArrayAndCountOfSortingElementsIsOdd() {
            int[] array = new int[]{2, -3, 4, 7, 1, 3, 2, 3};
            ArrayUtils.mergeSort(array, 1, 6);
            int[] expectedArray = new int[]{2, -3, 1, 3, 4, 7, 2, 3};
            Assertions.assertArrayEquals(expectedArray, array);
        }

        @Test
        public void shouldSortWhenNeedToSortPartOfArrayAndCountOfSortingElementsIsEven() {
            int[] array = new int[]{2, -3, 4, 7, 5, 1, 3, 2, 3};
            ArrayUtils.mergeSort(array, 1, 7);
            int[] expectedArray = new int[]{2, -3, 1, 3, 4, 5, 7, 2, 3};
            Assertions.assertArrayEquals(expectedArray, array);
        }

        @Test
        public void shouldSortWhenNeedToSortOnlyOneElementFromArray() {
            int[] array = new int[] {4, 2, -1, 4, 2, -5, 3};
            ArrayUtils.mergeSort(array, 6, 7);
            int[] expectedArray = new int[]{4, 2, -1, 4, 2, -5, 3};
            Assertions.assertArrayEquals(expectedArray, array);
        }

        @Test
        public void shouldSortWhenHaveNotElementForSorting() {
            int[] array = new int[] {4, 2, -1, 4, 2, -5, 3};
            ArrayUtils.mergeSort(array, 7, 7);
            int[] expectedArray = new int[]{4, 2, -1, 4, 2, -5, 3};
            Assertions.assertArrayEquals(expectedArray, array);
        }

        @Test
        public void shouldSortWhenNeedToSortAllElementsFromArray() {
            int[] array = new int[] {4, 2, -1, 4, 2, -5, 3};
            ArrayUtils.mergeSort(array, 0, 7);
            int[] expectedArray = new int[]{-5, -1, 2, 2, 3, 4, 4};
            Assertions.assertArrayEquals(expectedArray, array);
        }

        @Test
        public void shouldWorkWhenArrayIsEmpty() {
            int[] array = new int[]{};
            ArrayUtils.mergeSort(array, 0, 0);
            int[] expectedArray = new int[]{};
            Assertions.assertArrayEquals(expectedArray, array);
        }

        @Test
        public void shouldWorkLessThanOneSecondWhenArrayHaveBigData() {
            int[] array = SortBenchmark.randomArray(100000, 1, 30000);
            long firstTime = System.currentTimeMillis();
            ArrayUtils.mergeSort(array, 2, 92459);
            long secondTime = System.currentTimeMillis();
            long result = secondTime - firstTime;
            Assertions.assertTrue(result < 1000);
        }

        @Test
        public void shouldSortWhenNeedToSortPartOfArrayWithEvents() {
            Event[] events = new Event[] {
                    new Event (2019, 12, 3, "A"),
                    new Event (2018, 4, 2, "B"),
                    new Event (2021, 3, 4, "C"),
                    new Event (2014, 4, 3, "D"),
                    new Event (2015, 2, 12, "E")
            };
            ArrayUtils.mergeSort(events, 2, 5, comparator);
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
        public void shouldSortWhenNeedToOnlyOneEvent() {
            Event[] events = new Event[] {
                    new Event (2019, 12, 3, "A"),
                    new Event (2018, 4, 2, "B"),
                    new Event (2021, 3, 4, "C"),
                    new Event (2014, 4, 3, "D"),
                    new Event (2015, 2, 12, "E")
            };
            ArrayUtils.mergeSort(events, 4, 5, comparator);
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
        public void shouldWorkLessThanOneSecondWithBigData() {
            Event[] events = SortBenchmark.randomEvents(36000, 2000, 2022);
            long firstTime = System.currentTimeMillis();
            ArrayUtils.mergeSort(events, 22, 34521, comparator);
            long secondTime = System.currentTimeMillis();
            long result = secondTime - firstTime;
            Assertions.assertTrue(result < 1000);
        }
    }
}
