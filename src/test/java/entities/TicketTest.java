package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    public void toStringShouldReturnInfoWhenMethodWasCalled() {
        Ticket one = new Ticket(1, "Bank");
        String actual = one.toString();
        String expected = "Ticket{number = 1, place = 'Bank'}";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void toStringShouldNotShowInfoWhenTicketHaveNotData() {
        Ticket one = new Ticket();
        String actual = one.toString();
        String expected = "";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void toStringShouldNotChangeTicketWhenMethodWasCalled() {
        Ticket one = new Ticket(32, "Pharmacy");
        Ticket expected = one;
        Ticket expectedValues =new Ticket(one.number, one.place);
        one.toString();
        Assertions.assertSame(expected, one);
        Assertions.assertEquals(expectedValues.number, one.number);
        Assertions.assertEquals(expectedValues.place, one.place);
    }

    @Test
    public void toStringShouldReturnDataWhenPlaceIsNull() {
        Ticket one = new Ticket(32, null);
        String actual =one.toString();
        String expected = "Ticket{number = 32, place = 'null'}";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equalsShouldReturnTrueWheBothObjectsHaveSameFields() {
        Ticket one = new Ticket(46, "Administration");
        Ticket two = new Ticket(46, "Administration");
        boolean result = one.equals(two);
        Assertions.assertTrue(result);
    }

    @Test
    public void equalsShouldReturnTrueWheBothObjectsHaveSameFieldsAndFieldPlaceIsNull() {
        Ticket one = new Ticket(74, null);
        Ticket two = new Ticket(74, null);
        boolean result = one.equals(two);
        Assertions.assertTrue(result);
    }

    @Test
    public void equalsShouldReturnFalseWhenOnePlaceHaveDataAndSecondPlaceIsNull() {
        Ticket one = new Ticket(74, null);
        Ticket two = new Ticket(74, "School");
        boolean result = one.equals(two);
        Assertions.assertFalse(result);
    }

    @Test
    public void equalsShouldReturnFalseWhenObjectsHaveDifferentNumbersAndSameNames() {
        Ticket one = new Ticket(54, "Administration");
        Ticket two = new Ticket(24, "Administration");
        boolean result = one.equals(two);
        Assertions.assertFalse(result);
    }

    @Test
    public void equalsShouldReturnFalseWhenObjectsHaveSameNumbersAndDifferentNames() {
        Ticket one = new Ticket(24, "Pharmacy");
        Ticket two = new Ticket(24, "Administration");
        boolean result = one.equals(two);
        Assertions.assertFalse(result);
    }

    @Test
    public void equalsShouldReturnFalseWhenAllFieldsGHaveDifferentData() {
        Ticket one = new Ticket(54, "Pharmacy");
        Ticket two = new Ticket(24, "Administration");
        boolean result = one.equals(two);
        Assertions.assertFalse(result);
    }

}