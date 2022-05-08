package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import entities.Event;

import static org.junit.jupiter.api.Assertions.*;

class EventListTest {

    private void compareEvents(Event[] first, Event[] second) {
        Assertions.assertEquals(first.length, second.length);
        for (int i = 0; i < first.length; i++) {
            Assertions.assertTrue(first[i].equals(second[i]));
        }
    }

    private void add(EventList list, Event[] events) {
        for (int i = 0; i < events.length; i++ ) {
            list.addEvent(events[i]);
        }
    }

    @Test
    public void addEventShouldAddEventToCurrentObjectWhenMethodWasCalled(){
        EventList list = new EventList();
        Event[] expectedEvents = new Event[] { new Event( 2022,8,4, "A"),
                new Event(2021, 8, 4, "B"),
                new Event(2019, 4, 16, "C"),
                new Event(2022, 12, 6, "D"),
                new Event(2017, 5, 5, "E"),
                new Event(2023, 4, 21, "J")
        };
        add(list, expectedEvents);
        Event[] actualEvents = list.getEvents();
        compareEvents(expectedEvents, actualEvents);
    }

    @Test
    public void removeShouldDeleteEventByIdWhenObjectHaveInputId() {
        EventList list = new EventList();
        Event[] events = new Event[] { new Event( 2022,8,4, "A"),
                new Event(2021, 8, 4, "B"),
                new Event(2019, 4, 16, "C"),
                new Event(2022, 12, 6, "D")
        };
        add(list, events);
        list.remove(3);
        Event[] actualEvents = list.getAllEvents();
        Event[] expectedEvents = new Event[] { new Event( 1,2022,8,4, "A"),
                new Event(2,2021, 8, 4, "B"),
                new Event(4,2022, 12, 6, "D")
        };
        compareEvents(expectedEvents, actualEvents);
    }

    @Test
    public void removeShouldNotdDeleteEventWhenObjectHaveNotInputId() {
        EventList list = new EventList();
        Event[] events = new Event[] { new Event( 2022,8,4, "A"),
                new Event(2021, 8, 4, "B"),
                new Event(2019, 4, 16, "C"),
                new Event(2022, 12, 6, "D")
        };
        add(list, events);
        list.remove(6);
        Event[] actualEvents = list.getAllEvents();
        Event[] expectedEvents = new Event[] {new Event( 1,2022,8,4, "A"),
                new Event(2,2021, 8, 4, "B"),
                new Event(3,2019, 4, 16, "C"),
                new Event(4,2022, 12, 6, "D")
        };
        compareEvents(expectedEvents, actualEvents);
    }

    @Test
    public void editShouldEditEventListObjectWhenObjectHaveInputId() {
        EventList list = new EventList();
        Event[] events = new Event[] { new Event( 2022,8,4, "A"),
                new Event(2021, 8, 4, "B"),
                new Event(2019, 4, 16, "C"),
                new Event(2022, 12, 6, "D")
        };
        add(list, events);
        Event newEvent = new Event (2014,3,24, "Good day");
        list.edit(3, newEvent);
        Event[] actualEvents = list.getAllEvents();
        Event[] expectedEvents = new Event[] {new Event( 1,2022,8,4, "A"),
                new Event(2,2021, 8, 4, "B"),
                new Event(3,2014, 3, 24, "Good day"),
                new Event(4,2022, 12, 6, "D")
        };
        compareEvents(expectedEvents, actualEvents);
    }

    @Test
    public void editShouldNotEditEventListObjectWhenObjectHaveNotInputId() {
        EventList list = new EventList();
        Event[] events = new Event[] { new Event( 2022,8,4, "A"),
                new Event(2021, 8, 4, "B"),
                new Event(2019, 4, 16, "C"),
                new Event(2022, 12, 6, "D")
        };
        add(list, events);
        Event newEvent = new Event (2014,3,24, "Good day");
        list.edit(12, newEvent);
        Event[] actualEvents = list.getAllEvents();
        Event[] expectedEvents = new Event[] {new Event( 1,2022,8,4, "A"),
                new Event(2,2021, 8, 4, "B"),
                new Event(3,2019, 4, 16, "C"),
                new Event(4,2022, 12, 6, "D")
        };
        compareEvents(expectedEvents, actualEvents);
    }

}