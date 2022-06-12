package benchmarks;

import collections.ArrayList;
import collections.LinkedList;

public class ListBenchmark {
    // ArrayListWithCapacity takes 0.028 sec
    // ArrayListWith takes 0.071 sec
    // LinkedList takes 0.86 sec
    public static void main(String[] args) {
        long firstTime = System.currentTimeMillis();
        createArrayListWithCapacity(10000000);
        long secondTime = System.currentTimeMillis();
        createArrayList(10000000);
        long thirdTime = System.currentTimeMillis();
        createLinkedList(10000000);
        long fourthTime = System.currentTimeMillis();
        System.out.println("ArrayListWithCapacity takes " + (secondTime - firstTime) + "ms");
        System.out.println("ArrayListWith takes " + (thirdTime - secondTime) + "ms");
        System.out.println("LinkedList takes " + (fourthTime - thirdTime) + "ms");
    }

   public static ArrayList createArrayListWithCapacity(int length) {
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length;  i++) {
            arrayList.add(i);
        }
        return arrayList;
    }

   public static ArrayList createArrayList(int length) {
        ArrayList arrayList = new ArrayList();
       for (int i = 0; i < length;  i++) {
           arrayList.add(i);
       }
       return arrayList;
   }

   public static LinkedList createLinkedList(int length) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < length; i++) {
            list.addLast(i);
        }
        return list;
   }
}
