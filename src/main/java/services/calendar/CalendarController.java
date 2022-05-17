package services.calendar;


import entities.Event;
import org.springframework.web.bind.annotation.*;
import collections.EventList;


@RestController
public class CalendarController {

    private EventList events = new EventList();

    /**
     * Add event to object by EventList class
     * @cpu O(1)
     * @ram O(n), n - this.events.length
     * @param event object by Event class
     */
    @PostMapping("/api/event/add")
    public void postEvent(@RequestBody Event event) {
        this.events.addEvent(event);
    }

    /**
     * Get event from object by EventList class by id
     * @cpu O(n), n - this.size
     * @ram O(1)
     * @param id argument
     */
    @GetMapping("/api/event/get")
    public Event getEvent(@RequestBody int id) {
        return events.getEvent(id);
    }

    /**
     * Delete event from object by EventList class by id
     * @cpu O(n), n - this.size
     * @ram O(1)
     * @param id argument
     */
    @PostMapping("/api/event/remove")
    public void removeEvent(@RequestBody int id) {
        this.events.remove(id);
    }

    /**
     * Edit event from object by EventList class by id
     * @cpu O(n), n - this.size
     * @ram O(1)
     * @param id argument
     * @param event object by Event class
     */
    @PostMapping("/api/event/edit/{id}")
    public void editEvent(@PathVariable int id, @RequestBody  Event event) {
        this.events.edit(id, event);
    }

    /**
     * Get all events from object by EventList class
     * @cpu O(n * logn), n - this.size
     * @ram O(n), n - this.size
     */
    @GetMapping("/api/event/all")
    public Event[] getAllEvents() {
        Event[] result = this.events.getAllEvents();
        EventList.sortEvents(result);
        return result;
    }

    /**
     * Filter events object by Event class by year.
     * @cpu O(n * logn), n  - events.size
     * @ram O(n), events.size
     * @param year argument
     * @return array with events that are sorted by year
     */
    @GetMapping("/api/event/year")
    public Event[] getEventsByYear(@RequestParam int year) {
        return EventList.filterEventsByYear(this.events.getAllEvents(), year);
    }

    /**
     * Filter events object by Event class by year and month.
     * @cpu O(n * logn), n  - events.size
     * @ram O(n), events.size
     * @param year argument
     * @param month argument
     * @return array with events that are sorted by year and month
     */
    @GetMapping("/api/event/year/month")
    public Event[] getEventsByYearMonth(@RequestParam int year, @RequestParam int month) {

        return EventList.filterEventsByYearMonth(this.events.getAllEvents(), year, month);
    }

    /**
     * Filter events object by Event class by year, month and day
     * @cpu O(n * logn), n  - events.size
     * @ram O(n), events.size
     * @param year argument
     * @param month argument
     * @param day argument
     * @return array with events that are sorted by year, month and day
     */
    @GetMapping("/api/event/year/month/day")
    public Event[] getEventsByYearMonthDay(@RequestParam int year, @RequestParam int month, @RequestParam int day) {
        return EventList.filterEventsByYearMonthDay(this.events.getAllEvents(), year, month, day);
    }
}
