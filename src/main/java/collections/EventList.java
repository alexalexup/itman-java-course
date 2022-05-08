package collections;
import entities.Event;

public class EventList {
    private Event[] events;
    private int size;
    private int id;

    /**
     * Create empty EventList and set size 12 for field events
     * @cpu O(1)
     * @ram O(1)
     * return object without logical data by EventList class
     */
    public EventList() {
        this.events = new Event[12];
    }

    /**
     * Get logical data from field events by object by EventList class
     * @cpu O(n), n - this.size
     * @ram O(n), n - this.size
     * return array with events that include data from events field by object by EventList class
     */
    public Event[] getEvents() {
        Event[] newEvents = new Event[this.size];
        System.arraycopy(this.events, 0, newEvents, 0, this.size);
        return newEvents;
    }

    /**
     * Add event to object by EventList class
     * @cpu O(1)
     * @ram O(n), n - this.events.length
     * @param event object by Event class
     */
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

    /**
     * Add event object by Event class to object list by EventList class
     * @cpu O(1)
     * @ram O(n), n - list.events.length
     * @param event object by Event class
     * @param list object by EventList class
     */
    private static void add(Event event, EventList list) {
        if (list.size >= list.events.length) {
            Event[] newEvents = new Event [list.events.length * 2];
            System.arraycopy(list.events, 0, newEvents, 0, list.events.length );
            list.events = newEvents;
        }
        list.size++;
        list.events[list.size - 1] = event;
    }

    /**
     * Delete event from object by EventList class by id
     * @cpu O(n), n - this.size
     * @ram O(1)
     * @param id argument
     */
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

    /**
     * Edit event from object by EventList class by id
     * @cpu O(n), n - this.size
     * @ram O(1)
     * @param id argument
     * @param event object by Event class
     */
    public void edit(int id, Event event) {
        for (int i = 0; i < size; i++) {
            if (this.events[i].getId() == id) {
                this.events[i] = new Event(id, event.getYear(), event.getMonth(), event.getDay(), event.getName());
                return;
            }
        }
    }

    /**
     * Get event from object by EventList class by id
     * @cpu O(n), n - this.size
     * @ram O(1)
     * @param id argument
     */
    public Event getEvent(int id) {
        for (int i = 0; i < this.size; i ++) {
            if (this.events[i].getId() == id) {
                return this.events[i];
            }
        }
        return null;
    }

    /**
     * Get all events from object by EventList class
     * @cpu O(n), n - this.size
     * @ram O(n), n - this.size
     */
    public Event[] getAllEvents() {
        Event[] logicalEvents = new Event[this.size];
        System.arraycopy(this.events, 0, logicalEvents, 0, this.size);
        return logicalEvents;
    }

    /**
     * Compare two object by String class
     * @cpu O(k), k - min(n, m), n - firstName.length(), m - secondName.length()
     * @ram O(n + m), n - firstName.length(), m - secondName.length()
     * @param firstName object by String class
     * @param secondName object by String class
     * return 1 if firstName > secondName, -1 if firstName < secondName, 0 if firstName == secondName
     */
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

    /**
     * Filter events object by Event class by year
     * @cpu O(n), n  - events.length
     * @ram O(m), m - list.events.length
     * @param events array with events
     * @param year argument
     * @return array with events that are sorted by year
     */
    public static Event[] filterEventsByYear(Event[] events, int year) {
        EventList list = new EventList();
        for (int i = 0; i < events.length && events[i].getYear() < year + 1; i ++) {
            if (events[i].getYear() == year) {
                add(events[i], list);
            }
        }
        return list.getAllEvents();
    }

    /**
     * Filter events object by Event class by year and month
     * @cpu O(n), n  - events.length
     * @ram O(m), m - list.events.length
     * @param events array with events
     * @param year argument
     * @param month argument
     * @return array with events that are sorted by year and month
     */
    public static Event[] filterEventsByYearMonth(Event[] events, int year, int month) {
        EventList list = new EventList();
        for (int i = 0; (i < events.length) &&
                (events[i].getYear() <= year) &&
                (events[i].getYear()!= year || events[i].getMonth() <= month); i ++) {
            if (events[i].getYear() == year && events[i].getMonth() == month) {
                add(events[i], list);
            }
        }
        return list.getAllEvents();
    }

    /**
     * Filter events object by Event class by year, month and day
     * @cpu O(n), n  - events.length
     * @ram O(m), m - list.events.length
     * @param events array with events
     * @param year argument
     * @param month argument
     * @return array with events that are sorted by year, month and day
     */
    public static Event[] filterEventsByYearMonthDay(Event[] events, int year, int month, int day) {
        EventList list = new EventList();
        for (int i = 0; (i < events.length) &&
                (events[i].getYear() <= year) &&
                (events[i].getYear() != year || events[i].getMonth() <= month) &&
                (events[i].getYear() != year || events[i].getMonth() != month || events[i].getDay() <= day); i ++) {
            if (events[i].getYear() == year && events[i].getMonth() == month && events[i].getDay() == day) {
                add(events[i], list);
            }
        }
        return list.getAllEvents();
    }
}
