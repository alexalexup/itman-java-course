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

    private static long calcTotalVisitsByDays(int[][]visitsByDays, int day) {
        long result = 0;
        if (visitsByDays.length == 1) {
            result = (long)visitsByDays[0][day];
            return result;
        }
        for (int i = 0; i < visitsByDays.length; i++) {
            result = result + (long)visitsByDays[i][day];
        }
        return result;
    }

    private static double calcAverageVisitsByDays(int[][]visitsByDays, int day) {
        double result = (double)QueueManagementSystemUtils.calcTotalVisitsByDays(visitsByDays,  day);
        return result / visitsByDays.length;
    }

    private static int findMinVisitsByDays(int[][]visitsByDays, int day) {
        int result = visitsByDays[0][day];
        if (visitsByDays.length == 1) {
            return result;
        }
        for (int i = 0; i < visitsByDays.length; i++) {
            if (result > visitsByDays[i][day]) {
                result = visitsByDays[i][day];
            }
        }
        return result;
    }

    private static int findMaxVisitsByDays(int[][]visitsByDays, int day) {
        int result = visitsByDays[0][day];
        if (visitsByDays.length == 1) {
            return result;
        }
        for (int i = 0; i < visitsByDays.length; i++) {
            if (result < visitsByDays[i][day]) {
                result = visitsByDays[i][day];
            }
        }
        return result;
    }

    private static int[][] fillEmptyDays(QueueManagementSystem[] systems) {
        int size = systems[0].getVisitsByDay().toArray().length;
        for (int i = 0; i < systems.length; i++) {
            if (size < systems[i].getVisitsByDay().toArray().length ) {
                size = systems[i].getVisitsByDay().toArray().length;
            }
        }
        int[][] visitsByDays = new int[systems.length][size];
        for (int i = 0; i < systems.length; i++) {
            if (systems[i].getVisitsByDay().toArray().length == size) {
                System.arraycopy(systems[i].getVisitsByDay().toArray(),0,visitsByDays[i],0,size);
            }else {
                int delta = size - systems[i].getVisitsByDay().toArray().length;
                System.arraycopy(systems[i].getVisitsByDay().toArray(),0,
                                 visitsByDays[i],delta,systems[i].getVisitsByDay().toArray().length);
            }
        }
        return visitsByDays;
    }

    private static double calcMedianVisitsByDays(int[][] visitsByDays, int day) {
        double result = visitsByDays[0][day];
        if (visitsByDays.length == 1) {
            return result;
        }
        int[] sortVisitsByDays = new int[visitsByDays.length];
        for (int i = 0; i < sortVisitsByDays.length; i ++) {
            sortVisitsByDays[i] = visitsByDays[i][day];
        }
        for (int i = 0; i < sortVisitsByDays.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j <sortVisitsByDays.length; j++) {
                if (sortVisitsByDays[minIndex] > sortVisitsByDays[j]) {
                        minIndex = j;
                }
            }
            int buffer = sortVisitsByDays[i];
            sortVisitsByDays[i] = sortVisitsByDays[minIndex];
            sortVisitsByDays[minIndex] = buffer;
        }
        if ((sortVisitsByDays.length % 2) != 0) {
            result = (double)sortVisitsByDays[sortVisitsByDays.length / 2 ];
            return result;
        }
        result = ((double)sortVisitsByDays[(sortVisitsByDays.length / 2) - 1]
                + (double)sortVisitsByDays[sortVisitsByDays.length / 2]) / 2;
        return  result;
    }


    public static Statistic[] calcStatisticByDays(QueueManagementSystem[] systems) {
        if (systems == null) {
            return null;
        }
        if (systems.length == 0) {
            Statistic[] statistic = new Statistic[]{};
            return statistic;
        }
        int[][] visitByDays = fillEmptyDays(systems);
        Statistic[] statistic = new Statistic[visitByDays[0].length];
        for (int i = 0; i < visitByDays[0].length; i++){
            statistic[i] = new Statistic(findMinVisitsByDays(visitByDays, i),
                    findMaxVisitsByDays(visitByDays,i),
                    calcTotalVisitsByDays(visitByDays,i),
                    calcAverageVisitsByDays(visitByDays,i),
                    calcMedianVisitsByDays(visitByDays,i));
        }
        return statistic;
    }
}
