package test;

import entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryy extends CrudRepository<OrderEntity, Integer> {
}
