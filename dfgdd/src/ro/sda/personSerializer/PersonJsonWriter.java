package ro.sda.personSerializer;

public class PersonJsonWriter extends AbstractPersonWriter{
    public PersonJsonWriter(String filePath) {
        super(filePath);
        this.personSerializer = new PersonJsonSerializer();
    }
}
