package edu.ib.spring_data.dao;

import edu.ib.spring_data.dao.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Long> {
}
