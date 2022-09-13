package services.example;

public enum Mth {
    PLUS() {
        /**
         * Do math operation plus with two arguments
         * @cpu O(1)
         * @ram O(1)
         * @param term1 argument
         * @param term2 argument
         * @return  the result of addition of two arguments
         */
        @Override
        public double calculate(double term1, double term2) {
            return term1 + term2;
        }
    },
    MINUS() {
        /**
         * Do math operation minus with two arguments
         * @cpu O(1)
         * @ram O(1)
         * @param term1 argument
         * @param term2 argument
         * @return  the result of  subtraction of two arguments
         */
        @Override
        public double calculate(double term1, double term2) {
            return term1 - term2;
        }
    },
    MULTIPLY() {
        /**
         * Do math operation multiply with two arguments
         * @cpu O(1)
         * @ram O(1)
         * @param term1 argument
         * @param term2 argument
         * @return  the result of  multiplication of two arguments
         */
        @Override
        public double calculate(double term1, double term2) {
            return term1 * term2;
        }
    },
    DIVIDE() {
        /**
         * Do math operation multiply with two arguments
         * @cpu O(1)
         * @ram O(1)
         * @param term1 argument
         * @param term2 argument
         * @return  the result of  dividing of two arguments
         */
        @Override
        public double calculate(double term1, double term2) {
            return term1 / term2;
        }
    };

    /**
     * The method is created to override depending on the value of enum
     * @cpu O(1)
     * @ram O(1)
     * @param term1 argument
     * @param term2 argument
     */
    public abstract double calculate(double term1, double term2);
}
