package collections;

import benchmarks.SortBenchmark;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.ArrayUtils;


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
        ArrayList a = ArrayList.of(1);
        int actualResult = a.size();
        int expectedResult = 1;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void sizeShouldReturnResultWhenArrayListHaveAnyElements() {
        ArrayList a = ArrayList.of(1, 2, 3, 4, 5);
        int actualResult = a.size();
        int expectedResult = 5;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void addShouldAddElementAndChangeSizeOfArrayWhenIndexOfElementBiggerThanSizeOfArray() {
        ArrayList a = new ArrayList(2);
        ArrayList expectedResult = ArrayList.of(1 ,2 ,3 ,4 ,5);
        for (int i = 0; i < 5; i++) {
            a.add(i+1);
            Assertions.assertEquals(expectedResult.get(i), a.get(i));
        }
        Assertions.assertEquals(5, a.size());
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
        ArrayList a = ArrayList.of(1, 2, 3, 4, 5);
        int actualValue = a.remove(0);
        int expectedValue = 1;
        int[] actualArray = a.toArray();
        int[] expectedArray = new int[] {2,3,4,5};
        Assertions.assertEquals(expectedValue, actualValue);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void removeShouldReturnResultWhenIndexIsLast() {
        ArrayList a = ArrayList.of(1, 2, 3, 4, 5);
        int actualValue = a.remove(4);
        int expectedValue = 5;
        int[] actualArray = a.toArray();
        int[] expectedArray = new int[] {1,2,3,4};
        Assertions.assertEquals(expectedValue, actualValue);
        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void removeShouldReturnResultWhenIndexInMiddle() {
        ArrayList a = ArrayList.of(1, 2, 3, 4, 5);
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
        ArrayList firstArray = ArrayList.of(1, 2, 3, 4, 5);
        ArrayList secondArray = ArrayList.of(1, 2, 3, 4, 5);
        boolean actualResult = firstArray.equals(secondArray);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void equalsShouldReturnFalseWhenSecondObjectIsNull() {
        ArrayList firstArray = ArrayList.of(1, 2, 3, 4);
        ArrayList secondArray = null;
        boolean actualResult = firstArray.equals(secondArray);
        Assertions.assertFalse(actualResult);
    }

    @Test
    public void equalsShouldReturnFalseWhenArraysHaveSameLengthAndOneDifferentElement() {
        ArrayList firstArray = ArrayList.of(1, 2, 3, 4, 5);
        ArrayList secondArray = ArrayList.of(1, 2, 3, 3, 5);
        boolean actualResult = firstArray.equals(secondArray);
        Assertions.assertFalse(actualResult);
    }

    @Test
    public void equalsShouldReturnFalseWhenArraysHaveDifferentLengthAndEqualsElements() {
        ArrayList firstArray = ArrayList.of(1, 2, 3, 4, 5);
        ArrayList secondArray = ArrayList.of(1, 2, 3, 4);
        boolean actualResult = firstArray.equals(secondArray);
        Assertions.assertFalse(actualResult);
    }

    @Test
    public void equalsShouldReturnFalseWhenLengthOfBothArraysIsOneAndElementsAreDifferent() {
        ArrayList firstArray = ArrayList.of(2);
        ArrayList secondArray = ArrayList.of(1);
        boolean actualResult = firstArray.equals(secondArray);
        Assertions.assertFalse(actualResult);
    }

    @Test
    public void sortShouldSortArrayWhenMethodWasCalled() {
        ArrayList actualArray = ArrayList.of(4, 2, 3, 1, 1, 5, -5);
        ArrayList expectedArray = ArrayList.of(-5, 1, 1, 2, 3, 4, 5);
        actualArray.sort();
        boolean expectedResult = actualArray.equals(expectedArray);
        Assertions.assertTrue(expectedResult);
    }


    @Test
    public void sortShouldWorkWhenArrayHaveOneElement() {
        ArrayList actualArray = ArrayList.of(4);
        ArrayList expectedArray = ArrayList.of(4);
        actualArray.sort();
        boolean expectedResult = actualArray.equals(expectedArray);
        Assertions.assertTrue(expectedResult);
    }

    @Test
    public void sortShouldWorkWhenArrayAreSorted() {
        ArrayList actualArray = ArrayList.of(1, 2, 3, 4);
        ArrayList expectedArray = ArrayList.of(1, 2, 3, 4);
        actualArray.sort();
        boolean expectedResult = actualArray.equals(expectedArray);
        Assertions.assertTrue(expectedResult);
    }

    @Test
    public void ArrayListShouldCreateObjectsWithElementsFromTheReceivedObject() {
        ArrayList expectedArray = ArrayList.of(1, 2, 3, 4, 5, 6, 7);
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
    public void ofShouldReturnArrayListWithElementFromArgumentWhenArgumentHaveOneElement() {
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
    public void toStringShouldReturnEmptyStringWhenArrayHaveNotElements() {
        ArrayList actualArray = new ArrayList();
        String expectedString = "[]";
        String actualString = actualArray.toString();
        Assertions.assertEquals(expectedString,actualString);
    }

    @Test
    public void toStringShouldReturnResultWhenArrayHaveAnyData() {
        ArrayList array = ArrayList.of(1, 2, 3, 4, 5, 6, 7);
        String expectedResult = "[1, 2, 3, 4, 5, 6, 7]";
        String actualResult = array.toString();
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void toStringShouldReturnResultWhenArrayHaveAOneElement() {
        ArrayList array = ArrayList.of(1);
        String expectedResult = "[1]";
        String actualResult = array.toString();
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void toStringShouldWorkLessThanOneSecWithBigData() {
        int[] data = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            data[i] = i +1000000;
        }
        ArrayList array = ArrayList.of(data);
        long firstTime = System.currentTimeMillis();
        array.toString();
        long secondTime = System.currentTimeMillis();
        long actualResult = secondTime - firstTime;
        Assertions.assertTrue(actualResult < 1000.0);
    }
}