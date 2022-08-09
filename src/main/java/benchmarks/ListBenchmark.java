package benchmarks;

import collections.ArrayList;
import collections.IntArrayList;
import collections.LinkedList;

public class ListBenchmark {
    // ArrayIntListWithCapacity takes 0.028 sec
    // ArrayIntListWith takes 0.071 sec
    // LinkedList takes 0.86 sec
    // ArrayList 0.518 sec
    public static void main(String[] args) {

        long firstTime = System.currentTimeMillis();
        createIntArrayListWithCapacity(10000000);
        long secondTime = System.currentTimeMillis();
        createIntArrayList(10000000);
        long thirdTime = System.currentTimeMillis();
        createLinkedList(10000000);
        long fourthTime = System.currentTimeMillis();
        createArrayList(10000000);
        long fifthTime = System.currentTimeMillis();
        System.out.println("ArrayListWithCapacity takes " + (secondTime - firstTime) + "ms");
        System.out.println("ArrayListWith takes " + (thirdTime - secondTime) + "ms");
        System.out.println("LinkedList takes " + (fourthTime - thirdTime) + "ms");
        System.out.println("ArrayList " + (fifthTime - fourthTime) + "ms");
    }

    /**
     * Create IntArrayList with capacity from argument
     * @cpu O(n), n - length
     * @ram O(n), n - length
     * @param length argument
     * return IntArrayList
     */
   public static IntArrayList createIntArrayListWithCapacity(int length) {
        IntArrayList intArrayList = new IntArrayList(length);
        for (int i = 0; i < length;  i++) {
            intArrayList.add(i);
        }
        return intArrayList;
    }

    /**
     * Create IntArrayList with default capacity
     * @cpu O(n), n - length
     * @ram O(n), n - length
     * @param length argument
     * return IntArrayList
     */
   public static IntArrayList createIntArrayList(int length) {
        IntArrayList intArrayList = new IntArrayList();
       for (int i = 0; i < length;  i++) {
           intArrayList.add(i);
       }
       return intArrayList;
   }

    /**
     * Create LinkedList with capacity from argument
     * @cpu O(n), n - length
     * @ram O(n), n - length
     * @param length argument
     * return LinkedList
     */
   public static LinkedList createLinkedList(int length) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < length; i++) {
            list.addLast(i);
        }
        return list;
   }

    /**
     * Create ArrayList with default capacity
     * @cpu O(n), n - length
     * @ram O(n), n - length
     * @param length argument
     * return ArrayList
     */
   public static ArrayList createArrayList(int length) {
        ArrayList arrayList = new ArrayList();
       for (int i = 0; i < length;  i++) {
           arrayList.add(i);
       }
       return arrayList;
   }
}
