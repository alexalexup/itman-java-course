package collections;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

class ArrayListTest {

    @Nested
    public class Set {
        @Test
        public void shouldSetElementInFirstPositionWhenIndexIsFirst() {
            ArrayList a = new ArrayList(5);
            a.set(0, 4);
            int actualResult = a.get(0);
            int expectedResult = 4;
            Assertions.assertEquals(expectedResult, actualResult);
        }

        @Test
        public void shouldSetElementInLastPositionWhenIndexIsLast() {
            ArrayList a = new ArrayList(9);
            a.set(8, 22);
            int actualResult = a.get(8);
            int expectedResult = 22;
            Assertions.assertEquals(expectedResult, actualResult);
        }
    }

    @Nested
    public class Get {
        @Test
        public void shouldReturnFistElementWhenIndexIsFirst() {
            ArrayList a = new ArrayList(4);
            a.set(0, 4);
            int actualResult = a.get(0);
            int expectedResult = 4;
            Assertions.assertEquals(expectedResult, actualResult);
        }

        @Test
        public void shouldReturnReturnLastElementWhenIndexIsLast() {
            ArrayList a = new ArrayList(4);
            a.set(3, 44);
            int actualResult = a.get(3);
            int expectedResult = 44;
            Assertions.assertEquals(expectedResult, actualResult);
        }

        @Test
        public void shouldReturnFirstElementWhenArrayListHaveOneElement() {
            ArrayList a = new ArrayList(1);
            a.set(0, 86);
            int actualResult = a.get(0);
            int expectedResult = 86;
            Assertions.assertEquals(expectedResult, actualResult);
        }
    }

    @Nested
    public class Size {
        @Test
        public void shouldReturnOneWhenArrayListHaveOneElement() {
            ArrayList a = ArrayList.of(1);
            int actualResult = a.size();
            int expectedResult = 1;
            Assertions.assertEquals(expectedResult, actualResult);
        }

        @Test
        public void shouldReturnResultWhenArrayListHaveAnyElements() {
            ArrayList a = ArrayList.of(1, 2, 3, 4, 5);
            int actualResult = a.size();
            int expectedResult = 5;
            Assertions.assertEquals(expectedResult, actualResult);
        }
    }

    @Nested
    public class Add {
        @Test
        public void shouldAddElementAndChangeSizeOfArrayWhenIndexOfElementBiggerThanSizeOfArray() {
            ArrayList a = new ArrayList(2);
            ArrayList expectedResult = ArrayList.of(1 ,2 ,3 ,4 ,5);
            for (int i = 0; i < 5; i++) {
                a.add(i+1);
                Assertions.assertEquals(expectedResult.get(i), a.get(i));
            }
            Assertions.assertEquals(5, a.size());
        }
    }

    @Nested
    public class ToArray {
        @Test
        public void shouldReturnResultWhenLogicalAndPhysicalArraysHaveDifferentLength() {
            ArrayList a = new ArrayList(4);
            a.add(5);
            int[] actualResult = a.toArray();
            int[] expectedResult = new int[]{5};
            Assertions.assertArrayEquals(expectedResult, actualResult);
        }

        @Test
        public void shouldReturnResultWhenArrayChangeSizeSeveralTimes() {
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

    @Nested
    public class Remove {
        @Test
        public void shouldReturnResultWhenIndexIsFirst() {
            ArrayList a = ArrayList.of(1, 2, 3, 4, 5);
            int actualValue = a.remove(0);
            int expectedValue = 1;
            int[] actualArray = a.toArray();
            int[] expectedArray = new int[] {2,3,4,5};
            Assertions.assertEquals(expectedValue, actualValue);
            Assertions.assertArrayEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldReturnResultWhenIndexIsLast() {
            ArrayList a = ArrayList.of(1, 2, 3, 4, 5);
            int actualValue = a.remove(4);
            int expectedValue = 5;
            int[] actualArray = a.toArray();
            int[] expectedArray = new int[] {1,2,3,4};
            Assertions.assertEquals(expectedValue, actualValue);
            Assertions.assertArrayEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldReturnResultWhenIndexInTheMiddle() {
            ArrayList a = ArrayList.of(1, 2, 3, 4, 5);
            int actualValue = a.remove(2);
            int expectedValue = 3;
            int[] actualArray = a.toArray();
            int[] expectedArray = new int[] {1,2,4,5};
            Assertions.assertEquals(expectedValue, actualValue);
            Assertions.assertArrayEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldReturnResultWhenLengthOfArrayIsOne() {
            ArrayList actualArray = new ArrayList(1);
            actualArray.add(1);
            int actualValue = actualArray.remove(0);
            int expectedValue = 1;
            Assertions.assertEquals(expectedValue, actualValue);
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldBeEqualsWhenBothArraysAreEqual() {
            ArrayList firstArray = ArrayList.of(1, 2, 3, 4, 5);
            ArrayList secondArray = ArrayList.of(1, 2, 3, 4, 5);
            Assertions.assertEquals(firstArray, secondArray);
        }

        @Test
        public void shouldNotBeEqualWhenSecondArrayIsNull() {
            ArrayList firstArray = ArrayList.of(1, 2, 3, 4);
            ArrayList secondArray = null;
            Assertions.assertNotEquals(firstArray, secondArray);
        }

        @Test
        public void shouldNotBeEqualWhenArraysHaveSameLengthAndOneDifferentElement() {
            ArrayList firstArray = ArrayList.of(1, 2, 3, 4, 5);
            ArrayList secondArray = ArrayList.of(1, 2, 3, 3, 5);
            Assertions.assertNotEquals(firstArray, secondArray);
        }

        @Test
        public void shouldNotBeEqualWhenArraysHaveDifferentLengthAndEqualsElements() {
            ArrayList firstArray = ArrayList.of(1, 2, 3, 4, 5);
            ArrayList secondArray = ArrayList.of(1, 2, 3, 4);
            Assertions.assertNotEquals(firstArray, secondArray);
        }

        @Test
        public void shouldNotBeEqualWhenLengthOfBothArraysIsOneAndElementsAreDifferent() {
            ArrayList firstArray = ArrayList.of(2);
            ArrayList secondArray = ArrayList.of(1);
            Assertions.assertNotEquals(firstArray, secondArray);
        }

        @Test
        public void shouldNotBeEqualWhenOneObjectIsNotByArrayListClass() {
            ArrayList arrayList = ArrayList.of(1, 2, 3, 4, 5);
            Object object = new Object();
            Assertions.assertNotEquals(arrayList, object);
        }
    }

    @Nested
    public class Sort {
        @Test
        public void shouldSortArrayWhenMethodWasCalled() {
            ArrayList actualArray = ArrayList.of(4, 2, 3, 1, 1, 5, -5);
            ArrayList expectedArray = ArrayList.of(-5, 1, 1, 2, 3, 4, 5);
            actualArray.sort();
            Assertions.assertEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldShouldWorkWhenArrayHaveOneElement() {
            ArrayList actualArray = ArrayList.of(4);
            ArrayList expectedArray = ArrayList.of(4);
            actualArray.sort();
            Assertions.assertEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldWorkWhenArrayAreSorted() {
            ArrayList actualArray = ArrayList.of(1, 2, 3, 4);
            ArrayList expectedArray = ArrayList.of(1, 2, 3, 4);
            actualArray.sort();
            Assertions.assertEquals(expectedArray, actualArray);
        }
    }

    @Nested
    public class ArayList {
        @Test
        public void shouldCreateObjectsWithElementsFromTheReceivedObject() {
            ArrayList expectedArray = ArrayList.of(1, 2, 3, 4, 5, 6, 7);
            ArrayList actualArray = new ArrayList(expectedArray);
            Assertions.assertEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldCreateObjectsWithElementsFromTheReceivedObjectWhenReceivedObjectHaveOneElement() {
            ArrayList expectedArray = new ArrayList(1);
            expectedArray.add(4);
            ArrayList actualArray = new ArrayList(expectedArray);
            Assertions.assertEquals(expectedArray, actualArray);
        }
    }

    @Nested
    public class Of {
        @Test
        public void shouldReturnnArrayListWithElementsFromArgumentWhenArgumentIsNumbers() {
            ArrayList actualArray = ArrayList.of(1, 2, 3, 4, 5);
            ArrayList expectedArray = new ArrayList(1);
            for (int i = 1; i < 6; i++) {
                expectedArray.add(i);
            }
            Assertions.assertEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldReturnArrayListWithElementsFromArgumentWhenArgumentIsArray() {
            ArrayList actualArray = ArrayList.of(new int[]{1, 2, 3, 4, 5});
            ArrayList expectedArray = new ArrayList(1);
            for (int i = 1; i < 6; i++) {
                expectedArray.add(i);
            }
            Assertions.assertEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldReturnArrayListWithElementFromArgumentWhenArgumentHaveOneElement() {
            ArrayList actualArray = ArrayList.of(6);
            ArrayList expectedArray = new ArrayList(1);
            expectedArray.add(6);
            Assertions.assertEquals(expectedArray, actualArray);
        }

        @Test
        public void shouldReturnArrayWithoutElementWhenArgumentHaveNotElements() {
            ArrayList actualArray = ArrayList.of();
            ArrayList expectedArray = new ArrayList();
            Assertions.assertEquals(expectedArray, actualArray);
        }
    }

    @Nested
    public class ToString {
        @Test
        public void shouldReturnEmptyStringWhenArrayHaveNotElements() {
            ArrayList actualArray = new ArrayList();
            String expectedString = "[]";
            String actualString = actualArray.toString();
            Assertions.assertEquals(expectedString,actualString);
        }

        @Test
        public void shouldReturnResultWhenArrayHaveAnyData() {
            ArrayList array = ArrayList.of(1, 2, 3, 4, 5, 6, 7);
            String expectedResult = "[1, 2, 3, 4, 5, 6, 7]";
            String actualResult = array.toString();
            Assertions.assertEquals(expectedResult,actualResult);
        }

        @Test
        public void shouldReturnResultWhenArrayHaveOneElement() {
            ArrayList array = ArrayList.of(1);
            String expectedResult = "[1]";
            String actualResult = array.toString();
            Assertions.assertEquals(expectedResult,actualResult);
        }

        @Test
        public void shouldWorkLessThanOneSecWithBigData() {
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
}