package ro.sda.personSerializer.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ro.sda.personSerializer.Person;
import ro.sda.personSerializer.PersonCsvSerializer;
import ro.sda.personSerializer.PersonSerializer;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class PersonCsvSerializerTest {

    Person person;

    @Before
    public void setUp(){
        person = new Person();
        person.setFirstName("Ion");
        person.setLastName("Rotaru");
        person.setCnp("1345432345678");
        person.setAge(32);
        person.setSex('M');
        person.setOcupation("None");
    }

    @Test
    public void testSerialize_result(){
        String expected = "Ion;Rotaru;1345432345678;32;M;None";
        PersonSerializer personSerializer = new PersonCsvSerializer();
        String result = personSerializer.serialize(person);
        assertEquals(expected, result);
    }

    @Test
    public void testSerialize_resultContainsAge(){
        PersonSerializer personSerializer = new PersonCsvSerializer();
        String result = personSerializer.serialize(person);
        assertTrue(result.contains(person.getAge().toString()));
    }

    @Test
    public void testSerialize_resultContainsSeparator(){
        int expectedSeparatorCount = 5;//Number of fields - 1
        PersonSerializer personSerializer = new PersonCsvSerializer();
        String result = personSerializer.serialize(person);
        int actualSeparatorCount = StringUtils.countMatches(result,PersonCsvSerializer.SEPARATOR);
        assertEquals(expectedSeparatorCount,actualSeparatorCount);
    }
}
