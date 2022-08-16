package services.calculation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculationController {


    /**
     * Do math operation on the numbers that method gets
     * @cpu O(1)
     * @ram O(1)
     * @return result of the math operation on the numbers that user passed
     */
    @PostMapping("/calculation")
    public double getCalculation(@RequestBody Math.Operator operator
            ,@RequestParam double term1
            ,@RequestParam double term2) {
       return new Math(term1, term2, operator).getOperator().calculate();
    }


    /**
     * Return all constans from Math enum (all operation that we can do)
     * @cpu O(n), n - Math.values().length
     * @ram O(n), n - Math.values().length
     * @return result of the math operation on the numbers that user passed
     */
    @GetMapping("/calculation/operators")
    public Object[] getOperators() {
        return Math.Operator.values();
    }
}
