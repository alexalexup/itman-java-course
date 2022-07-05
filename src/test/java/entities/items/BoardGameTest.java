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

    @Nested
    public class Equals{
        @Test
        public void shouldReturnTrueWhenCompareObjectsHaveEqualLink() {
            BoardGame firstGame = new BoardGame(1,"Ri", 34, 2, 8, 3,10);
            BoardGame secondGame = firstGame;
            Assertions.assertTrue(firstGame.equals(secondGame));
        }

        @Test
        public void shouldReturnTrueWhenFieldsFromObjectsHaveSameValues() {
            BoardGame firstGame = new BoardGame(1,"Ri", 34, 2, 8, 3,10);
            BoardGame secondGame = new BoardGame(1,"Ri", 34, 2, 8, 3,10);
            Assertions.assertTrue(firstGame.equals(secondGame));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromDifferentClassesAndHaveFieldsWithSameValues() {
            Item item = new Item(1,"Rick", 34);
            BoardGame game = new BoardGame(1,"Ri", 34, 2, 8, 3,10);
            Assertions.assertFalse(game.equals(item));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromSameClassesAndHaveDifferentValues() {
            BoardGame firstGame = new BoardGame(1,"Ri", 34, 2, 8, 3,10);
            BoardGame secondGame = new BoardGame(2,"TTT", 3, 3, 9, 1,15);
            Assertions.assertFalse(firstGame.equals(secondGame));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromSameClassesAndHaveOnlyOneDifferentField() {
            BoardGame firstGame = new BoardGame(1,"Ri", 34, 2, 8, 3,10);
            BoardGame secondGame = new BoardGame(2,"Ri", 34, 2, 8, 3,10);
            Assertions.assertFalse(firstGame.equals(secondGame));
        }

        @Test
        public void shouldReturnFalseWhenThatObjectIsNull() {
            BoardGame firstGame = new BoardGame(1,"Ri", 34, 2, 8, 3,10);
            BoardGame secondGame = null;
            Assertions.assertFalse(firstGame.equals(secondGame));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromSameClassesAndOneFiledIsNull() {
            BoardGame firstGame = new BoardGame(1,null, 34, 2, 8, 3,10);
            BoardGame secondGame = new BoardGame(1,"Ri", 34, 2, 12, 3,10);
            Assertions.assertFalse(firstGame.equals(secondGame));
        }

        @Test
        public void shouldReturnTrueWhenObjectsFromSameClassesAndSomeFieldsAreNull() {
            BoardGame firstGame = new BoardGame(1,null, 34, 2, 12, 3,10);
            BoardGame secondGame = new BoardGame(1,null, 34, 2, 12, 3,10);
            Assertions.assertTrue(firstGame.equals(secondGame));
        }
    }
}