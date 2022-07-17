package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PairTest {

    @Nested
    public class ToString{
        @Test
        public void shouldReturnStringWhenObjectHaveData() {
            Pair pair = new Pair(3, 4);
            Assertions.assertEquals("Pair{left=3, right=4}", pair.toString());
        }
    }

    @Nested
    public class Equals{
        @Test
        public void shouldReturnTrueWhenObjectsHaveSameData() {
            Pair first = new Pair(10, 12);
            Pair second = new Pair(10, 12);
            Assertions.assertTrue(first.equals(second));
        }

        @Test
        public void shouldReturnFalseWhenObjectsHaveDifferentData() {
            Pair first = new Pair(10, 12);
            Pair second = new Pair(9, 12);
            Assertions.assertFalse(first.equals(second));
        }
    }
}