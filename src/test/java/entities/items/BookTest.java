package entities.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BookTest {
    @Nested
    public class ToString{
        @Test
        public void ShouldReturnStringWithDataFromBookObject(){
            Book book =  new Book(1,"Books",36, "Jack", 128);
            String actualResult = book.toString();
            String expectedResult = "Book{Item{id=1, title='Books', price=36}, author='Jack', pages=128}";
            Assertions.assertTrue(actualResult.equals(expectedResult));
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldReturnTrueWhenCompareObjectsHaveEqualLink() {
            Book firstBook = new Book(1,"Harry", 34, "Rick" , 128);
            Book secondBook = firstBook;
            Assertions.assertTrue(firstBook.equals(secondBook));
        }

        @Test
        public void shouldReturnTrueWhenFieldsFromObjectsHaveSameValues() {
            Book firstBook = new Book(1,"Harry", 34, "Rick" , 128);
            Book secondBook = new Book(1,"Harry", 34, "Rick" , 128);
            Assertions.assertTrue(firstBook.equals(secondBook));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromDifferentClassesAndHaveFieldsWithSameValues() {
            Item item = new Item(1,"Chess", 34);
            Book book = new Book(1, "Chess", 34, "Hoking", 32);
            Assertions.assertFalse(book.equals(item));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromSameClassesAndHaveDifferentValues() {
            Book firstBook = new Book(2,"Potter", 36, "Ann" , 300);
            Book secondBook = new Book(1,"Harry", 34, "Rick" , 128);
            Assertions.assertFalse(firstBook.equals(secondBook));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromSameClassesAndHaveOnlyOneDifferentField() {
            Book firstBook = new Book(2,"Potter", 45, "Ann" , 300);
            Book secondBook = new Book(3,"Potter", 45, "Ann" , 300);
            Assertions.assertFalse(firstBook.equals(secondBook));
        }

        @Test
        public void shouldReturnFalseWhenThatObjectIsNull() {
            Book firstBook = new Book(2,"Potter", 36, "Ann" , 300);
            Book secondBook = null;
            Assertions.assertFalse(firstBook.equals(secondBook));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromSameClassesAndOneFiledIsNull() {
            Book firstBook = new Book(2,"Potter", 36, null , 300);
            Book secondBook = new Book(2,"Potter", 45, "Ann" , 300);
            Assertions.assertFalse(firstBook.equals(secondBook));
        }

        @Test
        public void shouldReturnTrueWhenObjectsFromSameClassesAndSomeFieldsAreNull() {
            Book firstBook = new Book(2,"Potter", 36, null , 300);
            Book secondBook = new Book(2,"Potter", 36, null , 300);
            Assertions.assertTrue(firstBook.equals(secondBook));
        }

        @Test
        public void shouldReturnTrueWhenObjectsFromSameClassesAndFieldsWithLinksTypeAreNull() {
            Book firstBook = new Book(2,null, 36, null , 300);
            Book secondBook = new Book(2,null, 36, null , 300);
            Assertions.assertTrue(firstBook.equals(secondBook));
        }
    }

}