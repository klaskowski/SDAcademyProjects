package ro.sda.personSerializer;

public class PersonCsvSerializer implements PersonSerializer {
    public static final String SEPARATOR = ";";
    @Override
    public String serialize(Person person) {
        StringBuilder sb = new StringBuilder();
        sb.append(person.getFirstName());
        sb.append(SEPARATOR);
        sb.append(person.getLastName());
        sb.append(SEPARATOR);
        sb.append(person.getCnp());
        sb.append(SEPARATOR);
        sb.append(person.getAge());
        sb.append(SEPARATOR);
        sb.append(person.getSex());
        sb.append(SEPARATOR);
        sb.append(person.getOcupation());
        return sb.toString();
    }
}
