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

}