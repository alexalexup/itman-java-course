package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;




class StatisticTest {

    @Nested
    public class ToString {
        @Test
        public void shouldReturnDataWhenMethodWasCalled() {
            Statistic statistic = new Statistic(3, 5,5,2,3);
            String expectedString = "Statistic{min=3, max=5, count=5, average=2.0, median=3.0}";
            String actualString = statistic.toString();
            boolean actualResult = actualString.equals(expectedString);
            Assertions.assertTrue(actualResult);
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldReturnTrueWhenBothObjectsAreEqual() {
            Statistic first = new Statistic(3,4, 8,2, 2);
            Statistic second = new Statistic(3,4, 8,2, 2);
            boolean actualResult = first.equals(second);
            Assertions.assertTrue(actualResult);
        }

        @Test
        public void shouldReturnFalseWhenSecondObjectsIsNull() {
            Statistic first = new Statistic(3,4, 8,2, 2);
            Statistic second = null;
            boolean actualResult = first.equals(second);
            Assertions.assertFalse(actualResult);
        }

        @Test
        public void shouldReturnFalseWhenSecondObjectHaveOneDifferentElement() {
            Statistic first = new Statistic(3,4, 8,2, 2);
            Statistic second = new Statistic(3,4, 8,2, 3);
            boolean actualResult = first.equals(second);
            Assertions.assertFalse(actualResult);
        }

        @Test
        public void shouldReturnFalseWhenSecondObjectHaveAllDifferentElements() {
            Statistic first = new Statistic(3,4, 8,3.6666666666666665, 2);
            Statistic second = new Statistic(2,5, 7,3.666666666666667, 2);
            boolean actualResult = first.equals(second);
            Assertions.assertFalse(actualResult);
        }
    }
}