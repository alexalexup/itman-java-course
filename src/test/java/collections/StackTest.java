package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    public void peekShouldReturnLastElementFromStack() {
        Stack stack = new Stack();
        stack.push(1);
        int actualResult = stack.peek();
        Assertions.assertEquals(1,actualResult);
        }

    @Test
    public void popShouldPickElementFromTheStack() {
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
    public void pushShouldAddElementFromToTheEndOfTheStack() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int[] actualData = stack.toArray();
        int actualElement = actualData[actualData.length-1];
        Assertions.assertEquals(3,actualElement);
    }

    @Test
    public void sizeShouldReturnLengthOfTheStack() {
        Stack stack = new Stack();
        for (int i = 0; i < 20; i++ ) {
            stack.push(i);
        }
        int actualResult = stack.size();
        Assertions.assertEquals(20, actualResult);
    }

    @Test
    public void isEmptyShouldReturnTrueWhenPickAllElementsFromTheStack() {
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
    public void isEmptyShouldReturnTrueWhenStackHaveNotElements() {
        Stack stack = new Stack();
        boolean actualResult = stack.isEmpty();
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void isEmptyShouldReturnFalseWhenStackHaveAnyElements() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        boolean actualResult = stack.isEmpty();
        Assertions.assertFalse(actualResult);
    }

    @Test
    public void toArrayShouldReturnArrayWithDataFromTheStack() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int[] expectedResult = new int[]{1, 2, 3};
        int[] actualResult = stack.toArray();
        Assertions.assertArrayEquals(expectedResult,actualResult);
    }
}