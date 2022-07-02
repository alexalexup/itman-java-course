package entities.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BoardGameTest {

    @Nested
    public class ToString{
        @Test
        public void ShouldReturnStringWithDataFromObject() {
            BoardGame boardGame = new BoardGame(10,"Rick", 2, 8, 10, 10, 60 );
            String actualResult = boardGame.toString();
            String expectedResult = "BoardGame{Game{Item{id=10, title='Rick', price=2}, playersMin=8, playersMax=10}" +
                                        ", timeMin=10, timeMax=60}";
            Assertions.assertTrue(actualResult.equals(expectedResult));
        }
    }

}