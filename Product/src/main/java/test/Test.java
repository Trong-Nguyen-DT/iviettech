package test;

import config.BeanConfiguration;
import test.OrderRepositoryy;
import entity.OrderEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    static ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
    static OrderRepositoryy orderRepositoryy = context.getBean(OrderRepositoryy.class);

    public static void main(String[] args) {
        Iterable<OrderEntity> orderList = orderRepositoryy.findAll();
        for (OrderEntity order : orderList) {
            System.out.println(order);
        }
    }
}
