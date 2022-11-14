package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class Task527Test {

    @Nested
    public class Solve {
        @Test
        public void shouldReturnLastElementFromStackWhenAnyElementsLeftIsTheStack() {
            int[] books = new int[]{1, 2, 3, 4, 5};
            int[] queue = new int[]{2, 4, 4, -1, -1, 3, -1, 2};
            int actualResult = Task514.solve(books, queue);
            Assertions.assertEquals(7,actualResult);
        }
    }
}