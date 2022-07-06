package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class EventTest {

    @Nested
    public class ToString {
        @Test
        public void shouldReturnEqualStringArgumentThatIsEvent() {
            Event event = new Event(1,2020, 12, 24, "ABCDabcd");
            String expected = event.toString();
            String actual = "Event{id=1, year=2020, month=12, day=24, name='ABCDabcd'}";
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldNotChangeEventWhenMethodWasCalled() {
            Event event = new Event(1,2020, 12, 24, "ABCDabcd");
            Event expected = event;
            Event expectedValues = new Event(event.getId(),event.getYear(), event.getMonth(), event.getDay(), event.getName());
            event.toString();
            Assertions.assertSame(expected, event);
            Assertions.assertEquals(expectedValues.getYear(), event.getYear());
            Assertions.assertEquals(expectedValues.getMonth(), event.getMonth());
            Assertions.assertEquals(expectedValues.getDay(), event.getDay());
            Assertions.assertEquals(expectedValues.getName(), event.getName());
            Assertions.assertEquals(expectedValues.getId(), event.getId());
        }

        @Test
        public void shouldReturnDefaultDataWhenEventHaveNotData() {
            Event event = new Event();
            String actual = event.toString();
            String expected = "Event{id=0, year=0, month=0, day=0, name='null'}";
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnResultWhenNameIsNull() {
            Event event = new Event(3,1952, 12, 1, null);
            String expected = "Event{id=3, year=1952, month=12, day=1, name='null'}";
            String actual = event.toString();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldBeEqualWhenEventsHaveSameValues() {
            Event first = new Event(5, 1956, 10, 24, "Happy day");
            Event second = new Event(5, 1956, 10, 24, "Happy day");
            Assertions.assertEquals(first, second);
        }

        @Test
        public void shouldNotBeEqualWhenEventsHaveDifferentDays() {
            Event first = new Event(5, 1956, 10, 21, "Happy day");
            Event second = new Event(5, 1956, 10, 24, "Happy day");
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void shouldNotBeEqualWhenEventsHaveDifferentMonth() {
            Event first = new Event(5, 1956, 10, 24, "Happy day");
            Event second = new Event(5, 1956, 11, 24, "Happy day");
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void shouldNotBeEqualWhenEventsHaveDifferentYears() {
            Event first = new Event(5, 1956, 10, 24, "Happy day");
            Event second = new Event(5, 1951, 10, 24, "Happy day");
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void shouldNotBeEqualWhenEventsHaveDifferentNames() {
            Event first = new Event(5, 1956, 10, 24, "Usual day");
            Event second = new Event(5, 1956, 10, 24, "Happy day");
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void shouldNotBeEqualWhenEventsHaveSameValuesAndFirstNameFieldIsNull() {
            Event first = new Event(5, 1956, 10, 24, null);
            Event second = new Event(5, 1956, 10, 24, "Happy day");
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void shouldNotBeEqualWhenEventsHaveSameValuesAndIdFieldAreDifferent() {
            Event first = new Event(5, 1956, 10, 24, "Happy day");
            Event second = new Event(1, 1956, 10, 24, "Happy day");
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void shouldBeEqualWhenEventsHaveSameValuesAndFieldsNameAreNull() {
            Event first = new Event(5, 1956, 10, 24, null);
            Event second = new Event(5, 1956, 10, 24, null);
            Assertions.assertEquals(first, second);
        }

        @Test
        public void shouldNotBeEqualWhenAllElementsHaveDifferentValues() {
            Event first = new Event(2, 1954, 8, 4, "Not bad day");
            Event second = new Event(5, 1956, 10, 24, "Happy day");
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void shouldNotBeEqualWhenSecondEventIsNull() {
            Event first = new Event(5, 1956, 10, 24, "Happy day");
            Event second = null;
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void shouldNotChangeEventsWhenMethodWasCalled() {
            Event first = new Event(2002, 5, 23, "Birthday");
            Event second = new Event(1989, 9, 28, "Win jackpot");
            Event firstExpected = first;
            Event secondExpected = second;
            Event firstExpectedValues = new Event(first.getYear(), first.getMonth(),first.getDay(), "Birthday");
            Event secondExpectedValues = new Event(second.getYear(), second.getMonth(), second.getDay(),second.getName());
            first.equals(second);
            Assertions.assertSame(firstExpected, first);
            Assertions.assertSame(secondExpected, second);
            boolean firstResult = first.equals(firstExpectedValues);
            boolean secondResult = second.equals(secondExpectedValues);
            Assertions.assertTrue(firstResult);
            Assertions.assertTrue(secondResult);
        }
    }

    @Nested
    public class CompareTo {
        @Test
        public void ShouldReturnPlusValueWhenFistEventLatestThanSecondEvent() {
            Event first = new Event (2018, 4 , 24, "Wedding");
            Event second = new Event (2018, 2, 20, "Super party");
            Assertions.assertTrue(first.compareTo(second) > 0);
        }

        @Test
        public void shouldReturnMinusValueWhenSecondEventLatestThanFirstEvent() {
            Event first = new Event (2018, 4 , 2, "Wedding");
            Event second = new Event (2018, 4, 20, "Super party");
            Assertions.assertTrue(first.compareTo(second) < 0);
        }

        @Test
        public void shouldReturnZeroWhenFirstAndSecondEventsHaveSameDatesAndDifferentNames() {
            Event first = new Event (2022, 7 , 24, "New record bitcoin value");
            Event second = new Event (2022, 7, 24, "Blackout");
            Assertions.assertEquals(0, first.compareTo(second));
        }

        @Test
        public void shouldReturnNegativeNumberWhenSecondEventLatestThanFirstEventAndAllValuesAreDifferent() {
            Event first = new Event (2017, 4 , 12, "Create new company");
            Event second = new Event (2019, 8, 18, "Wedding");
            Assertions.assertTrue(first.compareTo(second) < 0);
        }

        @Test
        public void shouldNotChangeEventsWhenMethodWasCalled(){
            Event first = new Event(2002, 5, 23, "Fishing with friends");
            Event second = new Event(1989, 9, 28, "Win jackpot");
            Event firstExpected = first;
            Event secondExpected = second;
            Event firstExpectedValues = new Event(first.getYear(), first.getMonth(), first.getDay(), first.getName());
            Event secondExpectedValues = new Event(second.getYear(), second.getMonth(), second.getDay(), second.getName());
            first.compareTo(second);
            Assertions.assertSame(firstExpected, first);
            Assertions.assertSame(secondExpected, second);
            boolean expectedFirst = first.equals(firstExpectedValues);
            boolean expectedSecond = second.equals(secondExpectedValues);
            Assertions.assertTrue(expectedFirst);
            Assertions.assertTrue(expectedSecond);
        }
    }
}