package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private final Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product) {
        if(product == null){
            throw new IllegalArgumentException("product is null");
        }
        this.products.put(product, 1);
    }

    public void addProduct(Product product, Integer quantity){
        if(product == null){
            throw new IllegalArgumentException("product is null");
        }
        if(quantity <= 0){
            throw new IllegalArgumentException("quantity cannot be less than 1");
        }
        this.products.put(product, quantity);
    }

    public BigDecimal getSubtotal() {
        return products
                .entrySet()
                .stream()
                .map(e -> e.getKey().getPrice().multiply(new BigDecimal(e.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public BigDecimal getTax() {
       return getTotal().subtract(getSubtotal());
    }

    public BigDecimal getTotal() {
        return products
                .entrySet()
                .stream()
                .map(e -> e.getKey().getPriceWithTax().multiply(new BigDecimal(e.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
