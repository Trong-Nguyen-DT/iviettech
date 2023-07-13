package controller.Service;

import pojo.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(long id);
    List<Customer> getAllCustomers();
    void addCustomer();
    void updateCustomer();
    void deleteCustomer();
    boolean isCustomerExist(long customerId);
    void displayCustomerList();
}
