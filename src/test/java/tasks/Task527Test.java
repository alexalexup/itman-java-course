package tasks;

import collections.IntArrayList;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task527Test {
    @Nested
    public class FindComponent {
        @Test
        public void shouldWork() {
            boolean[] result = Task527.findComponent(new IntArrayList[4]);
            for (int i = 0 ; i < result.length; i++) {
                System.out.println(result[i]);
            }
        }
    }

}