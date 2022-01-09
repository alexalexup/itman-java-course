package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    public void getNextTicketShouldReturnTicketWhereNumberIsOneWhenMethodWasCalledFirstTime(){
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
}