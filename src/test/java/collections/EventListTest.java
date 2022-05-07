package collections;

import org.junit.jupiter.api.Test;
import entities.Event;

import static org.junit.jupiter.api.Assertions.*;

class EventListTest {

    @Test
    public void ShouldReturn(){
        EventList list = new EventList();
        Event[] events = new Event[] { new Event( 2022,12,24, "A"),
                new Event(2022, 12, 2, "B"),
                new Event(2022, 4, 2, "B"),
                new Event(2022, 3, 2, "B"),
                new Event(2023, 4, 21, "C"),
                new Event(2023, 4, 21, "D"),
                new Event(2023, 5, 21, "D"),
                new Event(2025, 5, 21, "D"),
        };
        for (int i = 0; i < events.length; i++) {
            list.addEvent(events[i]);
        }
        Event[] result = EventList.filterEventsByYear(events, 2025);
        for (int i = 0; i < result.length; i++ ) {
            System.out.println(result[i]);
        }
    }
}