package emp;

public class SalariedAccountant extends SalariedEmp implements AccEmployeeInterface{

    public SalariedAccountant(String name) {
        super(name);
    }

    public SalariedAccountant(String name, double salary){
        super(name);
        this.salary = salary;
    }

    @Override
    public void pay(SalariedEmployeeInterface salariedEmployeeInterface) {
        System.out.println("Salary: " + salariedEmployeeInterface.getSalary());
    }

    @Override
    public void pay(HourlyEmployeeInterface hourlyEmployeeInterface) {
        System.out.println("Total hours * rate: " + hourlyEmployeeInterface.getHours() * hourlyEmployeeInterface.getRate());
    }

    public void sayName(){
        System.out.println("Accountant name: " + name);
    }

    public void pay(PayableInterface payableInterface){
        System.out.println("Payed " + payableInterface.getPayAmount());
    }

    public void pay(PayableInterface[] payableInterfaces, int numberOfEmployees){
        for (int i = 0; i < numberOfEmployees; i++){
            PayableInterface payableInterface = payableInterfaces[i];
            pay(payableInterface);
        }
    }

    public void pay (Employee[] employees, int numberOfEmps){
        for (int i = 0; i < numberOfEmps; i++){
            pay(employees[i]);
        }
    }
}
