package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    @Test
    public void setShouldSetElementInFirstPositionWhenIndexIsFirst() {
        ArrayList a = new ArrayList(5);
        a.set(0, 4);
        int actualResult = a.get(0);
        int expectedResult = 4;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void setShouldSetElementInLastPositionWhenIndexIsLast() {
        ArrayList a = new ArrayList(9);
        a.set(8, 22);
        int actualResult = a.get(8);
        int expectedResult = 22;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getShouldReturnFistElementWhenIndexIsFirst() {
        ArrayList a = new ArrayList(4);
        a.set(0, 4);
        int actualResult = a.get(0);
        int expectedResult = 4;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getShouldReturnLastElementWhenIndexIsLast() {
        ArrayList a = new ArrayList(4);
        a.set(3, 44);
        int actualResult = a.get(3);
        int expectedResult = 44;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getShouldReturnFirstElementWhenArrayListHaveOneElement() {
        ArrayList a = new ArrayList(1);
        a.set(0, 86);
        int actualResult = a.get(0);
        int expectedResult = 86;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void sizeShouldReturnOneWhenArrayListHaveOneElement() {
        ArrayList a = new ArrayList(1);
        a.add(3);
        int actualResult = a.size();
        int expectedResult = 1;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void addShouldAddElementAndChangeSizeOfArrayWhenIndexOfElementBiggerThanSizeOfArray() {
        ArrayList a = new ArrayList(2);
        int expectedLength = 5;
        ArrayList expectedResult = new ArrayList(expectedLength);
        for (int i = 0; i < expectedLength; i++) {
            a.add(i+1);
            expectedResult.set(i, i+1);
        }
        Assertions.assertEquals(expectedLength, a.size());
        for (int i = 0; i < expectedLength; i++) {
            Assertions.assertEquals(expectedResult.get(i), a.get(i));
        }
    }

    @Test
    public void toArrayShouldReturnResultWhenLogicalAndPhysicalArraysHaveDifferentLength() {
        ArrayList a = new ArrayList(4);
        a.add(5);
        int[] actualResult = a.toArray();
        int[] expectedResult = new int[]{5};
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void toArrayShouldReturnResultWhenArrayChangeSizeSeveralTimes() {
        ArrayList a = new ArrayList(2);
        int expectedLength = 22;
        int[] expectedResult = new int[expectedLength];
        for (int i = 0; i < expectedLength; i++) {
            expectedResult[i] = i;
            a.add(i);
        }
        int[] actualResult = a.toArray();
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void removeShouldReturnResultWhenIndexIsFirst() {
        ArrayList a = new ArrayList(1);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        int actualValue = a.remove(0);
        int expectedValue = 1;
        int[] actualArray = a.toArray();
        int[] expectedArray = new int[] {2,3,4,5};
        Assertions.assertEquals(expectedValue, actualValue);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void removeShouldReturnResultWhenIndexIsLast() {
        ArrayList a = new ArrayList(1);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        int actualValue = a.remove(4);
        int expectedValue = 5;
        int[] actualArray = a.toArray();
        int[] expectedArray = new int[] {1,2,3,4};
        Assertions.assertEquals(expectedValue, actualValue);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void removeShouldReturnResultWhenIndexInMiddle() {
        ArrayList a = new ArrayList(1);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        int actualValue = a.remove(2);
        int expectedValue = 3;
        int[] actualArray = a.toArray();
        int[] expectedArray = new int[] {1,2,4,5};
        Assertions.assertEquals(expectedValue, actualValue);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void removeShouldReturnResultWhenLengthOfArrayIsOne() {
        ArrayList actualArray = new ArrayList(1);
        actualArray.add(1);
        int actualValue = actualArray.remove(0);
        int expectedValue = 1;
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void equalsShouldReturnTrueWhenBothArraysAreEqual() {
        ArrayList firstArray = new ArrayList(1);
        ArrayList secondArray = new ArrayList(1);
        for (int i = 1; i < 8; i++) {
            firstArray.add(i);
            secondArray.add(i);
        }
        boolean actualResult = firstArray.equals(secondArray);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void equalsShouldReturnFalseWhenSecondObjectIsNull() {
        ArrayList firstArray = new ArrayList(1);
        ArrayList secondArray = null;
        for (int i = 1; i < 4; i++) {
            firstArray.add(i);
        }
        boolean actualResult = firstArray.equals(secondArray);
        Assertions.assertFalse(actualResult);
    }

    @Test
    public void equalsShouldReturnFalseWhenArraysHaveSameLengthAndOneDifferentElement() {
        ArrayList firstArray = new ArrayList(1);
        ArrayList secondArray = new ArrayList(1);
        for (int i = 1; i < 4; i++) {
            firstArray.add(i);
            secondArray.add(i);
        }
        firstArray.add(5);
        secondArray.add(9);
        boolean actualResult = firstArray.equals(secondArray);
        Assertions.assertFalse(actualResult);
    }

    @Test
    public void equalsShouldReturnFalseWhenArraysHaveDifferentLengthAndEqualsElements() {
        ArrayList firstArray = new ArrayList(1);
        ArrayList secondArray = new ArrayList(1);
        for (int i = 1; i < 4; i++) {
            firstArray.add(i);
            secondArray.add(i);
        }
        secondArray.add(1);
        boolean actualResult = firstArray.equals(secondArray);
        Assertions.assertFalse(actualResult);
    }

    @Test
    public void equalsShouldReturnFalseWhenLengthOfBothArraysIsOneAndElementsAreDifferent() {
        ArrayList firstArray = new ArrayList(1);
        ArrayList secondArray = new ArrayList(1);
        firstArray.add(1);
        secondArray.add(2);
        boolean actualResult = firstArray.equals(secondArray);
        Assertions.assertFalse(actualResult);
    }

    @Test
    public void sortShouldSortArrayWhenElementsAreNotSorted() {
        ArrayList actualArray = new ArrayList(1);
        ArrayList expectedArray = new ArrayList(1);
        actualArray.add(4);
        actualArray.add(2);
        actualArray.add(3);
        actualArray.add(1);
        for (int i = 1; i < 5; i++) {
            expectedArray.add(i);
        }
        actualArray.sort();
        boolean expectedResult = actualArray.equals(expectedArray);
        Assertions.assertTrue(expectedResult);
    }

    @Test
    public void sortShouldWorkWhenArrayHaveOneElement() {
        ArrayList actualArray = new ArrayList(1);
        ArrayList expectedArray = new ArrayList(1);
        actualArray.add(4);
        expectedArray.add(4);
        actualArray.sort();
        boolean expectedResult = actualArray.equals(expectedArray);
        Assertions.assertTrue(expectedResult);
    }

    @Test
    public void sortShouldWorkWhenArrayAreSorted() {
        ArrayList actualArray = new ArrayList(1);
        ArrayList expectedArray = new ArrayList(1);
        for (int i = 1; i < 5; i++) {
            actualArray.add(i);
            expectedArray.add(i);
        }
        actualArray.sort();
        boolean expectedResult = actualArray.equals(expectedArray);
        Assertions.assertTrue(expectedResult);
    }

    @Test
    public void ArrayListShouldCreateObjectsWithElementsFromTheReceivedObject() {
        ArrayList expectedArray = new ArrayList(1);
        for (int i = 0; i < 8; i++) {
            expectedArray.add(i);
        }
        ArrayList actualArray = new ArrayList(expectedArray);
        boolean expectedResult = actualArray.equals(expectedArray);
        Assertions.assertTrue(expectedResult);
    }

    @Test
    public void ArrayListShouldCreateObjectsWithElementsFromTheReceivedObjectWhenReceivedObjectHaveOneElement() {
        ArrayList expectedArray = new ArrayList(1);
        expectedArray.add(4);
        ArrayList actualArray = new ArrayList(expectedArray);
        boolean expectedResult = actualArray.equals(expectedArray);
        Assertions.assertTrue(expectedResult);
    }

    @Test
    public void ofShouldReturnArrayListWithElementsFromArgumentWhenArgumentIsNumbers() {
        ArrayList actualArray = ArrayList.of(1, 2, 3, 4, 5);
        ArrayList expectedArray = new ArrayList(1);
        for (int i = 1; i < 6; i++) {
            expectedArray.add(i);
        }
        boolean expectedResult = actualArray.equals(expectedArray);
        Assertions.assertTrue(expectedResult);
    }

    @Test
    public void ofShouldReturnArrayListWithElementsFromArgumentWhenArgumentIsArray() {
        ArrayList actualArray = ArrayList.of(new int[]{1, 2, 3, 4, 5});
        ArrayList expectedArray = new ArrayList(1);
        for (int i = 1; i < 6; i++) {
            expectedArray.add(i);
        }
        boolean expectedResult = actualArray.equals(expectedArray);
        Assertions.assertTrue(expectedResult);
    }

    @Test
    public void ofShouldReturnArrayListWithElementFromArgumentWhenArgumentIsOne() {
        ArrayList actualArray = ArrayList.of(6);
        ArrayList expectedArray = new ArrayList(1);
        expectedArray.add(6);
        boolean expectedResult = actualArray.equals(expectedArray);
        Assertions.assertTrue(expectedResult);
    }

    @Test
    public void ofShouldReturnArrayWithoutElementWhenHaveNotArguments() {
        ArrayList actualArray = ArrayList.of();
        ArrayList expectedArray = new ArrayList();
        boolean expectedResult = actualArray.equals(expectedArray);
        Assertions.assertTrue(expectedResult);
    }

    @Test
    public void toStringShouldReturnResultWhenArrayIsEmpty() {
        ArrayList array = new ArrayList();
        String expectedResult = "";
        String actualResult = array.toString();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void toStringShouldReturnResultWhenArrayHaveAnyData() {
        ArrayList array = ArrayList.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        String expectedResult = "123456789101112131415";
        String actualResult = array.toString();
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void toStringShouldReturnResultWhenArrayHaveAOneElement() {
        ArrayList array = ArrayList.of(1);
        String expectedResult = "1";
        String actualResult = array.toString();
        Assertions.assertEquals(expectedResult,actualResult);
    }
}