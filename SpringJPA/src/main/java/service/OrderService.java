package service;

import model.Product;

import java.util.List;

public interface OrderService {
    List<Product> addProductToOrder(List<Product> products);
    void getAllProductByOrder(List<Product> products);
    void placeOrder(List<Product> products);
}
