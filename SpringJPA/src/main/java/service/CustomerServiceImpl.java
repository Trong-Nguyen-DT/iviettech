package service;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CustomerRepository;

import java.time.LocalDate;
import java.util.Scanner;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void createCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Birthday (yyyy-MM-dd): ");
        String birthdayString = scanner.nextLine();
        LocalDate birthday = LocalDate.parse(birthdayString);

        System.out.print("Enter Sex (true for male, false for female): ");
        boolean sex = scanner.nextBoolean();

        scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        Customer customer = new Customer();
        customer.setName(name);
        customer.setBirthday(birthday);
        customer.setSex(sex);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setAddress(address);

        customerRepository.save(customer);
        System.out.println("Customer created successfully!");
    }


    @Override
    public void updateCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID of Customer update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Customer customer = customerRepository.findById(id);

        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        System.out.println("1. Name: " + customer.getName());
        System.out.println("2. Birthday: " + customer.getBirthday());
        System.out.println("3. Sex: " + customer.isSex());
        System.out.println("4. Email: " + customer.getEmail());
        System.out.println("5. Phone: " + customer.getPhone());
        System.out.println("6. Address: " + customer.getAddress());
        System.out.println("0. Cancel");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter new Name: ");
                String newName = scanner.nextLine();
                customer.setName(newName);
            }
            case 2 -> {
                System.out.print("Enter new Birthday (yyyy-MM-dd): ");
                String newBirthdayString = scanner.nextLine();
                LocalDate newBirthday = LocalDate.parse(newBirthdayString);
                customer.setBirthday(newBirthday);
            }
            case 3 -> {
                System.out.print("Enter new Sex (true for male, false for female): ");
                boolean newSex = scanner.nextBoolean();
                customer.setSex(newSex);
            }
            case 4 -> {
                scanner.nextLine();
                System.out.print("Enter new Email: ");
                String newEmail = scanner.nextLine();
                customer.setEmail(newEmail);
            }
            case 5 -> {
                scanner.nextLine();
                System.out.print("Enter new Phone: ");
                String newPhone = scanner.nextLine();
                customer.setPhone(newPhone);
            }
            case 6 -> {
                scanner.nextLine();
                System.out.print("Enter new Address: ");
                String newAddress = scanner.nextLine();
                customer.setAddress(newAddress);
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

        customerRepository.save(customer);
        System.out.println("Customer updated successfully!");
    }



    @Override
    public void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID of Customer delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Customer customer = customerRepository.findById(id);
        if (customer != null) {
            customerRepository.delete(customer);
            System.out.println("Customer deleted successfully!");
        } else {
            System.out.println("Customer not found!");
        }

    }
    @Override
    public void getAllCustomer() {
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-5s | %-20s | %-10s | %-25s | %-15s | %-50s |\n", "ID", "Name", "Birthday", "Email", "Phone", "Address");
        System.out.println("------------------------------------------------------------------------------------------------------------------");

        customerRepository.findAll().forEach(customer -> {
            System.out.printf("| %-5s | %-20s | %-10s | %-25s | %-15s | %-50s |\n", customer.getId(), customer.getName(), customer.getBirthday(), customer.getEmail(), customer.getPhone(), customer.getAddress());
        });

        System.out.println("------------------------------------------------------------------------------------------------------------------");
    }

}
