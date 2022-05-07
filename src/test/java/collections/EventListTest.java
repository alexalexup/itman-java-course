package collections;

import org.junit.jupiter.api.Test;
import entities.Event;

import static org.junit.jupiter.api.Assertions.*;

class EventListTest {

    @Test
    public void ShouldReturn(){
        EventList list = new EventList();
        Event[] events = new Event[] { new Event( 2022,12,2, "B"),
                new Event(2022, 12, 2, "C"),
                new Event(2022, 12, 2, "A"),
                new Event(2022, 12, 2, "B"),
                new Event(2022, 12, 21, "C"),
                new Event(2023, 4, 21, "D"),
                new Event(2023, 5, 21, "D"),
                new Event(2025, 5, 21, "D"),
        };
        for (int i = 0; i < events.length; i++) {
            list.addEvent(events[i]);
        }
        EventList.sortEvents(events);
        Event[] result = EventList.filterEventsByYearMonthDay(events, 2022, 12, 2);
        for (int i = 0; i < result.length; i++ ) {
            System.out.println(result[i]);
        }
    }
}