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

    @Nested
    public class Equals {
        @Test
        public void shouldReturnTrueWhenCompareObjectsHaveEqualLink() {
            Game firstGame = new Game(1,"Rick", 34, 2, 8);
            Game secondGame = firstGame;
            Assertions.assertTrue(firstGame.equals(secondGame));
        }

        @Test
        public void shouldReturnTrueWhenFieldsFromObjectsHaveSameValues() {
            Game firstGame = new Game(1,"Rick", 34, 2, 8);
            Game secondGame = new Game(1,"Rick", 34, 2, 8);
            Assertions.assertTrue(firstGame.equals(secondGame));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromDifferentClassesAndHaveFieldsWithSameValues() {
            Item item = new Item(1,"Rick", 34);
            Game game = new Game(1, "Rick", 34, 2, 8);
            Assertions.assertFalse(game.equals(item));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromSameClassesAndHaveDifferentValues() {
            Game firstGame = new Game(1,"Rick", 34, 2, 8);
            Game secondGame = new Game(2,"Bug", 31, 4, 16);
            Assertions.assertFalse(firstGame.equals(secondGame));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromSameClassesAndHaveOnlyOneDifferentField() {
            Game firstGame = new Game(1,"Rick", 34, 2, 8);
            Game secondGame = new Game(2,"Rick", 34, 2, 8);
            Assertions.assertFalse(firstGame.equals(secondGame));
        }

        @Test
        public void shouldReturnFalseWhenThatObjectIsNull() {
            Game firstGame = new Game(1,"Rick", 34, 2, 8);
            Game secondGame = null;
            Assertions.assertFalse(firstGame.equals(secondGame));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromSameClassesAndOneFiledIsNull() {
            Game firstGame = new Game(1,null, 34, 2, 8);
            Game secondGame = new Game(1,"Rick", 36, 2, 8);
            Assertions.assertFalse(firstGame.equals(secondGame));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromSameClassesAndSomeFieldsAreNull() {
            Game firstGame = new Game(1,null, 34, 2, 8);
            Game secondGame = new Game(1,null, 34, 2, 8);
            Assertions.assertFalse(firstGame.equals(secondGame));
        }
    }
}