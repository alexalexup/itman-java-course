package tasks;

public class task406 {
    //Напишите функцию, которая принимает массив из целых чисел.
    //Возвращает второй по максимальности элемент.
    public static int findSecondMax (int[] a ) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        if (a.length == 1) {
            return a[0];
        }
        for (int i = 0; i < a.length; i++) {
            if ( max <= a[i]) {
                max2 =max;
                max = a[i];
            } else if (max2 < a[i]) {
                max2 = a[i];
            }
        }
        return max2;
    }


}
