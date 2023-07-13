package controller.Service;

import controller.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Customer;
import pojo.Product;

import java.util.List;
import java.util.Scanner;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(long id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }
    @Override
    public void addCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Add new customer -----");
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter customer address: ");
        String customerAddress = scanner.nextLine();
        System.out.print("Enter customer phone: ");
        String customerPhone = scanner.nextLine();
        Customer customer = new Customer(customerId, customerName, customerAddress, customerPhone);
        customerRepository.addCustomer(customer);
        System.out.println("New customer has been added successfully.");
    }

    @Override
    public void updateCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Update customer -----");
        System.out.print("Enter customer ID to update: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        Customer customer = customerRepository.getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }
        System.out.println("Current customer information:");
        System.out.println("ID: " + customer.getId());
        System.out.println("Name: " + customer.getName());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("Phone: " + customer.getPhone());
        System.out.println("Enter new customer information:");
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new address: ");
        String newAddress = scanner.nextLine();
        System.out.print("Enter new phone: ");
        String newPhone = scanner.nextLine();
        customer.setName(newName);
        customer.setAddress(newAddress);
        customer.setPhone(newPhone);
        customerRepository.updateCustomer(customer);
        System.out.println("Customer information has been updated successfully.");
    }

    @Override
    public void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Delete customer -----");
        System.out.print("Enter customer ID to delete: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        Customer customer = customerRepository.getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }
        customerRepository.deleteCustomer(customerId);
        System.out.println("Customer has been deleted successfully.");
    }
    @Override
    public boolean isCustomerExist(long customerId) {
        Customer customer = customerRepository.getCustomerById(customerId);
        return customer != null;
    }
    @Override
    public void displayCustomerList() {
        System.out.println("----- Customer List -----");
        List<Customer> customers = getAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer.getId() + " | " + customer.getName() + " | " + customer.getPhone() + " | "+ customer.getPhone());
        }
    }
}

