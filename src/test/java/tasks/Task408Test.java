package tasks;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task408Test {

    public void checkEqualsValues(Event[] events, Event[] expectedValues) {
        for (int i = 0; i < events.length; i++) {
            boolean expectedResult = events[i].equals(expectedValues[i]);
            Assertions.assertTrue(expectedResult);
        }
    }

    @Test
    public void sortShouldNotChangeLinksOnEventsWhenMethodWasCalled() {
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
        Task408.sort(events);
        Assertions.assertArrayEquals(expectedLinks, events);
        Assertions.assertSame(expectedEvents, events);
    }

    @Test
    public void sortShouldSortEventsWhenAllEventsHaveDifferenceYears() {
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
        Task408.sort(events);
        checkEqualsValues(events, expectedValues);
    }

    @Test
    public void sortShouldSortEventsWhenEventsHaveSameYears() {
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
        Task408.sort(events);
        checkEqualsValues(events, expectedValues);
    }

    @Test
    public void sortShouldSortEventsWhenYeasAndMonthAreSame() {
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
        Task408.sort(events);
        checkEqualsValues(events, expectedValues);
    }

    @Test
    public void sortShouldSortEventsWhenEventsHaveThreeSameEvent() {
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
        Task408.sort(events);
        checkEqualsValues(events, expectedValues);
    }

    @Test
    public void sortShouldNotSwapElementsOfEventsWhenAllElementsAreSame() {
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
        Task408.sort(events);
        checkEqualsValues(events, expectedValues);
    }

    @Test
    public void sortShouldNotChangeEventsWhenEventsHaveOneEvent() {
        entities.Event[] events = new entities.Event[]{new entities.Event(2018, 8, 25, "jodOffer")};
        entities.Event[] expectedValues = new entities.Event[]{new entities.Event(2018, 8, 25, "jodOffer")};
        Task408.sort(events);
        checkEqualsValues(events, expectedValues);
    }

    @Test
    public void sortShouldNotChangeEventsWhenEventsWithoutElements() {
        entities.Event[] events = new entities.Event[]{};
        entities.Event[] expectedValues = new entities.Event[]{};
        Task408.sort(events);
        checkEqualsValues(events, expectedValues);
    }

    @Test
    public void sortShouldSortEventsWhenEventsHaveSameMonthAndDifferenceYearsAndDays() {
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
        Task408.sort(events);
        checkEqualsValues(events, expectedValues);
    }

    @Test
    public void sortShouldSortEventsWhenEventsHaveTwoSameEvents() {
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
        Task408.sort(events);
        checkEqualsValues(events, expectedValues);
    }
}
