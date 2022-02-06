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
}