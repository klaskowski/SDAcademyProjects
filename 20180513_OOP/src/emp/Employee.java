package emp;

import java.util.Date;

public abstract class Employee extends Person implements PayableInterface{

    private Date hireDate;

    public Employee(String name) {
        super(name);
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public void sayName(){
        System.out.println("Employee name: " + name);
    }

    public abstract double getPayAmount();
}
