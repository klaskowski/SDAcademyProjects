package ro.sda.personSerializer;

public class Main {
    public static void main(String[] args) {
        PersonConsoleReader reader = new PersonConsoleReader();
        Person person = reader.read();
        //PersonCsvWriter writer = new PersonCsvWriter("F:\\persons.csv");
        AbstractPersonWriter writer = new PersonJsonWriter("F:\\persons.json");
        writer.persist(person);


    }
}
