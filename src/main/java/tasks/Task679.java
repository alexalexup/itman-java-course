package tasks;

public class Task679 {
    public static void repSort(int[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            int index = i;
            int min = array[i];
            for(int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }
            int buffer = array[i];
            array[i] = array[index];
            array[index] = buffer;
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int buffer = array[j];
                    array[j] =array[j+1];
                    array[j+1] = buffer;
                }
            }
        }
    }

    public static void countingSort(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i ++) {
            if (array[i] < min) {
                min =array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        int[] count = new int[Math.abs(max - min) +1];
        for (int i = 0; i < array.length; i ++) {
            int index = array[i] - min;
            count[index]++;
        }
        for (int i = 0, k = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                array[k] = i + min;
                k++;
            }
        }
    }
}
