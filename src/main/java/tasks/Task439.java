package tasks;

public class Task439 {
    /**
     * Find latest event from array events
     * @ram O(1)
     * cpu O(events.length)
     * @param events array
     * @return latest event from events array
     */
    public static entities.Event findLast(entities.Event[] events) {
        int index = 0;
        int maxYear = -1;
        if (events.length < 1) {
            return null;
        }
       for (int i = 0; i < events.length; i++ ) {
           if (events[i].year > maxYear) {
               maxYear = events[i].year;
               index = i;
           } else if (events[i].year == maxYear) {
               if (events[i].month > events[index].month) {
                   index =i;
               } else if (events[i].month == events[index].month) {
                   if (events[i].day > events[index].day) {
                       index = i;
                   } else if (events[i].day == events[index].day) {
                       index = i;
                   }
               }
           }
       }
       System.out.println("!!!!!!" + index);
        return events[index];
    }
}
