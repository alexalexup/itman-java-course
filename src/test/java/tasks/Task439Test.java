package tasks;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task439Test {
    @Test
    public void findLastWhenEventFirst() {
        entities.Event[] events = new entities.Event[] {
                new entities.Event(2005, 8, 5, "birthday"),
                new entities.Event(2005, 8, 20, "jobOffer"),
                new entities.Event(2008, 12, 25, "christmas"),
                new entities.Event(2008, 5, 14 , "startHolidays")
        };
        entities.Event[] expectedEvents = new entities.Event[] {
                new entities.Event(2005, 8, 5, "birthday"),
                new entities.Event(2005, 8, 20, "jobOffer"),
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

}