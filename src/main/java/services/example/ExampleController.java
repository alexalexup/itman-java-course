package services.example;

import entities.Event;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;
import utils.StringBuilder;

@RestController
public class ExampleController {

    private Event event;

    @GetMapping("/")
    /**
     * Return text message
     * @cpu O(1)
     * @ram O(1)
     * @return text message "I'm your first web-service"
     */
    public String firstPage() {
        return "I'm your first web-service";
    }

    @GetMapping("/second")
    /**
     * Return text message
     * @cpu O(1)
     * @ram O(1)
     * @return text message "I'm the second binding"
     */
    public String secondPage() {
        return "I'm the second binding";
    }

    @PostMapping("/second")
    /**
     * Return text message
     * @cpu O(1)
     * @ram O(1)
     * @return text message "I'm post mapping"
     */
    public String postMethod() {
        return "I'm post mapping";
    }

    @PutMapping("/second")
    /**
     * Return text message
     * @cpu O(1)
     * @ram O(1)
     * @return text message "I'm put mapping"
     */
    public String putMethod() {
        return "I'm put mapping";
    }

    @PatchMapping("/second")
    /**
     * Return text message
     * @cpu O(1)
     * @ram O(1)
     * @return text message "I'm patch mapping"
     */
    public String patchMethod() {
        return "I'm patch mapping";
    }

    @DeleteMapping("/second")
    /**
     * Return text message
     * @cpu O(1)
     * @ram O(1)
     * @return text message "I'm delete mapping"
     */
    public String deleteMethod() {
        return "I'm delete mapping";
    }

    @PostMapping("/extract/{pathVariable}/{second}")
    /**
     * Return information from http request by query, path and body
     * @cpu O(1)
     * @ram O(1)
     * @param pathVariable path parameter
     * @param secondVariable path parameter
     * @param required query parameter
     * @param optional query parameter
     * @param defaultValue query parameter
     * @param body body from http request
     * @return text message with information from http request
     */
    public String extract(@PathVariable String pathVariable,
                          @PathVariable(name = "second") int secondVariable,
                          @RequestParam String required,
                          @RequestParam(required = false) String optional,
                          @RequestParam(name = "default", defaultValue = "-1") int defaultValue,
                          @RequestBody String body) {
        return "pathVariable = " + pathVariable + "\n"
                + "second = " + secondVariable + "\n"
                + "required = " + required + "\n"
                + "optional = " + optional + "\n"
                + "default = " + defaultValue + "\n"
                + "body = " + body + "\n";
    }

    /**
     * Return String with numbers in range by input data since "from" by "to"
     * @cpu O(n), n = Math.abs(to - from)
     * @ram O(n), n = Math.abs(to - from)
     * @param from
     * @param to
     * @return String with numbers in range by input data since "from" by "to"
     */
    private String range(int from, int to) {
        int length = Math.abs(to - from);
        StringBuilder string = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            string.append( i + from + "\n");
        }
        String result = string.toString();
        return result;
    }

    @GetMapping("api/range")
    /**
     * Return String with numbers in range by input data since "from" by "to"
     * @cpu O(n), n = Math.abs(to - from)
     * @ram O(n), n = Math.abs(to - from)
     * @param from path parameter
     * @param to path parameter
     * @return String with numbers in range by input data since "from" by "to"
     */
    public String numbFromParam(@RequestParam int from, @RequestParam int to) {
       return range(from, to);
    }

    @GetMapping("api/range/{param1}/{param2}")
    /**
     * Return String with numbers in range by input data since "from" by "to"
     * @cpu O(n), n = Math.abs(to - from)
     * @ram O(n), n = Math.abs(to - from)
     * @param from path parameter
     * @param to path parameter
     * @return String with numbers in range by input data since "from" by "to"
     */
    public String numbFromVariable(@PathVariable("param1") int from, @PathVariable("param2") int to) {
        return range(from, to);
    }

    @PostMapping("/api/event")
    /**
     * Get Event Object from body and save it
     * @cpu O(1)
     * @ram O(1)
     * @param event body from http request
     */
    public void postEvent(@RequestBody Event event) {
        this.event = event;
    }

    @GetMapping("/api/event")
    /**
     * Return Event Object
     * @cpu O(1)
     * @ram O(1)
     * @return Event Objet
     */
    public Event getEvent() {
        return this.event;
    }
}
