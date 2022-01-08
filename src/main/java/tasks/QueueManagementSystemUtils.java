package tasks;

import tasks.QueueManagementSystem;

public class QueueManagementSystemUtils {

    public static long calcTotalVisits(QueueManagementSystem[] systems) {
        int n = systems.length;
        long result = 0;
        for (int i = 0; i < n; i++){
           result = result + (long)systems[i].getTotalTickets();
       }
        return result;
    }

    public static double calcAverageVisits(QueueManagementSystem[] systems) {
        double count = systems.length;
        if (systems.length == 0) {
            return 0;
        }
        if (systems.length == 1) {
            return (double)systems[0].totalTickets;
        }
        double result = (double)calcTotalVisits(systems) / count;
        return result;
    }

    public static double calcMedianVisits(QueueManagementSystem[] systems) {
        int n = systems.length;
        int[] sortTotalTickets = new int[n];
        for (int i = 0; i < n; i++) {
            sortTotalTickets[i] = systems[i].totalTickets;
        }
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i +1; j < n; j++) {
                if (sortTotalTickets[minIndex] > sortTotalTickets[j]) {
                    minIndex = j;
                }
            }
            int buffer = sortTotalTickets[i];
            sortTotalTickets[i] = sortTotalTickets[minIndex];
            sortTotalTickets[minIndex] = buffer;
        }
        if (n % 2 != 0) {
            double result = sortTotalTickets[n / 2];
            return result;
        }
        double result = (double)(sortTotalTickets[n / 2 -1] + sortTotalTickets[n / 2]) / 2;
        return result;
    }
}
