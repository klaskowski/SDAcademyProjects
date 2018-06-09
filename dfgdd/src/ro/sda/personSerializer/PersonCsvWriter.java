package ro.sda.personSerializer;

import java.io.FileWriter;
import java.io.IOException;

public class PersonCsvWriter extends AbstractPersonWriter{

    public PersonCsvWriter(String filePath) {
        super(filePath);
        this.personSerializer = new PersonCsvSerializer();
    }
}
