package controller.Repository;

import org.springframework.stereotype.Repository;
import pojo.Customer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private Map<Long, Customer> customerMap;

    @PostConstruct
    public void initData(){
        customerMap = new HashMap<>();
    }
    @Override
    public Customer getCustomerById(long id) {
        return customerMap.get(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void addCustomer(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }

    @Override
    public void deleteCustomer(long id) {
        customerMap.remove(id);
    }

}

