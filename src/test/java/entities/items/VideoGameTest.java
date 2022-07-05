package entities.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class VideoGameTest {
    @Nested
    public class ToString {
        @Test
        public void ShouldReturnStringWithDataFromObject() {
            VideoGame videoGame = new VideoGame(4, "War", 36, 1, 4, "Steam");
            String actualResult = videoGame.toString();
            String expectedResult = "VideoGame{Game{Item{id=4, title='War', price=36}, playersMin=1, playersMax=4}" +
                    ", platform='Steam'}";
            Assertions.assertTrue(actualResult.equals(expectedResult));
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldReturnTrueWhenCompareObjectsHaveEqualLink() {
            VideoGame firstGame = new VideoGame(1,"War", 24, 2, 8, "Steam");
            VideoGame secondGame = firstGame;
            Assertions.assertTrue(firstGame.equals(secondGame));
        }

        @Test
        public void shouldReturnTrueWhenFieldsFromObjectsHaveSameValues() {
            VideoGame firstGame = new VideoGame(1,"War", 24, 2, 8, "Steam");
            VideoGame secondGame = new VideoGame(1,"War", 24, 2, 8, "Steam");
            Assertions.assertTrue(firstGame.equals(secondGame));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromDifferentClassesAndHaveFieldsWithSameValues() {
            Game game = new Game(1, "War" , 24, 2, 4);
            VideoGame videoGame = new VideoGame(1, "War", 24, 2, 4, "Steam");
            Assertions.assertFalse(videoGame.equals(game));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromSameClassesAndHaveDifferentValues() {
            VideoGame firstGame = new VideoGame(1,"War", 24, 2, 8, "Steam");
            VideoGame secondGame = new VideoGame(3,"Fly", 22, 3, 9, "Store");
            Assertions.assertFalse(firstGame.equals(secondGame));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromSameClassesAndHaveOnlyOneDifferentField() {
            VideoGame firstGame = new VideoGame(1,"War", 24, 2, 8, "Steam");
            VideoGame secondGame = new VideoGame(1,"Wwarr", 24, 2, 8, "Steam");
            Assertions.assertFalse(firstGame.equals(secondGame));
        }

        @Test
        public void shouldReturnFalseWhenThatObjectIsNull() {
            VideoGame firstGame = new VideoGame(1,"War", 24, 2, 8, "Steam");
            VideoGame secondGame = null;
            Assertions.assertFalse(firstGame.equals(secondGame));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromSameClassesAndOneFiledIsNull() {
            VideoGame firstGame = new VideoGame(1,"War", 24, 2, 8, "Steam");
            VideoGame secondGame = new VideoGame(1,null, 24, 2, 8, "Steam");
            Assertions.assertFalse(firstGame.equals(secondGame));
        }

        @Test
        public void shouldReturnFalseWhenObjectsFromSameClassesAndSomeFieldsAreNull() {
            VideoGame firstGame = new VideoGame(1,null, 24, 2, 8, null);
            VideoGame secondGame = new VideoGame(1,null, 24, 2, 8, null);
            Assertions.assertFalse(firstGame.equals(secondGame));
        }
    }

}