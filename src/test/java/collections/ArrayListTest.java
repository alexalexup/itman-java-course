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
        int actualResult = a.size();
        int expectedResult = 1;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void sizeShouldReturnResultWhenArrayListHaveSomeElements() {
        ArrayList a = new ArrayList(156);
        int actualResult = a.size();
        int expectedResult = 156;
        Assertions.assertEquals(expectedResult, actualResult);
    }
}