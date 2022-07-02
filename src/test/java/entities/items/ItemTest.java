package entities.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ItemTest {
    @Nested
    public class ToString{
        @Test
        public void ShouldReturnStringWhenObjectHaveData(){
            Item item = new Item(16,"Phones", 36);
            String actualResult = item.toString();
            String expectedResult = "Item{id=16, title='Phones', price=36}";
            Assertions.assertTrue(actualResult.equals(expectedResult));
        }

    }

}