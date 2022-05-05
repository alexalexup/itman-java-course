package services.calendar;


import entities.Event;
import org.springframework.web.bind.annotation.*;
import collections.EventList;


@RestController
public class CalendarController {

    private EventList events = new EventList();

    @PostMapping("/api/event/add")
    public void postEvent(@RequestBody Event event) {
        this.events.addEvent(event);
    }

    @GetMapping("/api/event/get")
    public Event getEvent(@RequestBody int id) {
        return events.getEvent(id);
    }

    @PostMapping("/api/event/remove")
    public void removeEvent(@RequestBody int id) {
        this.events.remove(id);
    }

    @PostMapping("/api/event/edit/{id}")
    public void editEvent(@PathVariable int id, @RequestBody  Event event) {
        this.events.edit(id, event);
    }

    @GetMapping("/api/event/all")
    public Event[] getEvent() {
        return events.getAllEvents();
    }
}
