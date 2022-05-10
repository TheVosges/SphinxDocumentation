package edu.ib.spring_data.manager;

import edu.ib.spring_data.dao.CustomerRepo;
import edu.ib.spring_data.dao.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerManager {

    private CustomerRepo customerRepo;

    @Autowired
    public CustomerManager(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Optional<Customer> find(Long id){
        return customerRepo.findById(id);
    }

    public Iterable<Customer> findAll(){
        return customerRepo.findAll();
    }

    public Customer save(Customer customer){
        return customerRepo.save(customer);
    }

    public Customer patch(Customer customer){
        Optional<Customer> previous = find(customer.getCustomer_id());
        previous.stream().findFirst().get().updateClass(customer);
        return customerRepo.save(previous.get());
    }

    public void delete(Long id){
        customerRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new Customer("Jak Kowalski", "Wrocław"));
        save(new Customer("Ola Żak", "Warszawa"));
        save(new Customer("Joe Doe", "Los Andżeles"));
    }

}
