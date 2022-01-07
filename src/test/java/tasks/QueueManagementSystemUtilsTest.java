package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueManagementSystemUtilsTest {

    public entities.Ticket callGetNextTicket(QueueManagementSystem that, int count) {
        that.totalTickets = that.totalTickets + count - 1;
        entities.Ticket newTicket = that.getNextTicket();
        return newTicket;
    }

    @Test
    public void calcTotalVisitsShouldReturnResultWhenResultHaveValueMoreThanIntegerMaxValue() {
       QueueManagementSystem[] systems = new QueueManagementSystem[] {
               new QueueManagementSystem("Bank"),
               new QueueManagementSystem("School"),
               new QueueManagementSystem("Pharmacy"),
               new QueueManagementSystem("Administration")
       };
       int countBank = Integer.MAX_VALUE;
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

    @Test
    public void calcTotalVisitsShouldReturnResultWhenSomePlacesAreNull() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{
                new QueueManagementSystem(null),
                new QueueManagementSystem("Pharmacy"),
                new QueueManagementSystem(null),
                new QueueManagementSystem("School")
        };
        int countNullFirst = 3;
        int countPharmacy = 2;
        int countNullSecond = 4;
        int countSchool = 5;
        callGetNextTicket(systems[0], countNullFirst);
        callGetNextTicket(systems[1], countPharmacy );
        callGetNextTicket(systems[2], countNullSecond);
        callGetNextTicket(systems[3], countSchool);
        long actualResult = QueueManagementSystemUtils.calcTotalVisits(systems);
        long expectedResult = countNullFirst + countPharmacy + countNullSecond + countSchool;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calcTotalVisitsShouldReturnZeroWhenMethodCallGetNextTicketWasNotCalled() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{
                new QueueManagementSystem("Pharmacy"),
                new QueueManagementSystem("School")
        };
        long actualResult = QueueManagementSystemUtils.calcTotalVisits(systems);
        Assertions.assertEquals(0, actualResult);
    }

    @Test
    public void calcTotalVisitsShouldNotChangeFieldPlaceInSystemsWhenMethodWasCalled() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{
                new QueueManagementSystem("Pharmacy"),
                new QueueManagementSystem("School"),
                new QueueManagementSystem("Administration")
        };
        int expectedNumberPharmacy = 15;
        int expectedNumberSchool= 8;
        int expectedNumberAdministration = 7;
        String expectedPlacePharmacy = systems[0].place;
        String expectedPlaceSchool = systems[1].place;
        String expectedPlaceAdministration = systems[2].place;
        callGetNextTicket(systems[0], expectedNumberPharmacy);
        callGetNextTicket(systems[1], expectedNumberSchool );
        callGetNextTicket(systems[2], expectedNumberAdministration);
        QueueManagementSystemUtils.calcTotalVisits(systems);
        Assertions.assertEquals(expectedPlacePharmacy, systems[0].place);
        Assertions.assertEquals(expectedPlaceSchool, systems[1].place);
        Assertions.assertEquals(expectedPlaceAdministration , systems[2].place);
    }

    @Test
    public void calcAverageVisitsShouldReturnSystemTotalTicketsWhenSystemsLengthIsOne() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{new QueueManagementSystem("Pharmacy")};
        double expectedResult = 8;
        callGetNextTicket(systems[0], (int)expectedResult);
        double actualResult = QueueManagementSystemUtils.calcAverageVisits(systems);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calcAverageVisitsShouldReturnResultWhenSomeTotalTicketsHaveMaxValues() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{
                new QueueManagementSystem("Administration"),
                new QueueManagementSystem("Pharmacy"),
                new QueueManagementSystem("ConcertHall"),
                new QueueManagementSystem("School")
        };
        int countAdministration = 3;
        int countPharmacy = Integer.MAX_VALUE;
        int countConcertHall = 4;
        int countSchool = Integer.MAX_VALUE;
        callGetNextTicket(systems[0], countAdministration);
        callGetNextTicket(systems[1], countPharmacy);
        callGetNextTicket(systems[2], countConcertHall);
        callGetNextTicket(systems[3], countSchool);
        double expectedResult = ((double)countAdministration + (double)countPharmacy
                + (double)countConcertHall + (double)countSchool) / 4;
        double actualResult = QueueManagementSystemUtils.calcAverageVisits(systems);
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void calcAverageVisitsShouldReturnZeroWhenSystemsHaveNotElements() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{};
        double expectedResult = 0;
        double actualResult = QueueManagementSystemUtils.calcAverageVisits(systems);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calcAverageVisitsShouldNotChangePlaceInSystemsWhenMethodWasCalled() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{
                new QueueManagementSystem("Administration"),
                new QueueManagementSystem("Pharmacy"),
                new QueueManagementSystem("ConcertHall")
        };
        String expectedAdministration = systems[0].place;
        String expectedPharmacy = systems[1].place;
        String expectedConcertHall= systems[2].place;
        QueueManagementSystemUtils.calcAverageVisits(systems);
        Assertions.assertEquals(expectedAdministration, systems[0].place);
        Assertions.assertEquals(expectedPharmacy, systems[1].place);
        Assertions.assertEquals(expectedConcertHall, systems[2].place);
    }
}