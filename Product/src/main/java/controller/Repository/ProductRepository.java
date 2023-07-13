package controller.Repository;

import pojo.Product;

import java.util.List;

public interface ProductRepository {
    Product getProductById(long id);
    List<Product> getAllProducts();
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(long id);
}
