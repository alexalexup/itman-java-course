package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TicketTest {

    @Nested
    public class ToString {
        @Test
        public void shouldReturnInfoWhenMethodWasCalled() {
            Ticket one = new Ticket(1, "Bank");
            String actual = one.toString();
            String expected = "Ticket{number=1, place='Bank'}";
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnResultWhenTicketHaveNotData() {
            Ticket one = new Ticket();
            String actual = one.toString();
            String expected = "Ticket{number=0, place='null'}";
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldNotChangeTicketWhenMethodWasCalled() {
            Ticket one = new Ticket(32, "Pharmacy");
            Ticket expected = one;
            Ticket expectedValues =new Ticket(one.getNumber(), one.getPlace());
            one.toString();
            Assertions.assertSame(expected, one);
            Assertions.assertEquals(expectedValues.getNumber(), one.getNumber());
            Assertions.assertEquals(expectedValues.getPlace(), one.getPlace());
        }

        @Test
        public void shouldReturnDataWhenPlaceIsNull() {
            Ticket one = new Ticket(32, null);
            String actual =one.toString();
            String expected = "Ticket{number=32, place='null'}";
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldBeEqualWheBothObjectsHaveSameFields() {
            Ticket one = new Ticket(46, "Administration");
            Ticket two = new Ticket(46, "Administration");
            Assertions.assertEquals(one, two);
        }

        @Test
        public void shouldNotBeEqualWhenObjectsHaveDifferentNumbersAndSameNames() {
            Ticket one = new Ticket(54, "Administration");
            Ticket two = new Ticket(24, "Administration");
            Assertions.assertNotEquals(one, two);
        }

        @Test
        public void shouldNotBeEqualWhenObjectsHaveSameNumbersAndDifferentNames() {
            Ticket one = new Ticket(24, "Pharmacy");
            Ticket two = new Ticket(24, "Administration");
            Assertions.assertNotEquals(one, two);
        }

        @Test
        public void shouldNotBeEqualWhenAllFieldsGHaveDifferentData() {
            Ticket one = new Ticket(54, "Pharmacy");
            Ticket two = new Ticket(24, "Administration");
            Assertions.assertNotEquals(one, two);
        }

        @Test
        public void shouldNotBeEqualWhenSecondTicketIsNull() {
            Ticket one = new Ticket(54, "Pharmacy");
            Ticket two = null;
            Assertions.assertNotEquals(one, two);
        }

        @Test
        public void shouldNotBeEqualWhenOneFieldPlaceIsNullAndSecondFiledPlaceHaveData() {
            Ticket one = new Ticket(54, null);
            Ticket two = new Ticket(24, "Administration");
            Assertions.assertNotEquals(one, two);
        }

        @Test
        public void shouldBeEqualWhenObjectsHaveSameDataAndFieldsPlaceAreNull() {
            Ticket one = new Ticket(24, null);
            Ticket two = new Ticket(24, null);
            Assertions.assertEquals(one, two);
        }

        @Test
        public void shouldNotBeEqualWhenOneObjectIsNotFromTicketClass() {
            Ticket one = new Ticket(24, null);
            Object obj = new Object();
            Assertions.assertNotEquals(one, obj);
        }
    }
}