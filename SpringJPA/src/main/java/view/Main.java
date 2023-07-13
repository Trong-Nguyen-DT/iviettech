package view;

import config.BeanConfiguration;

import model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.CustomerService;
import service.OrderService;
import service.ProductService;

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
        orderService = context.getBean(OrderService.class);
        customerService = context.getBean(CustomerService.class);
        productService = context.getBean(ProductService.class);
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
        handleOrderMenuFirst();
        List<Product> products = new ArrayList<>();
        boolean exit = false;
        boolean continueAdding = false;
        do {
            if (continueAdding) {
                orderService.getAllProductByOrder(products);
                handleOrderMenuContinue();
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    productService.getAllProduct();
                    products = orderService.addProductToOrder(products);
                    continueAdding = true;
                }
                case 2 -> {
                    orderService.placeOrder(products);
                    orderService.getAllProductByOrder(products);
                    System.out.println("Order placed successfully!");
                    System.exit(0);
                }
                case 0 -> exit = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (!exit);
    }
    private static void handleOrderMenuFirst() {
        System.out.println("1. Add Product");
        System.out.println("0. Back");
        System.out.print("Please choose an option: ");
    }
    private static void handleOrderMenuContinue() {
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
                case 1 -> customerService.createCustomer();
                case 2 -> customerService.updateCustomer();
                case 3 -> customerService.deleteCustomer();
                case 4 -> customerService.getAllCustomer();
                case 0 -> exit = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private static void printCustomerMenu() {
        System.out.println("----- Customer -----");
        System.out.println("1. Create Customer");
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
                case 1 -> productService.createProduct();
                case 2 -> productService.updateProduct();
                case 3 -> productService.deleteProduct();
                case 4 -> productService.getAllProduct();
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
