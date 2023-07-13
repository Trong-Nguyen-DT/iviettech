package controller.Repository;

import entity.OrderEntity;
import pojo.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
    void placeOrder(Order order);
}
