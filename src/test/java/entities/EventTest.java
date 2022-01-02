package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    public void toStringShouldReturnEqualStringArgumentThatIsEvent() {
        Event event = new Event(2028,8, 24, "Birthday");
        String expected = event.toString();
        String actual = event + "";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void toStringShouldNotChangeEventWhenMethodWasCalled() {
        Event event = new Event(2028,8, 24, "Birthday");
        Event expected = event;
        Event expectedValues = new Event(event.year, event.month, event.day, event.name);
        event.toString();
        Assertions.assertSame(expected, event);
        Assertions.assertEquals(expectedValues.year, event.year);
        Assertions.assertEquals(expectedValues.month, event.month);
        Assertions.assertEquals(expectedValues.day, event.day);
        Assertions.assertEquals(expectedValues.name, event.name);
    }

    @Test
    public void toStringShouldNotReturnDataWhenEventHaveNotData() {
        Event event = new Event();
        String inform = event.toString();
        Assertions.assertEquals(inform, "");
    }

    @Test
    public void toStringShouldReturnNullForNameArgumentWhenNameIsNull() {
        Event event = new Event(1952,12, 1, "null");
        Event expectedValues = new Event(event.year, event.month, event.day, event.name);
        event.toString();
        Assertions.assertEquals(expectedValues.name, event.name);
    }

    @Test
    public void equalsShouldReturnTrueWhenEventsHaveSameValues() {
        Event first = new Event(1954, 24, 12, "creation new department");
        Event second = new Event(1954, 24, 12, "creation new department");
        boolean result = first.equals(second);
        Assertions.assertTrue(result);
    }

    @Test
    public void equalsShouldReturnFalseWhenEventsHaveDifferentDays() {
        Event first = new Event(1954, 24, 12, "creation new department");
        Event second = new Event(1954, 24, 10, "creation new department");
        boolean result = first.equals(second);
        Assertions.assertFalse(result);
    }

    @Test
    public void equalsShouldReturnFalseWhenEventsHaveDifferentMonth() {
        Event first = new Event(1954, 24, 12, "creation new department");
        Event second = new Event(1954, 21, 12, "creation new department");
        boolean result = first.equals(second);
        Assertions.assertFalse(result);
    }

    @Test
    public void equalsShouldReturnFalseWhenEventsHaveDifferentYears() {
        Event first = new Event(1954, 7, 12, "creation new department");
        Event second = new Event(2954, 7, 12, "creation new department");
        boolean result = first.equals(second);
        Assertions.assertFalse(result);
    }

    @Test
    public void equalsShouldReturnFalseWhenEventsHaveDifferentNames() {
        Event first = new Event(1954, 8, 12, "Creation new department");
        Event second = new Event(2954, 8, 12, "creation new department");
        boolean result = first.equals(second);
        Assertions.assertFalse(result);
    }

    @Test
    public void equalsShouldReturnTrueWhenEventsHaveSameValuesAndNamesAreNull() {
        Event first = new Event(1954, 4, 12, "null");
        Event second = new Event(1954, 4, 12, "null");
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
    public void equalsShouldNotChangeEventsWhenMethodWasCalled() {
        Event first = new Event(2002, 5, 23, "Fishing with friends");
        Event second = new Event(1989, 9, 28, "Win jackpot");
        Event firstExpected = first;
        Event secondExpected = second;
        Event firstExpectedValues = new Event(first.year, first.month, first.day, first.name);
        Event secondExpectedValues = new Event(second.year, second.month, second.day, second.name);
        first.equals(second);
        Assertions.assertSame(firstExpected, first);
        Assertions.assertSame(secondExpected, second);
        boolean firstResult = first.equals(firstExpectedValues);
        boolean secondResult = second.equals(secondExpectedValues);
        Assertions.assertTrue(firstResult);
        Assertions.assertTrue(secondResult);
    }

    @Test
    public void equalsShouldReturnTrueWhenEventsHaveNotData() {
        Event first = new Event();
        Event second = new Event();
        boolean result = first.equals(second);
        Assertions.assertTrue(result);
    }

    @Test
    public void equalsShouldReturnFalseWhenOneEventIsNull() {
        Event first = new Event(2005, 3, 3, "Happy day");
        Event second = null;
        boolean result = first.equals(second);
        Assertions.assertFalse(result);
    }

    @Test
    public void compareToShouldReturnPlusValueWhenFistEventLatestThanSecondEvent() {
        Event first = new Event (2018, 4 , 24, "Wedding");
        Event second = new Event (2018, 2, 20, "Super party");
        int actual = first.compareTo(second);
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToShouldReturnMinusValueWhenSecondEventLatestThanFirstEvent() {
        Event first = new Event (2018, 4 , 2, "Wedding");
        Event second = new Event (2018, 4, 20, "Super party");
        int actual = first.compareTo(second);
        int expected = -1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToShouldReturnZeroWhenFirstAndSecondEventsHaveSameDates() {
        Event first = new Event (2022, 7 , 24, "New record bitcoin value");
        Event second = new Event (2022, 7, 24, "Blackout");
        int actual = first.compareTo(second);
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToShouldReturnMinusWhenSecondEventLatestThanFirstEventAndAllValuesAreDifferent() {
        Event first = new Event (2017, 4 , 12, "Create new company");
        Event second = new Event (2019, 8, 18, "Wedding");
        int actual = first.compareTo(second);
        int expected = -1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToShouldNotChangeEventsWhenMethodWasCalled() {
        Event first = new Event(2002, 5, 23, "Fishing with friends");
        Event second = new Event(1989, 9, 28, "Win jackpot");
        Event firstExpected = first;
        Event secondExpected = second;
        Event firstExpectedValues = new Event(first.year, first.month, first.day, first.name);
        Event secondExpectedValues = new Event(second.year, second.month, second.day, second.name);
        first.compareTo(second);
        Assertions.assertSame(firstExpected, first);
        Assertions.assertSame(secondExpected, second);
        boolean firstResult = first.equals(firstExpectedValues);
        boolean secondResult = second.equals(secondExpectedValues);
        Assertions.assertTrue(firstResult);
        Assertions.assertTrue(secondResult);
    }

}