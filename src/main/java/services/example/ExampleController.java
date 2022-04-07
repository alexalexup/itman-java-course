package services.example;

import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;
import utils.StringBuilder;

@RestController
public class ExampleController {

    @GetMapping("/")
    public String firstPage() {
        return "I'm your first web-service";
    }

    @GetMapping("/second")
    public String secondPage() {
        return "I'm the second binding";
    }

    @PostMapping("/second")
    public String postMethod() {
        return "I'm post mapping";
    }

    @PutMapping("/second")
    public String putMethod() {
        return "I'm put mapping";
    }

    @PatchMapping("/second")
    public String patchMethod() {
        return "I'm patch mapping";
    }

    @DeleteMapping("/second")
    public String deleteMethod() {
        return "I'm delete mapping";
    }

    @PostMapping("/extract/{pathVariable}/{second}")
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

    @GetMapping("api/range")
    public String numbFromKey(@RequestParam int from, @RequestParam int to) {
        int length = to - from;
        StringBuilder string = new StringBuilder(length);
        for (int i = 0; i < length + 1; i++) {
           string.append( i + from + "\n");
        }
        String result = string.toString();
        return result;
    }
}
