package services.example;

import org.springframework.web.bind.annotation.*;

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
    public String PostMethod() {
        return "I'm post mapping";
    }

    @PutMapping("/second")
    public String PutMethod() {
        return "I'm put mapping";
    }

    @PatchMapping("/second")
    public String PutchMethod() {
        return "I'm patch mapping";
    }

    @DeleteMapping("/second")
    public String DeleteMethod() {
        return "I'm delete mapping";
    }
}
