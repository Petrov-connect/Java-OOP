//created by J.M.

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductStockTest {

    private ProductStock instock;

    @Before
    public void SetUp() {
        instock = new Instock();
    }

    @Test
    public void testGetCountMustReturnCorrectCountOfAddedProducts() {
        instock.add(new Product("test_label_1", 100, 1));
        instock.add(new Product("test_label_2", 100, 1));

        assertEquals(Integer.valueOf(2), instock.getCount());
    }

    @Test
    public void testGetCountMustReturnZeroWhenCollectionIsEmpty() {
        assertEquals(Integer.valueOf(0), instock.getCount());
    }

    @Test
    public void testAddMustStoreTheProductByValidatingWhitContains() {
        Product product = new Product("test_label_1", 100, 1);
        instock.add(product);
        Boolean contains = instock.contains(product);
        assertNotNull(contains);
        assertTrue(contains);
    }

    @Test
    public void testAddShouldNotAddSameProductTwice() {
        Product product = new Product("test_label_1", 100, 1);
        instock.add(product);
        instock.add(product);
        Integer count = instock.getCount();
        assertNotNull(count);
        assertEquals(Integer.valueOf(1), count);
    }

    @Test
    public void testContainsMustReturnFalseWhenProductIsNotPresent() {
        Product product = new Product("test_label_1", 100, 1);
        instock.add(product);
        Boolean contains = instock.contains(new Product("test_label", 100, 1));
        assertNotNull(contains);
        assertFalse(contains);
    }

    @Test
    public void testContainsMustReturnFalseWhenCollectionIsEmpty() {
        Boolean contains = instock.contains(new Product("test_label", 100, 1));
        assertNotNull(contains);
        assertFalse(contains);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindMustFailsIfIndexIsNotValid(){

    }
    @Test
    public void testFindShouldReturnProductAtGivenIndex(){

    }
}