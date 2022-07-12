package tasks;

import entities.Statistic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LinkedQueueManagementSystemUtilsTest {

    public static void checkEqualsStat(Statistic[] expected, Statistic[] actual){
        Assertions.assertTrue(expected.length == actual.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertTrue(expected[i].equals(actual[i]));
        }
    }

    public QueueManagementSystem callSomeTickets(String place, int... count) {
        QueueManagementSystem result = new QueueManagementSystem (place);
        for (int i = 0; i < count[0]; i++) {
            result.getNextTicket();
        }
        for (int i = 1; i < count.length; i++) {
            result.toNextWorkDay();
            for (int j = 0; j < count[i]; j++) {
                result.getNextTicket();
            }
        }
        return result;
    }

    @Nested
    public class CalcTotalVisits {
        @Test
        public void shouldReturnResultWhenSomePlacesAreNull() {
            QueueManagementSystem[] systems = new QueueManagementSystem[]{
                    callSomeTickets(null, 3),
                    callSomeTickets("Pharmacy", 2),
                    callSomeTickets(null, 4),
                    callSomeTickets("School", 5)
            };
            long actualResult = QueueManagementSystemUtils.calcTotalVisits(systems);
            Assertions.assertEquals(14, actualResult);
        }

        @Test
        public void shouldReturnResultWhenQueueHaveSomeDays() {
            QueueManagementSystem queue = callSomeTickets("bank", 3, 10, 0, 2);
            int actualResult = queue.getTotalTickets();
            Assertions.assertEquals(15,actualResult);
        }

        @Test
        public void shouldReturnResultWhenHaveSomeQueuesAndAllFieldHaveData() {
            QueueManagementSystem[] systems = new QueueManagementSystem[]{
                    callSomeTickets("CandyShop", 9, 3, 4),
                    callSomeTickets("Pharmacy", 4, 4),
                    callSomeTickets("Gym", 3, 2, 2),
                    callSomeTickets("School", 6, 4)
            };
            long actualResult = QueueManagementSystemUtils.calcTotalVisits(systems);
            Assertions.assertEquals(41, actualResult);
        }

        @Test
        public void shouldReturnZeroWhenThereAreNotTickets() {
            QueueManagementSystem[] systems = new QueueManagementSystem[]{
                    callSomeTickets("Pharmacy", 0, 0, 0),
                    callSomeTickets("School", 0, 0)
            };
            long actualResult = QueueManagementSystemUtils.calcTotalVisits(systems);
            Assertions.assertEquals(0, actualResult);
        }
    }

    @Nested
    public class CalcAverageVisits {
        @Test
        public void shouldReturnResultWhenSystemsLengthIsOne() {
            QueueManagementSystem[] systems = new QueueManagementSystem[]{callSomeTickets("Pharmacy", 8)};
            double actualResult = QueueManagementSystemUtils.calcAverageVisits(systems);
            Assertions.assertEquals(8, actualResult);
        }

        @Test
        public void shouldReturnZeroWhenSystemsHaveNotElements() {
            QueueManagementSystem[] systems = new QueueManagementSystem[]{};
            double actualResult = QueueManagementSystemUtils.calcAverageVisits(systems);
            Assertions.assertEquals(0, actualResult);
        }

        @Test
        public void shouldReturnResultWhenHaveSomeQueuesAndAllFieldHaveData() {
            QueueManagementSystem[] systems = new QueueManagementSystem[]{
                    callSomeTickets("Administration", 3, 2),
                    callSomeTickets("Pharmacy", 12, 6),
                    callSomeTickets("ConcertHall", 4, 7),
                    callSomeTickets("School", 15, 8)
            };
            double expectedResult = 57.00 / 4.00;
            double actualResult = QueueManagementSystemUtils.calcAverageVisits(systems);
            Assertions.assertEquals(expectedResult,actualResult);
        }
    }

    @Nested
    public class CalcMedianVisits {
        @Test
        public void shouldReturnResultWhenLengthOfSystemsIsOdd() {
            QueueManagementSystem[] systems = new QueueManagementSystem[]{
                    callSomeTickets("Administration", 42, 25),
                    callSomeTickets("Pharmacy", 24, 8),
                    callSomeTickets("ConcertHall", 13, 5),
                    callSomeTickets("School", 31, 6),
                    callSomeTickets("CandyShop", 22, 7)
            };
            double actualResult = QueueManagementSystemUtils.calcMedianVisits(systems);
            Assertions.assertEquals(32, actualResult);
        }

        @Test
        public void shouldReturnResultWhenLengthOfSystemsIsEven() {
            QueueManagementSystem[] systems = new QueueManagementSystem[]{
                    callSomeTickets("Administration", 8, 4),
                    callSomeTickets("Pharmacy", 14, 5),
                    callSomeTickets("ConcertHall", 9, 8),
                    callSomeTickets("School", 6, 3)
            };
            double actualResult = QueueManagementSystemUtils.calcMedianVisits(systems);
            Assertions.assertEquals(14.5, actualResult);
        }

        @Test
        public void shouldReturnZeroWhenSystemsHaveNotElements() {
            QueueManagementSystem[] systems = new QueueManagementSystem[]{};
            double expectedResult = 0;
            double actualResult = QueueManagementSystemUtils.calcMedianVisits(systems);
            Assertions.assertEquals(expectedResult, actualResult);
        }

        @Test
        public void shouldNotSortArrayOfQueuesWhenMethodWasCalled() {
            QueueManagementSystem[] systems = new QueueManagementSystem[]{
                    callSomeTickets("Administration", 25),
                    callSomeTickets("Pharmacy", 24),
                    callSomeTickets("ConcertHall", 22),
                    callSomeTickets("School", 18)
            };
            QueueManagementSystem[] expectedSystems = new QueueManagementSystem[] {
                    systems[0], systems[1], systems[2], systems[3]
            };
            QueueManagementSystemUtils.calcMedianVisits(systems);
            for (int i = 0; i < systems.length; i++) {
                Assertions.assertEquals(expectedSystems[i], systems[i]);
            }
        }
    }

    @Nested
    public class CalcStatisticByDays {
        @Test
        public void shouldReturnStatisticWhenQueuesHaveEqualCountOfWorkDaysAndSystemsLengthIsOdd() {
            QueueManagementSystem[] systems = new QueueManagementSystem[]{
                    callSomeTickets("Administration", 25, 4, 42),
                    callSomeTickets("Pharmacy", 20, 32, 3),
                    callSomeTickets("School", 18, 8, 8)
            };
            Statistic[] actualStatistic = QueueManagementSystemUtils.calcStatisticByDays(systems);
            Statistic[] expectedStatistic = new Statistic[] {
                    (new Statistic(18, 25, 63, 21.0, 20.0)),
                    (new Statistic(4, 32, 44, 44.0 / 3.0, 8.0)),
                    (new Statistic(3, 42,53, 53.0 / 3.0, 8.0))};
            LinkedQueueManagementSystemUtilsTest.checkEqualsStat(expectedStatistic,actualStatistic);
        }

        @Test
        public void shouldReturnStatisticWhenQueuesAndDaysHaveOneElement() {
            QueueManagementSystem[] systems = new QueueManagementSystem[]{callSomeTickets("Administration", 25)};
            Statistic[] actualStatistic = QueueManagementSystemUtils.calcStatisticByDays(systems);
            Statistic[] expectedStatistic = new Statistic[]{(new Statistic(25, 25, 25,
                    25, 25))};
            LinkedQueueManagementSystemUtilsTest.checkEqualsStat(expectedStatistic,actualStatistic);
        }

        @Test
        public void shouldReturnStatisticWhenQueuesHaveOneElementAndDaysHaveSomeElements() {
            QueueManagementSystem[] systems = new QueueManagementSystem[]{callSomeTickets("Administration"
                    , 25, 32, 43, 0)};

            Statistic[] actualStatistic = QueueManagementSystemUtils.calcStatisticByDays(systems);
            Statistic[] expectedStatistic = new Statistic[] {
                    (new Statistic(25, 25, 25, 25, 25)),
                    (new Statistic(32, 32, 32, 32, 32)),
                    (new Statistic(43, 43, 43, 43, 43)),
                    (new Statistic(0, 0, 0, 0, 0))};
            LinkedQueueManagementSystemUtilsTest.checkEqualsStat(expectedStatistic,actualStatistic);
        }

        @Test
        public void shouldReturnStatisticWhenQueuesHaveNotElements() {
            QueueManagementSystem[] systems = new QueueManagementSystem[]{};
            Statistic[] actualStatistic = QueueManagementSystemUtils.calcStatisticByDays(systems);
            Statistic[] expectedStatistic = new Statistic[]{};
            LinkedQueueManagementSystemUtilsTest.checkEqualsStat(expectedStatistic,actualStatistic);
        }

        @Test
        public void shouldReturnStatisticWhenQueuesHaveDifferentCountOfDays() {
            QueueManagementSystem[] systems = new QueueManagementSystem[]{
                    callSomeTickets("Administration", 7, 3, 5),
                    callSomeTickets("Pharmacy", 4, 2),
                    callSomeTickets("School", 6)
            };
            Statistic[] actualStatistic = QueueManagementSystemUtils.calcStatisticByDays(systems);
            Statistic[] expectedStatistic = new Statistic[] {
                    (new Statistic(7, 7, 7, 7, 7)),
                    (new Statistic(3, 4, 7, 3.5, 3.5)),
                    (new Statistic(2, 6,13, 13.0 / 3.0, 5.0))};
            LinkedQueueManagementSystemUtilsTest.checkEqualsStat(expectedStatistic,actualStatistic);
        }

        @Test
        public void shouldReturnStatisticWhenQueuesHaveDifferentCountOfDaysAndOneDayHaveNotTickets() {
            QueueManagementSystem[] systems = new QueueManagementSystem[]{
                    callSomeTickets("Administration", 1, 2, 3, 4),
                    callSomeTickets("Pharmacy", 0, 1),
                    callSomeTickets("School", 5, 10, 7)
            };
            Statistic[] actualStatistic = QueueManagementSystemUtils.calcStatisticByDays(systems);
            Statistic[] expectedStatistic = new Statistic[]{
                    (new Statistic(1, 1, 1, 1.0, 1.0)),
                    (new Statistic(2, 5, 7, 3.5, 3.5)),
                    (new Statistic(0, 10, 13, 13.0 / 3.0, 3.0)),
                    (new Statistic(1, 7, 12, 4.0, 4.0))};
            LinkedQueueManagementSystemUtilsTest.checkEqualsStat(expectedStatistic, actualStatistic);
        }
    }
}