package edu.ib.spring_data.manager;

import edu.ib.spring_data.dao.OrderRepo;
import edu.ib.spring_data.dao.entity.Customer;
import edu.ib.spring_data.dao.entity.Order;
import edu.ib.spring_data.dao.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderManager {

    private OrderRepo orderRepo;

    @Autowired
    public OrderManager(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Optional<Order> find(Long id){
        return orderRepo.findById(id);
    }

    public Iterable<Order> findAll(){
        return orderRepo.findAll();
    }

    public Order save(Order order){
        return orderRepo.save(order);
    }

    public Order patch(Order order){
        Optional<Order> previous = find(order.getOrder_id());
        previous.stream().findFirst().get().updateClass(order);
        return orderRepo.save(previous.get());
    }

    public void delete(Long id){
        orderRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){

        Product product = new Product("Korek", 2.55f, true);
        Product product1 = new Product("Rura", 5f, true);
        Customer customer = new Customer("Jak Kowalski", "Wrocław");
        Set<Product> products = new HashSet<>() {
            {
                add(product);
                add(product1);
            }};
        Order order = new Order(customer, products, LocalDateTime.now(), "in progress");
        save(order);

    }

}
