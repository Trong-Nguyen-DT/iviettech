package controller.Repository;

import org.springframework.stereotype.Repository;
import pojo.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private Map<Long, Product> productMap;

    public ProductRepositoryImpl() {
        productMap = new HashMap<>();
    }

    @Override
    public Product getProductById(long id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void addProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void updateProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void deleteProduct(long id) {
        productMap.remove(id);
    }
}

