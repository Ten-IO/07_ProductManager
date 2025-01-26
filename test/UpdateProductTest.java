import lab07.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class UpdateProductTest {
    @Test
    @DisplayName("Update product correctly (product name exists, new name is not blank)")
    void testUpdateWithExistName() {
        ProductManager product = new ProductManager();
        product.addProduct("Key", 2);
        product.addProduct("Car", 10000);
        assertEquals(true, product.updateProduct("Key", "Lock", 2, 3.5));
        assertEquals(true, product.updateProduct("car", "Toyota Car", 1000, 24000));
    }


@Test
@DisplayName("update product incorrectly (product name not exists)")
void testUpdateWithMissingName() {
    ProductManager product = new ProductManager();
    boolean expect = false;
    boolean actual = product.updateProduct("Car", "Mercedes-Benz E", 27000, 0);
    assertEquals(expect, actual);
}

@Test
@DisplayName("update product incorrectly (product name exits but new name is blank)")
void testUpdateExistNameToBlank() {
    ProductManager product = new ProductManager();
    product.addProduct("potato", 0);
    product.updateProduct("potato", "", 10, 0);
    assertEquals(1, product.getCount());
    assertEquals(true, product.updateProduct("potato", "", 0, 0));
    assertEquals(-1, product.findProduct(""));
    assertEquals(0, product.findProduct("potato"));
}
@Test @DisplayName("update product incorrectly (product name exists but new price is less than 0)")
    void testUpdateProductPriceUnderZero() {
        ProductManager product = new ProductManager();
        product.addProduct("Apple", 1.5);
        assertTrue(product.updateProduct("apple", "apple", -20, 0));
        Product chkProduct = product.removeProduct("Apple");
        assertNotNull(chkProduct);
        assertEquals(1.5,chkProduct.getPrice());
        assertEquals("apple",chkProduct.getName());
    }
@Test @DisplayName("update product incorrectly (product name exists but new price is less than 0)")
    void testUpdateProductDiscountOutOfRange() {
        ProductManager product = new ProductManager();
        product.addProduct("Apple", 1.5);
        assertTrue(product.updateProduct("apple", "apple", 0, -2));
        Product chkProduct1 = product.removeProduct("Apple");
        assertNotNull(chkProduct1);
        assertEquals(0,chkProduct1.getDiscount());
        assertEquals(1.5,chkProduct1.getPrice());
        product.addProduct("APPLE",  0, 10);
        assertTrue(product.updateProduct("apple", "apple", 0, 108));
        Product chkProduct2 = product.removeProduct("Apple");
        assertEquals(10,chkProduct2.getDiscount());
    }
    @Test @DisplayName("Check for count stay the same as before the update")
    void testUpdateCount() {
        ProductManager product = new ProductManager();
        product.addProduct("Apple", 1.5);
        product.addProduct("Peanut", 1.01);
        product.addProduct("Corn", 2.5);
        assertEquals(3, product.getCount());
        product.updateProduct("apple", "apple", 0, -2);
        assertEquals(3, product.getCount());

    }
}