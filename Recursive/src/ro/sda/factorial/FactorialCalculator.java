package ro.sda.factorial;

import java.math.BigDecimal;

public class FactorialCalculator {
    public BigDecimal calculate(int value){
        if(value == 1){
            return new BigDecimal(1);
        } else{

            return BigDecimal.valueOf(value).multiply(calculate(value -1));
        }
    }
}
