package tasks;

import entities.Statistic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import entities.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class QueueManagementSystemUtilsTest {

    public static boolean checkEqualsStat(Statistic[] expected, Statistic[] actual){
        if (expected.length != actual.length) {
            return false;
        }
        for (int i = 0; i < expected.length; i++) {
            if (expected[i].equals(actual[i]) == false) {
                return false;
            }
        }
        return true;
    }

    public QueueManagementSystem callSomeTickets(int count, String place) {
        QueueManagementSystem result = new QueueManagementSystem (place);
        for (int i = 0; i < count; i++) {
            result.getNextTicket();
        }
        return result;
    }

    public Ticket callGetNextTicket(QueueManagementSystem that, int count) {
        Ticket newTicket = new entities.Ticket();
        for (int i = 0; i < count; i++) {
            newTicket = that.getNextTicket();
        }
        return newTicket;
    }

    public void callNextDays(QueueManagementSystem[] that) {
        for (int i = 0; i < that.length; i++) {
            that[i].toNextWorkDay();
        }
    }

    @Test
    public void calcTotalVisitsShouldReturnResultWhenSomePlacesAreNull() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{
                callSomeTickets(3,null),
                callSomeTickets(2,"Pharmacy"),
                callSomeTickets(4,null),
                callSomeTickets(5,"School")
        };
        long actualResult = QueueManagementSystemUtils.calcTotalVisits(systems);
        Assertions.assertEquals(14, actualResult);
    }

    @Test
    public void calcTotalVisitsShouldReturnResultWhenHaveSomeQueuesAndAllFieldHaveData() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{
                callSomeTickets(9,"CandyShop"),
                callSomeTickets(4,"Pharmacy"),
                callSomeTickets(3,"Gym"),
                callSomeTickets(6,"School")
        };
        long actualResult = QueueManagementSystemUtils.calcTotalVisits(systems);
        Assertions.assertEquals(22, actualResult);
    }

    @Test
    public void calcTotalVisitsShouldReturnZeroWhenThereAreNotTickets() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{
                callSomeTickets(0,"Pharmacy"),
                callSomeTickets(0,"School")
        };
        long actualResult = QueueManagementSystemUtils.calcTotalVisits(systems);
        Assertions.assertEquals(0, actualResult);
    }

    @Test
    public void calcAverageVisitsShouldReturnResultWhenSystemsLengthIsOne() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{callSomeTickets(8,"Pharmacy")};
        double actualResult = QueueManagementSystemUtils.calcAverageVisits(systems);
        Assertions.assertEquals(8, actualResult);
    }

    @Test
    public void calcAverageVisitsShouldReturnZeroWhenSystemsHaveNotElements() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{};
        double actualResult = QueueManagementSystemUtils.calcAverageVisits(systems);
        Assertions.assertEquals(0, actualResult);
    }

    @Test
    public void calcAverageVisitsShouldReturnResultWhenHaveSomeQueuesAndAllFieldHaveData() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{
                callSomeTickets(3,"Administration"),
                callSomeTickets(12,"Pharmacy"),
                callSomeTickets(4,"ConcertHall"),
                callSomeTickets(15,"School")
        };
        double expectedResult = (3.00 +12.00 + 4.00 + 15.00) / 4.00;
        double actualResult = QueueManagementSystemUtils.calcAverageVisits(systems);
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void calcMedianVisitsShouldReturnResultWhenLengthOfSystemsIsOdd() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{
                callSomeTickets(42,"Administration"),
                callSomeTickets(24,"Pharmacy"),
                callSomeTickets(13,"ConcertHall"),
                callSomeTickets(31,"School"),
                callSomeTickets(22,"CandyShop")
        };
        double expectedResult = 24.00;
        double actualResult = QueueManagementSystemUtils.calcMedianVisits(systems);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calcMedianVisitsShouldReturnResultWhenLengthOfSystemsIsEven() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{
                callSomeTickets(8,"Administration"),
                callSomeTickets(14,"Pharmacy"),
                callSomeTickets(9,"ConcertHall"),
                callSomeTickets(6,"School")
        };
        double expectedResult = (8.00 + 9.00) / 2;
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

    @Test
    public void calcMedianVisitsShouldNotSortArrayOfQueuesWhenMethodWasCalled() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{
                callSomeTickets(25,"Administration"),
                callSomeTickets(24,"Pharmacy"),
                callSomeTickets(22,"ConcertHall"),
                callSomeTickets(18,"School")
        };
        QueueManagementSystem[] expectedSystems = new QueueManagementSystem[] {
                systems[0], systems[1], systems[2], systems[3]
        };
        QueueManagementSystemUtils.calcMedianVisits(systems);
        for (int i = 0; i < systems.length; i++) {
            Assertions.assertEquals(expectedSystems[i], systems[i]);
        }
    }

    @Test
    public void calcStatisticByDaysShouldReturnStatisticWhenQueuesHaveEqualCountOfWorkDaysAndSystemsLengthIsOdd() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{
                callSomeTickets(25,"Administration"),
                callSomeTickets(20,"Pharmacy"),
                callSomeTickets(18,"School")
        };
        callNextDays(systems);
        callGetNextTicket(systems[0], 4);
        callGetNextTicket(systems[1], 32);
        callGetNextTicket(systems[2], 8);
        callNextDays(systems);
        callGetNextTicket(systems[0], 42);
        callGetNextTicket(systems[1], 3);
        callGetNextTicket(systems[2], 8);
        Statistic[] actualStatistic = QueueManagementSystemUtils.calcStatisticByDays(systems);
        Statistic[] expectedStatistic = new Statistic[] {
                (new Statistic(18, 25, 63, 21.0, 20.0)),
                (new Statistic(4, 32, 44, 44.0 / 3.0, 8.0)),
                (new Statistic(3, 42,53, 53.0 / 3.0, 8.0))};
        boolean actualResult = QueueManagementSystemUtilsTest.checkEqualsStat(expectedStatistic,actualStatistic);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void calcStatisticByDaysShouldReturnStatisticWhenQueuesAndDaysHaveOneElement() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{callSomeTickets(25,"Administration")};
        Statistic[] actualStatistic = QueueManagementSystemUtils.calcStatisticByDays(systems);
        Statistic[] expectedStatistic = new Statistic[]{(new Statistic(25,25,25,
                25,25))};
        boolean actualResult =QueueManagementSystemUtilsTest.checkEqualsStat(expectedStatistic,actualStatistic);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void calcStatisticByDaysShouldReturnStatisticWhenQueuesHaveOneElementAndDaysHaveSomeElements() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{callSomeTickets(25,"Administration")};
        systems[0].toNextWorkDay();
        callGetNextTicket(systems[0], 32);
        systems[0].toNextWorkDay();
        callGetNextTicket(systems[0], 43);
        systems[0].toNextWorkDay();
        Statistic[] actualStatistic = QueueManagementSystemUtils.calcStatisticByDays(systems);
        Statistic[] expectedStatistic = new Statistic[] {
                (new Statistic(25, 25, 25, 25, 25)),
                (new Statistic(32, 32, 32, 32, 32)),
                (new Statistic(43, 43,43, 43, 43)),
                (new Statistic(0,0,0,0,0))};
        boolean actualResult = QueueManagementSystemUtilsTest.checkEqualsStat(expectedStatistic,actualStatistic);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void calcStatisticByDaysShouldReturnStatisticWhenQueuesHaveNotElements() {
        QueueManagementSystem[] systems = new QueueManagementSystem[]{};
        Statistic[] actualStatistic = QueueManagementSystemUtils.calcStatisticByDays(systems);
        Statistic[] expectedStatistic = new Statistic[]{new Statistic(0, 0,0,0,0)};
        boolean actualResult = QueueManagementSystemUtilsTest.checkEqualsStat(expectedStatistic,actualStatistic);
        Assertions.assertTrue(actualResult);
    }
}