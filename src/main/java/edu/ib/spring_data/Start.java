package edu.ib.spring_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class Start {

    private ProductRepo productRepo;
    private OrderRepo orderRepo;
    private CustomerRepo customerRepo;

    @Autowired
    public Start(ProductRepo productRepo, OrderRepo orderRepo, CustomerRepo customerRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {
        Product product = new Product("Korek", 2.55f, true);
        Product product1 = new Product("Rura", 5f, true);
        Customer customer = new Customer("Jak Kowalski", "Wrocław");
        Set<Product> products = new HashSet<>() {
            {
                add(product);
                add(product1);
            }};
        Order order = new Order(customer, products, LocalDateTime.now(), "in progress");

        productRepo.save(product);
        productRepo.save(product1);
        customerRepo.save(customer);
        orderRepo.save(order);

    }
}
