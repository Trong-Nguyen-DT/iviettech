package pojo;

import java.util.List;


public class Order {
    private long id;
    private List<Product> products;
    private Customer customer;

    public Order() {
    }

    public Order(long id, List<Product> products, Customer customer) {
        this.id = id;
        this.products = products;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
