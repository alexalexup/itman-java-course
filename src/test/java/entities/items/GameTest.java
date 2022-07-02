package entities.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameTest {

    @Nested
    public class ToString{
        @Test
        public void ShouldReturnStringWithDataFromObject() {
            Game game = new Game(3,"Monopoly", 125, 4, 12);
            String actualResult = game.toString();
            String expectedResult ="Game{Item{id=3, title='Monopoly', price=125}, playersMin=4, playersMax=12}";
            Assertions.assertTrue(actualResult.equals(expectedResult));
        }
    }

}