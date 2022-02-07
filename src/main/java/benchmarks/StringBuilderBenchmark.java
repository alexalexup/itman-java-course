package benchmarks;


public class StringBuilderBenchmark {

    public static String concatenateUsingOperator(int n) {
        String result = " ";
        for (int i = 0; i < n; i++) {
            result += " " + i % 10;
        }
        return result;
    }

    public static String concatenateUsingStringBuilder(int n) {
        StringBuilder result = new StringBuilder().append(" ");
        for (int i = 0; i < n; i++) {
            result.append(" " + i % 10);
        }
        return result.toString();
    }

    //concatenateUsingOperator takes 39,06 sec
    //concatenateUsingStringBuilder takes 0,07 sec
    public static void main(String[] args) {
        double firstTime = System.currentTimeMillis();
        concatenateUsingOperator(500000);
        double secondTime = System.currentTimeMillis();
        concatenateUsingStringBuilder(500000);
        double thirdTime = System.currentTimeMillis();
        System.out.println("concatenateUsingOperator takes " + (secondTime - firstTime) + "ms");
        System.out.println("concatenateUsingStringBuilder " + (thirdTime - secondTime) + " ms");
    }
}
