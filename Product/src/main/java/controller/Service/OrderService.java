package controller.Service;

import pojo.Order;
import pojo.Product;

import java.util.List;

public interface OrderService {
    void placeOrder(Order order);
    List<Product> addProductToOrder(List<Product> products, Product product);
    Order createOrder(long orderId);
}
