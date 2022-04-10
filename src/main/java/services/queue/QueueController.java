package services.queue;

import entities.Ticket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tasks.QueueManagementSystem;

@RestController
public class QueueController {

    private QueueManagementSystem queue = new QueueManagementSystem("bank");

    @GetMapping("/api/queue/nextTicket")
    /**
     * Create and return newTicket with number increased by one to the previous ticket
     * @cpu O(1)
     * @ram O(1)
     * @return newTicket with number increased by one to the previous ticket
     */
    public Ticket getNextTicket() {
        return this.queue.getNextTicket();
    }

    @GetMapping("/api/queue/totalTickets")
    /**
     * Get information about totalTickets from queue
     * @cpu O(1)
     * @ram O(1)
     * @return information about totalTickets from queue
     */
    public String getTotalTickets() {
        return "" + this.queue.getTotalTickets();
    }

   @PostMapping("api/queue/toNextWorkDay")
   /**
    * Switch queue to new work day. Increase by one size of ArrayList days and reset to zero value of totalTickets
    * @cpu Θ(1)
    * @ram O(n), n - days.size()
    */
    public void  toNextWorkDay() {
        this.queue.toNextWorkDay();
   }

    @GetMapping("api/queue/getVisitsByDays")
    /**
     * Get information about tickets by days and return it in array
     * @cpu O(n), n - days.size()
     * @ram O(n), n - days.size()
     * @return array with data about tickets by days
     */
    public int[]  getVisitsByDays() {
        return this.queue.getVisitsByDay().toArray();
    }
}
