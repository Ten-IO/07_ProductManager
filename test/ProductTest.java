import lab07.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class ProductTest {
    @Test @DisplayName("Set name correctly (name is not blank)")
    void testNameNotBlank() {
        Product product = new Product();
        product.setName("Grape");
        assertEquals("Grape", product.getName());
        product.setName("   Pap aya     ");
        assertEquals("Pap aya", product.getName().trim());
    }
    @Test @DisplayName("Set name incorrectly (name is blank)")
    void testNameBlank() {
        Product product = new Product();
        product.setName("               ");
        assertNull(product.getName());
    }
    @Test @DisplayName("Set price correctly (price is greater than 0)")
    void testPriceZero() {
        Product product = new Product();
        product.setPrice(0);
        assertEquals(0, product.getPrice());
    }
    @Test @DisplayName("Set price correctly (price is greater than 0)")
    void testPriceGreaterThanZero() {
        Product product = new Product();
        product.setPrice(12);
        assertEquals(12, product.getPrice());
    }
    @Test @DisplayName("Set discount correctly (discount is between 0 and 100)")
    void testDiscountZeroToHundred() {
        Product product = new Product();
        product.setDiscount(100);
        assertEquals(100, product.getDiscount());
    }
    @Test @DisplayName("Set discount incorrectly (price is less than or equals to 0)")
    void testDiscountLessThanZero() {
        Product product = new Product();
        product.setDiscount(-1);
        assertEquals(0, product.getDiscount());
        product.setDiscount(1000);
        assertEquals(0, product.getDiscount());
    }
}