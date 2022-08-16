package services.calculation;

public class Math {
    private static double term1;
    private static  double term2;
    private  Operator operator;
    public enum Operator {
        PLUS () {
            /**
             * Do math operation plus on two numbers
             * @cpu O(1)
             * @ram O(1)
             * @return result plus operation on two numbers
             */
            @Override
            public double calculate() {
                return Math.term1 + Math.term2;
            }
        },
        MINUS () {
            /**
             * Do math operation minus on two numbers
             * @cpu O(1)
             * @ram O(1)
             * @return result minus operation on two numbers
             */
            @Override
            public double calculate() {
                return Math.term1 - Math.term2;
            }
        },
        MULTIPLY () {
            /**
             * Do math operation multiply on two numbers
             * @cpu O(1)
             * @ram O(1)
             * @return result multiply operation on two numbers
             */
            @Override
            public double calculate() {
                return Math.term1 * Math.term2;
            }
        },
        DIVIDE () {
            /**
             * Do math operation divide on two numbers
             * @cpu O(1)
             * @ram O(1)
             * @return result divide operation on two numbers
             */
            @Override
            public double calculate() {
                return Math.term1 /Math.term2;
            }
        };

        /**
         * Method crate fo override them for each constant from Math enum
         * @cpu O(1)
         * @ram O(1)
         * @return 0
         */
        public double calculate() {
            return 0;
        }
    }

    /**
     * Method get field operator from Math class
     * @cpu O(1)
     * @ram O(1)
     * @return field operator from Math class
     */
    public Operator getOperator() {
        return operator;
    }

    public Math(double term1, double term2, Operator operator) {
        this.term1 = term1;
        this.term2 = term2;
        this.operator = operator;
    }


}
