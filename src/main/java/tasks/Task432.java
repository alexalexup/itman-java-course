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
        long [] PrimeNumbers = new long [13];
        int IndexActualPrimeNumbers = 0;
        if (x < 2) {
            long [] actualPrimeNumbers = new long [] {};
            return actualPrimeNumbers;
        }
        for (int i = 2; i < (int)Math.sqrt(x) ; i++) {
            if (x % i == 0) {
                do {
                    x = x / i;
                } while (x % i == 0);
                PrimeNumbers [IndexActualPrimeNumbers] = i;
                IndexActualPrimeNumbers++;
            }
        }
        if (IndexActualPrimeNumbers == 0) {
            long [] actualPrimeNumbers = new long [] {x};
            return actualPrimeNumbers;
        } else {
            if (PrimeNumbers[IndexActualPrimeNumbers-1] < x) {
                PrimeNumbers[IndexActualPrimeNumbers] = x;
            } else {
                IndexActualPrimeNumbers--;
            }
        }
        int n = IndexActualPrimeNumbers + 1;
        long [] ActualPrimeNumbers = new long [n];
        for (int i = 0; i < n; i++) {
            ActualPrimeNumbers[i] = PrimeNumbers[i];
        }
        return ActualPrimeNumbers;
    }
}
