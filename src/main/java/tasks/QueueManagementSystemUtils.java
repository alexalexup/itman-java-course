package tasks;

import tasks.QueueManagementSystem;
import entities.Statistic;

public class QueueManagementSystemUtils {

    /**
     * calculate value of total tickets from all queues
     * @cpu O(n * m), n - systems.length, m - systems[].days.size()
     * @ram O(1)
     * @param systems array with queues
     * @return value of all tickets from queues
     */
    public static long calcTotalVisits(QueueManagementSystem[] systems) {
        long result = 0;
        for (int i = 0; i < systems.length; i++){
           result = result + (long)systems[i].getTotalTickets();
       }
        return result;
    }

    /**
     * calculate value of average tickets from all queues
     * @cpu O(n * m), n - systems.length,  m - systems[].days.size()
     * @ram O(1)
     * @param systems array with queues
     * @return value of average tickets from queues
     */
    public static double calcAverageVisits(QueueManagementSystem[] systems) {
        double count = systems.length;
        if (systems.length == 0) {
            return 0;
        }
        if (systems.length == 1) {
            return (double)systems[0].getTotalTickets();
        }
        double result = (double)calcTotalVisits(systems) / count;
        return result;
    }

    /**
     * calculate value of median tickets from all queues
     * @cpu O(n * m + n^2), n - systems.length, m - systems[].days.size()
     * @ram O(n), n - systems.length
     * @param systems array with queues
     * @return value of median tickets  from queues
     */
    public static double calcMedianVisits(QueueManagementSystem[] systems) {
        if (systems.length == 0) {
            return 0;
        }
        int[] sortTotalTickets = new int[systems.length];
        for (int i = 0; i < systems.length; i++) {
            sortTotalTickets[i] = systems[i].getTotalTickets();
        }
        for (int i = 0; i < systems.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < systems.length; j++) {
                if (sortTotalTickets[minIndex] > sortTotalTickets[j]) {
                    minIndex = j;
                }
            }
            int buffer = sortTotalTickets[i];
            sortTotalTickets[i] = sortTotalTickets[minIndex];
            sortTotalTickets[minIndex] = buffer;
        }
        if (systems.length % 2 != 0) {
            double result = sortTotalTickets[systems.length / 2];
            return result;
        }
        double result = (double)(sortTotalTickets[systems.length / 2 -1] + sortTotalTickets[systems.length / 2]) / 2;
        return result;
    }

    private static long calcTotalVisitsWhenEqualCount(QueueManagementSystem[] systems, int day) {
        long result = 0;
        if (systems.length == 1) {
            return (long)systems[0].getVisitsByDay().toArray()[day];
        }
        for (int i = 0; i < systems[0].getVisitsByDay().toArray().length; i++) {
                result = result + (long)systems[i].getVisitsByDay().toArray()[day];
        }
        return result;
    }

    private static long calcTotalVisitsWhenDifferentCount(QueueManagementSystem[] systems, int day, int maxDays) {
        long result = 0;
        for (int i = 0; i < systems.length; i++) {
            int delta = maxDays - systems[i].getVisitsByDay().toArray().length;
            if (day >= delta) {
                result = result + (long)systems[i].getVisitsByDay().toArray()[day - delta];
            }
        }
        return result;
    }

    private static double calcAvrVisitsWhenDifferentCount(QueueManagementSystem[] systems, int day, int maxDays) {
        int countOfDays = 0;
        for (int  i = 0; i < systems.length; i++) {
            int delta = maxDays - systems[i].getVisitsByDay().toArray().length;
            if (day >= delta) {
                countOfDays++;
            }
        }
        return (double)QueueManagementSystemUtils.calcTotalVisitsWhenDifferentCount(systems,day, maxDays)
                / (double)countOfDays;
    }

    private static double calcAvrVisitsWhenEqualCount(QueueManagementSystem[] systems, int day) {
        if (systems.length == 1) {
             return (double)systems[0].getVisitsByDay().toArray()[day];
        }
        return (double)QueueManagementSystemUtils.calcTotalVisitsWhenEqualCount(systems,day)
                / (double)systems[0].getVisitsByDay().toArray().length;
    }

    private static int findMinVisitsWhenDifferentCount(QueueManagementSystem[] systems, int day, int maxDays){
        int result = Integer.MAX_VALUE;
        for( int i = 0; i <systems.length; i++) {
            int delta = maxDays - systems[i].getVisitsByDay().toArray().length;
            if((day >= delta) && (systems[i].getVisitsByDay().toArray()[day - delta]) < result) {
                result = systems[i].getVisitsByDay().toArray()[day - delta];
            }
        }
        return result;
    }

    private static int findMinVisitsWhenEqualCount(QueueManagementSystem[] systems, int day) {
        if (systems.length == 1) {
            return systems[0].getVisitsByDay().toArray()[day];
        }
        int result = systems[0].getVisitsByDay().toArray()[day];
        for (int i = 0; i <systems.length; i++) {
            if (result > systems[i].getVisitsByDay().toArray()[day]) {
                result = systems[i].getVisitsByDay().toArray()[day];
            }
        }
        return result;
    }

    private static int findMaxVisitsWhenDifferentCount(QueueManagementSystem[] systems, int day, int maxDays){
        int result = 0;
        for( int i = 0; i <systems.length; i++) {
            int delta = maxDays - systems[i].getVisitsByDay().toArray().length;
            if((day >= delta) && (systems[i].getVisitsByDay().toArray()[day - delta]) > result) {
                result = systems[i].getVisitsByDay().toArray()[day - delta];
            }
        }
        return result;
    }

    private static int findMaxVisitsWhenEqualCount(QueueManagementSystem[] systems, int day) {
        if (systems.length == 1) {
            return systems[0].getVisitsByDay().toArray()[day];
        }
        int result = systems[0].getVisitsByDay().toArray()[day];
        for (int i = 0; i <systems.length; i++) {
            if (result < systems[i].getVisitsByDay().toArray()[day]) {
                    result = systems[i].getVisitsByDay().toArray()[day];
            }
        }
        return result;
    }

    private static double calcMedianVisitsWhenEqualCount(QueueManagementSystem[] systems, int day) {
        if (systems.length == 1) {
            return systems[0].getVisitsByDay().toArray()[day];
        }

        int[] sortVisitsByDays = new int[systems[0].getVisitsByDay().toArray().length];
        for (int i = 0; i < systems.length; i++) {
            sortVisitsByDays[i] = systems[i].getVisitsByDay().toArray()[day];
        }
        return calcMedianFromArray(sortVisitsByDays);
    }

    private static double calcMedianVisitsWhenDifferentCount(QueueManagementSystem[] systems, int day, int maxDays) {
        int countOfDays = 0;
        for( int i = 0; i <systems.length; i++) {
            int delta = maxDays - systems[i].getVisitsByDay().toArray().length;
            if((day >= delta)) {
                countOfDays++;
            }
        }
        int[] sortVisitsByDays = new int[countOfDays];
        for (int i = 0, j = 0; i < systems.length; i++) {
            int delta = maxDays - systems[i].getVisitsByDay().toArray().length;
            if(day >= delta ) {
                sortVisitsByDays[j] = systems[i].getVisitsByDay().toArray()[day - delta];
                j++;
            }
        }
        return calcMedianFromArray(sortVisitsByDays);
    }

    private static boolean checkEqualsDays(QueueManagementSystem[] systems) {
        int length = systems[0].getVisitsByDay().toArray().length;
        for (int i = 0; i < systems.length; i++ ) {
            if (systems[i].getVisitsByDay().toArray().length != length) {
                return false;
            }
        }
        return true;
    }

    private static int findMaxCountOfDays(QueueManagementSystem[] systems) {
        int result = 0;
        for (int i = 0; i <systems.length; i++) {
            if (result < systems[i].getVisitsByDay().toArray().length) {
                result = systems[i].getVisitsByDay().toArray().length;
            }
        }
        return result;
    }

    private static double calcMedianFromArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int buffer = array[i];
            array[i] = array[minIndex];
            array[minIndex] = buffer;
        }
        if ((array.length % 2) != 0) {
            return (double)array[array.length / 2 ];
        }
        return ((double)array[(array.length / 2) - 1] + (double)array[array.length / 2]) / 2;
    }

    public static Statistic[] calcStatisticByDays(QueueManagementSystem[] systems) {
        if (systems == null) {
            return null;
        }
        if (systems.length == 0) {
            Statistic[] statistic = new Statistic[]{};
            return statistic;
        }
        int maxCountOfDays = findMaxCountOfDays(systems);
        Statistic[] statistic = new Statistic[maxCountOfDays];
        if (checkEqualsDays(systems)) {
            for (int i = 0; i < maxCountOfDays; i++) {
                statistic[i] = new Statistic(findMinVisitsWhenEqualCount(systems,i),
                        findMaxVisitsWhenEqualCount(systems,i),
                        calcTotalVisitsWhenEqualCount(systems,i),
                        calcAvrVisitsWhenEqualCount(systems,i),
                        calcMedianVisitsWhenEqualCount(systems,i));
            }
            return statistic;
        }
        for (int i = 0; i < maxCountOfDays; i++){
            statistic[i] = new Statistic(findMinVisitsWhenDifferentCount(systems, i, maxCountOfDays),
                    findMaxVisitsWhenDifferentCount(systems,i, maxCountOfDays),
                    calcTotalVisitsWhenDifferentCount(systems,i, maxCountOfDays),
                    calcAvrVisitsWhenDifferentCount(systems,i, maxCountOfDays),
                    calcMedianVisitsWhenDifferentCount(systems,i, maxCountOfDays));
        }
        return statistic;
    }
}
