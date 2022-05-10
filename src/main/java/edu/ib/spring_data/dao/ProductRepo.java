package edu.ib.spring_data.dao;

import edu.ib.spring_data.dao.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Long> {

}
