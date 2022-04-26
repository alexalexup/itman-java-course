package services.calendar;


import entities.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import collections.EventList;


@RestController
public class CalendarController {

    private EventList events = new EventList();

    @PostMapping("/api/event")
    public void postEvent(@RequestBody Event event) {
        this.events.addEvent(event);
    }

    @GetMapping("/api/event")
    public Event getEvent(@RequestBody int id) {
        return events.getEvent(id);
    }

    @GetMapping("/api/event/all")
    public Event[] getEvent() {
        return events.getAllEvents();
    }
}
