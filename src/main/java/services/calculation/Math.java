package services.calculation;

public enum Math {
    PLUS (0, 0) {
        @Override
        public double Plus() {
            return PLUS.term1 + PLUS.term2;
        }
    },
    MINUS (0, 0) {
        @Override
        public double Minus() {
            return MINUS.term1 - MINUS.term2;
        }
    },
    MULTIPLY (0, 0) {
        @Override
        public double Multiply() {
            return MULTIPLY.term1 * MULTIPLY.term2;
        }
    },
    DIVIDE (0, 1) {
        @Override
        public double Divide() {
            return DIVIDE.term1 / DIVIDE.term2;
        }
    };
    private double term1;
    private double term2;
    Math (double term1, double term2) {
        this.term1 = term1;
        this.term2 = term2;
    }
    public void SetTerms(double term1, double term2) {
        this.term1 = term1;
        this.term2 = term2;
    }

    public double Plus() {
        return 0;
    }

    public double Minus() {
        return 0;
    }

    public double Multiply() {
        return 0;
    }

    public double Divide() {
        return 0;
    }
}
