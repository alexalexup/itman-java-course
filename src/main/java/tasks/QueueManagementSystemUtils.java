package tasks;

import tasks.QueueManagementSystem;
import entities.Statistic;

public class QueueManagementSystemUtils {

    /**
     * calculate value of total tickets from all queues
     * @cpu O(n), n - systems.length
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
     * @cpu O(n), n - systems.length;
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
     * @cpu O(n^2), n - systems.length
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

    public static long calcTotalVisitsByDays(QueueManagementSystem[] systems, int day) {
        long result = 0;
        if (systems.length == 1) {
            result = (long)systems[0].getVisitsByDay().toArray()[day];
            return result;
        }
        if (checkEqualsDays(systems)) {
            for (int i = 0; i < systems[0].getVisitsByDay().toArray().length; i++) {
                result = result + (long)systems[i].getVisitsByDay().toArray()[day];
                }
            return result;
            }
        int maxDays = findMaxCountOfDays(systems);
        for (int i = 0; i < systems.length; i++) {
            int delta = maxDays - systems[i].getVisitsByDay().toArray().length;
            if (day >= delta) {
                result = result + (long)systems[i].getVisitsByDay().toArray()[day - delta];
            }
        }
        return result;
    }

    public static double calcAverageVisitsByDays(QueueManagementSystem[] systems, int day) {
        double result = 0;
        if (systems.length == 1) {
            result = (double)systems[0].getVisitsByDay().toArray()[day];
            return result;
        }
        result = (double)QueueManagementSystemUtils.calcTotalVisitsByDays(systems,day);
        if (checkEqualsDays(systems)) {
            result = result / systems[0].getVisitsByDay().toArray().length;
            return result;
        }
        int maxDays = findMaxCountOfDays(systems);
        int countOfDays = 0;
        for (int  i = 0; i < systems.length; i++) {
            int delta = maxDays - systems[i].getVisitsByDay().toArray().length;
            if (day >= delta) {
                countOfDays++;
            }
        }
        result = result / (double)countOfDays;
        return result;
    }

    private static int findMinVisitsWhenDifferentCountOfDays(QueueManagementSystem[] systems, int day, int maxDays ){
        int result = 0;
        for( int i = 0; i <systems.length; i++) {
            int delta = maxDays - systems[i].getVisitsByDay().toArray().length;
            if((day >= delta) && (systems[i].getVisitsByDay().toArray()[day - delta]) < result) {
                result = systems[i].getVisitsByDay().toArray()[day - delta];
            }
        }
        return result;
    }

    public static int findMinVisitsWhenEqualCountOfDays(QueueManagementSystem[] systems, int day) {
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

    private static int findMaxVisitsWhenDifferentCountOfDays(QueueManagementSystem[] systems, int day, int maxDays ){
        int result = 0;
        for( int i = 0; i <systems.length; i++) {
            int delta = maxDays - systems[i].getVisitsByDay().toArray().length;
            if((day >= delta) && (systems[i].getVisitsByDay().toArray()[day - delta]) > result) {
                result = systems[i].getVisitsByDay().toArray()[day - delta];
            }
        }
        return result;
    }

    public static int findMaxVisitsWhenEqualCountOfDays(QueueManagementSystem[] systems, int day) {
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


    public static double calcMedianVisitsByDays(QueueManagementSystem[] systems, int day) {
        if (systems.length == 1) {
            return systems[0].getVisitsByDay().toArray()[day];
        }
        if (checkEqualsDays(systems)){
            int[] sortVisitsByDays = new int[systems[0].getVisitsByDay().toArray().length];
            for (int i = 0; i < systems.length; i++) {
                sortVisitsByDays[i] = systems[i].getVisitsByDay().toArray()[day];
            }
            return calcMedianFromArray(sortVisitsByDays);
        }
        int maxDays = findMaxCountOfDays(systems);
        int countOfDays = 0;
        for( int i = 0; i <systems.length; i++) {
            int delta = maxDays - systems[i].getVisitsByDay().toArray().length;
            if((day >= delta)) {
                countOfDays++;
            }
        }
        int[] sortVisitsByDays = new int[countOfDays++];
        for (int i = 0; i < systems.length; i++) {
            int delta = maxDays - systems[i].getVisitsByDay().toArray().length;
            if(day >= delta ) {
                sortVisitsByDays[i] = systems[i].getVisitsByDay().toArray()[day - delta];
            }
        }
        return calcMedianFromArray(sortVisitsByDays);
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

        }
        for (int i = 0; i < maxCountOfDays; i++){
            statistic[i] = new Statistic(findMinVisitsByDays(systems, i),
                    findMaxVisitsByDays(systems,i),
                    calcTotalVisitsByDays(systems,i),
                    calcAverageVisitsByDays(systems,i),
                    calcMedianVisitsByDays(systems,i));
        }
        return statistic;
    }
}
