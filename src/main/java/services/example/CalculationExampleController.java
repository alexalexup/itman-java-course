package services.example;

import org.springframework.web.bind.annotation.*;


@RestController
public class CalculationExampleController {

    /**
     * Do math operation on the numbers that method gets
     * @cpu O(1)
     * @ram O(1)
     * @return result of the math operation on the numbers that user passed
     */
    @PostMapping("/calculation")
    public double getCalculation(@RequestParam double term1, @RequestParam String operator, @RequestParam double term2 ) {
        return Mth.valueOf(operator).calculate(term1, term2);
    }

    /**
     * Return all constans from Math enum (all operation that we can do)
     * @cpu O(n), n - Math.values().length
     * @ram O(n), n - Math.values().length
     * @return result of the math operation on the numbers that user passed
     */
    @GetMapping("/calculation/operators")
    public Object[] getOperators() {
        return Mth.values();
    }
}