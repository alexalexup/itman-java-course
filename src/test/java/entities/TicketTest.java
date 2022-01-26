package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    public void toStringShouldReturnInfoWhenMethodWasCalled() {
        Ticket one = new Ticket(1, "Bank");
        String actual = one.toString();
        String expected = "Ticket{number=1, place='Bank'}";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void toStringShouldReturnResultWhenTicketHaveNotData() {
        Ticket one = new Ticket();
        String actual = one.toString();
        String expected = "Ticket{number=0, place='null'}";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void toStringShouldNotChangeTicketWhenMethodWasCalled() {
        Ticket one = new Ticket(32, "Pharmacy");
        Ticket expected = one;
        Ticket expectedValues =new Ticket(one.getNumber(), one.getPlace());
        one.toString();
        Assertions.assertSame(expected, one);
        Assertions.assertEquals(expectedValues.getNumber(), one.getNumber());
        Assertions.assertEquals(expectedValues.getPlace(), one.getPlace());
    }

    @Test
    public void toStringShouldReturnDataWhenPlaceIsNull() {
        Ticket one = new Ticket(32, null);
        String actual =one.toString();
        String expected = "Ticket{number=32, place='null'}";
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

    @Test
    public void equalsShouldReturnFalseWhenSecondTicketIsNull() {
        Ticket one = new Ticket(54, "Pharmacy");
        Ticket two = null;
        boolean result = one.equals(two);
        Assertions.assertFalse(result);
    }

    @Test
    public void equalsShouldReturnFalseWhenOneFieldPlaceIsNullAndSecondFiledPlaceHaveData() {
        Ticket one = new Ticket(54, null);
        Ticket two = new Ticket(24, "Administration");
        boolean result = one.equals(two);
        Assertions.assertFalse(result);
    }

    @Test
    public void equalsShouldReturnTrueWhenObjectsHaveSameDataAndFieldsPlaceAreNull() {
        Ticket one = new Ticket(24, null);
        Ticket two = new Ticket(24, null);
        boolean result = one.equals(two);
        Assertions.assertTrue(result);
    }
}