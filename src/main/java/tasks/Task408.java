package tasks;

import entities.Event;

public class Task408 {
    /**
     * Sort events in increasing order of date
     * @ram O(1);
     * @cpu O(event.length^2);
     * @param events array
     */
    public static void  sort(entities.Event[] events) {
        if (events.length < 1) {
           return;
        }
        for (int i = events.length; i > 1; i--) {
            for (int j = 1; j < i; j++) {
                if (events[j - 1].year > events[j].year) {
                    entities.Event t = events[j - 1];
                    events[j - 1] = events[j];
                    events[j] = t;
                } else if (events[j - 1].year == events[j].year) {
                    if (events[j - 1].month > events[j].month) {
                        entities.Event t = events[j - 1];
                        events[j - 1] = events[j];
                        events[j] = t;
                    } else if (events[j - 1].month == events[j].month) {
                        if (events[j - 1].day > events[j].day) {
                            entities.Event t = events[j - 1];
                            events[j - 1] = events[j];
                            events[j] = t;
                        }
                    }
                }
            }
        }
    }
}


