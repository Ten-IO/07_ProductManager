import lab07.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddProductTest {
    @Test
    @DisplayName("Add product correctly (product name not exist)")
    void testAddProductWithDiffName() {
        ProductManager product = new ProductManager();
        assertEquals(-1, product.findProduct("Jojo"));
        product.addProduct("Jojo", 10);
        assertEquals(1, product.getCount());
        
        assertEquals(-1, product.findProduct("Dio"));
        product.addProduct("Dio", 0, 0);
        assertEquals(2, product.getCount());
    }
    @Test @DisplayName("Add product incorrectly (product name duplicated)")
    void testProductWithSameName() {
        ProductManager product = new ProductManager();
        product.addProduct("Potato", 0);
        assertNotEquals(-1, product.findProduct("potato"));
        product.addProduct("potato", 20);
        assertEquals(1, product.getCount());
    }
    @Test @DisplayName("Check for count increased by 1 or not")
    void testCheckCount() {
        ProductManager product = new ProductManager();
        assertEquals(0, product.getCount());
        product.addProduct("Banana",10,20);
        assertEquals(1, product.getCount());
        product.addProduct("Banana", 0);
        assertEquals(1, product.getCount());
        product.addProduct("Apple", 0);
        assertEquals(2, product.getCount());
    }
}