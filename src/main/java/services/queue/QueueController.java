package services.queue;

import entities.Ticket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tasks.QueueManagementSystem;

@RestController
public class QueueController {

    private QueueManagementSystem queue = new QueueManagementSystem("bank");

    @GetMapping("/api/queue/getCurrentQueue")
    public Ticket[] getCurrentQueue(){
        return this.queue.getCurrentQueue();
    }

    @PostMapping("/api/queue/callNext")
    public Ticket callNext() {
        return this.queue.callNext();
    }

    /**
     * Create and return newTicket with number increased by one to the previous ticket
     * @cpu O(1)
     * @ram O(1)
     * @return newTicket with number increased by one to the previous ticket
     */
    @GetMapping("/api/queue/nextTicket")
    public Ticket getNextTicket() {
        return this.queue.getNextTicket();
    }

    /**
     * Get information about totalTickets from queue
     * @cpu O(1)
     * @ram O(1)
     * @return information about totalTickets from queue
     */
    @GetMapping("/api/queue/totalTickets")
    public int getTotalTickets() {
        return this.queue.getTotalTickets();
    }

    /**
     * Switch queue to new work day. Increase by one size of ArrayList days and reset to zero value of totalTickets
     * @cpu O(1)
     * @ram O(n), n - days.size()
     */
   @PostMapping("api/queue/toNextWorkDay")
    public void  toNextWorkDay() {
        this.queue.toNextWorkDay();
   }

    /**
     * Get information about tickets by days and return it in array
     * @cpu O(n), n - days.size()
     * @ram O(n), n - days.size()
     * @return array with data about tickets by days
     */
    @GetMapping("api/queue/getVisitsByDays")
    public int[]  getVisitsByDays() {
        return this.queue.getVisitsByDay().toArray();
    }
}
