package tasks;

public class Task439 {
    /**
     * Find latest event from array events
     * cpu O(n), n- events.length
     * @ram O(1)
     * @param events array
     * @return latest event from events array
     */
    public static entities.Event findLast(entities.Event[] events) {
        int index = 0;
        int n = events.length;
        if (n < 1) {
            return null;
        }
       for (int i = 0; i < n; i++ ) {
           if (events[i].year > events[index].year
                   || (events[i].month > events[index].month && events[i].year == events[index].year)
                   || (events[i].day > events[index].day && events[i].month == events[index].month
                   && events[i].year == events[index].year)) {
               index = i;
           }
       }
        return events[index];
    }
}
