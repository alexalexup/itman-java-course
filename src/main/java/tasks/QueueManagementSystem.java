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
        days.set(days.size()-1, totalTickets);
        Ticket newTicket = new Ticket(days.get(days.size()-1), place);
        return newTicket;
    }

    public void toNextWorkDay() {
        totalTickets = 0;
        days.add(totalTickets);
    }

    public ArrayList getVisitsByDay() {
        ArrayList result = new ArrayList();
        for (int i = 0; i < days.size(); i++) {
            result.add(days.get(i));
        }
        return result;
    }
}
