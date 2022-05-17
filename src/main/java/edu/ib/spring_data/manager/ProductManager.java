package edu.ib.spring_data.manager;

import edu.ib.spring_data.dao.ProductRepo;
import edu.ib.spring_data.dao.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductManager {

    private ProductRepo productRepo;

    @Autowired
    public ProductManager(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Optional<Product> find(Long id){
        return productRepo.findById(id);
    }

    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }

    public Product save(Product product){
        return productRepo.save(product);
    }

    public Product patch(Product product){
        Optional<Product> previous = find(product.getProduct_id());
        previous.stream().findFirst().get().updateClass(product);
        return productRepo.save(previous.get());
    }

    public void delete(Long id){
        productRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
//        save(new Product("Rura", 5f, true));
//        save(new Product("Korek", 2.55f, true));
    }

}
