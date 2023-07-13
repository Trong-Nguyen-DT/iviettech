package service;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.Scanner;


@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void createProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        productRepository.save(product);
        System.out.println("Product created successfully!");
    }

    @Override
    public void updateProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID of Product update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Product product = productRepository.findById(id);


        if (product == null) {
            System.out.println("Product not found!");
            return;
        }

        System.out.println("--------------------------------------------------");
        System.out.println("| ID  |   Name          |   Price       |");
        System.out.println("--------------------------------------------------");
        System.out.printf("| %-4d| %-15s| %-12.2f|\n", product.getId(), product.getName(), product.getPrice());
        System.out.println("--------------------------------------------------");


        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter new Name: ");
                String newName = scanner.nextLine();
                product.setName(newName);
            }
            case 2 -> {
                System.out.print("Enter new Price: ");
                double newPrice = scanner.nextDouble();
                scanner.nextLine();
                product.setPrice(newPrice);
            }
            case 0 -> {
                System.out.println("Update canceled.");
                return;
            }
            default -> {
                System.out.println("Invalid choice. Update canceled.");
                return;
            }
        }

        productRepository.save(product);
        System.out.println("Customer updated successfully!");
    }

    @Override
    public void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID of Product delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Product product = productRepository.findById(id);
        if (product != null) {
            productRepository.delete(product);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    @Override
    public void getAllProduct() {
        System.out.println("--------------------------------------------------------------");
        System.out.printf("| %-5s | %-20s | %-10s |\n", "ID", "Name", "Price");
        System.out.println("--------------------------------------------------------------");
        productRepository.findAll().forEach(product -> {
            System.out.printf("| %-5d | %-20s | %-10.2f |\n", product.getId(), product.getName(), product.getPrice());
        });
        System.out.println("--------------------------------------------------------------");
    }

}
