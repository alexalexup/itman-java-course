package utils;

import collections.IntArrayList;
import entities.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GraphUtilsTest {
    @Nested
    public class toAdjacencyList {
        @Test
        public void shouldReturnIntArrayListWhenGraphHaveSomeEdgesAndVertices() {
            IntArrayList[] list = GraphUtils.toAdjacencyList(3
                    , new Pair[]{new Pair(1, 2)
                    , new Pair(1, 3)});
            IntArrayList[] expected = new IntArrayList[]{IntArrayList.of()
                    ,IntArrayList.of(2, 3)
                    ,IntArrayList.of()
                    ,IntArrayList.of()};
            Assertions.assertArrayEquals(expected, list);
        }
    }

    @Test
    public void shouldReturnIntArrayListWhenGraphHaveSomeEdgesAndVertices() {
        IntArrayList[] list = GraphUtils.toAdjacencyList(4
                , new Pair[]{new Pair(1, 3)
                        ,new Pair(3, 3)
                        ,new Pair(1,2)
                        ,new Pair(4,1)});
        IntArrayList[] expected = new IntArrayList[]{IntArrayList.of()
                ,IntArrayList.of(3, 2)
                ,IntArrayList.of()
                ,IntArrayList.of(3)
                ,IntArrayList.of(1)};
        Assertions.assertArrayEquals(expected, list);
    }
}