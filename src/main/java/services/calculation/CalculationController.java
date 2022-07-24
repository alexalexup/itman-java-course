package services.calculation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationController {


    @GetMapping("/calculation")
    public double getCalculation(@RequestParam double term1, @RequestParam String operator, @RequestParam double term2) {
        Math math = Math.valueOf(operator);
        math.SetTerms(term1, term2);
        return math.Calculate();
    }

    @GetMapping("/calculation/operators")
    public Object[] getOperators() {
        return Math.values();
    }
}
