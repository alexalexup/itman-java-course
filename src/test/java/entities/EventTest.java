package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    public void toStringShouldReturnEqualStringArgumentThatIsEvent() {
        Event event = new Event(2020,12, 24, "ABCDabcd", 1);
        String expected = event.toString();
        String actual = "Event{id=1, year=2020, month=12, day=24, name='ABCDabcd'}";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void toStringShouldNotChangeEventWhenMethodWasCalled() {
        Event event = new Event(2028,8, 24, "Birthday",1);
        Event expected = event;
        Event expectedValues = new Event(event.getYear(), event.getMonth(), event.getDay(), event.getName(), event.getId());
        event.toString();
        Assertions.assertSame(expected, event);
        Assertions.assertEquals(expectedValues.getYear(), event.getYear());
        Assertions.assertEquals(expectedValues.getMonth(), event.getMonth());
        Assertions.assertEquals(expectedValues.getDay(), event.getDay());
        Assertions.assertEquals(expectedValues.getName(), event.getName());
    }

    @Test
    public void toStringShouldReturnDefaultDataWhenEventHaveNotData() {
        Event event = new Event();
        String actual = event.toString();
        String expected = "Event{id=0, year=0, month=0, day=0, name='null'}";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void toStringShouldReturnResultWhenNameIsNull() {
        Event event = new Event(1952,12, 1, null, 3);
        String expected = "Event{id=3, year=1952, month=12, day=1, name='null'}";
        String actual = event.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equalsShouldReturnTrueWhenEventsHaveSameValues() {
        Event first = new Event(1954, 24, 12, "creation new department", 2);
        Event second = new Event(1954, 24, 12, "creation new department", 2);
        boolean result = first.equals(second);
        Assertions.assertTrue(result);
    }

    @Test
    public void equalsShouldReturnFalseWhenEventsHaveDifferentDays() {
        Event first = new Event(1954, 24, 12, "creation new department", 3);
        Event second = new Event(1954, 24, 10, "creation new department", 3);
        boolean result = first.equals(second);
        Assertions.assertFalse(result);
    }

    @Test
    public void equalsShouldReturnFalseWhenEventsHaveDifferentMonth() {
        Event first = new Event(1954, 24, 12, "creation new department", 3);
        Event second = new Event(1954, 21, 12, "creation new department", 3);
        boolean result = first.equals(second);
        Assertions.assertFalse(result);
    }

    @Test
    public void equalsShouldReturnFalseWhenEventsHaveDifferentYears() {
        Event first = new Event(1954, 7, 12, "creation new department", 3);
        Event second = new Event(2954, 7, 12, "creation new department", 3);
        boolean result = first.equals(second);
        Assertions.assertFalse(result);
    }

    @Test
    public void equalsShouldReturnFalseWhenEventsHaveDifferentNames() {
        Event first = new Event(1954, 8, 12, "Creation new department", 3);
        Event second = new Event(2954, 8, 12, "creation new department", 3);
        boolean result = first.equals(second);
        Assertions.assertFalse(result);
    }

    @Test
    public void equalsShouldReturnFalseWhenEventsHaveSameValuesAndFirstNameFieldIsNull() {
        Event first = new Event(2020, 01, 01,null, 3);
        Event second = new Event(2020, 01,01, "A", 3);
        boolean result = first.equals(second);
        Assertions.assertFalse(result);
    }

    @Test
    public void equalsShouldReturnFalseWhenEventsHaveSameValuesAndIdFieldAreDifferent() {
        Event first = new Event(1954, 4, 12,"Cool party", 2);
        Event second = new Event(1954, 4, 12, "Cool party", 22);
        boolean result = first.equals(second);
        Assertions.assertFalse(result);
    }

    @Test
    public void equalsShouldReturnTrueWhenEventsHaveSameValuesAndFieldsNameAreNull() {
        Event first = new Event(1954, 4, 12,null);
        Event second = new Event(1954, 4, 12, null);
        boolean result = first.equals(second);
        Assertions.assertTrue(result);
    }

    @Test
    public void equalsShouldReturnFalseWhenAllElementsHaveDifferentValues() {
        Event first = new Event(2005, 3, 3, "Happy day");
        Event second = new Event(2001, 4, 28, "Blackout");
        boolean result = first.equals(second);
        Assertions.assertFalse(result);
    }

    @Test
    public void equalsShouldReturnFalseWhenSecondEventIsNull() {
        Event first = new Event(2005, 3, 3, "Happy day");
        Event second = null;
        boolean result = first.equals(second);
        Assertions.assertFalse(result);
    }

    @Test
    public void equalsShouldNotChangeEventsWhenMethodWasCalled() {
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

    @Test
    public void compareToShouldReturnPlusValueWhenFistEventLatestThanSecondEvent() {
        Event first = new Event (2018, 4 , 24, "Wedding");
        Event second = new Event (2018, 2, 20, "Super party");
        int actual = first.compareTo(second);
        boolean expected = actual > 0;
        Assertions.assertTrue(expected);
    }

    @Test
    public void compareToShouldReturnMinusValueWhenSecondEventLatestThanFirstEvent() {
        Event first = new Event (2018, 4 , 2, "Wedding");
        Event second = new Event (2018, 4, 20, "Super party");
        int actual = first.compareTo(second);
        boolean expected = actual < 0;
        Assertions.assertTrue(expected);
    }

    @Test
    public void compareToShouldReturnZeroWhenFirstAndSecondEventsHaveSameDatesAndDifferentNames() {
        Event first = new Event (2022, 7 , 24, "New record bitcoin value");
        Event second = new Event (2022, 7, 24, "Blackout");
        int actual = first.compareTo(second);
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToShouldReturnNegativeNumberWhenSecondEventLatestThanFirstEventAndAllValuesAreDifferent() {
        Event first = new Event (2017, 4 , 12, "Create new company");
        Event second = new Event (2019, 8, 18, "Wedding");
        int actual = first.compareTo(second);
        boolean expected = actual < 0;
        Assertions.assertTrue(expected);
    }

    @Test
    public void compareToShouldNotChangeEventsWhenMethodWasCalled() {
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