package tasks;

import entities.Ticket;

public class QueueManagementSystem {
    private int totalTickets;
    private String place;

    /**
     * Set value for field place when creating the object
     * @cpu O(1)
     * @ram O(1)
     */
    public QueueManagementSystem(String place) {
        this.place = place;
    }

    /**
     * Get value of the totalTickets field from an object
     * @cpu O(1)
     * @ram O(1)
     * @return value of the totalTickets field
     */
    public int getTotalTickets() {
        return totalTickets;
    }

    /**
     * create newTicket
     * @cpu O(1)
     * @ram O(1)
     * @return newTicket with number increased by one to the previous ticket and with place where method was called
     */
    public Ticket getNextTicket() {
        totalTickets++;
        Ticket newTicket = new Ticket(totalTickets, place);
        return newTicket;
    }
}
