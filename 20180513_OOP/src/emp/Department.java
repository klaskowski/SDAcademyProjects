package emp;

public class Department {

    public Manager manager;
    public String name;
    private int currentNrOfEmps= 1;
    Employee[] employees = new Employee[10];

    public Department (Manager manager, String name){
        this.manager = manager;
        this.name = name;
        employees[0] = manager;
    }

    public int getCurrentNrOfEmps() {
        return currentNrOfEmps;
    }

    public void setCurrentNrOfEmps(int currentNrOfEmps) {
        this.currentNrOfEmps = currentNrOfEmps;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public void addEmp(Employee employee){
        employees[currentNrOfEmps] = employee;
        currentNrOfEmps++;
    }

    public void showEmployees(){
        System.out.println("Department: " + name);
        System.out.println();
        for (int i = 0; i < currentNrOfEmps; i ++){
            Employee employee = employees[i];
            employee.sayName();
        }
    }
}
