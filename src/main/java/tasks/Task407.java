package tasks;

public class Task407 {
    /**
     * Sorting array rows in decreasing order of the sum of row elements
     * @ram O(n)
     * @cpu O(n*m + n^2)
     * @param matrix array with numbers
     */
    public static void sortMatrixRowsDesc(int[][] matrix) {
       int n = matrix.length;
       int m = matrix[0].length;
       int [] key = new int [n];
       for (int i = 0; i < n; i++) {
           for (int j = 0; j < m; j++) {
               key [i] = key[i] + matrix[i][j];
           }
       }
       for (int i = n; i > 1; i--) {
           for (int j = 1; j < i; j++) {
               if (key[j-1] < key[j]) {
                   int a = key[j-1];
                   int [] b = matrix[j-1];
                   key[j-1] = key[j];
                   matrix [j-1] = matrix[j];
                   key[j] = a;
                   matrix[j] = b;
               }
           }
       }
    }
}

