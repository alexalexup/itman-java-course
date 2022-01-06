package tasks;

import entities.Ticket;

public class QueueManagementSystem {
    public int totalTickets;
    public String place;

    public QueueManagementSystem(String place) {
        this.place = place;
    }

    public entities.Ticket getNextTicket() {
        totalTickets++;
        entities.Ticket newTicket = new entities.Ticket(totalTickets, place);
        return newTicket;
    }

    public int getTotalTickets() {
        return totalTickets;
    }


}
