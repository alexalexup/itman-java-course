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

    public String getPlace() {
        return place;
    }

    public int setTotalTickets(int totalTickets) {
        return this.totalTickets = totalTickets;
    }

    public entities.Ticket getNextTicket() {
        totalTickets++;
        entities.Ticket newTicket = new entities.Ticket(totalTickets, place);
        return newTicket;
    }
}
