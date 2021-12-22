package tasks;

public class Task432 {
    /**
     * Calculation unique prime numbers
     * @cpu 0(sqrt(x))
     * @ram O(1)
     * @param x argument
     * @return actual array with unique  prime numbers
     */
    public static long[] calcPrimeNumbers( long x) {
        long [] primeNumbers = new long [13];
        int indexActualPrimeNumbers = 0;
        if (x < 2) {
            long [] actualPrimeNumbers = new long [] {};
            return actualPrimeNumbers;
        }
        for (int i = 2; i < (int)Math.sqrt(x) ; i++) {
            if (x % i == 0) {
                do {
                    x = x / i;
                } while (x % i == 0);
                primeNumbers [indexActualPrimeNumbers] = i;
                indexActualPrimeNumbers++;
            }
        }
        if (indexActualPrimeNumbers == 0) {
            long [] actualPrimeNumbers = new long [] {x};
            return actualPrimeNumbers;
        } else {
            if (primeNumbers[indexActualPrimeNumbers-1] < x) {
                primeNumbers[indexActualPrimeNumbers] = x;
            } else {
                indexActualPrimeNumbers--;
            }
        }
        int n = indexActualPrimeNumbers + 1;
        long [] actualPrimeNumbers = new long [n];
        for (int i = 0; i < n; i++) {
            actualPrimeNumbers[i] = primeNumbers[i];
        }
        return actualPrimeNumbers;
    }
}
