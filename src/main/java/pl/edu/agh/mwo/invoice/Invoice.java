package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private final Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product) {
        this.products.put(product, 1);
    }

    public void addProduct(Product product, Integer quantity){
        this.products.put(product, quantity);
    }

    public BigDecimal getSubtotal() {
        return null;
    }

    public BigDecimal getTax() {
        return null;
    }

    public BigDecimal getTotal() {
        return null;
    }
}
