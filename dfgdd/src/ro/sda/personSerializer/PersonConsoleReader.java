package ro.sda.personSerializer;

import java.util.Scanner;

public class PersonConsoleReader implements PersonReader{

    @Override
    public Person read() {
        Person person = new Person();
        Scanner scanner = new Scanner(System.in);
        System.out.println("First Name: ");
        person.setFirstName(scanner.nextLine());
        System.out.println("Last Name: ");
        person.setLastName(scanner.nextLine());
        System.out.println("CNP: ");
        person.setCnp(scanner.next());
        System.out.println("Age: ");
        person.setAge(scanner.nextInt());
        System.out.println("Sex:");
        person.setSex(scanner.next().charAt(0));
        System.out.println("Ocupation:");
        person.setOcupation(scanner.nextLine());
        return person;
    }
}
