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
}