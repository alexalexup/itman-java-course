package tasks;

import entities.Ticket;

public class QueueManagementSystem {
    private int totalTickets;
    private String place;

    public QueueManagementSystem(String place) {
        this.place = place;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    /**
     * create newTicket
     * @cpu O(1)
     * @ram O(1)
     * @return newTicket with number increased by one to the previous ticket and with place where method was called
     */
    public entities.Ticket getNextTicket() {
        totalTickets++;
        entities.Ticket newTicket = new entities.Ticket(totalTickets, place);
        return newTicket;
    }
}
