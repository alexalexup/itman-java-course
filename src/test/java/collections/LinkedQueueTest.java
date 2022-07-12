package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LinkedQueueTest {

    @Nested
    public class Offer {
        @Test
        public void shouldAddElementInTheEndOfTheQueue() {
            LinkedQueue linkedQueue = new LinkedQueue();
            for (int i = 1; i < 11; i++) {
                linkedQueue.offer(i);
            }
            Object[] actualResult = linkedQueue.toArray();
            Object[] expectedResult = new Object[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            Assertions.assertArrayEquals(expectedResult, actualResult);
        }

        @Test
        public void shouldAddElementWhenQueueHaveNotElements() {
            LinkedQueue linkedQueue = new LinkedQueue();
            linkedQueue.offer(1);
            Object[] actualResult = linkedQueue.toArray();
            Object[] expectedResult = new Object[] {1};
            Assertions.assertArrayEquals(expectedResult, actualResult);
        }
    }

    @Nested
    public class Peek {
        @Test
        public void shouldReturnFirsElementFromQueueWhenQueueHaveSomeElements() {
            LinkedQueue linkedQueue = new LinkedQueue();
            linkedQueue.offer(1);
            linkedQueue.offer(2);
            linkedQueue.offer(3);
            Object actualResult = linkedQueue.peek();
            Assertions.assertEquals(1, actualResult);
        }

        @Test
        public void shouldReturnFirsElementFromQueueWhenQueueHaveOneElement() {
            LinkedQueue linkedQueue = new LinkedQueue();
            linkedQueue.offer(5);
            Object actualResult = linkedQueue.peek();
            Assertions.assertEquals(5, actualResult);
        }
    }

    @Nested
    public class Poll {
        @Test
        public void shouldReturnAndDeleteFirsElementFromQueueWhenQueueHaveSomeElements() {
            LinkedQueue linkedQueue = new LinkedQueue();
            linkedQueue.offer(1);
            linkedQueue.offer(2);
            linkedQueue.offer(3);
            Object actualResult = linkedQueue.poll();
            Object[] actualArray = linkedQueue.toArray();
            Assertions.assertEquals(1, actualResult);
            Assertions.assertArrayEquals(new Object[]{2, 3}, actualArray);
        }

        @Test
        public void shouldReturnAndDeleteFirsElementFromQueueWhenQueueHaveOneElement() {
            LinkedQueue linkedQueue = new LinkedQueue();
            linkedQueue.offer(1);
            Object actualResult = linkedQueue.poll();
            Object[] actualArray = linkedQueue.toArray();
            Assertions.assertEquals(1, actualResult);
            Assertions.assertArrayEquals(new Object[]{}, actualArray);
        }
    }

    @Nested
    public class Size {
        @Test
        public void shouldReturnZeroWhenQueueHaveNotAnyElements() {
            LinkedQueue linkedQueue = new LinkedQueue();
            int actualResult = linkedQueue.size();
            Assertions.assertEquals(0,actualResult);
        }

        @Test
        public void shouldReturnOneWhenQueueHaveOneElement() {
            LinkedQueue linkedQueue = new LinkedQueue();
            linkedQueue.offer(1);
            int actualResult = linkedQueue.size();
            Assertions.assertEquals(1,actualResult);
        }

        @Test
        public void shouldReturnResultWhenQueueHaveSomeElements() {
            LinkedQueue linkedQueue = new LinkedQueue();
            for (int i = 0; i < 24; i++) {
                linkedQueue.offer(i);
            }
            int actualResult = linkedQueue.size();
            Assertions.assertEquals(24,actualResult);
        }
    }

    @Nested
    public class IsEmpty {
        @Test
        public void shouldReturnFalseWhenQueueHaveOneElement() {
            LinkedQueue linkedQueue = new LinkedQueue();
            linkedQueue.offer(1);
            Assertions.assertFalse(linkedQueue.isEmpty());
        }

        @Test
        public void shouldReturnFalseWhenQueueHaveSomeElements() {
            LinkedQueue linkedQueue = new LinkedQueue();
            linkedQueue.offer(1);
            linkedQueue.offer(2);
            linkedQueue.offer(3);
            Assertions.assertFalse(linkedQueue.isEmpty());
        }

        @Test
        public void shouldReturnTrueWhenQueueHaveNotAnyElements() {
            LinkedQueue linkedQueue = new LinkedQueue();
            Assertions.assertTrue(linkedQueue.isEmpty());
        }
    }

    @Nested
    public class ToArray {
        @Test
        public void shouldReturnArrayWithoutElementsWhenQueueHaveNotAnyElements() {
            LinkedQueue linkedQueue = new LinkedQueue();
            Object[] actualResult = linkedQueue.toArray();
            Assertions.assertArrayEquals(new Object[]{}, actualResult);
        }

        @Test
        public void shouldReturnArrayWhenQueueHaveSomeElements() {
            LinkedQueue linkedQueue = new LinkedQueue();
            linkedQueue.offer(1);
            linkedQueue.offer(2);
            linkedQueue.offer(3);
            Object[] actualResult = linkedQueue.toArray();
            Assertions.assertArrayEquals(new Object[]{1, 2, 3}, actualResult);
        }
    }
}