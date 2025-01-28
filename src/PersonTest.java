import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;

public class PersonTest {

    @Test
    void testFullName() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1985);
        assertEquals("John Doe", person.fullName());
    }

    @Test
    void testFormalName() {
        Person person = new Person("Jane", "Smith", "67890", "Dr.", 1975);
        assertEquals("Dr. Jane Smith", person.formalName());
    }

    @Test
    void testGetAge() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1985);
        assertEquals(Calendar.getInstance().get(Calendar.YEAR) - 1985, person.getAge());
    }

    @Test
    void testGetAgeWithYear() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1985);
        assertEquals(40, person.getAge(2025));
    }

    @Test
    void testToCSV() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1985);
        assertEquals("John,Doe,12345,Mr.,1985", person.toCSV());
    }

    @Test
    void testToJSON() {
        Person person = new Person("Jane", "Doe", "67890", "Mrs.", 1990);
        String expected = "{\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"ID\":\"67890\",\"title\":\"Mrs.\",\"YOB\":1990}";
        assertEquals(expected, person.toJSON());
    }

    @Test
    void testToXML() {
        Person person = new Person("Jane", "Doe", "67890", "Mrs.", 1990);
        String expected = "<Person><FirstName>Jane</FirstName><LastName>Doe</LastName><ID>67890</ID><Title>Mrs.</Title><YOB>1990</YOB></Person>";
        assertEquals(expected, person.toXML());
    }
}