import emp.*;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("Marcel");
        Department department= new Department(manager, "Oale si ulcele");
        Employee emp1 = new HourlyEmp("Employee1", 5, 20);
        Employee emp2 = new SalariedEmp("Employee2", 5000);
        manager.hire(department, emp1);
        manager.hire(department, emp2);
        Employee emp3 = new SalariedAccountant("Contabilu", 3000);
        manager.hire(department, emp3);
        department.showEmployees();
        ((SalariedAccountant) emp3).pay(department.getEmployees(), department.getCurrentNrOfEmps());


    }
}
