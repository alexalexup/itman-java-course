package tasks;

import entities.Event;

public class Task439 {
    /**
     * Find latest event from array events
     * cpu O(n), n- events.length
     * @ram O(1)
     * @param events array
     * @return latest event from events array
     */
    public static Event findLast(Event[] events) {
        int index = 0;
        int n = events.length;
        if (n < 1) {
            return null;
        }
        for (int i = 0; i < n; i++) {
            if( events[i].compareTo(events[index]) >= 0) {
                index = i;
            }
        }
        return events[index];
    }
}
