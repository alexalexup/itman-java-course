package services.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
