package edu.ib.spring_data.api;

import edu.ib.spring_data.dao.entity.Product;
import edu.ib.spring_data.manager.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductApi {

    private ProductManager productManager;

    @Autowired
    public ProductApi(ProductManager productManager) {
        this.productManager = productManager;
    }

    @GetMapping("/product/all")
    public Iterable<Product> getAll() {
        return productManager.findAll();
    }

    @GetMapping("/product")
    public Optional<Product> geById(@RequestParam Long index) {
        return productManager.find(index);
    }

    @PostMapping("admin/product")
    public Product addProduct(@RequestBody Product product) {
        return  productManager.save(product);
    }

    @PutMapping("admin/product")
    public Product updateProduct(@RequestBody Product product) {
        return  productManager.save(product);
    }

    @PatchMapping("admin/product")
    public Product patchProduct(@RequestBody Product product) {
        return  productManager.patch(product);
    }

    @DeleteMapping("admin/product")
    public void deleteProduct(@RequestParam Long index){
        productManager.delete(index);
    }
}
