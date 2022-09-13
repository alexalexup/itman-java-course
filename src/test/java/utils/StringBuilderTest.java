package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;



class StringBuilderTest {

    @Nested
    public class Append {
        @Test
        public void shouldAddDataToCurrentObjectWhenSizeIsZero() {
            StringBuilder s = new StringBuilder();
            String data = "Have a nice day";
            String actualString = s.append(data).toString();
            Assertions.assertEquals(data, actualString);
        }

        @Test
        public void shouldAddDataFromStringToCurrentObjectWhenMethodWasCalled() {
            StringBuilder s = new StringBuilder();
            String data = "One";
            String actualString = s.append(data).toString();
            Assertions.assertEquals(data, actualString);
        }

        @Test
        public void shouldAddDataFromArgumentToCurrentObjectWhenArgumentFromIntegerClass() {
            StringBuilder s = new StringBuilder();
            int data = 245564;
            String actualString = s.append(data).toString();
            String expectedString = "245564";
            Assertions.assertEquals(expectedString, actualString);
        }

        @Test
        public void shouldAddDataFromArgumentToCurrentObjectWhenArgumentFromDoubleClass() {
            StringBuilder s = new StringBuilder();
            double data = 2.1313123;
            String actualString = s.append(data).toString();
            String expectedString = "2.1313123";
            Assertions.assertEquals(expectedString, actualString);
        }

        @Test
        public void shouldAddDataFromArgumentToCurrentObjectWhenWhenArgumentFromLongClass() {
            StringBuilder s = new StringBuilder();
            long data = 3232322232323232323L;
            String actualString = s.append(data).toString();
            String expectedString = "3232322232323232323";
            Assertions.assertEquals(expectedString, actualString);
        }

        @Test
        public void shouldAddDataFromArgumentToCurrentObjectWhenWhenArgumentFromBooleanClass() {
            StringBuilder s = new StringBuilder();
            boolean data = false;
            String actualString = s.append(data).toString();
            String expectedString = "false";
            Assertions.assertEquals(expectedString, actualString);
        }

        @Test
        public void shouldWorkWhenNullIsPassedToMethod() {
            StringBuilder s = new StringBuilder(1);
            s.append(null);
            String expectedString = "null";
            String actualString = s.toString();
            Assertions.assertEquals(expectedString, actualString);
        }

        @Test
        public void shouldWorkLessThanOneSecWhenArgumentHaveIntegerMaxValue() {
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
        public void shouldWorkLessThanOneSecWhenArgumentHaveLongMaxValue() {
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
        public void shouldWorkLessThanOneSecWhenArgumentHaveDoubleMaxValue() {
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
        public void shouldWorkLessThanOneSecWhenMethodWasCalledAnyTimes() {
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

    @Nested
    public class ToString {
        @Test
        public void shouldReturnResultWhenObjectHaveNotData() {
            StringBuilder s = new StringBuilder();
            String actualString = s.toString();
            String expectedString = "";
            boolean actualResult = actualString.equals(expectedString);
            Assertions.assertTrue(actualResult);
        }
    }
}