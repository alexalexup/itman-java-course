package tasks;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task408Test {

    @Test
    public void sortWhenDifferentYears() {
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
        entities.Event[] expectedLinks = new entities.Event[]{
                events[3],
                events[2],
                events[0],
                events[1]
        };
        Task408.sort(events);
        Assertions.assertArrayEquals(expectedLinks, events);
        for (int i = 0; i < events.length; i++) {
            Assertions.assertEquals(expectedValues[i].year, events[i].year);
            Assertions.assertEquals(expectedValues[i].month, events[i].month);
            Assertions.assertEquals(expectedValues[i].day, events[i].day);
            Assertions.assertEquals(expectedValues[i].name, events[i].name);
        }
    }

    @Test
    public void sortWhenSameYearsDifferentMonthAndDays() {
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
        entities.Event[] expectedLinks = new entities.Event[]{
                events[3],
                events[2],
                events[1],
                events[0]
        };
        Task408.sort(events);
        Assertions.assertArrayEquals(expectedLinks, events);
        for (int i = 0; i < events.length; i++) {
            Assertions.assertEquals(expectedValues[i].year, events[i].year);
            Assertions.assertEquals(expectedValues[i].month, events[i].month);
            Assertions.assertEquals(expectedValues[i].day, events[i].day);
            Assertions.assertEquals(expectedValues[i].name, events[i].name);
        }
    }

    @Test
    public void sortWhenOnlyDaysDifferent() {
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
        entities.Event[] expectedLinks = new entities.Event[]{
                events[1],
                events[0],
                events[3],
                events[2]
        };
        Task408.sort(events);
        Assertions.assertArrayEquals(expectedLinks, events);
        for (int i = 0; i < events.length; i++) {
            Assertions.assertEquals(expectedValues[i].year, events[i].year);
            Assertions.assertEquals(expectedValues[i].month, events[i].month);
            Assertions.assertEquals(expectedValues[i].day, events[i].day);
            Assertions.assertEquals(expectedValues[i].name, events[i].name);
        }
    }

    @Test
    public void sortWhenThreeSameElements() {
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
        entities.Event[] expectedLinks = new entities.Event[]{
                events[2],
                events[0],
                events[1],
                events[3]
        };
        Task408.sort(events);
        Assertions.assertArrayEquals(expectedLinks, events);
        for (int i = 0; i < events.length; i++) {
            Assertions.assertEquals(expectedValues[i].year, events[i].year);
            Assertions.assertEquals(expectedValues[i].month, events[i].month);
            Assertions.assertEquals(expectedValues[i].day, events[i].day);
            Assertions.assertEquals(expectedValues[i].name, events[i].name);
        }
    }

    @Test
    public void sortWhenAllElementsSame() {
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
        entities.Event[] expectedLinks = new entities.Event[]{
                events[0],
                events[1],
                events[2],
                events[3]
        };
        Task408.sort(events);
        Assertions.assertArrayEquals(expectedLinks, events);
        for (int i = 0; i < events.length; i++) {
            Assertions.assertEquals(expectedValues[i].year, events[i].year);
            Assertions.assertEquals(expectedValues[i].month, events[i].month);
            Assertions.assertEquals(expectedValues[i].day, events[i].day);
            Assertions.assertEquals(expectedValues[i].name, events[i].name);
        }
    }

    @Test
    public void sortWhenOneEvent() {
        entities.Event[] events = new entities.Event[]{new entities.Event(2018, 8, 25, "jodOffer")};
        entities.Event[] expectedValues = new entities.Event[]{new entities.Event(2018, 8, 25, "jodOffer")};
        entities.Event[] expectedLinks = new entities.Event[]{events[0]};
        Task408.sort(events);
        Assertions.assertArrayEquals(expectedLinks, events);
        Assertions.assertEquals(expectedValues[0].year, events[0].year);
        Assertions.assertEquals(expectedValues[0].month, events[0].month);
        Assertions.assertEquals(expectedValues[0].day, events[0].day);
        Assertions.assertEquals(expectedValues[0].name, events[0].name);
    }

}
