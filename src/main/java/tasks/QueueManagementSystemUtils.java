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
}
