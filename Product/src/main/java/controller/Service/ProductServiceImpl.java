package controller.Service;

import controller.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Product;

import java.util.List;
import java.util.Scanner;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProductById(long id) {
        return productRepository.getProductById(id);
    }
    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Add new product -----");
        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter product price: ");
        double productPrice = scanner.nextDouble();
        scanner.nextLine();
        Product product = new Product(productId, productName, productPrice);
        productRepository.addProduct(product);
        System.out.println("New product has been added successfully.");
    }

    @Override
    public void addProductToOrder() {

    }

    @Override
    public void updateProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Update product -----");
        System.out.print("Enter product ID to update: ");
        int productId = scanner.nextInt();
        scanner.nextLine();
        Product product = productRepository.getProductById(productId);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }
        System.out.print("Enter new product name: ");
        String newProductName = scanner.nextLine();
        System.out.print("Enter new product price: ");
        double newProductPrice = scanner.nextDouble();
        scanner.nextLine();
        product.setTitle(newProductName);
        product.setPrice(newProductPrice);
        productRepository.updateProduct(product);
        System.out.println("Product has been updated successfully.");
    }

    @Override
    public void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Delete product -----");
        System.out.print("Enter product ID to delete: ");
        int productId = scanner.nextInt();
        scanner.nextLine();
        Product product = productRepository.getProductById(productId);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }
        productRepository.deleteProduct(productId);
        System.out.println("Product has been deleted successfully.");
    }

    @Override
    public boolean isProductExist(long productId) {
        Product product = productRepository.getProductById(productId);
        return product != null;
    }

    @Override
    public void displayProductList() {
        System.out.println("----- Product List -----");
        List<Product> products = getAllProducts();
        for (Product product : products) {
            System.out.println(product.getId() + " | " + product.getTitle() + " | " + product.getPrice());
        }
    }


}

