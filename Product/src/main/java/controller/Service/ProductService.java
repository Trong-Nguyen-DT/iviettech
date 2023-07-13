package controller.Service;

import pojo.Order;
import pojo.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(long id);
    List<Product> getAllProducts();
    void addProduct();
    void addProductToOrder();
    void updateProduct();
    void deleteProduct();
    boolean isProductExist(long productId);
    void displayProductList();
}
