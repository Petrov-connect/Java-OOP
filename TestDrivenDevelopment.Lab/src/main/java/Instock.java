//created by J.M.

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Instock implements ProductStock {

    private Map<String,Product> products;

    public Instock(){
        this.products = new HashMap<>();
    }

    @Override
    public Integer getCount() {
        return products.size();
    }

    @Override
    public Boolean contains(Product product) {
        return this.products.containsKey(product.getLabel());
    }

    @Override
    public void add(Product product) {
        if(!contains(product)){
            this.products.put(product.getLabel(),product);

        }
    }

    @Override
    public void changeQuantity(String product, int quantity) {

    }

    @Override
    public Product find(int index) {
        return null;
    }

    @Override
    public Product findByLabel(String label) {
        return null;
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        return null;
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return null;
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return null;
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        return null;
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return null;
    }

    @Override
    public Iterator<Product> iterator() {
        return null;
    }
}
