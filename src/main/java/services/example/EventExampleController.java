package services.example;

import entities.Event;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventExampleController {

    private Event event;

    /**
     * Get Event Object from body and save it
     * @cpu O(1)
     * @ram O(1)
     * @param event body from http request
     */
    @PostMapping("/api/event")
    public void postEvent(@RequestBody Event event) {
        this.event = event;
    }
    
    /**
     * Return Event Object
     * @cpu O(1)
     * @ram O(1)
     * @return Event Objet
     */
    @GetMapping("/api/event")
    public Event getEvent() {
        return this.event;
    }
}
