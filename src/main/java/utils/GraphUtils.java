package utils;

import entities.Pair;
import collections.IntArrayList;

public class GraphUtils {
    public static IntArrayList[] toAdjacencyList(int vertices, Pair[] edges) {
        IntArrayList[] list = new IntArrayList[vertices + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new IntArrayList();
        }
        for (int i = 0; i < edges.length; i++) {
            list[edges[i].getLeft()].add(edges[i].getRight());
        }
        return list;
    }

    public static IntArrayList[] toUndirectedAdjacencyList(int vertices, Pair[] edges) {
        IntArrayList[] list = new IntArrayList[vertices + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new IntArrayList();
        }
        for (int i = 0; i < edges.length; i++) {
            list[edges[i].getLeft()].add(edges[i].getRight());
            list[edges[i].getRight()].add(edges[i].getLeft());
        }
        return list;
    }
}
