package service;

import model.Order;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CustomerRepository;
import repository.OrderRepository;
import repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Product> addProductToOrder(List<Product> products) {
        boolean continueAdding = true;

        while (continueAdding) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter ID Product (0 to stop adding): ");
            int id = scanner.nextInt();
            scanner.nextLine();

            if (id == 0) {
                continueAdding = false;
            } else {
                Product product = productRepository.findById(id);

                if (product != null) {
                    products.add(product);
                } else {
                    System.out.println("Invalid Product ID. Please try again.");
                }
            }
        }
        return products;
    }

    @Override
    public void getAllProductByOrder(List<Product> products) {
        double totalPrice = 0;

        System.out.println("---------------------------------------------");
        System.out.printf("| %-3s | %-20s | %-10s |\n", "STT", "Name", "Price");
        System.out.println("---------------------------------------------");

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            double price = product.getPrice();
            totalPrice += price;

            System.out.printf("| %-3d | %-20s | %-10.2f |\n", (i + 1), product.getName(), price);
        }

        System.out.println("---------------------------------------------");
        System.out.printf("| %-3s | %-20s | %-10.2f |\n", "", "Total Price", totalPrice);
        System.out.println("---------------------------------------------");
    }

    @Override
    public void placeOrder(List<Product> products) {
        Order order = new Order();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID Customer: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        order.setOrderDate(LocalDateTime.now());
        order.setCustomer(customerRepository.findById(id));
        order.setProductEntities(products);
        orderRepository.save(order);
    }

}
