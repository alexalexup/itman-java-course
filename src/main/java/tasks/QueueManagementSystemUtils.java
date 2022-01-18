package tasks;

import tasks.QueueManagementSystem;

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
}
