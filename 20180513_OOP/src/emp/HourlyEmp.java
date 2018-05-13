package emp;

public class HourlyEmp extends Employee implements HourlyEmployeeInterface {

    int hours;
    double rate;

    public HourlyEmp(String name) {
        super(name);
    }

    public HourlyEmp(String name, int hours, double rate){
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public double getPayAmount() {
        return getHours() * getRate();
    }
}
