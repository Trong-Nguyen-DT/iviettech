package controller.Repository;

import pojo.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer getCustomerById(long id);
    List<Customer> getAllCustomers();
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(long id);
}
