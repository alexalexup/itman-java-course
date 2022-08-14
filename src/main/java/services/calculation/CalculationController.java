package services.calculation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationController {


    /**
     * Do math operation on the numbers that method gets
     * @cpu O(1)
     * @ram O(1)
     * @param term1 argument
     * @param operator math operation that method  do
     * @param term2 argument
     * @return result of the math operation on the numbers that user passed
     */
    @GetMapping("/calculation")
    public double getCalculation(@RequestParam double term1, @RequestParam String operator, @RequestParam double term2) {
        Math math = Math.valueOf(operator);
        math.setTerms(term1, term2);
        return math.calculate();
    }

    /**
     * Return all constans from Math enum (all operation that we can do)
     * @cpu O(n), n - Math.values().length
     * @ram O(n), n - Math.values().length
     * @return result of the math operation on the numbers that user passed
     */
    @GetMapping("/calculation/operators")
    public Object[] getOperators() {
        return Math.values();
    }
}
