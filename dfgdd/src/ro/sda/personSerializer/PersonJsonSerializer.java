package ro.sda.personSerializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PersonJsonSerializer implements PersonSerializer {
    public static final String SEPARATOR = ",";
    public static final String newLine = System.getProperty("line.separator");
    @Override
    public String serialize(Person person) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(person);
    }
}
