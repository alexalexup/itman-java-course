package tasks;

import entities.Ticket;
import collections.IntArrayList;

public class QueueManagementSystem {
    private int totalTickets;
    private int previousTickets;
    private String place;
    private IntArrayList days;
    private LinkedList tickets;


    private static class LinkedList {
        private Node node;
        private Node lastNode;
        private int size;


        private static class Node {
            private Ticket ticket;
            private Node next;
            private Node prev;

            private Ticket getTicket() {
                return ticket;
            }

            private Node getNext() {
                return next;
            }

            private void setNext(Node next) {
                this.next = next;
            }

            private void setPrev(Node prev) {
                this.prev = prev;
            }



            private Node(Ticket ticket, Node next, Node prev) {
                this.ticket = ticket;
                this.next = next;
                this.prev = prev;
            }

            private Node() {
            }

        }

        private Node getNode() {
            return node;
        }


        private LinkedList() {

        }

        /**
         * Return size of the LinkedList tickets
         * @cpu O(1)
         * @ram O(1)
         * @return size of the LinkedList tickets
         */
        private int size() {
            return this.size;
        }

        /**
         * Add one element to the end of the LinkedList tickets
         * @cpu O(1)
         * @ram O(1)
         * @param ticket that we need to add to the end of the queue
         */
        private void addLast(Ticket ticket) {
            this.size++;
            Node link = this.getNode();
            if (link == null) {
                this.node = new Node(ticket, null, null);
                this.lastNode = this.node;
                return;
            }
            this.lastNode.setNext(new Node(ticket, null, this.lastNode));
            this.lastNode = this.lastNode.getNext();
        }

        /**
         * Get ticket from head of the queue
         * @cpu O(1)
         * @ram O(1)
         * @return first ticket from the queue
         */
        private Ticket getFirst() {
            return this.node.getTicket();
        }

        /**
         * Get ticket from head of the queue and delete it
         * @cpu O(1)
         * @ram O(1)
         * @return first ticket from the queue
         */
        private Ticket removeFirst() {
            this.size--;
            Ticket result = this.getFirst();
            Node link = this.node;
            if (link.getNext() == null) {
                this.node = null;
                return result;
            }
            this.node = this.node.getNext();
            this.node.setPrev(null);
            return result;
        }

        /**
         * Create and return array with tickets from the LinkedList tickets
         * @cpu O(n), n -  this.tickets.size() (size of the LinkedList tickets)
         * @ram O(n), n -  this.tickets.size() (size of the LinkedList tickets)
         * @return array with tickets from the LinkedList tickets
         */
        private Ticket[] getTickets() {
            Ticket[] tickets = new Ticket[this.size()];
            Node link = this.node;
            if (link == null) {
                return null;
            }
            for (int i = 0; i < tickets.length; i++) {
                tickets[i] = link.getTicket();
                link = link.getNext();
            }
            return tickets;
        }
    }

    /**
     * Create and return array with tickets from the LinkedList tickets
     * @cpu O(n), size of the LinkedList tickets
     * @ram O(n), size of the LinkedList tickets
     * @return array with tickets from the LinkedList tickets
     */
    public Ticket[] getCurrentQueue() {
        if(this.tickets.size() == 0) {
            return new Ticket[]{};
        }
        return this.tickets.getTickets();
    }

    /**
     * Get ticket from head of the queue and delete it
     * @cpu O(1)
     * @ram O(1)
     * @return first ticket from the queue
     */
    public Ticket callNext() {
        return this.tickets.removeFirst();
    }

    /**
     * Set value for field place when creating the object
     * @cpu O(1)
     * @ram O(1)
     */
    public QueueManagementSystem(String place) {
        this.place = place;
        this.days = new IntArrayList();
        this.days.add(totalTickets);
        this.tickets = new LinkedList();
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
        this.tickets.addLast(newTicket);
        return newTicket;
    }

    /**
     * Increase by one size of ArrayList days and reset to zero value of totalTickets. Create new LinkedList tickets (reset)
     * @cpu O(1)
     * @ram O(n), n - days.size()
     */
    public void toNextWorkDay() {
        previousTickets = totalTickets;
        days.add(0);
        this.tickets = new LinkedList();
    }

    /**
     * Create arrayList with data from days field
     * @cpu O(n), n - days.size()
     * @ram O(n), n - days.size()
     * return arrayList with visits by day
     */
    public IntArrayList getVisitsByDay() {
        return new IntArrayList(this.days);
    }
}
