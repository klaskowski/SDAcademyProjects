package emp;

public interface AccEmployeeInterface {

    void pay(SalariedEmployeeInterface salariedEmployeeInterface);
    void pay(HourlyEmployeeInterface hourlyEmployeeInterface);
    void pay(PayableInterface payableInterface);

}
