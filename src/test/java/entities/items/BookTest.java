package entities.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

}