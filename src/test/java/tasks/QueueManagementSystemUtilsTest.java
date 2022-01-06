package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueManagementSystemUtilsTest {

    public entities.Ticket callGetNextTicket(QueueManagementSystem that, int count) {
        entities.Ticket newTicket = new entities.Ticket();
        for (int i = 0; i < count; i++ ) {
            newTicket = that.getNextTicket();
        }
        return newTicket;
    }

    @Test
    public void calcTotalVisitsShouldReturnResultWhenResultHaveValueMoreThanMaxInt() {
       QueueManagementSystem[] systems = new QueueManagementSystem[] {
               new QueueManagementSystem("Bank"),
               new QueueManagementSystem("School"),
               new QueueManagementSystem("Pharmacy"),
               new QueueManagementSystem("Administration")
       };
       int countBank = 2147483647;
       int countSchool = 10;
       int  countPharmacy = 25;
       int  countAdministration = 340;
       callGetNextTicket(systems[0],countBank);
       callGetNextTicket(systems[1],countSchool);
       callGetNextTicket(systems[2], countPharmacy);
       callGetNextTicket(systems[3], countAdministration);
       long expectedResult = (long)countBank + (long)countSchool + (long)countPharmacy + (long)countAdministration;
       long actualResult = QueueManagementSystemUtils.calcTotalVisits(systems);
       Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calcTotalVisitsShouldNotChangeValueTotalTicketsInQueueManagementSystemWhenMethodWasCalled() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{
                new QueueManagementSystem("Bank"),
                new QueueManagementSystem("School")};
        int expectedBank = 20;
        int expectedSchool = 5;
        callGetNextTicket(systems[0], expectedBank);
        callGetNextTicket(systems[1], expectedSchool);
        QueueManagementSystemUtils.calcTotalVisits(systems);
        int actualBank = systems[0].getTotalTickets();
        int actualSchool =systems[1].getTotalTickets();
        Assertions.assertEquals(expectedBank, actualBank);
        Assertions.assertEquals(expectedSchool, actualSchool);
    }
}