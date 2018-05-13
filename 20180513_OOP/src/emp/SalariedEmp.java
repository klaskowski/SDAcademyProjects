package emp;

public class SalariedEmp extends Employee implements SalariedEmployeeInterface {

    double salary;

    public SalariedEmp(String name) {
        super(name);
    }

    public SalariedEmp(String name, double salary){
        super(name);
        this.salary = salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }

    @Override
    public double getPayAmount() {
        return getSalary();
    }

}
