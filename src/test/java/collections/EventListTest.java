package collections;

import org.junit.jupiter.api.Test;
import entities.Event;

import static org.junit.jupiter.api.Assertions.*;

class EventListTest {

    @Test
    public void ShouldReturn(){
        EventList list = new EventList();
        Event[] events = new Event[] { new Event( 2021,12,24, "A"),
                new Event(2022, 12, 2, "B"),
                new Event(2023, 4, 21, "C"),
                new Event(2023, 4, 21, "D"),
        };
        list.addEvent(events[0]);
        list.addEvent(events[1]);
        list.addEvent(events[2]);
        list.addEvent(events[3]);
        list.remove(2);
        list.addEvent(new Event(2024, 3, 3, "J"));
        for (int i = 0; i < list.size; i++) {
            System.out.println(list.events[i]);
        }
    }
}