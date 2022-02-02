package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import collections.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class QueueManagementSystemTest {

    public entities.Ticket callGetNextTicket(QueueManagementSystem that, int count) {
        entities.Ticket newTicket = new entities.Ticket();
        for (int i = 0; i < count; i++) {
            newTicket = that.getNextTicket();
        }
        return newTicket;
    }

    @Test
    public void getTotalTicketsShouldReturnZeroWhenDidNotGetTicketsAnywhere(){
        QueueManagementSystem bank = new  QueueManagementSystem("Bank");
        int expected = 0;
        int actual = bank.getTotalTickets();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getTotalTicketsShouldReturnActualResultForEachObjectSeparate(){
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
    public void getTotalTicketsShouldReturnResultForAllDays() {
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

    @Test
    public void getNextTicketShouldReturnTicketWhereFieldNumberIsOneWhenMethodWasCalledFirstTime(){
        QueueManagementSystem bank = new  QueueManagementSystem("Bank");
        entities.Ticket actual = bank.getNextTicket();
        entities.Ticket expected = new entities.Ticket(1, "Bank");
        Assertions.assertEquals(expected.getNumber(), actual.getNumber());
    }

    @Test
    public void getNextTicketShouldReturnTicketWithSamePlaceAsQueManagementSystem(){
        QueueManagementSystem administration = new  QueueManagementSystem("Administration");
        entities.Ticket actual = administration.getNextTicket();
        String expected = "Administration";
        Assertions.assertEquals(expected, actual.getPlace());
    }

    @Test
    public void getNextTicketShouldCalculateTicketsForEachPlaceSeparate(){
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
    public void getNextTicketShouldReturnTicketWithNullPlaceWhenQueManagementSystemHaveNullPlace(){
        QueueManagementSystem administration = new  QueueManagementSystem(null);
        entities.Ticket actual = callGetNextTicket(administration, 15);
        entities.Ticket expected = new entities.Ticket(15,null);
        Assertions.assertEquals(expected.getNumber(), actual.getNumber());
        Assertions.assertEquals(null, actual.getPlace());
    }

    @Test
    public void toNextWorkDayShouldResetToZeroFieldOfTotalTicketsAndCreateOneMoreElementInDaysFieldWithZeroValue() {
        QueueManagementSystem administration = new  QueueManagementSystem("Administration");
        callGetNextTicket(administration, 21);
        administration.toNextWorkDay();
        int[] actualArray = administration.getVisitsByDay().toArray();
        int actualValue = actualArray[1];
        Assertions.assertEquals(0,actualValue);
    }

    @Test
    public void getVisitsByDayShouldReturnTotalTicketsByDaysWhenQueueHaveSomeDays() {
        QueueManagementSystem administration = new  QueueManagementSystem("Administration");
        callGetNextTicket(administration, 21);
        administration.toNextWorkDay();
        callGetNextTicket(administration, 5);
        administration.toNextWorkDay();
        callGetNextTicket(administration, 6);
        administration.toNextWorkDay();
        administration.toNextWorkDay();
        callGetNextTicket(administration, 8);
        ArrayList actualArray = administration.getVisitsByDay();
        ArrayList expectedArray = new ArrayList();
        expectedArray.add(21);
        expectedArray.add(5);
        expectedArray.add(6);
        expectedArray.add(0);
        expectedArray.add(8);
        boolean actualResult = actualArray.equals(expectedArray);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void getVisitsByDayShouldReturnResultThatShouldNotChangeTheFieldDaysOfTheObjectIfItIsChanged(){
        QueueManagementSystem administration = new  QueueManagementSystem("Administration");
        callGetNextTicket(administration, 3);
        administration.toNextWorkDay();
        callGetNextTicket(administration, 7);
        administration.toNextWorkDay();
        callGetNextTicket(administration, 2);
        ArrayList actualArray = administration.getVisitsByDay();
        ArrayList expectedArray = administration.getVisitsByDay();
        actualArray.set(0,5);
        actualArray.set(1,10);
        actualArray.set(2,8);
        boolean actualResult = expectedArray.equals(administration.getVisitsByDay());
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void getVisitsByDayShouldReturnArrayWithOneElementThatValueIsZeroWhenHaveNotNextDaysAndTickets() {
        QueueManagementSystem administration = new  QueueManagementSystem("Administration");
        ArrayList actualArray = administration.getVisitsByDay();
        ArrayList expectedArray = new ArrayList();
        expectedArray.add(0);
        boolean actualResult = actualArray.equals(expectedArray);
        Assertions.assertTrue(actualResult);
    }

    @Test public void sdfsdf() {
        QueueManagementSystem administration = new  QueueManagementSystem("Administration");
        int a = QueueManagementSystem.take(2);
        System.out.println(a);
    }
}