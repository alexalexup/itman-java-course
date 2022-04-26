package services.calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import services.queue.QueueSpringApplication;

@SpringBootApplication
public class CalendarSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalendarSpringApplication.class, args);
    }
}
