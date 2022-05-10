package edu.ib.spring_data.dao.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    private String name;
    private float price;
    private boolean available;
    @Transient
    @ManyToMany(mappedBy = "order_id")
    private Set<Order> orders;

    public Product(String name, float price, boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public Product() {
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Float.compare(product.price, price) == 0 && available == product.available && Objects.equals(product_id, product.product_id) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id, name, price, available);
    }
}
