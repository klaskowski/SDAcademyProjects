package ro.sda.personSerializer;

import java.io.FileWriter;
import java.io.IOException;

public abstract class AbstractPersonWriter {
    protected String filePath;
    protected PersonSerializer personSerializer;

    public AbstractPersonWriter(String filePath){
        this.filePath = filePath;
    }

    public void persist(Person person){
        String personLiteral = personSerializer.serialize(person);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath, true);
            fileWriter.write(personLiteral);
            fileWriter.write(System.getProperty("line.separator"));
            fileWriter.close();
        } catch(IOException e){
            e.getMessage();
        }
    }
}
