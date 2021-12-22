package tasks;

import entities.Event;

public class Task408 {
    /**
     * Sort events in increasing order of date
     * @cpu O(n^2), n- events.length
     * @ram O(1)
     * @param events array
     */
    public static void  sort(entities.Event[] events) {
        int n = events.length;
        if (n < 1) {
           return;
        }
        for (int i = n; i > 1; i--) {
            for (int j = 1; j < i; j++) {
                if (events[j - 1].year > events[j].year
                        || (events[j - 1].month > events[j].month && events[j - 1].year == events[j].year)
                        || (events[j - 1].day > events[j].day && events[j - 1].year == events[j].year
                        && events[j - 1].year == events[j].year ) ) {
                    entities.Event t = events[j - 1];
                    events[j - 1] = events[j];
                    events[j] = t;
                }
            }
        }
    }
}


