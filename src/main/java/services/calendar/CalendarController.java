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
    public Event[] getAllEvents() {
        Event[] result = this.events.getAllEvents();
        EventList.sortEvents(result);
        return result;
    }

    @GetMapping("/api/event/year")
    public Event[] getEventsByYear(@RequestParam int year) {
        Event[] result = getAllEvents();
        return EventList.filterEventsByYear(result, year);
    }

    @GetMapping("/api/event/year/month")
    public Event[] getEventsByYearMonth(@RequestParam int year, @RequestParam int month) {
        Event[] result = getAllEvents();
        return EventList.filterEventsByYearMonth(result, year, month);
    }

    @GetMapping("/api/event/year/month/day")
    public Event[] getEventsByYearMonthDay(@RequestParam int year, @RequestParam int month, @RequestParam int day) {
        Event[] result = getAllEvents();
        return EventList.filterEventsByYearMonthDay(result, year, month, day);
    }
}
