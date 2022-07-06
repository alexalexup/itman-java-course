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
        public void shouldBeEqualWhenBothObjectsAreEqual() {
            Statistic first = new Statistic(3,4, 8,2, 2);
            Statistic second = new Statistic(3,4, 8,2, 2);
            Assertions.assertEquals(first, second);
        }

        @Test
        public void shouldNotBeEqualWhenSecondObjectsIsNull() {
            Statistic first = new Statistic(3,4, 8,2, 2);
            Statistic second = null;
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void shouldNotBeEqualWhenSecondObjectHaveOneDifferentElement() {
            Statistic first = new Statistic(3,4, 8,2, 2);
            Statistic second = new Statistic(3,4, 8,2, 3);
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void shouldNotBeEqualWhenSecondObjectHaveAllDifferentElements() {
            Statistic first = new Statistic(3,4, 8,3.6666666666666665, 2);
            Statistic second = new Statistic(2,5, 7,3.666666666666667, 2);
            Assertions.assertNotEquals(first, second);

        }

        @Test
        public void shouldNotBeEqualWhenOneObjectIsNoyFromStatisticClass() {
            Statistic first = new Statistic(3,4, 8,3.6666666666666665, 2);
            Object obj = new Object();
            Assertions.assertNotEquals(first, obj);
        }
    }
}