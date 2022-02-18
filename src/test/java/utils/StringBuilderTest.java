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
    public void appendShouldAddDataFromStringToCurrentObjectWhenMethodWasCalled() {
        StringBuilder s = new StringBuilder();
        String data = "One";
        String actualString = s.append(data).toString();
        String expectedString = "One";
        boolean actualResult = actualString.equals(expectedString);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void appendShouldAddDataFromArgumentToCurrentObjectWhenArgumentFromIntegerClass() {
        StringBuilder s = new StringBuilder();
        int data = 245564;
        String actualString = s.append(data).toString();
        String expectedString = "245564";
        boolean actualResult = actualString.equals(expectedString);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void appendShouldAddDataFromArgumentToCurrentObjectWhenArgumentFromDoubleClass() {
        StringBuilder s = new StringBuilder();
        double data = 2.1313123;
        String actualString = s.append(data).toString();
        String expectedString = "2.1313123";
        boolean actualResult = actualString.equals(expectedString);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void appendShouldAddDataFromArgumentToCurrentObjectWhenWhenArgumentFromLongClass() {
        StringBuilder s = new StringBuilder();
        long data = 3232322232323232323L;
        String actualString = s.append(data).toString();
        String expectedString = "3232322232323232323";
        boolean actualResult = actualString.equals(expectedString);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void appendShouldAddDataFromArgumentToCurrentObjectWhenWhenArgumentFromBooleanClass() {
        StringBuilder s = new StringBuilder();
        boolean data = false;
        String actualString = s.append(data).toString();
        String expectedString = "false";
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