package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class QueueTest {

    @Nested
    public class Offer {
        @Test
        public void shouldAddElementInTheEndOfTheQueue() {
            Queue queue = new Queue();
            for (int i = 1; i < 11; i++) {
                queue.offer(i);
            }
            Object[] actualResult = queue.toArray();
            Object[] expectedResult = new Object[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            Assertions.assertArrayEquals(expectedResult, actualResult);
        }

        @Test
        public void shouldAddElementWhenQueueHaveNotElements() {
            Queue queue = new Queue();
            queue.offer(1);
            Object[] actualResult = queue.toArray();
            Object[] expectedResult = new Object[] {1};
            Assertions.assertArrayEquals(expectedResult, actualResult);
        }
    }

    @Nested
    public class Peek {
        @Test
        public void shouldReturnFirsElementFromQueueWhenQueueHaveSomeElements() {
            Queue queue = new Queue();
            queue.offer(1);
            queue.offer(2);
            queue.offer(3);
            Object actualResult = queue.peek();
            Assertions.assertEquals(1, actualResult);
        }

        @Test
        public void shouldReturnFirsElementFromQueueWhenQueueHaveOneElement() {
            Queue queue = new Queue();
            queue.offer(5);
            Object actualResult = queue.peek();
            Assertions.assertEquals(5, actualResult);
        }
    }

    @Nested
    public class Poll {
        @Test
        public void shouldReturnAndDeleteFirsElementFromQueueWhenQueueHaveSomeElements() {
            Queue queue = new Queue();
            queue.offer(1);
            queue.offer(2);
            queue.offer(3);
            Object actualResult = queue.poll();
            Object[] actualArray = queue.toArray();
            Assertions.assertEquals(1, actualResult);
            Assertions.assertArrayEquals(new Object[]{2, 3}, actualArray);
        }

        @Test
        public void shouldReturnAndDeleteFirsElementFromQueueWhenQueueHaveOneElement() {
            Queue queue = new Queue();
            queue.offer(1);
            Object actualResult = queue.poll();
            Object[] actualArray = queue.toArray();
            Assertions.assertEquals(1, actualResult);
            Assertions.assertArrayEquals(new Object[]{}, actualArray);
        }
    }

    @Nested
    public class Size {
        @Test
        public void shouldReturnZeroWhenQueueHaveNotAnyElements() {
            Queue queue = new Queue();
            int actualResult = queue.size();
            Assertions.assertEquals(0,actualResult);
        }

        @Test
        public void shouldReturnOneWhenQueueHaveOneElement() {
            Queue queue = new Queue();
            queue.offer(1);
            int actualResult = queue.size();
            Assertions.assertEquals(1,actualResult);
        }

        @Test
        public void shouldReturnResultWhenQueueHaveSomeElements() {
            Queue queue = new Queue();
            for (int i = 0; i < 24; i++) {
                queue.offer(i);
            }
            int actualResult = queue.size();
            Assertions.assertEquals(24,actualResult);
        }
    }

    @Nested
    public class IsEmpty {
        @Test
        public void shouldReturnFalseWhenQueueHaveOneElement() {
            Queue queue = new Queue();
            queue.offer(1);
            Assertions.assertFalse(queue.isEmpty());
        }

        @Test
        public void shouldReturnFalseWhenQueueHaveSomeElements() {
            Queue queue = new Queue();
            queue.offer(1);
            queue.offer(2);
            queue.offer(3);
            Assertions.assertFalse(queue.isEmpty());
        }

        @Test
        public void shouldReturnTrueWhenQueueHaveNotAnyElements() {
            Queue queue = new Queue();
            Assertions.assertTrue(queue.isEmpty());
        }
    }

    @Nested
    public class ToArray {
        @Test
        public void shouldReturnArrayWithoutElementsWhenQueueHaveNotAnyElements() {
            Queue queue = new Queue();
            Object[] actualResult = queue.toArray();
            Assertions.assertArrayEquals(new Object[]{}, actualResult);
        }

        @Test
        public void shouldReturnArrayWhenQueueHaveSomeElements() {
            Queue queue = new Queue();
            queue.offer(1);
            queue.offer(2);
            queue.offer(3);
            Object[] actualResult = queue.toArray();
            Assertions.assertArrayEquals(new Object[]{1, 2, 3}, actualResult);
        }
    }
}