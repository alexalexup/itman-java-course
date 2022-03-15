package tasks;

import collections.ArrayList;
import tasks.QueueManagementSystem;
import entities.Statistic;
import utils.ArrayUtils;

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
     * @cpu O(n), n - systems.length,
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
     * @cpu O(n * logn), n - systems.length
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
        ArrayUtils.mergeSort(sortTotalTickets);
        if (systems.length % 2 != 0) {
            double result = sortTotalTickets[systems.length / 2];
            return result;
        }
        double result = (double)(sortTotalTickets[systems.length / 2 -1] + sortTotalTickets[systems.length / 2]) / 2;
        return result;
    }

    /**
     * calculate value of total tickets from all queues by current day when queues have different counts of days
     * @cpu O(n), n - daysByQueue.length
     * @ram O(1)
     * @param daysByQueue array that include data with visits by days from queues
     * @param day argument
     * @param maxDays argument
     * @return value of total tickets  from queues by current cay
     */
    private static long calcTotalVisits(int[][] daysByQueue, int day, int maxDays) {
        long result = 0;
        if (daysByQueue.length == 1) {
            return (long)daysByQueue[0][day];
        }
        for (int i = 0; i < daysByQueue.length; i++) {
            int delta = maxDays - daysByQueue[i].length;
            if (day >= delta) {
                result = result + (long)daysByQueue[i][day - delta];
            }
        }
        return result;
    }

    /**
     * calculate value of average tickets from all queues by current day when queues have different counts of days
     * @cpu O(n), n - daysByQueue.length
     * @ram O(1)
     * @param daysByQueue array that include data with visits by days from queues
     * @param day argument
     * @param maxDays argument
     * @return value of average tickets  from queues by current cay
     */
    private static double calcAvrVisits(int[][] daysByQueue, int day, int maxDays) {
        if (daysByQueue.length == 1) {
            return (double)daysByQueue[0][day];
        }
        int countOfDays = 0;
        for (int  i = 0; i < daysByQueue.length; i++) {
            int delta = maxDays - daysByQueue[i].length;
            if (day >= delta) {
                countOfDays++;
            }
        }
        return (double)QueueManagementSystemUtils.calcTotalVisits(daysByQueue, day, maxDays)
                / (double)countOfDays;
    }

    /**
     * find value of minimum tickets from all queues by current day when queues have different counts of days
     * @cpu O(n), n - daysByQueue.length,
     * @ram O(1)
     * @param daysByQueue array that include data with visits by days from queues
     * @param day argument
     * @param maxDays argument
     * @return value of minimum tickets from all queues by current day
     */
    private static int findMinVisits(int[][] daysByQueue, int day, int maxDays){
        if (daysByQueue.length == 1) {
            return daysByQueue[0][day];
        }
        int result = Integer.MAX_VALUE;
        for( int i = 0; i < daysByQueue.length; i++) {
            int delta = maxDays - daysByQueue[i].length;
            if (day >= delta) {
                int countOfVisits = daysByQueue[i][day - delta];
                if (countOfVisits < result) {
                    result = countOfVisits;
                }
            }
        }
        return result;
    }

    /**
     * find value of maximum tickets from all queues by current day when queues have different counts of days
     * @cpu O(n), n - daysByQueues.length
     * @ram O(1)
     * @param daysByQueue array that include data with visits by days from queues
     * @param day argument
     * @param maxDays argument
     * @return value of maximum tickets from all queues by current day
     */
    private static int findMaxVisits(int[][] daysByQueue, int day, int maxDays){
        if (daysByQueue.length == 1) {
            return daysByQueue[0][day];
        }
        int result = 0;
        for( int i = 0; i < daysByQueue.length; i++) {
            int delta = maxDays - daysByQueue[i].length;
            if (day >= delta) {
                int countOfVisits = daysByQueue[i][day - delta];
                if (countOfVisits > result) {
                    result = countOfVisits ;
                }
            }
        }
        return result;
    }

    /**
     * calculate value of median tickets from all queues by current day when queues have different counts of days
     * @cpu O(n * logn), n - daysByQueue.length
     * @ram O(n), n - daysByQueue.length
     * @param daysByQueue array that include data with visits by days from queues
     * @param day argument
     * @param maxDays argument
     * @return value of median tickets from all queues by current day
     */
    private static double calcMedianVisits(int[][] daysByQueue, int day, int maxDays) {
        if (daysByQueue.length == 1) {
            return daysByQueue[0][day];
        }
        int countOfDays = 0;
        for( int i = 0; i < daysByQueue.length; i++) {
            int delta = maxDays - daysByQueue[i].length;
            if((day >= delta)) {
                countOfDays++;
            }
        }
        int[] newVisitsByDays = new int[countOfDays];
        for (int i = 0, j = 0; i < daysByQueue.length; i++) {
            int delta = maxDays - daysByQueue[i].length;
            if(day >= delta ) {
                newVisitsByDays[j] = daysByQueue[i][day - delta];
                j++;
            }
        }
        return calcMedianFromArray(newVisitsByDays);
    }

    /**
     * Find max count of days from queues
     * @cpu O(n), n - daysByQueue.length
     * @ram O(1)
     * @param daysByQueue array that include data with visits by days from queues
     * @return max count of days from queue
     */
    private static int findMaxCountOfDays(int[][] daysByQueue) {
        int result = 0;
        for (int i = 0; i < daysByQueue.length; i++) {
            int size = daysByQueue[i].length;
            if (result < size) {
                result = size;
            }
        }
        return result;
    }

    /**
     * calculate median value from array
     * @cpu O(n * logn), n - array.length
     * @ram O(n), n, array.length
     * @param array with data
     * @return median value from array
     */
    private static double calcMedianFromArray(int[] array) {
        ArrayUtils.mergeSort(array);
        if ((array.length % 2) != 0) {
            return (double)array[array.length / 2 ];
        }
        return ((double)array[(array.length / 2) - 1] + (double)array[array.length / 2]) / 2;
    }

    /**
     * calculate statistic from all queues by days
     * @cpu O(m * n * logn), n - systems.length, m - days.size()
     * @ram O(n * m), n - systems.length, m - days.size()
     * @param systems array with queues
     * @return values of minimum, maximum, total, average and median  tickets from all queues by days
     */
    public static Statistic[] calcStatisticByDays(QueueManagementSystem[] systems) {
        if (systems == null) {
            return null;
        }
        if (systems.length == 0) {
            Statistic[] statistic = new Statistic[]{};
            return statistic;
        }
        int[][] daysByQueue = new int[systems.length][];
        for (int i = 0; i < systems.length; i++) {
            daysByQueue[i] = systems[i].getVisitsByDay().toArray();
        }
        int maxCountOfDays = findMaxCountOfDays(daysByQueue);
        Statistic[] statistic = new Statistic[maxCountOfDays];
        for (int i = 0; i < maxCountOfDays; i++){
            statistic[i] = new Statistic(findMinVisits(daysByQueue, i, maxCountOfDays),
                    findMaxVisits(daysByQueue,i, maxCountOfDays),
                    calcTotalVisits(daysByQueue, i, maxCountOfDays),
                    calcAvrVisits(daysByQueue, i, maxCountOfDays),
                    calcMedianVisits(daysByQueue, i, maxCountOfDays));
        }
        return statistic;
    }
}
