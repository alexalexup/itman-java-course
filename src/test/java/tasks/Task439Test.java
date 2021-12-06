package tasks;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task439Test {
    @Test
    public void findLastWhenEventFirst() {
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
        entities.Event[] expectedEventsLinks = new entities.Event[] {
                events[0],
                events[1],
                events[2],
                events[3]
        };

        Event expected = events[0];
        Event actual = Task439.findLast(events);
        Assertions.assertSame(expected, actual);
        Assertions.assertArrayEquals(expectedEventsLinks, events);
        for (int i = 0; i < events.length; i++) {
            Assertions.assertEquals(events[i].year, expectedEvents[i].year);
            Assertions.assertEquals(events[i].month, expectedEvents[i].month);
            Assertions.assertEquals(events[i].day, expectedEvents[i].day);
            Assertions.assertEquals(events[i].name, expectedEvents[i].name);
        }
    }

    @Test
    public void findLastWhenEventInMiddle() {
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
        entities.Event[] expectedEventsLinks = new entities.Event[] {
                events[0],
                events[1],
                events[2],
                events[3]
        };

        Event expected = events[2];
        Event actual = Task439.findLast(events);
        Assertions.assertSame(expected, actual);
        Assertions.assertArrayEquals(expectedEventsLinks, events);
        for (int i = 0; i < events.length; i++) {
            Assertions.assertEquals(events[i].year, expectedEvents[i].year);
            Assertions.assertEquals(events[i].month, expectedEvents[i].month);
            Assertions.assertEquals(events[i].day, expectedEvents[i].day);
            Assertions.assertEquals(events[i].name, expectedEvents[i].name);
        }
    }

    @Test
    public void findLastWhenEventLast() {
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
        entities.Event[] expectedEventsLinks = new entities.Event[] {
                events[0],
                events[1],
                events[2],
                events[3]
        };

        Event expected = events[3];
        Event actual = Task439.findLast(events);
        Assertions.assertSame(expected, actual);
        Assertions.assertArrayEquals(expectedEventsLinks, events);
        for (int i = 0; i < events.length; i++) {
            Assertions.assertEquals(events[i].year, expectedEvents[i].year);
            Assertions.assertEquals(events[i].month, expectedEvents[i].month);
            Assertions.assertEquals(events[i].day, expectedEvents[i].day);
            Assertions.assertEquals(events[i].name, expectedEvents[i].name);
        }
    }

    @Test
    public void findLastwhenEventContainOneElement() {
        entities.Event[] events = new entities.Event[] {new entities.Event(1999, 4, 18, "wedding")};
        entities.Event[] expectedEvents = new entities.Event[] {(events[0])};
        Event actual = Task439.findLast(events);
        Assertions.assertArrayEquals(expectedEvents, events);
        Assertions.assertEquals(events[0].year, expectedEvents[0].year);
        Assertions.assertEquals(events[0].month, expectedEvents[0].month);
        Assertions.assertEquals(events[0].day, expectedEvents[0].day);
        Assertions.assertEquals(events[0].name, expectedEvents[0].name);
    }
    @Test
    public void findLastwhenEventWithoutElement() {
        entities.Event[] events = new entities.Event[] {};
        Event actual = Task439.findLast(events);
        Assertions.assertEquals(actual, null);

    }

    @Test
    public void findLastWhenEventHaveTreeSameYears() {
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
        entities.Event[] expectedEventsLinks = new entities.Event[] {
                events[0],
                events[1],
                events[2],
                events[3]
        };

        Event expected = events[1];
        Event actual = Task439.findLast(events);
        Assertions.assertSame(expected, actual);
        Assertions.assertArrayEquals(expectedEventsLinks, events);
        for (int i = 0; i < events.length; i++) {
            Assertions.assertEquals(events[i].year, expectedEvents[i].year);
            Assertions.assertEquals(events[i].month, expectedEvents[i].month);
            Assertions.assertEquals(events[i].day, expectedEvents[i].day);
            Assertions.assertEquals(events[i].name, expectedEvents[i].name);
        }
    }
}