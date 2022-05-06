package collections;
import entities.Event;

public class EventList {
    public Event[] events;
    public int size;
    public int id;

    public EventList() {
        this.events = new Event[12];
    }

    public void addEvent(Event event){
        event.setId(++this.id);
        if (this.size >= this.events.length) {
            Event[] newEvents = new Event[this.events.length * 2];
            System.arraycopy(this.events, 0, newEvents, 0, this.events.length);
            this.events = newEvents;
        }
        this.size++;
        this.events[this.size -1] = event;
    }

    public void remove(int id) {
        for (int i = 0; i < size; i ++) {
            if (this.events[i].getId() == id) {
                this.size--;
                for (int j = i; j < size; j++) {
                    this.events[j] = this.events[j+1];
                }
                return;
            }
        }
    }

    public void edit(int id, Event event) {
        for (int i = 0; i < size; i++) {
            if (this.events[i].getId() == id) {
                this.events[i] = new Event(id, event.getYear(), event.getMonth(), event.getDay(), event.getName());
                return;
            }
        }
    }

    public Event getEvent(int id) {
        for (int i = 0; i < this.size; i ++) {
            if (this.events[i].getId() == id) {
                return this.events[i];
            }
        }
        return null;
    }

    public Event[] getAllEvents() {
        Event[] logicalEvents = new Event[this.size];
        System.arraycopy(this.events, 0, logicalEvents, 0, this.size);
        return logicalEvents;
    }

    private static int compareNames(String firstName, String secondName) {
        char[] first = firstName.toCharArray();
        char[] second =secondName.toCharArray();
        for (int i = 0; i < first.length & i <second.length; i++) {
            if (first[i] > second[i]) {
                return 1;
            }
            if (first[i] < second[i]) {
                return -1;
            }
        }
        if (first.length > second.length) {
            return 1;
        }
        if (first.length < second.length) {
            return -1;
        }
        return 0;
    }

    /**
     * Merge two arrays with events in increasing order of date
     * @cpu O(n + m), n = aTo - aFrom, m = bTo - bFrom
     * @ram O(1)
     * @param a array with events
     * @param aFrom argument
     * @param aTo argument
     * @param b array with events
     * @param bFrom argument
     * @param bTo argument
     * @param r array with events
     * @param rFrom argument
     */
    private static void merge(Event[] a, int aFrom, int aTo, Event[] b, int bFrom, int bTo, Event[] r, int rFrom) {
        int length = rFrom + aTo - aFrom + bTo - bFrom;
        for (int i = rFrom, j = aFrom, k = bFrom; i < length; i++) {
            if (k < bTo  && ((j >= aTo || a[j].compareTo(b[k]) == 1) ||
                    (a[j].compareTo(b[k]) == 0 && compareNames(a[j].getName(), b[k].getName()) == 1))) {
                r[i] = b[k];
                k++;
            } else {
                r[i] = a[j];
                j++;
            }
        }
    }

    /**
     * Sort array with events use merge method
     * @cpu O(n * logn), n  - events.length
     * @ram O(n), n - events.length
     * @param events array with events
     */
    public static void sortEvents(Event[] events) {
        Event[] bufferEvents = new Event[events.length];
        int size = 1;
        while (size < bufferEvents.length) {
            for (int i = 0; i < bufferEvents.length; i = i + 2 * size) {
                int aFrom = i;
                int aTo = i + size;
                if (aTo > bufferEvents.length) {
                    aTo = bufferEvents.length;
                }
                int bFrom = aTo;
                int bTo = bFrom + size;
                if (bTo > bufferEvents.length) {
                    bTo = bufferEvents.length;
                }
                merge(events, aFrom, aTo, events, bFrom, bTo, bufferEvents, i);
            }
            size = size * 2;
            System.arraycopy(bufferEvents, 0, events, 0, bufferEvents.length);
        }
    }

    public static Event[] filterEventsByYear(Event[] events, int year) {
        EventList list = new EventList();
        for (int i = 0; i < events.length && events[i].getYear() <= year; i ++) {
            if (events[i].getYear() == year) {
                list.addEvent(events[i]);
                list.events[i].setId(events[i].getId());
            }
        }
        return list.getAllEvents();
    }
}
