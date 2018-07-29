package composite;

public class Main {
    public static void main(String[] args) {
        Employee manager = new Employee("John", "Manager", 5000);
        Employee driver = new Employee("Mike", "Driver", 3000);
        Employee accountant = new Employee("Jane", "Accountant", 4500);
        Employee CEO = new Employee("Mary", "CEO", 10000);
        Employee runos = new Employee("Tom", "Human Resources", 4000);

        CEO.add(manager);
        manager.add(driver);
        manager.add(accountant);
        accountant.add(runos);

        System.out.println(CEO.printEmployeeAndSubordinates());
        //System.out.println(manager.printEmployeeAndSubordinates());
//        displayAllEmployees(CEO.getSubordinates());
//        displayAllEmployees(manager.getSubordinates());
    }
}
