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
        addFiveProducts();
        assertEquals(Integer.valueOf(5), instock.getCount());
    }

    @Test
    public void testGetCountMustReturnZeroWhenCollectionIsEmpty() {

        assertEquals(Integer.valueOf(0), instock.getCount());
    }

    @Test
    public void testAddMustStoreTheProductByValidatingWhitContains() {

        Product product = createTestProduct();
        instock.add(product);
        Boolean contains = instock.contains(product);
        assertNotNull(contains);
        assertTrue(contains);
    }

    @Test
    public void testAddShouldNotAddSameProductTwice() {

        Product product = createTestProduct();
        instock.add(product);
        instock.add(product);
        Integer count = instock.getCount();
        assertNotNull(count);
        assertEquals(Integer.valueOf(1), count);
    }

    @Test
    public void testContainsMustReturnFalseWhenProductIsNotPresent() {

        addFiveProducts();
        Boolean contains = instock.contains(createTestProduct());
        assertNotNull(contains);
        assertFalse(contains);
    }

    @Test
    public void testContainsMustReturnFalseWhenCollectionIsEmpty() {

        Boolean contains = instock.contains(createTestProduct());
        assertNotNull(contains);
        assertFalse(contains);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindMustFailsIfIndexIsNegative(){

        instock.find(-1);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindMustFailsIfIndexEqualsToCount(){

        addFiveProducts();
        instock.find(instock.getCount());

    }

    @Test
    public void testFindShouldReturnFirstAddedProduct(){

        assertFindShouldReturnCorrectProduct(0);

    }

    @Test
    public void testFindShouldReturnLastAddedProduct(){

        assertFindShouldReturnCorrectProduct(4);

    }

    @Test
    public void testFindShouldReturnCorrectProductAtGivenIndex(){

        assertFindShouldReturnCorrectProduct(2);

    }

    private void assertFindShouldReturnCorrectProduct(int index){
        addFiveProducts();
        Product product = instock.find(index);
        assertNotNull(product);
        assertEquals("test_label_"+(index+1) ,product.getLabel());
    }

    private void addFiveProducts(){
        instock.add(new Product("test_label_1", 100.0, 1));
        instock.add(new Product("test_label_2", 100.1, 2));
        instock.add(new Product("test_label_3", 100.2, 3));
        instock.add(new Product("test_label_4", 100.3, 4));
        instock.add(new Product("test_label_5", 100.4, 5));
    }

    private Product createTestProduct(){
        return new Product("test_label", 100, 1);
    }
}