package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueManagementSystemTest {

    public entities.Ticket callGetNextTicket(QueueManagementSystem that, int count) {
        that.totalTickets = that.totalTickets + count - 1;
        entities.Ticket newTicket = that.getNextTicket();
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
    public void getNextTicketShouldReturnTicketWhereNumberIsOneWhenMethodWasCalledFirstTime(){
        QueueManagementSystem bank = new  QueueManagementSystem("Bank");
        entities.Ticket actual = bank.getNextTicket();
        entities.Ticket expected = new entities.Ticket(1, "Bank");
        Assertions.assertEquals(expected.number, actual.number);
    }

    @Test
    public void getNextTicketShouldReturnTicketWithSamePlaceAsQueManagementSystem(){
        QueueManagementSystem administration = new  QueueManagementSystem("Administration");
        entities.Ticket actual = administration.getNextTicket();
        String expected = "Administration";
        Assertions.assertEquals(expected, actual.place);
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
        Assertions.assertEquals(expectedAdministration, actualAdministration.number);
        Assertions.assertEquals(expectedBank, actualBank.number);
        Assertions.assertEquals(expectedPharmacy, actualPharmacy.number);
    }

    @Test
    public void getNextTicketShouldReturnTicketWithNullPlaceWhenQueManagementSystemHaveNullPlace(){
        QueueManagementSystem administration = new  QueueManagementSystem(null);
        entities.Ticket actual = callGetNextTicket(administration, 15);
        entities.Ticket expected = new entities.Ticket(15,null);
        Assertions.assertEquals(expected.number, actual.number);
        Assertions.assertEquals(null, actual.place);
    }




}