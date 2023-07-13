import config.BeanConfiguration;
import controller.Service.CustomerService;
import controller.Service.OrderService;
import controller.Service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pojo.Order;
import pojo.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static CustomerService customerService;
    private static ProductService productService;
    private static OrderService orderService;
    private static Scanner scanner;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        customerService = context.getBean(CustomerService.class);
        productService = context.getBean(ProductService.class);
        orderService = context.getBean(OrderService.class);
        scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            printMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> handleOrderMenu();
                case 2 -> handleCustomerMenu();
                case 3 -> handleProductMenu();
                case 0 -> exit = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }

        context.close();
    }

    private static void printMainMenu() {
        System.out.println("----- MENU -----");
        System.out.println("1. Order");
        System.out.println("2. Customer");
        System.out.println("3. Product");
        System.out.println("0. Exit");
        System.out.print("Please choose an option: ");
    }

    private static void handleOrderMenu() {
        boolean exit = false;
        int customerId;
        do {
            System.out.print("Enter customer ID: ");
            customerId = scanner.nextInt();
            scanner.nextLine();

            if (!customerService.isCustomerExist(customerId)) {
                System.out.println("Invalid customer ID. Please try again.");
            }
        } while (!customerService.isCustomerExist(customerId));
        System.out.print("Enter Order ID: ");
        long orderId = scanner.nextLong();
        scanner.nextLine();
        Order order = orderService.createOrder(orderId);
        List<Product> products = new ArrayList<>();
        while (!exit) {
            printOrderMenu(products);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    productService.displayProductList();
                    System.out.println("----- Order -----");
                    System.out.print("Enter product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    if (productService.isProductExist(productId)) {
                        orderService.addProductToOrder(products, productService.getProductById(productId));
                        System.out.println("Product has been added to the order.");
                    } else {
                        System.out.println("Invalid product ID. Please try again.");
                    }
                }
                case 2 -> {
                    orderService.placeOrder(order);
                    break;
                }
                case 0 -> exit = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void printOrderMenu(List<Product> products) {
        System.out.println("----- List of Ordered Products -----");
        double totalprice = 0;
        int i = 1;
        for (Product product : products) {
            System.out.println(i + ": " + product.getTitle());
            i++;
            totalprice += product.getPrice();
        }
        System.out.println("Total: " + totalprice);
        System.out.println("1. Continue Adding Product");
        System.out.println("2. Place Order");
        System.out.println("0. Back");
        System.out.print("Please choose an option: ");
    }


    private static void handleCustomerMenu() {
        boolean exit = false;

        while (!exit) {
            printCustomerMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> customerService.addCustomer();
                case 2 -> customerService.updateCustomer();
                case 3 -> customerService.deleteCustomer();
                case 4 -> customerService.displayCustomerList();
                case 0 -> exit = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void printCustomerMenu() {
        System.out.println("----- Customer -----");
        System.out.println("1. Add Customer");
        System.out.println("2. Update Customer");
        System.out.println("3. Delete Customer");
        System.out.println("4. Display Customer List");
        System.out.println("0. Back");
        System.out.print("Please choose an option: ");
    }

    private static void handleProductMenu() {
        boolean exit = false;

        while (!exit) {
            printProductMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> productService.addProduct();
                case 2 -> productService.updateProduct();
                case 3 -> productService.deleteProduct();
                case 4 -> productService.displayProductList();
                case 0 -> exit = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void printProductMenu() {
        System.out.println("----- Product -----");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Display Product List");
        System.out.println("0. Back");
        System.out.print("Please choose an option: ");
    }

}
