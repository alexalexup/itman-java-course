package tasks;

import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import collections.InArrayList;

class QueueManagementSystemTest {

    public entities.Ticket callGetNextTicket(QueueManagementSystem that, int count) {
        entities.Ticket newTicket = new entities.Ticket();
        for (int i = 0; i < count; i++) {
            newTicket = that.getNextTicket();
        }
        return newTicket;
    }

    @Nested
    public class CallNext{
        @Test
        public void shouldReturnFirstTicketFromQueue() {
            QueueManagementSystem bank = new  QueueManagementSystem("Bank");
            callGetNextTicket(bank, 5);
            Ticket actualResult = bank.callNext();
            Ticket expectedResult = new Ticket(1,"Bank");
            Assertions.assertTrue(actualResult.toString().equals(expectedResult.toString()));
        }

        @Test
        public void shouldDeleteFirstTicketFromQueueWhenQueueHaveSomeTickets() {
            QueueManagementSystem bank = new  QueueManagementSystem("Bank");
            callGetNextTicket(bank, 8);
            bank.callNext();
            bank.callNext();
            Ticket[] actualResult = bank.getCurrentQueue();
            Ticket[] expectedResult = new Ticket[]{new Ticket(3,"Bank"),
                    new Ticket(4,"Bank"),
                    new Ticket(5,"Bank"),
                    new Ticket(6,"Bank"),
                    new Ticket(7,"Bank"),
                    new Ticket(8,"Bank")};
            Assertions.assertEquals(actualResult.length, expectedResult.length);
            for (int i = 0; i < 6; i++) {
                Assertions.assertTrue(actualResult[i].toString().equals(expectedResult[i].toString()));
            }
        }

        @Test
        public void shouldDeleteFirstTicketFromQueueWhenQueueHaveSomeTicketsYesterday() {
            QueueManagementSystem bank = new  QueueManagementSystem("Bank");
            callGetNextTicket(bank, 8);
            bank.toNextWorkDay();
            callGetNextTicket(bank, 5);
            bank.callNext();
            Ticket[] actualResult = bank.getCurrentQueue();
            Ticket[] expectedResult = new Ticket[]{new Ticket(2,"Bank"),
                    new Ticket(3,"Bank"),
                    new Ticket(4,"Bank"),
                    new Ticket(5,"Bank")};
            Assertions.assertEquals(actualResult.length, expectedResult.length);
            for (int i = 0; i < 4; i++) {
                Assertions.assertTrue(actualResult[i].toString().equals(expectedResult[i].toString()));
            }
        }
    }

    @Nested
    public class getCurrentQueue {
        @Test
        public void shouldReturnTicketsWhenQueueHaveSomeTickets(){
            QueueManagementSystem bank = new  QueueManagementSystem("Bank");
            Ticket[] expectedResult = new Ticket[3];
            for (int i = 0; i < 3; i++) {
                expectedResult[i] = bank.getNextTicket();
            }
            Ticket[] actualResult = bank.getCurrentQueue();
            Assertions.assertArrayEquals(expectedResult, actualResult);
        }

        @Test
        public void shouldReturnNullWhenQueueHaveNotAnyTicketsTodayButHaveSomeTicketYesterday(){
            QueueManagementSystem bank = new  QueueManagementSystem("Bank");
            callGetNextTicket(bank, 5);
            bank.toNextWorkDay();
            Ticket[] tickets = bank.getCurrentQueue();
            Assertions.assertArrayEquals(new Ticket[]{}, tickets);
        }

        @Test
        public void shouldReturnTicketsWhenQueueHaveSomeTicketsTodayAndHaveSomeTicketYesterday(){
            QueueManagementSystem bank = new  QueueManagementSystem("Bank");
            callGetNextTicket(bank, 5);
            bank.toNextWorkDay();
            callGetNextTicket(bank, 3);
            Ticket[] actualResult = bank.getCurrentQueue();
            Ticket[] expectedResult = new Ticket[]{new Ticket(1,"Bank"),
                    new Ticket(2,"Bank"),
                    new Ticket(3,"Bank")};
            Assertions.assertEquals(actualResult.length, expectedResult.length);
            for (int i = 0; i < 3; i++) {
                Assertions.assertTrue(actualResult[i].toString().equals(expectedResult[i].toString()));
            }
        }
    }

    @Nested
    public class GetTotalTickets {
        @Test
        public void shouldReturnZeroWhenDidNotGetTicketsAnywhere(){
            QueueManagementSystem bank = new  QueueManagementSystem("Bank");
            int expected = 0;
            int actual = bank.getTotalTickets();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnActualResultForEachObjectSeparate(){
            QueueManagementSystem bank = new  QueueManagementSystem("Bank");
            QueueManagementSystem pharmacy = new  QueueManagementSystem("Pharmacy");
            int expectedBank = 8;
            int expectedPharmacy = 32;
            callGetNextTicket(bank,expectedBank);
            callGetNextTicket(pharmacy,expectedPharmacy);
            callGetNextTicket(bank,expectedBank);
            expectedBank = 16;// call NextTicket for bank second time
            int actualBank = bank.getTotalTickets();
            int actualPharmacy = pharmacy.getTotalTickets();
            Assertions.assertEquals(expectedBank, actualBank);
            Assertions.assertEquals(expectedPharmacy, actualPharmacy);
        }

        @Test
        public void shouldReturnResultForAllDays() {
            QueueManagementSystem administration = new  QueueManagementSystem("Administration");
            callGetNextTicket(administration,4);
            administration.toNextWorkDay();
            callGetNextTicket(administration,8);
            administration.toNextWorkDay();
            callGetNextTicket(administration, 23);
            administration.toNextWorkDay();
            int actualResult = administration.getTotalTickets();
            Assertions.assertEquals(35, actualResult);
        }
    }

    @Nested
    public class GetNextTicket {
        @Test
        public void shouldReturnTicketWhereFieldNumberIsOneWhenMethodWasCalledFirstTime(){
            QueueManagementSystem bank = new  QueueManagementSystem("Bank");
            entities.Ticket actual = bank.getNextTicket();
            entities.Ticket expected = new entities.Ticket(1, "Bank");
            Assertions.assertEquals(expected.getNumber(), actual.getNumber());
        }

        @Test
        public void shouldReturnTicketWithSamePlaceAsQueManagementSystem(){
            QueueManagementSystem administration = new  QueueManagementSystem("Administration");
            entities.Ticket actual = administration.getNextTicket();
            String expected = "Administration";
            Assertions.assertEquals(expected, actual.getPlace());
        }

        @Test
        public void shouldCalculateTicketsForEachPlaceSeparate(){
            QueueManagementSystem administration = new  QueueManagementSystem("Administration");
            QueueManagementSystem bank = new  QueueManagementSystem("Bank");
            QueueManagementSystem pharmacy = new  QueueManagementSystem("Pharmacy");
            int expectedAdministration = 18;
            int expectedBank = 4;
            int expectedPharmacy= 79;
            entities.Ticket actualAdministration = callGetNextTicket(administration,expectedAdministration);
            entities.Ticket actualBank  = callGetNextTicket(bank,expectedBank);
            entities.Ticket actualPharmacy = callGetNextTicket(pharmacy,expectedPharmacy);
            Assertions.assertEquals(expectedAdministration, actualAdministration.getNumber());
            Assertions.assertEquals(expectedPharmacy, actualPharmacy.getNumber());
            Assertions.assertEquals(expectedBank, actualBank.getNumber());
        }

        @Test
        public void shouldReturnTicketWithNullPlaceWhenQueManagementSystemHaveNullPlace(){
            QueueManagementSystem administration = new  QueueManagementSystem(null);
            entities.Ticket actual = callGetNextTicket(administration, 15);
            entities.Ticket expected = new entities.Ticket(15,null);
            Assertions.assertEquals(expected.getNumber(), actual.getNumber());
            Assertions.assertEquals(null, actual.getPlace());
        }
    }

    @Nested
    public class ToNextWorkDay {
        @Test
        public void shouldCreateOneMoreElementInDaysFieldWithZeroValue() {
            QueueManagementSystem administration = new  QueueManagementSystem("Administration");
            callGetNextTicket(administration, 21);
            administration.toNextWorkDay();
            int[] actualArray = administration.getVisitsByDay().toArray();
            int actualValue = actualArray[1];
            Assertions.assertEquals(0,actualValue);
        }
    }

    @Nested
    public class GetVisitsByDay{
        @Test
        public void shouldReturnTotalTicketsByDaysWhenQueueHaveSomeDays() {
            QueueManagementSystem administration = new  QueueManagementSystem("Administration");
            callGetNextTicket(administration, 21);
            administration.toNextWorkDay();
            callGetNextTicket(administration, 5);
            administration.toNextWorkDay();
            callGetNextTicket(administration, 6);
            administration.toNextWorkDay();
            administration.toNextWorkDay();
            callGetNextTicket(administration, 8);
            InArrayList actualArray = administration.getVisitsByDay();
            InArrayList expectedArray = InArrayList.of(21, 5, 6, 0, 8);
            boolean actualResult = actualArray.equals(expectedArray);
            Assertions.assertTrue(actualResult);
        }

        @Test
        public void shouldReturnResultThatShouldNotChangeTheFieldDaysOfTheObjectIfItIsChanged(){
            QueueManagementSystem administration = new  QueueManagementSystem("Administration");
            callGetNextTicket(administration, 3);
            administration.toNextWorkDay();
            callGetNextTicket(administration, 7);
            administration.toNextWorkDay();
            callGetNextTicket(administration, 2);
            InArrayList actualArray = administration.getVisitsByDay();
            InArrayList expectedArray = InArrayList.of(3, 7, 2);
            actualArray.set(0, 5);
            actualArray.set(1, 10);
            actualArray.set(2, 8);
            boolean actualResult = expectedArray.equals(administration.getVisitsByDay());
            Assertions.assertTrue(actualResult);
        }

        @Test
        public void shouldReturnArrayWithOneElementThatValueIsZeroWhenHaveNotNextDaysAndTickets() {
            QueueManagementSystem administration = new  QueueManagementSystem("Administration");
            InArrayList actualArray = administration.getVisitsByDay();
            InArrayList expectedArray = new InArrayList();
            expectedArray.add(0);
            boolean actualResult = actualArray.equals(expectedArray);
            Assertions.assertTrue(actualResult);
        }
    }
}