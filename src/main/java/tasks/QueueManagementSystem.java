package tasks;

import entities.Ticket;
import collections.ArrayList;

public class QueueManagementSystem {
    private int totalTickets;
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
     * @cpu O(n), n - days.size()
     * @ram O(1)
     * @return value totalTickets  for all days
     */
    public int getTotalTickets() {
        int result = 0;
        for (int i = 0; i < days.size(); i++) {
            result = result + days.get(i);
        }
        return result;
    }

    /**
     * Increase value of totalTickets, set this value for actual day in arrayList days and create newTicket
     * @cpu O(1)
     * @ram O(1)
     * @return newTicket with number increased by one to the previous ticket and with place where method was called
     */
    public Ticket getNextTicket() {
        totalTickets++;
        days.set(days.size()-1, totalTickets);
        Ticket newTicket = new Ticket(days.get(days.size()-1), place);
        return newTicket;
    }

    /**
     * Increase by one size of ArrayList days and reset to zero value of totalTickets
     * @cpu Θ(1)
     * @ram O(n), n - days.size()
     */
    public void toNextWorkDay() {
        totalTickets = 0;
        days.add(totalTickets);
    }

    /**
     * Create arrayList with data from days field
     * @cpu Θ(n), n - days.size()
     * @ram O(n), n - days.size()
     * return arrayList with visits by day
     */
    public ArrayList getVisitsByDay() {
        ArrayList result = new ArrayList();
        for (int i = 0; i < days.size(); i++) {
            result.add(days.get(i));
        }
        return result;
    }
}
