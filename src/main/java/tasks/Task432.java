package tasks;

public class Task432 {
    /**
     * Calculation unique prime numbers
     * @ram O(sqrt(x))
     * @cpu 0(sqrt(x))
     * @param x argument
     * @return actual array with unique  prime numbers
     */
    public static long[] calcPrimeNumbers( long x) {
        int maxCountPrimeNumbers = (int)Math.sqrt(x) + 1; // максимальное количество простых делителей
        int maxValuePrimeNumber = 0; // максимальное значение простого делителя
        int lastIndexActualPrimeNumbers = 0; //последний индекс + 1 массива PrimeNumbers который не равен 0
        long [] PrimeNumbers = new long [maxCountPrimeNumbers];
        if (x < 2) {
            long [] ActualPrimeNumbers = new long [] {};
            return ActualPrimeNumbers;
        }
        for (int i = 2; i < maxCountPrimeNumbers; i++) {
            if (x % i == 0) {
                x = x / i;
                maxCountPrimeNumbers = (int)Math.sqrt(x) + 1;
                if (i > maxValuePrimeNumber) {
                    maxValuePrimeNumber = i;
                    PrimeNumbers[lastIndexActualPrimeNumbers] = i;
                    lastIndexActualPrimeNumbers++;
                }
                i = 1;
            }
        }
        if (lastIndexActualPrimeNumbers == 0) {
            long [] ActualPrimeNumbers = new long [] {x};
            return ActualPrimeNumbers;
        } else {
            if (PrimeNumbers[lastIndexActualPrimeNumbers -1] < x) {
                PrimeNumbers[lastIndexActualPrimeNumbers] = x;
            } else {
                lastIndexActualPrimeNumbers--;
            }
        }
        int n = lastIndexActualPrimeNumbers + 1;
        long [] ActualPrimeNumbers = new long [n];
        for (int i = 0; i < n; i++) {
            ActualPrimeNumbers[i] = PrimeNumbers[i];
        }
        return ActualPrimeNumbers;
    }
}
