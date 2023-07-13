package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ProductEntity")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    @ManyToMany(mappedBy = "productEntities", fetch = FetchType.EAGER)
    private List<Order> orderEntities;

    public Product() {
    }

    public List<Order> getOrderEntities() {
        return orderEntities;
    }

    public void setOrderEntities(List<Order> orderEntities) {
        this.orderEntities = orderEntities;
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
