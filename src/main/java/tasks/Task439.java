package tasks;

public class Task439 {
    // Надо написать функцию, которая принимает массив событий (0 <= N <= 10^6) и возвращает событие случившиеся позже всего.
    public static entities.Event findLast(entities.Event[] events) {
        int index = 0;
        int maxYear = -1;
       for (int i = 0; i < events.length; i++ ) {
           if (events[i].year > maxYear) {
               maxYear = events[i].year;
               index = i;
           } else if (events[i].year == maxYear) {
               if (events[i].month > events[i-1].month) {
                   index =i;
               } else if (events[i].month < events[i-1].month) {
                   index = i-1;
               } else if (events[i].month == events[i-1].month) {
                   if (events[i].day > events[i-1].day) {
                       index = i;
                   } else if (events[i].day < events[i-1].day) {
                       index = i-1;
                   } else if (events[i].day == events[i-1].day) {
                       index = i;
                   }
               }
           }
       }
        return events[index];
    }
}
