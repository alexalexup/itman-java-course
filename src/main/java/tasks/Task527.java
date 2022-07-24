package tasks;

import collections.IntArrayList;

public class Task527 {
    public static boolean[] findComponent(IntArrayList[] adjacencyList) {
        boolean[] result = new boolean[adjacencyList.length];
        if (adjacencyList[0].size() == 0) {
            return result;
        } else {
            result[0] = true;
                }
        int index = 0;
        for (int  i = 0; i < adjacencyList[index].size(); i++) {
            result[adjacencyList[index].get(i)] = true;
        }
        return null;
    }
}
