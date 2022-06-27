package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Nested
    public class Peek {
        @Test
        public void shouldReturnLastElementFromStackWhenStackHaveOneElement() {
            Stack stack = new Stack();
            stack.push(1);
            int actualResult = stack.peek();
            Assertions.assertEquals(1,actualResult);
        }

        @Test
        public void shouldReturnLastElementFromStackWhenStackHaveSomeElements() {
            Stack stack = new Stack();
            for (int i = 0 ; i < 35; i++) {
                stack.push(i);
            }
            int actualResult = stack.peek();
            Assertions.assertEquals(34,actualResult);
        }
    }

    @Nested
    public class Pop {
        @Test
        public void shouldGetLastElementFromTheStackWhenStackHaveSomeElements() {
            Stack stack = new Stack();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            int actualResult = stack.pop();
            int[] expectedData = new int[]{1, 2};
            Assertions.assertEquals(3,actualResult);
            Assertions.assertArrayEquals(expectedData,stack.toArray());
        }

        @Test
        public void shouldGetLastElementFromTheStackWhenStackHaveOneElement() {
            Stack stack = new Stack();
            stack.push(1);
            int actualResult = stack.pop();
            int[] expectedData = new int[]{};
            Assertions.assertEquals(1,actualResult);
            Assertions.assertArrayEquals(expectedData,stack.toArray());
        }
    }

    @Nested
    public class Push {
        @Test
        public void shouldAddElementToTheEndOfTheStack (){
            Stack stack = new Stack();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            int[] actualData = stack.toArray();
            int actualElement = actualData[actualData.length-1];
            Assertions.assertEquals(3,actualElement);
        }
    }

    @Nested
    public class Size {
        @Test
        public void shouldReturnLengthOfTheStackWhenStackHaveSomeElements() {
            Stack stack = new Stack();
            for (int i = 0; i < 20; i++ ) {
                stack.push(i);
            }
            int actualResult = stack.size();
            Assertions.assertEquals(20, actualResult);
        }

        @Test
        public void shouldReturnOneWhenStackHaveOneElement() {
            Stack stack = new Stack();
            stack.push(63);
            int actualResult = stack.size();
            Assertions.assertEquals(1, actualResult);
        }

        @Test
        public void shouldReturnZeroWhenStackHaveNorElements() {
            Stack stack = new Stack();
            int actualResult = stack.size();
            Assertions.assertEquals(0, actualResult);
        }
    }

    @Nested
    public class IsEmpty{
        @Test
        public void ShouldReturnTrueWhenPickAllElementsFromTheStack() {
            Stack stack = new Stack();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.pop();
            stack.pop();
            stack.pop();
            boolean actualResult = stack.isEmpty();
            Assertions.assertTrue(actualResult);
        }

        @Test
        public void shouldReturnTrueWhenStackHaveNotElements() {
            Stack stack = new Stack();
            boolean actualResult = stack.isEmpty();
            Assertions.assertTrue(actualResult);
        }

        @Test
        public void shouldReturnFalseWhenStackHaveSomeElements() {
            Stack stack = new Stack();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            boolean actualResult = stack.isEmpty();
            Assertions.assertFalse(actualResult);
        }
    }

    @Nested
    public class ToArray {
        @Test
        public void shouldReturnArrayWithDataFromTheStack() {
            Stack stack = new Stack();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            int[] expectedResult = new int[]{1, 2, 3};
            int[] actualResult = stack.toArray();
            Assertions.assertArrayEquals(expectedResult,actualResult);
        }

        @Test
        public void shouldReturnEmptyArrayWhenStackHaveNotElements() {
            Stack stack = new Stack();
            int[] expectedResult = new int[]{};
            int[] actualResult = stack.toArray();
            Assertions.assertArrayEquals(expectedResult, actualResult);
        }
    }
}