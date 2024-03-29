package benchmarks;


public class StringBuilderBenchmark {

    /**
     * Adds two characters from string to the current string n times
     * @cpu O(n^2)
     * @ram O(n)
     * @param n argument
     * return string with data after сoncatenation
     */
    public static String concatenateUsingOperator(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += " " + i % 10;
        }
        return result;
    }

    /**
     * Adds two characters from string to the current string n times
     * @cpu O(n)
     * @ram O(n)
     * @param n argument
     * return string with data after сoncatenation
     */
    public static String concatenateUsingStringBuilder(int n) {
        StringBuilder result = new StringBuilder().append("");
        for (int i = 0; i < n; i++) {
            result.append(" " + i % 10);
        }
        return result.toString();
    }

    //concatenateUsingOperator takes 38,72 sec when n is 500 000
    //concatenateUsingStringBuilder takes 0,05 sec when n is 500 000
    public static void main(String[] args) {
        long firstTime = System.currentTimeMillis();
        concatenateUsingOperator(500);
        long  secondTime = System.currentTimeMillis();
        concatenateUsingStringBuilder(500);
        long  thirdTime = System.currentTimeMillis();
        System.out.println("concatenateUsingOperator takes " + (secondTime - firstTime) + "ms");
        System.out.println("concatenateUsingStringBuilder " + (thirdTime - secondTime) + " ms");
    }
}
