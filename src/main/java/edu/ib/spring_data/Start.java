package edu.ib.spring_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private ProductRepo productRepo;

    @Autowired
    public Start(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {

        Product product1 = new Product("Malin", 1400,true);
        productRepo.save(product1);

        Product product2 = new Product("ECUMaster", 2000,false);
        productRepo.save(product2);

        Product product3 = new Product("Cybul", 1000,true);
        productRepo.save(product3);


        Iterable<Product> all = productRepo.findAll();
        all.forEach(System.out::println);

    }
}
