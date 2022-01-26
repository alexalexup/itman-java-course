package tasks;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task439Test {

    public void checkEqualsValues(Event[] events, Event[] expectedEvents) {
        for (int i = 0; i < events.length; i++) {
            boolean expectedResult = events[i].equals(expectedEvents[i]);
            Assertions.assertTrue(expectedResult);
        }
    }

    @Test
    public void findShouldReturnLastEventWhenLastIsAtFirstOfArray() {
        entities.Event[] events = new entities.Event[] {
                new entities.Event(2010, 8, 21, "birthday"),
                new entities.Event(2009, 12, 20, "jobOffer"),
                new entities.Event(2008, 12, 25, "christmas"),
                new entities.Event(2008, 5, 14 , "startHolidays")
        };
        entities.Event[] expectedEvents = new entities.Event[] {
                new entities.Event(2010, 8, 21, "birthday"),
                new entities.Event(2009, 12, 20, "jobOffer"),
                new entities.Event(2008, 12, 25, "christmas"),
                new entities.Event(2008, 5, 14 , "startHolidays")
        };
        Event expected = events[0];
        Event actual = Task439.findLast(events);
        Assertions.assertSame(expected, actual);
        checkEqualsValues(events, expectedEvents);
    }

    @Test
    public void findShouldNotChangeLinksOnEventsWhenMethodWasCalled() {
        entities.Event[] events = new entities.Event[] {
                new entities.Event(2010, 8, 21, "birthday"),
                new entities.Event(2009, 12, 20, "jobOffer"),
                new entities.Event(2008, 12, 25, "christmas"),
                new entities.Event(2008, 5, 14 , "startHolidays")
        };
        entities.Event[] expectedEventsLinks = new entities.Event[] {
                events[0],
                events[1],
                events[2],
                events[3]
        };
        Task439.findLast(events);
        Assertions.assertArrayEquals(expectedEventsLinks, events);
    }


    @Test
    public void findShouldReturnLastEventWhenLastIsInMiddleOfArray() {
        entities.Event[] events = new entities.Event[] {
                new entities.Event(2010, 8, 21, "birthday"),
                new entities.Event(2009, 12, 20, "jobOffer"),
                new entities.Event(2010, 12, 25, "christmas"),
                new entities.Event(2008, 5, 14 , "startHolidays")
        };
        entities.Event[] expectedEvents = new entities.Event[] {
                new entities.Event(2010, 8, 21, "birthday"),
                new entities.Event(2009, 12, 20, "jobOffer"),
                new entities.Event(2010, 12, 25, "christmas"),
                new entities.Event(2008, 5, 14 , "startHolidays")
        };
        Event expected = events[2];
        Event actual = Task439.findLast(events);
        Assertions.assertSame(expected, actual);
        checkEqualsValues(events, expectedEvents);
    }

    @Test
    public void findShouldReturnLastEventWhenLastIsAtLastOfArray() {
        entities.Event[] events = new entities.Event[] {
                new entities.Event(2010, 8, 21, "birthday"),
                new entities.Event(2012, 12, 20, "jobOffer"),
                new entities.Event(2010, 12, 25, "christmas"),
                new entities.Event(2012, 12, 25 , "startHolidays")
        };
        entities.Event[] expectedEvents = new entities.Event[] {
                new entities.Event(2010, 8, 21, "birthday"),
                new entities.Event(2012, 12, 20, "jobOffer"),
                new entities.Event(2010, 12, 25, "christmas"),
                new entities.Event(2012, 12, 25 , "startHolidays")
        };
        Event expected = events[3];
        Event actual = Task439.findLast(events);
        Assertions.assertSame(expected, actual);
        checkEqualsValues(events, expectedEvents);
    }

    @Test
    public void findShouldReturnLastEventWhenEventsContainOneElement() {
        entities.Event[] events = new entities.Event[] {new entities.Event(1999, 4, 18, "wedding")};
        entities.Event[] expectedEvents = new entities.Event[] {(events[0])};
        Event actual = Task439.findLast(events);
        checkEqualsValues(events, expectedEvents);
        Assertions.assertEquals(events[0], actual);
    }

    @Test
    public void findShouldReturnLastEventWhenEventWithoutElement() {
        entities.Event[] events = new entities.Event[] {};
        Event actual = Task439.findLast(events);
        Assertions.assertEquals(actual, null);
    }

    @Test
    public void findShouldReturnLastEventWhenEventHaveTreeSameYears() {
        entities.Event[] events = new entities.Event[] {
                new entities.Event(2010, 8, 21, "birthday"),
                new entities.Event(2012, 12, 20, "jobOffer"),
                new entities.Event(2012, 9, 25, "christmas"),
                new entities.Event(2012, 11, 25 , "startHolidays")
        };
        entities.Event[] expectedEvents = new entities.Event[] {
                new entities.Event(2010, 8, 21, "birthday"),
                new entities.Event(2012, 12, 20, "jobOffer"),
                new entities.Event(2012, 9, 25, "christmas"),
                new entities.Event(2012, 11, 25 , "startHolidays")
        };
        Event expected = events[1];
        Event actual = Task439.findLast(events);
        Assertions.assertSame(expected, actual);
    }

    @Test
    public void findShouldReturnLastEventWhenEventsHaveSameMonthAndHaveDifferenceYearsAndDays() {
        entities.Event[] events = new entities.Event[]{
                new entities.Event(2014, 6, 3, "jodOffer"),
                new entities.Event(2010, 6, 25, "birthday"),
                new entities.Event(2016, 6, 2, "wedding"),
                new entities.Event(2009, 6, 24, "holidays"),
                new entities.Event(2008, 6, 23, "meeting")
        };
        entities.Event[] expectedValues = new entities.Event[]{
                new entities.Event(2014, 6, 3, "jodOffer"),
                new entities.Event(2010, 6, 25, "birthday"),
                new entities.Event(2016, 6, 2, "wedding"),
                new entities.Event(2009, 6, 24, "holidays"),
                new entities.Event(2008, 6, 23, "meeting")
        };
        Event expected = events[2];
        Event actual = Task439.findLast(events);
        Assertions.assertSame(expected, actual);
        checkEqualsValues(events, expectedValues);
    }

    @Test
    public void findShouldReturnLastEventWhenEventsHaveSameEventsWithEqualElements() {
        entities.Event[] events = new entities.Event[]{
                new entities.Event(2020, 10, 25, "A"),
                new entities.Event(2020, 5, 20, "B"),
                new entities.Event(2020, 7, 15, "C"),
                new entities.Event(2021, 1, 1, "D"),
                new entities.Event(2021, 1, 1, "E")
        };
        entities.Event[] expectedValues = new entities.Event[]{
                new entities.Event(2020, 10, 25, "A"),
                new entities.Event(2020, 5, 20, "B"),
                new entities.Event(2020, 7, 15, "C"),
                new entities.Event(2021, 1, 1, "D"),
                new entities.Event(2021, 1, 1, "E")
        };
        Event expected = events[4];
        Event actual = Task439.findLast(events);
        Assertions.assertSame(expected, actual);
        checkEqualsValues(events, expectedValues);
    }
}