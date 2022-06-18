package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import entities.Event;


class EventListTest {

    private void compareEvents(Event[] first, Event[] second) {
        Assertions.assertEquals(first.length, second.length);
        for (int i = 0; i < first.length; i++) {
            Assertions.assertTrue(first[i].equals(second[i]));
        }
    }

    private void add(EventList list, Event[] events) {
        for (int i = 0; i < events.length; i++ ) {
            list.addEvent(events[i]);
        }
    }

    @Nested
    public class Add {
        @Test
        public void shouldAddEventsToCurrentObjectWhenObjectHaveNotData() {
            EventList list = new EventList();
            Event[] expectedEvents = new Event[] { new Event( 2022,8,4, "A"),
                    new Event(2021, 8, 4, "B"),
                    new Event(2019, 4, 16, "C"),
                    new Event(2022, 12, 6, "D"),
                    new Event(2017, 5, 5, "E"),
                    new Event(2023, 4, 21, "J")
            };
            add(list, expectedEvents);
            Event[] actualEvents = list.getAllEvents();
            compareEvents(expectedEvents, actualEvents);
        }
    }

    @Nested
    public class Remove {
        @Test
        public void shouldDeleteEventByIdWhenObjectHaveInputId() {
            EventList list = new EventList();
            Event[] events = new Event[] { new Event( 2022,8,4, "A"),
                    new Event(2021, 8, 4, "B"),
                    new Event(2019, 4, 16, "C"),
                    new Event(2022, 12, 6, "D")
            };
            add(list, events);
            list.remove(3);
            Event[] actualEvents = list.getAllEvents();
            Event[] expectedEvents = new Event[] { new Event( 1,2022,8,4, "A"),
                    new Event(2,2021, 8, 4, "B"),
                    new Event(4,2022, 12, 6, "D")
            };
            compareEvents(expectedEvents, actualEvents);
        }

        @Test
        public void shouldNotDeleteEventWhenObjectHaveNotInputId() {
            EventList list = new EventList();
            Event[] events = new Event[] { new Event( 2022,8,4, "A"),
                    new Event(2021, 8, 4, "B"),
                    new Event(2019, 4, 16, "C"),
                    new Event(2022, 12, 6, "D")
            };
            add(list, events);
            list.remove(6);
            Event[] actualEvents = list.getAllEvents();
            Event[] expectedEvents = new Event[] {new Event( 1,2022,8,4, "A"),
                    new Event(2,2021, 8, 4, "B"),
                    new Event(3,2019, 4, 16, "C"),
                    new Event(4,2022, 12, 6, "D")
            };
            compareEvents(expectedEvents, actualEvents);
        }
    }

    @Nested
    public class Edit {
        @Test
        public void shouldEditEventListObjectWhenObjectHaveInputId() {
            EventList list = new EventList();
            Event[] events = new Event[]{new Event(2022, 8, 4, "A"),
                    new Event(2021, 8, 4, "B"),
                    new Event(2019, 4, 16, "C"),
                    new Event(2022, 12, 6, "D")
            };
            add(list, events);
            Event newEvent = new Event(2014, 3, 24, "Good day");
            list.edit(3, newEvent);
            Event[] actualEvents = list.getAllEvents();
            Event[] expectedEvents = new Event[]{new Event(1, 2022, 8, 4, "A"),
                    new Event(2, 2021, 8, 4, "B"),
                    new Event(3, 2014, 3, 24, "Good day"),
                    new Event(4, 2022, 12, 6, "D")
            };
            compareEvents(expectedEvents, actualEvents);
        }

        @Test
        public void shouldNotEditEventListObjectWhenObjectHaveNotInputId() {
            EventList list = new EventList();
            Event[] events = new Event[]{new Event(2022, 8, 4, "A"),
                    new Event(2021, 8, 4, "B"),
                    new Event(2019, 4, 16, "C"),
                    new Event(2022, 12, 6, "D")
            };
            add(list, events);
            Event newEvent = new Event(2014, 3, 24, "Good day");
            list.edit(12, newEvent);
            Event[] actualEvents = list.getAllEvents();
            Event[] expectedEvents = new Event[]{new Event(1, 2022, 8, 4, "A"),
                    new Event(2, 2021, 8, 4, "B"),
                    new Event(3, 2019, 4, 16, "C"),
                    new Event(4, 2022, 12, 6, "D")
            };
            compareEvents(expectedEvents, actualEvents);
        }
    }

    @Nested
    public class GetEvent {
        @Test
        public void shouldReturnEventByIdFromEventListWhenIdIs() {
            EventList list = new EventList();
            Event[] events = new Event[] { new Event( 2022,8,4, "A"),
                    new Event(2021, 8, 4, "B"),
                    new Event(2019, 4, 16, "C"),
                    new Event(2022, 12, 6, "D")
            };
            add(list, events);
            Event actualEvent = list.getEvent(2);
            Event expectedEvent = new Event(2, 2021, 8, 4, "B" );
            Assertions.assertTrue(actualEvent.equals(expectedEvent));
        }

        @Test
        public void shouldNotReturnEventByIdFromEventListWhenIdIsNot() {
            EventList list = new EventList();
            Event[] events = new Event[] { new Event( 2022,8,4, "A"),
                    new Event(2021, 8, 4, "B"),
                    new Event(2019, 4, 16, "C"),
                    new Event(2022, 12, 6, "D")
            };
            add(list, events);
            Event actualEvent = list.getEvent(8);
            Assertions.assertEquals(actualEvent, null);
        }

        @Test
        public void shouldReturnAllEventWhenMethodWasCalled() {
            EventList list = new EventList();
            Event[] events = new Event[] { new Event( 2022,8,4, "Abc"),
                    new Event(2022, 8, 4, "Abb"),
                    new Event(2022, 8, 4, "Bf"),
                    new Event(2021, 12, 6, "Drc"),
                    new Event(2020, 5, 22, "Dra"),
                    new Event(2021, 12, 3, "Dre")
            };
            add(list, events);
            Event[] actualEvents = list.getAllEvents();
            Event[] expectedEvents = new Event[] { new Event( 1,2022,8,4, "Abc"),
                    new Event(2,2022, 8, 4, "Abb"),
                    new Event(3,2022, 8, 4, "Bf"),
                    new Event(4,2021, 12, 6, "Drc"),
                    new Event(5, 2020, 5, 22, "Dra"),
                    new Event(6,2021, 12, 3, "Dre")
            };
            compareEvents(expectedEvents, actualEvents);
        }
    }

    @Nested
    public class Sort {
        @Test
        public void shouldSortWhenAllEventsHaveDifferentYears() {
            Event[] actualEvents = new Event[] { new Event( 1,2024,8,4, "Abc"),
                    new Event(2,2019, 8, 4, "Abb"),
                    new Event(3,2021, 8, 4, "Bf"),
                    new Event(4,2025, 12, 6, "Drc"),
                    new Event(5,2022, 5, 22, "Dra"),
                    new Event(6,2018, 12, 3, "Dre")
            };
            EventList.sortEvents(actualEvents);
            Event[] expectedEvents =new Event[] { new Event( 6,2018, 12, 3, "Dre"),
                    new Event(2,2019, 8, 4, "Abb"),
                    new Event(3,2021, 8, 4, "Bf"),
                    new Event(5,2022, 5, 22, "Dra"),
                    new Event(1,2024,8,4, "Abc"),
                    new Event(4,2025, 12, 6, "Drc")
            };
            compareEvents(expectedEvents, actualEvents);
        }

        @Test
        public void shouldSortWhenSomeEventsHaveSameYears() {
            Event[] actualEvents = new Event[] { new Event( 1,2024,8,4, "Abc"),
                    new Event(2,2019, 8, 4, "Abb"),
                    new Event(3,2021, 8, 4, "Bf"),
                    new Event(4,2024, 1, 6, "Drc"),
                    new Event(5,2024, 2, 22, "Dra"),
                    new Event(6,2018, 12, 3, "Dre")
            };
            EventList.sortEvents(actualEvents);
            Event[] expectedEvents =new Event[] { new Event( 6,2018, 12, 3, "Dre"),
                    new Event(2,2019, 8, 4, "Abb"),
                    new Event(3,2021, 8, 4, "Bf"),
                    new Event(4,2024, 1, 6, "Drc"),
                    new Event(5,2024, 2, 22, "Dra"),
                    new Event(1,2024,8,4, "Abc")
            };
            compareEvents(expectedEvents, actualEvents);
        }

        @Test
        public void shouldSortWhenSomeEventsHaveSameYearsAndMonth() {
            Event[] actualEvents = new Event[] { new Event( 1,2024,8,4, "Abc"),
                    new Event(2,2019, 8, 4, "Abb"),
                    new Event(3,2021, 8, 4, "Bf"),
                    new Event(4,2024, 1, 6, "Drc"),
                    new Event(5,2024, 1, 3, "Dra"),
                    new Event(6,2018, 12, 3, "Dre")
            };
            EventList.sortEvents(actualEvents);
            Event[] expectedEvents =new Event[] { new Event( 6,2018, 12, 3, "Dre"),
                    new Event(2,2019, 8, 4, "Abb"),
                    new Event(3,2021, 8, 4, "Bf"),
                    new Event(5,2024, 1, 3, "Dra"),
                    new Event(4,2024, 1, 6, "Drc"),
                    new Event(1,2024,8,4, "Abc")
            };
            compareEvents(expectedEvents, actualEvents);
        }

        @Test
        public void shouldSortWhenSomeEventsHaveSameYearsMonthAndDays() {
            Event[] actualEvents = new Event[] { new Event( 1,2024,8,4, "Abc"),
                    new Event(2,2019, 8, 4, "Abb"),
                    new Event(3,2021, 8, 4, "Bf"),
                    new Event(4,2024, 1, 3, "Abd"),
                    new Event(5,2024, 1, 3, "Abb"),
                    new Event(6,2018, 12, 3, "Dre"),
                    new Event(7,2024,1,  3, "Br")

            };
            EventList.sortEvents(actualEvents);
            Event[] expectedEvents =new Event[] { new Event( 6,2018, 12, 3, "Dre"),
                    new Event(2,2019, 8, 4, "Abb"),
                    new Event(3,2021, 8, 4, "Bf"),
                    new Event(5,2024, 1, 3, "Abb"),
                    new Event(4,2024, 1, 3, "Abd"),
                    new Event(7,2024,1,  3, "Br"),
                    new Event(1,2024,8,4, "Abc")
            };
            compareEvents(expectedEvents, actualEvents);
        }
    }

    @Nested
    public class Filter {
        @Test
        public void shouldSortEventsAndReturnEventsThanIncludeYearFromInputData() {
            Event[] events = new Event[] { new Event( 1,2024,8,4, "Abc"),
                    new Event(2,2019, 8, 4, "Abb"),
                    new Event(3,2021, 8, 4, "Bf"),
                    new Event(4,2024, 1, 6, "Drc"),
                    new Event(5,2024, 1, 3, "Dra"),
                    new Event(6,2018, 12, 3, "Dre")
            };
            Event[] actualEvents = EventList.filterEventsByYear(events,2024);
            Event[] expectedEvents = new Event[] {new Event(5,2024, 1, 3, "Dra"),
                    new Event(4,2024, 1, 6, "Drc"),
                    new Event(1,2024,8,4, "Abc")
            };
            compareEvents(expectedEvents, actualEvents);
        }

        @Test
        public void shouldSortEventsAndReturnEventsThanIncludeYearAndMonthFromInputData() {
            Event[] events = new Event[] { new Event( 1,2024,8,4, "Abc"),
                    new Event(2,2019, 8, 4, "Abb"),
                    new Event(3,2021, 8, 4, "Bf"),
                    new Event(4,2024, 1, 6, "Drc"),
                    new Event(5,2024, 1, 3, "Dra"),
                    new Event(6,2018, 12, 3, "Dre")
            };
            Event[] actualEvents = EventList.filterEventsByYearMonth(events,2024,1);
            Event[] expectedEvents = new Event[] {new Event(5,2024, 1, 3, "Dra"),
                    new Event(4,2024, 1, 6, "Drc")
            };
            compareEvents(expectedEvents, actualEvents);
        }

        @Test
        public void shouldSortEventsAndReturnEventsThanIncludeYearMonthAndDayFromInputData() {
            Event[] events = new Event[] { new Event( 1,2024,1,3, "Abz"),
                    new Event(2,2019, 8, 4, "Abb"),
                    new Event(3,2021, 8, 4, "Bf"),
                    new Event(4,2024, 1, 3, "Abc"),
                    new Event(5,2024, 1, 3, "Abb"),
                    new Event(6,2018, 12, 3, "Dre")
            };
            Event[] actualEvents = EventList.filterEventsByYearMonthDay(events,2024,1,3);
            Event[] expectedEvents = new Event[] {new Event(5,2024, 1, 3, "Abb"),
                    new Event(4,2024, 1, 3, "Abc"),
                    new Event( 1,2024,1,3, "Abz")
            };
            compareEvents(expectedEvents, actualEvents);
        }
    }
}