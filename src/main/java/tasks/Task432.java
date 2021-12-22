package tasks;

public class Task432 {
    /**
     * Calculation unique prime numbers
     * @cpu 0(sqrt(x))
     * @ram O(sqrt(x))
     * @param x argument
     * @return actual array with unique  prime numbers
     */
    public static long[] calcPrimeNumbers( long x) {
        int maxCountPrimeNumbers = (int)Math.sqrt(x) + 1;
        int maxValuePrimeNumber = 0;
        int lastIndexActualPrimeNumbers = 0;
        long [] PrimeNumbers = new long [maxCountPrimeNumbers];
        if (x < 2) {
            long [] actualPrimeNumbers = new long [] {};
            return actualPrimeNumbers;
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
            long [] actualPrimeNumbers = new long [] {x};
            return actualPrimeNumbers;
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
