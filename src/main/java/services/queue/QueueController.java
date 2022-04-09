package services.queue;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tasks.QueueManagementSystem;

@RestController
public class QueueController {

    private QueueManagementSystem queue = new QueueManagementSystem("bank");

    @GetMapping("/api/queue/nextTicket")
    public String getNextTicket() {
        return this.queue.getNextTicket().toString();
    }

    @GetMapping("/api/queue/totalTickets")
    public String getTotalTickets() {
        return "" + this.queue.getTotalTickets();
    }

   @PostMapping("api/queue/toNextWorkDay")
    public void  toNextWorkDay() {
        this.queue.toNextWorkDay();
   }

    @GetMapping("api/queue/getVisitsByDays")
    public String  getVisitsByDays() {
        return this.queue.getVisitsByDay().toString();
    }

}
