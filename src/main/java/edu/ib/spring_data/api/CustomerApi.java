package edu.ib.spring_data.api;

import edu.ib.spring_data.dao.entity.Customer;

import edu.ib.spring_data.manager.CustomerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerApi {


    private CustomerManager customerManager;

    @Autowired
    public CustomerApi(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    @GetMapping("/customer/all")
    public Iterable<Customer> getAll() {
        return customerManager.findAll();
    }

    @GetMapping("/customer")
    public Optional<Customer> geById(@RequestParam Long index) {
        return customerManager.find(index);
    }

    @PostMapping("admin/customer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return  customerManager.save(customer);
    }

    @PutMapping("admin/customer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return  customerManager.save(customer);
    }

    @PatchMapping("admin/customer")
    public Customer patchCustomer(@RequestBody Customer customer) {
        return  customerManager.patch(customer);
    }

    @DeleteMapping("admin/customer")
    public void deleteCustomer(@RequestParam Long index){
        customerManager.delete(index);
    }
}
