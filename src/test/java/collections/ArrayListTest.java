package collections;

import entities.Event;
import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ArrayListTest {
    @Nested
    public class Add {
        @Test
        public void shouldAddNullToArrayList(){
            ArrayList arrayList = new ArrayList();
            arrayList.add(null);
            arrayList.add(null);
            arrayList.add(null);
            arrayList.add(null);
            arrayList.add(null);
            ArrayList expectedArrayList = ArrayList.of(null, null, null, null, null);
            Assertions.assertEquals(expectedArrayList, arrayList);
        }

        @Test
        public void shouldAddDifferentObjectsToArrayList(){
            ArrayList arrayList = new ArrayList();
            arrayList.add(new IntArrayList());
            arrayList.add(new LinkedList());
            arrayList.add(new IntArrayList());
            arrayList.add(new IntArrayList());
            ArrayList expectedArrayList = ArrayList.of(new IntArrayList()
                    , new LinkedList()
                    , new IntArrayList()
                    , new IntArrayList());
            Assertions.assertEquals(expectedArrayList, arrayList);
        }

        @Test
        public void shouldAddDifferentObjectsWithData() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(IntArrayList.of(1, 2, 3));
            arrayList.add(IntArrayList.of(5, 5, 5));
            arrayList.add(new Ticket(1, "Bank"));
            arrayList.add(new Event(2, 2, 2021, "a"));
            ArrayList expectedArrayList = ArrayList.of(IntArrayList.of(1, 2, 3)
                    , IntArrayList.of(5, 5, 5)
                    , new Ticket(1, "Bank")
                    , new Event(2, 2, 2021, "a"));
            Assertions.assertEquals(expectedArrayList, arrayList);
        }
    }
}