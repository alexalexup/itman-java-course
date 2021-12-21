package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task407Test {

    @Test
    public void sortShouldNotChangeMatrixLinksWhenMethodWasCalled() {
        int [][] matrix = new int [][]{
                {4, 3, -26},
                {34, -77, 1},
                {4, 22, 46},
                {0, -3, -4}
        };
        int [][] expectedlinks = new int [][] {matrix[2], matrix[3], matrix[0], matrix[1]};

        Task407.sortMatrixRowsDesc(matrix);
        for (int i = 0; i < matrix.length; i++) {
            Assertions.assertSame(expectedlinks[i], matrix[i]);
        }

    }

    @Test
    public void sortShouldSortMatrixFourRowsWhenMethodWasCalled() {
        int [][] matrix = new int [][]{
                {4, 3, -26},
                {34, -77, 1},
                {4, 22, 46},
                {0, -3, -4}
        };
        int [][] expectedValues = new int [][]{
                {4, 22, 46},
                {0, -3, -4},
                {4, 3, -26},
                {34, -77, 1}
        };
        Task407.sortMatrixRowsDesc(matrix);
        Assertions.assertArrayEquals(expectedValues, matrix);

   }

    @Test
    public void sortShouldSortMatrixThreeSameSumRowsWhenMethodWasCalled() {
        int [][] matrix = new int [][]{
                {1, 2, 3, 4},
                {4, 2, 3, 1},
                {1, 2, 3, 10},
                {4, 3, 2, 1}
        };
        int [][] expectedValues = new int [][]{
                {1, 2, 3, 10},
                {1, 2, 3, 4},
                {4, 2, 3, 1},
                {4, 3, 2, 1}
        };
        Task407.sortMatrixRowsDesc(matrix);
        Assertions.assertArrayEquals(expectedValues, matrix);

    }

    @Test
    public void sortShouldSortMatrixOneRowsWhenMethodWasCalled() {
        int [][] matrix = new int [][]{{1, 2, 3, 4}};
        int [][] expectedValues = new int [][]{{1, 2, 3, 4}};
        int [][] expectedlinks = matrix;
        Task407.sortMatrixRowsDesc(matrix);
        Assertions.assertSame(expectedlinks[0], matrix[0]);
        for (int i = 0; i < matrix.length; i++) {
                Assertions.assertEquals(expectedValues[0][i], matrix[0][i]);

        }
    }

}
