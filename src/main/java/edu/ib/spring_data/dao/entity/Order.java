package edu.ib.spring_data.dao.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @ManyToOne(cascade=CascadeType.ALL)
    private Customer customer;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "products_orders",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns =@JoinColumn(name = "product_id")
    )
    private Set<Product> products;

    private LocalDateTime placeDate;
    private String status;

    public Order(Customer customer, Set<Product> products, LocalDateTime placeDate, String status) {
        this.customer = customer;
        this.products = products;
        this.placeDate = placeDate;
        this.status = status;
    }

    public Order() {
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public LocalDateTime getPlaceDate() {
        return placeDate;
    }

    public void setPlaceDate(LocalDateTime placeDate) {
        this.placeDate = placeDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(order_id, order.order_id) && Objects.equals(customer, order.customer) && Objects.equals(products, order.products) && Objects.equals(placeDate, order.placeDate) && Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, customer, products, placeDate, status);
    }


    public void updateClass(Order order){
        if (order.getCustomer() != null) {
            this.customer = order.getCustomer();
        }
        if (order.getProducts() != null) {
            this.products = order.getProducts();
        }
        if (order.getStatus() != null) {
            this.status = order.getStatus();
        }
        if (order.getPlaceDate() != null) {
            this.placeDate = order.getPlaceDate();
        }
    }
}
