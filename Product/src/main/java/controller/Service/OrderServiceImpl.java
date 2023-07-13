package controller.Service;

import controller.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Order;
import pojo.Product;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void placeOrder(Order order) {
        orderRepository.placeOrder(order);
    }

    @Override
    public List<Product> addProductToOrder(List<Product> products, Product product) {
        products.add(product);
        return products;
    }
    @Override
    public Order createOrder(long orderId) {
        Order order = new Order();
        order.setId(orderId);
        return order;
    }
}

