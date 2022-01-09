package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueManagementSystemUtilsTest {

    public entities.Ticket callGetNextTicket(QueueManagementSystem that, int count) {
        entities.Ticket newTicket = new entities.Ticket();
        for (int i = 0; i < count; i++) {
            newTicket = that.getNextTicket();
        }
        return newTicket;
    }

    /*
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
     */

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
    public void calcTotalVisitsShouldNotChangeFieldsInSystemsWhenMethodWasCalled() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{
                new QueueManagementSystem("Pharmacy"),
                new QueueManagementSystem("School"),
                new QueueManagementSystem("Administration")
        };
        int expectedTotalTicketsPharmacy = 15;
        int expectedTotalTicketsSchool= 8;
        int expectedTotalAdministration = 7;
        String expectedPlacePharmacy = "Pharmacy";
        String expectedPlaceSchool = "School";
        String expectedPlaceAdministration = "Administration";
        entities.Ticket expectedTicketPharmacy = callGetNextTicket(systems[0], expectedTotalTicketsPharmacy);
        entities.Ticket expectedTicketSchool = callGetNextTicket(systems[1], expectedTotalTicketsSchool);
        entities.Ticket expectedTicketAdministration = callGetNextTicket(systems[2], expectedTotalAdministration);
        QueueManagementSystemUtils.calcTotalVisits(systems);
        Assertions.assertEquals(expectedPlacePharmacy,expectedTicketPharmacy.getPlace());
        Assertions.assertEquals(expectedPlaceSchool, expectedTicketSchool.getPlace()) ;
        Assertions.assertEquals(expectedPlaceAdministration , expectedTicketAdministration.getPlace());
        Assertions.assertEquals(expectedTotalTicketsPharmacy,systems[0].getTotalTickets());
        Assertions.assertEquals(expectedTotalTicketsSchool, systems[1].getTotalTickets()) ;
        Assertions.assertEquals(expectedTotalAdministration , systems[2].getTotalTickets());
    }

    @Test
    public void calcAverageVisitsShouldReturnSystemTotalTicketsWhenSystemsLengthIsOne() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{new QueueManagementSystem("Pharmacy")};
        double expectedResult = 8;
        callGetNextTicket(systems[0], (int)expectedResult);
        double actualResult = QueueManagementSystemUtils.calcAverageVisits(systems);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    /*@Test
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
     */

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
               new QueueManagementSystem("Pharmacy"),
               new QueueManagementSystem("School"),
               new QueueManagementSystem("Administration")
       };
       int expectedTotalTicketsPharmacy = 15;
       int expectedTotalTicketsSchool= 8;
       int expectedTotalAdministration = 7;
       String expectedPlacePharmacy = "Pharmacy";
       String expectedPlaceSchool = "School";
       String expectedPlaceAdministration = "Administration";
       entities.Ticket expectedTicketPharmacy = callGetNextTicket(systems[0], expectedTotalTicketsPharmacy);
       entities.Ticket expectedTicketSchool = callGetNextTicket(systems[1], expectedTotalTicketsSchool);
       entities.Ticket expectedTicketAdministration = callGetNextTicket(systems[2], expectedTotalAdministration);
       QueueManagementSystemUtils.calcAverageVisits(systems);
       Assertions.assertEquals(expectedPlacePharmacy,expectedTicketPharmacy.getPlace());
       Assertions.assertEquals(expectedPlaceSchool, expectedTicketSchool.getPlace()) ;
       Assertions.assertEquals(expectedPlaceAdministration , expectedTicketAdministration.getPlace());
       Assertions.assertEquals(expectedTotalTicketsPharmacy,systems[0].getTotalTickets());
       Assertions.assertEquals(expectedTotalTicketsSchool, systems[1].getTotalTickets()) ;
       Assertions.assertEquals(expectedTotalAdministration , systems[2].getTotalTickets());
    }

    @Test
    public void calcMedianVisitsShouldReturnResultWhenLengthOfSystemsIsOdd() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{
                new QueueManagementSystem("Administration"),
                new QueueManagementSystem("Pharmacy"),
                new QueueManagementSystem("ConcertHall"),
                new QueueManagementSystem("School"),
                new QueueManagementSystem("CandyShop")
        };
        int countAdministration = 42;
        int countPharmacy = 24;
        int countConcertHall = 13;
        int countSchool = 31;
        int contCandyShop = 22;
        callGetNextTicket(systems[0],countAdministration);
        callGetNextTicket(systems[1],countPharmacy);
        callGetNextTicket(systems[2],countConcertHall);
        callGetNextTicket(systems[3],countSchool);
        callGetNextTicket(systems[4],contCandyShop);
        double expectedResult = (double)countPharmacy;
        double actualResult = QueueManagementSystemUtils.calcMedianVisits(systems);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calcMedianVisitsShouldReturnResultWhenLengthOfSystemsIsEven() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{
                new QueueManagementSystem("Administration"),
                new QueueManagementSystem("Pharmacy"),
                new QueueManagementSystem("ConcertHall"),
                new QueueManagementSystem("School")
        };
        int countAdministration = 8;
        int countPharmacy = 14;
        int countConcertHall = 9;
        int countSchool = 6;
        callGetNextTicket(systems[0],countAdministration);
        callGetNextTicket(systems[1],countPharmacy);
        callGetNextTicket(systems[2],countConcertHall);
        callGetNextTicket(systems[3],countSchool);
        double expectedResult = (double)(countAdministration + countConcertHall) / 2;
        double actualResult = QueueManagementSystemUtils.calcMedianVisits(systems);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calcMedianVisitsShouldReturnZeroWhenSystemsHaveNotElements() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{};
        double expectedResult = 0;
        double actualResult = QueueManagementSystemUtils.calcMedianVisits(systems);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}