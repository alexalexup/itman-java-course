package tasks;

import tasks.QueueManagementSystem;

public class QueueManagementSystemUtils {

    public static long calcTotalVisits(QueueManagementSystem[] systems) {
        int n = systems.length;
        if (systems == null) {
            return 0;
        }
        long result = 0;
        for (int i = 0; i < n; i++){
           result = result + (long)systems[i].getTotalTickets();
       }
        return result;
    }
    public static double calcAverageVisits(QueueManagementSystem[] systems) {
        double count = systems.length;
        if (systems.length == 0 || systems == null) {
            return 0;
        }
        if (systems.length == 1) {
            return (double)systems[0].totalTickets;
        }
        double result = (double)calcTotalVisits(systems) / count;
        return result;
    }
}
