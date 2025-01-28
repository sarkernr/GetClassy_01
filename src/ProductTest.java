import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void testToCSV() {
        Product product = new Product("Laptop", "High-performance laptop", "P12345", 999.99);
        assertEquals("Laptop,High-performance laptop,P12345,999.99", product.toCSV());
    }

    @Test
    void testToJSON() {
        Product product = new Product("Mouse", "Wireless mouse", "P67890", 25.50);
        String expected = "{\"name\":\"Mouse\",\"description\":\"Wireless mouse\",\"ID\":\"P67890\",\"cost\":25.50}";
        assertEquals(expected, product.toJSON());
    }

    @Test
    void testToXML() {
        Product product = new Product("Keyboard", "Mechanical keyboard", "P54321", 45.75);
        String expected = "<Product><Name>Keyboard</Name><Description>Mechanical keyboard</Description><ID>P54321</ID><Cost>45.75</Cost></Product>";
        assertEquals(expected, product.toXML());
    }

    @Test
    void testEquals() {
        Product product1 = new Product("Monitor", "4K monitor", "P11223", 299.99);
        Product product2 = new Product("Monitor", "4K monitor", "P11223", 299.99);
        assertEquals(product1, product2);
    }

    @Test
    void testToString() {
        Product product = new Product("Tablet", "10-inch tablet", "P45678", 199.99);
        assertEquals("Tablet (P45678): 10-inch tablet - $199.99", product.toString());
    }
}