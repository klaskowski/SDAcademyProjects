package ro.sda.personSerializer;

public class Main {
    public static void main(String[] args) {
        PersonConsoleReader reader = new PersonConsoleReader();
        Person person = reader.read();
        PersonCsvWriter writer = new PersonCsvWriter("F:\\persons.csv");
        writer.persist(person);
    }
}
