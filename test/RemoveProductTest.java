import lab07.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class RemoveProductTest {
    @Test @DisplayName("Remove product correctly (product name exist)")
    void testRemoveProductExist() {
        ProductManager product = new ProductManager();
        product.addProduct("Corn", 0.5);
        assertNotNull(product.removeProduct("Corn"));
        assertEquals(-1, product.findProduct("Corn"));
        assertEquals(0, product.getCount());
    }
    @Test @DisplayName("Remove product incorrectly (product name not exist)")
    void testRemoveNotExistProduct() {
        ProductManager product = new ProductManager();
        product.addProduct("Wheat", 100);
        assertNull(product.removeProduct("Wine"));
    }
    @Test @DisplayName("Check decrease count")
    void testCountAtRemove() {
        ProductManager product = new ProductManager();
        product.addProduct("Kalimba", 0);
        product.addProduct("Raspberry Pi", 0);
        product.removeProduct("kalimba");
        assertEquals(1, product.getCount());
        product.removeProduct("raspberry pi");
        assertEquals(0, product.getCount());
    }
}