package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringBuilderTest {

    @Test
    public void appendShouldAddDataToCurrentObjectWhenSizeIsZero() {
        StringBuilder s = new StringBuilder();
        String data = "Have a nice day";
        String actualString = s.append(data).toString();
        boolean actualResult = actualString.equals(data);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void appendShouldAddSomeTypesOfDataToCurrentObjectWhenMethodWasCalled() {
        StringBuilder s = new StringBuilder();
        String firstData = "One";
        int secondData = 2;
        double thirdData = 3.15;
        boolean fourthData  = false;
        String actualString = s.append(firstData)
                .append(secondData)
                .append(thirdData)
                .append(fourthData)
                .toString();
        String expectedString = "One23.15false";
        boolean actualResult = actualString.equals(expectedString);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void toStringShouldReturnResultWhenObjectHaveNotData() {
        StringBuilder s = new StringBuilder();
        String actualString = s.toString();
        String expectedString = "";
        boolean actualResult = actualString.equals(expectedString);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void appendShouldWorkWhenNullIsPassedToMethod() {
        StringBuilder s = new StringBuilder(1);
        s.append(null);
        String expectedString = "null";
        String actualString = s.toString();
        boolean actualResult = actualString.equals(expectedString);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void appendShouldWorkLessThanOneSecWhenArgumentHaveIntegerMaxValue() {
        StringBuilder s = new StringBuilder(1);
        double firstTime = System.currentTimeMillis();
        s.append(Integer.MAX_VALUE);
        double secondTime = System.currentTimeMillis();
        double expectedTime = 1000.00;
        double actualTime = secondTime - firstTime;
        String expectedString = "2147483647";
        String actualString = s.toString();
        boolean actualResult = (actualString.equals(expectedString)) && (expectedTime > actualTime);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void appendShouldWorkLessThanOneSecWhenArgumentHaveLongMaxValue() {
        StringBuilder s = new StringBuilder(1);
        double firstTime = System.currentTimeMillis();
        s.append(Long.MAX_VALUE);
        double secondTime = System.currentTimeMillis();
        double expectedTime = 1000.00;
        double actualTime = secondTime - firstTime;
        String expectedString = "9223372036854775807";
        String actualString = s.toString();
        boolean actualResult = (actualString.equals(expectedString)) && (expectedTime > actualTime);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void appendShouldWorkLessThanOneSecWhenArgumentHaveDoubleMaxValue() {
        StringBuilder s = new StringBuilder(1);
        double firstTime = System.currentTimeMillis();
        s.append(Double.MAX_VALUE);
        double secondTime = System.currentTimeMillis();
        double expectedTime = 1000.00;
        double actualTime = secondTime - firstTime;
        String expectedString = "1.7976931348623157E308";
        String actualString = s.toString();
        boolean actualResult = (actualString.equals(expectedString)) && (expectedTime > actualTime);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void appendShouldWorkLessThanOneSecWhenMethodWasCalledAnyTimes() {
        StringBuilder s = new StringBuilder(1);
        double first = System.currentTimeMillis();
        for (int i = 1000000; i < 2000000; i++) {
            s.append(i);
        }
        double second = System.currentTimeMillis();
        double actualResult = second - first;
        Assertions.assertTrue(actualResult < 1000.0);
    }
}