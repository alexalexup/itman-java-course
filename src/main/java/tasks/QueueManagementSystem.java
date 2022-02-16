package tasks;

import entities.Ticket;
import collections.ArrayList;

public class QueueManagementSystem {
    private int totalTickets;
    private int previousTickets;
    private String place;
    private ArrayList days;

    /**
     * Set value for field place when creating the object
     * @cpu O(1)
     * @ram O(1)
     */
    public QueueManagementSystem(String place) {
        this.place = place;
        this.days = new ArrayList();
        this.days.add(totalTickets);
    }

    /**
     * Calculate totalTickets for all days from queue
     * @cpu O(1)
     * @ram O(1)
     * @return value totalTickets  for all days
     */
    public int getTotalTickets() {
        return totalTickets;
    }

    /**
     * Increase value of totalTickets, set this value for actual day in arrayList days and create newTicket
     * @cpu O(1)
     * @ram O(1)
     * @return newTicket with number increased by one to the previous ticket and with place where method was called
     */
    public Ticket getNextTicket() {
        totalTickets++;
        days.set(days.size()-1, totalTickets - previousTickets);
        Ticket newTicket = new Ticket(days.get(days.size()-1), place);
        return newTicket;
    }

    /**
     * Increase by one size of ArrayList days and reset to zero value of totalTickets
     * @cpu Θ(1)
     * @ram O(n), n - days.size()
     */
    public void toNextWorkDay() {
        previousTickets = totalTickets;
        days.add(0);
    }

    /**
     * Create arrayList with data from days field
     * @cpu O(n), n - days.size()
     * @ram O(n), n - days.size()
     * return arrayList with visits by day
     */
    public ArrayList getVisitsByDay() {
        return new ArrayList(this.days);
    }
}
