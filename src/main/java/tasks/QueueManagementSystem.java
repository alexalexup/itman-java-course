package tasks;

import entities.Ticket;
import collections.ArrayList;

public class QueueManagementSystem {
    private int totalTickets;
    private int previousTickets;
    private String place;
    private ArrayList days;
    private LinkedList tickets;


    private static class LinkedList {
        private Node node;
        private Node lastNode;
        private int size;


        private static class Node {
            private Ticket ticket;
            private Node next;
            private Node prev;

            public Ticket getTicket() {
                return ticket;
            }

            public void setTicket(Ticket ticket) {
                this.ticket = ticket;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public Node getPrev() {
                return prev;
            }

            public void setPrev(Node prev) {
                this.prev = prev;
            }



            public Node(Ticket ticket, Node next, Node prev) {
                this.ticket = ticket;
                this.next = next;
                this.prev = prev;
            }

            public Node() {
            }

        }

        public Node getNode() {
            return node;
        }

        public void setNode(Node node) {
            this.node = node;
        }

        public Node getLastNode() {
            return lastNode;
        }

        public void setLastNode(Node lastNode) {
            this.lastNode = lastNode;
        }

        public LinkedList() {

        }

        public int size() {
            return this.size;
        }

        public void addLast(Ticket ticket) {
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

        public Ticket getFirst() {
            return this.node.getTicket();
        }

        public Ticket removeFirst() {
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

        public Ticket[] getTickets() {
            Ticket[] tickets = new Ticket[this.size()];
            Node link = this.node;
            if (link == null) {
                return tickets;
            }
            for (int i = 0; i < tickets.length; i++) {
                tickets[i] = link.getTicket();
                link = link.getNext();
            }
            return tickets;
        }
    }

    public Ticket[] getCurrentQueue() {
        return this.tickets.getTickets();
    }

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
        this.days = new ArrayList();
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
     * Increase by one size of ArrayList days and reset to zero value of totalTickets
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
    public ArrayList getVisitsByDay() {
        return new ArrayList(this.days);
    }
}
