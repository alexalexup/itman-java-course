package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class Task514Test {

    @Test
    public void solveShouldReturnLastElementFromStackWhenAnyElementsLeftIsTheStack() {
        int[] books = new int[]{1, 2, 3, 4, 5};
        int[] queue = new int[]{2, 4, 4, -1, -1, 3, -1, 2};
        int actualResult = Task514.solve(books, queue);
        Assertions.assertEquals(7,actualResult);
    }

    @Test
    public void solveShouldReturnResultWhenQueueHaveNotElements() {
        int[] books = new int[]{1, 2, 3, 4, 5};
        int[] queue = new int[]{};
        int actualResult = Task514.solve(books, queue);
        Assertions.assertEquals(5,actualResult);
    }

    @Test
    public void solveShouldReturnZeroWhenAllBooksTakesAwayFromStack() {
        int[] books = new int[]{1, 2, 3};
        int[] queue = new int[]{-1, -1, -1};
        int actualResult = Task514.solve(books, queue);
        Assertions.assertEquals(0,actualResult);
    }

    @Test
    public void solveShouldReturnResultWhenAnyBooksAddsToEmptyStack() {
        int[] books = new int[]{};
        int[] queue = new int[]{2, 3, 1};
        int actualResult = Task514.solve(books, queue);
        Assertions.assertEquals(3,actualResult);
    }

    @Test
    public void solveShouldReturnResultWhenAllBooksTakesAwayFromStackAndThanAddAnyBooks() {
        int[] books = new int[]{1, 2, 3};
        int[] queue = new int[]{-1, -1, -1, 2, 4, 5, 5};
        int actualResult = Task514.solve(books, queue);
        Assertions.assertEquals(4,actualResult);
    }
}