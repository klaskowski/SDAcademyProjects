package ro.sda.factorial;

public class FactorialCalculator {
    public Long calculate(int value){
        if(value == 1){
            return 1L;
        } else{
            return value * calculate(value -1);
        }
    }
}
