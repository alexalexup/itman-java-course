package tasks;

public class Task407 {
    // Нужно отсортировать строки в порядке убывания суммы элементов строк.
    public static void sortMatrixRowsDesc(int[][] matrix) {
       int [] key = new int [matrix.length];
       for (int i = 0; i < matrix.length; i++) {
           for (int j = 0; j < matrix[i].length; j++) {
               key [i] = key[i] + matrix[i][j];
           }
       }
       for (int i = matrix.length; i > 1; i--) {
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

