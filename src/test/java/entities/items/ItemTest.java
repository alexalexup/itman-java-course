package entities.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ItemTest {

    @Nested
    public class ToString{
        @Test
        public void shouldReturnStringWhenObjectHaveData(){
            Item item = new Item(16,"Phones", 36);
            String actualResult = item.toString();
            String expectedResult = "Item{id=16, title='Phones', price=36}";
            Assertions.assertTrue(actualResult.equals(expectedResult));
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldReturnTrueWhenCompareObjectsHaveEqualLink() {
            Item firstItem = new Item(1,"Chess", 34);
            Item secondItem = firstItem;
            Assertions.assertTrue(firstItem.equals(secondItem));
        }

        @Test
        public void shouldReturnTrueWhenFieldsFromObjectsHaveSameValues() {
            Item firstItem = new Item(1,"Chess", 34);
            Item secondItem = new Item(1,"Chess", 34);
            Assertions.assertTrue(firstItem.equals(secondItem));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromDifferentClassesAndHaveFieldsWithSameValues() {
            Item item = new Item(1,"Chess", 34);
            Book book = new Book(1, "Chess", 34, "Hoking", 32);
            Assertions.assertFalse(item.equals(book));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromSameClassesAndHaveDifferentValues() {
            Item firstItem = new Item(3,"Mortal", 12);
            Item secondItem = new Item(1,"Chess", 34);
            Assertions.assertFalse(firstItem.equals(secondItem));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromSameClassesAndHaveOnlyOneDifferentField() {
            Item firstItem = new Item(3,"Mortal", 12);
            Item secondItem = new Item(1,"Mortal", 12);
            Assertions.assertFalse(firstItem.equals(secondItem));
        }

        @Test
        public void shouldReturnFalseWhenThatObjectIsNull() {
            Item firstItem = new Item(3,"Mortal", 12);
            Item secondItem = null;
            Assertions.assertFalse(firstItem.equals(secondItem));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromSameClassesAndOneFiledIsNull() {
            Item firstItem = new Item(1,null, 12);
            Item secondItem = new Item(1,"Mortal", 12);
            Assertions.assertFalse(firstItem.equals(secondItem));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromSameClassesAndSomeFieldsAreNull() {
            Item firstItem = new Item(1,null, 12);
            Item secondItem = new Item(1,null, 12);
            Assertions.assertFalse(firstItem.equals(secondItem));
        }
    }
}