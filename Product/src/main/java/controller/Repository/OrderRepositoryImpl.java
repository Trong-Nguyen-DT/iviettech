package controller.Repository;

import org.springframework.stereotype.Repository;
import pojo.Order;
import pojo.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public abstract class OrderRepositoryImpl implements OrderRepository {

    private Map<Long, Order> orderMap;

    public OrderRepositoryImpl() {
        orderMap = new HashMap<>();
    }

    @Override
    public void placeOrder(Order order) {
        System.out.println("Order " + order.getId() + " has been placed.");
    }
}

