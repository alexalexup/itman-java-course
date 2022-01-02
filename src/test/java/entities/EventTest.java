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
}