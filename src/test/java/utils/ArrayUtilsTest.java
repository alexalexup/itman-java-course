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
}
