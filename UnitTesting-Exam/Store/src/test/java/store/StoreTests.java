package store;
//created by J.M.

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StoreTests {

    private static Product product1;
    private static Product product2;
    private static final String name1 = "product1";
    private static final String name2 = "product2";
    private static final int quantity1 = 1;
    private static final int quantity2 = 2;
    private static final double price1 = 1.1;
    private static final double price2 = 2.2;
    private static final int invalidQuantity = -1;
    private static final double invalidPrice = -1;
    private static Store store;


    @Before
    public void setUp() {
        product1 = new Product(name1, quantity1, price1);
        product2 = new Product(name2, quantity2, price2);
        store = new Store();
        Main.main(new String[]{"",""});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddProductMustFailsWhenQuantityIsInvalid() {

        product1.setQuantity(invalidQuantity);
        store.addProduct(product1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddProductMustFailsWhenProductIsNull() {

        store.addProduct(null);
    }

    @Test
    public void testGetTheMostExpensiveProductMustReturnCorrectProduct() {

        store.addProduct(product1);
        store.addProduct(product2);
        Assert.assertEquals(product2.getPrice(), store.getTheMostExpensiveProduct().getPrice(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyProductMustFailsWhenProductIsNull() {

        store.buyProduct(null, quantity2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyProductMustFailsWhenProductQuantityIsNotEnough() {

        store.addProduct(product1);
        store.buyProduct(name1, quantity2);
    }

    @Test
    public void testBuyProductMustReturnsCorrectProduct(){

        store.addProduct(product1);
        store.addProduct(product2);
        Assert.assertEquals(quantity2*price2,store.buyProduct(name2,quantity2),0.0);
    }

    @Test
    public void testGetCountMustReturnsCorrectCountOfProducts(){

        store.addProduct(product1);
        store.addProduct(product2);
        Assert.assertEquals(2,store.getCount());
    }

    @Test
    public void testGetProductsMustReturnsCorrectCollectionOfProducts(){

        store.addProduct(product1);
        store.addProduct(product2);
        List<Product> productList=store.getProducts();
        Assert.assertEquals(product1,productList.get(0));
        Assert.assertEquals(product2,productList.get(1));
        Assert.assertEquals(name2,productList.get(1).getName());
        Assert.assertEquals(quantity2,productList.get(1).getQuantity());

    }
}