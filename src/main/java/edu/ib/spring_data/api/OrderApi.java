package edu.ib.spring_data.api;

import edu.ib.spring_data.dao.entity.Order;
import edu.ib.spring_data.manager.OrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrderApi {


    private OrderManager orderManager;

    @Autowired
    public OrderApi(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    @GetMapping("/order/all")
    public Iterable<Order> getAll() {
        return orderManager.findAll();
    }

    @GetMapping("/order")
    public Optional<Order> geById(@RequestParam Long index) {
        return orderManager.find(index);
    }

    @PostMapping("admin/order")
    public Order addOrder(@RequestBody Order order) {
        return  orderManager.save(order);
    }

    @PutMapping("admin/order")
    public Order updateOrder(@RequestBody Order order) {
        return  orderManager.save(order);
    }

    @PatchMapping("admin/order")
    public Order patchOrder(@RequestBody Order order) {
        return  orderManager.patch(order);
    }

    @DeleteMapping("admin/order")
    public void deleteOrder(@RequestParam Long index){
        orderManager.delete(index);
    }
}
